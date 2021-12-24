package com.example.security.config;



import com.example.security.config.handlers.LoginFailHandler;
import com.example.security.config.handlers.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

//security页面配置，跳转地址等
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.formLogin()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/login")
//                .successForwardUrl("/main");
//
//
//        http.authorizeRequests()
//                .antMatchers("/login.html").permitAll()
//                .anyRequest().authenticated();
//
//        http.csrf().disable();
// }

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Autowired
    private LoginFailHandler loginFailHandler;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                //自定义登录表单参数
                .usernameParameter("loginName")
                .passwordParameter("password")
                //.successForwardUrl("/main")
                .successHandler(loginSuccessHandler)
                //.failureForwardUrl("/login")
                .failureHandler(loginFailHandler)
                    .and().authorizeRequests()
                    .antMatchers("/login.html","/js/**","/images/**","/css/**").permitAll()
//                    .antMatchers("/hasAdmin").hasAuthority("admin")
//                    //.antMatchers("/main2").hasRole("def")
//                    .antMatchers("/main2").access("hasRole('def')")
                    .anyRequest().authenticated()
                        .and().csrf().disable();

        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);

    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
