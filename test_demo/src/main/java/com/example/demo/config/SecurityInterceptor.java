package com.example.demo.config;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.crypto.symmetric.DES;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.DesBody;
import com.example.demo.utils.HttpContextUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;


@Component
public class SecurityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        /**
         * handler保存了本次请求的controller也就是接口方法的一些信息，如类，方法，参数等
         * 如果是一次静态资源的请求则该handler不应该是HandlerMethod的实现类
         * 判断是否是一个正常的接口，如果是则进行鉴权操作，不是则直接放行
         */
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;// 把handler强转为HandlerMethod
            // 从handlerMethod中获取本次请求的接口方法对象然后判断该方法上是否标有我们自定义的注解@Security
            InterfaceCheck annotation = handlerMethod.getMethod().getAnnotation(InterfaceCheck.class);
            if(annotation == null){
                return true;
            }
            String md5ss = request.getHeader("md5ss");
            String time = request.getHeader("time");
            if(StrUtil.isBlank(md5ss) || StrUtil.isBlank(time)){
                retrunHttpResponse(response);
                return false;
            }
            System.out.println("md5:"+md5ss);
            System.out.println("time:"+time);

            String bodyParams = HttpContextUtils.getBodyString(request);
//            // 创建重写后的 HttpServletRequest
//            RequestReaderHttpServletRequestWrapper wrapper = new RequestReaderHttpServletRequestWrapper(request);
//            // 获取 body 参数
//            String bodyParams = wrapper.inputStream2String(wrapper.getInputStream());


            System.out.println("body:"+bodyParams);
            DesBody desBody = JSONObject.parseObject(bodyParams, DesBody.class);

            System.out.println(desBody.getBody());


            // 对用户进行鉴权
            try {
                if (checkAnno(desBody.getBody(), md5ss, time)) {
                    return true;
                }
            } catch (Exception e) {
                retrunHttpResponse(response);
            }


            return false;
        }
        return true;

    }


    private boolean checkAnno(String body,String md5,String time) throws UnsupportedEncodingException {
        String pk3 = "9193716c-970f-47f3-82bc-61206c61e97a";
        byte[] bytes = pk3.getBytes("UTF-8");
        //构建
        DES des = SecureUtil.des(bytes);

        String decryptStr = des.decryptStr(body);
        System.out.println("解密des: "+decryptStr);
        String s = Base64.decodeStr(decryptStr);
        System.out.println("解密base64: "+s);

        //第一层
        String pk1 = "2329a212-f4c2-4cb5-a40a-486b1991289f";
        //第一层key
        String key1 = s+time+pk1;
        System.out.println("第一次key1:"+key1);
        Digester md = new Digester(DigestAlgorithm.MD5);
        String md1 = md.digestHex(key1, StandardCharsets.UTF_8);
        System.out.println("md1:"+md1);

        //第二层
        String pk2 = "f4fad561-3e4a-42bc-8c2a-c5ad16bc2ce1";
        Digester md51 = new Digester(DigestAlgorithm.MD5);
        String ss2 = md1+pk2;

        String finalMd5 = md51.digestHex(ss2,StandardCharsets.UTF_8);
        System.out.println("final:"+finalMd5);

        if(finalMd5.equals(md5)){
            return true;
        }



        return false;

    }

    private void retrunHttpResponse(HttpServletResponse httpServletResponse) {

        JSONObject json = new JSONObject();
        json.put("code",-1);
        json.put("msg","非法请求");
        String res = json.toJSONString();

        PrintWriter writer = null;
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");

        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        try {
            writer = httpServletResponse.getWriter();
            writer.print(res);

        } catch (IOException e) {

        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }
}
