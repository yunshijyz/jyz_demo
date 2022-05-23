package com.example.demo.controller;


import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.crypto.symmetric.DES;
import com.example.demo.config.InterfaceCheck;
import com.example.demo.entity.DesAndMd5;
import com.example.demo.entity.DesBody;
import com.example.demo.entity.DesResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/des")
public class DesTestController {

    @InterfaceCheck
    @PostMapping("/testDes")
    public DesResult testDes(@RequestBody DesBody desBody) throws UnsupportedEncodingException {
        DesResult desResult = new DesResult();

        String body = desBody.getBody();

        String pk3 = "12345678";
        byte[] bytes = pk3.getBytes("UTF-8");
        //构建
        DES des = SecureUtil.des(bytes);

        String decryptStr = des.decryptStr(body);
        desResult.setDes(decryptStr);
        System.out.println("解密des: "+decryptStr);
        String s = Base64.decodeStr(decryptStr);
        desResult.setBase64(s);
        System.out.println("解密base64: "+s);
        return desResult;
    }

    @InterfaceCheck
    @PostMapping("/testDesAndMd5")
    public DesAndMd5 testDesAndMd5(HttpServletRequest request, @RequestBody DesBody desBody) throws UnsupportedEncodingException {
        DesAndMd5 desAndMd5 = new DesAndMd5();

        String pk3 = "9193716c-970f-47f3-82bc-61206c61e97a";
        byte[] bytes = pk3.getBytes("UTF-8");
        //构建
        DES des = SecureUtil.des(bytes);

        String decryptStr = des.decryptStr(desBody.getBody());
        desAndMd5.setDes(decryptStr);
        String s = Base64.decodeStr(decryptStr);
        desAndMd5.setBase64(s);

        String time = request.getHeader("time");
        String md5ss = request.getHeader("md5ss");
        //第一层
        String pk1 = "2329a212-f4c2-4cb5-a40a-486b1991289f";
        //第一层key
        String key1 = s+time+pk1;
        desAndMd5.setKey1(key1);
        Digester md = new Digester(DigestAlgorithm.MD5);
        String md1 = md.digestHex(key1, StandardCharsets.UTF_8);
        desAndMd5.setMd5one(md1);

        //第二层
        String pk2 = "f4fad561-3e4a-42bc-8c2a-c5ad16bc2ce1";
        Digester md51 = new Digester(DigestAlgorithm.MD5);
        String ss2 = md1+pk2;
        desAndMd5.setKey2(ss2);

        String finalMd5 = md51.digestHex(ss2,StandardCharsets.UTF_8);
        desAndMd5.setFinalMd5(finalMd5);
        if(finalMd5.equals(md5ss)){
            desAndMd5.setResult(true);
        }else {
            desAndMd5.setResult(false);
        }


        return desAndMd5;
    }

    @PostMapping("/test3")
    public DesAndMd5 test3(HttpServletRequest request,@RequestBody DesBody desBody){
        DesAndMd5 desAndMd5 = new DesAndMd5();
        desAndMd5.setFinalMd5(request.getHeader("md5ss"));
        desAndMd5.setDes(request.getHeader("time"));
        desAndMd5.setKey1(desBody.getBody());

        return desAndMd5;
    }
}
