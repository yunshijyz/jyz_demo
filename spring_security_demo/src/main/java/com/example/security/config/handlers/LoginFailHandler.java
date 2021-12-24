package com.example.security.config.handlers;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@Component
public class LoginFailHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

       // httpServletRequest.getRequestDispatcher("/login").forward(httpServletRequest,httpServletResponse);

        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");

        PrintWriter writer = httpServletResponse.getWriter();

        Map<String,Object> map = new HashMap<>();
        map.put("code",500);
        map.put("msg",e.getMessage());
        writer.write(JSON.toJSONString(map));
        writer.flush();
        writer.close();


    }
}
