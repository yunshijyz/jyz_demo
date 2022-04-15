package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 跨域配置
 */
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Resource
    private SecurityInterceptor securityInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET","POST","PUT","DELETE","HEAD","OPTIONS")
                .allowCredentials(true)//是否允许携带cookie
                .maxAge(3600)
                .allowedHeaders("*");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor);
        WebMvcConfigurer.super.addInterceptors(registry);
    }


//    /**
//     * 指定拦截请求
//     *
//     * @param registry
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(securityInterceptor);
//        WebMvcConfigurer.super.addInterceptors(registry);
//    }
//
//    /**
//     * 对指定请求的 HttpServletRequest 进行重新注册返回
//     *
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean setLogServiceFilter() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        RequestBodyFilter requestBodyFilter = new RequestBodyFilter();
//        registrationBean.setFilter(requestBodyFilter);
//        registrationBean.setName("interceptor filter body params");
//        registrationBean.addUrlPatterns("/*");
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }


}
