package com.example.security.config.handlers;


import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {


    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
//        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
//
//        httpServletResponse.setHeader("Content-Type","application/json;charset=utf-8");
//        PrintWriter writer = httpServletResponse.getWriter();
//        Map<String,Object> map = new HashMap<>();
//        map.put("status","error");
//        map.put("msg","权限不足");
//        writer.write(JSON.toJSONString(map));
//        writer.flush();
//        writer.close();
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/403.html");


    }
}
