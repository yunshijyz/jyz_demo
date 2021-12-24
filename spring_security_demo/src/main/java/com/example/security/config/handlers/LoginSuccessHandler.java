package com.example.security.config.handlers;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //httpServletRequest.getRequestDispatcher("/main").forward(httpServletRequest,httpServletResponse);

        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");

        PrintWriter writer = httpServletResponse.getWriter();
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","登陆成功");

        writer.write(JSON.toJSONString(map));
        writer.flush();
        writer.close();


    }

}
