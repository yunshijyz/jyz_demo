package com.demo.mybatis_plus.mybatis_plus_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;

@Configuration
//开启Swagger2
@EnableSwagger2
public class SwaggerConfig {


    //RequestHandlerSelectors)配置扫描接口的方式
    /*RequestHandlerSelectors.basePackage("com.ji.controller"):指定扫描的包
      RequestHandlerSelectors.any() 扫描全部
      RequestHandlerSelectors.none() 不扫描
      RequestHandlerSelectors.withClassAnnotation(RestController.class) 扫描类上的注解    @Target(ElementType.TYPE)
      RequestHandlerSelectors.withMethodAnnotation (GetMapping.class) 扫描方法上的注解  @Target(ElementType.METHOD)
    * */

    //paths :过滤什么路径
    //配置SwaggerDocket Bean实例

    //配置
    @Bean
    public Docket docket(Environment environment){
        //多环境 开关swagger  environment
        //设置要显示swagger 的环境
//        Profiles profiles= Profiles.of ("dev","test");
//        //判断当前环境是否是profiles中显示swagger的环境
//        boolean b = environment.acceptsProfiles (profiles);


        return new Docket (DocumentationType.OAS_30)
                .apiInfo (apiInfo ())
                .groupName ("jsp")   //配置Api文档分组   多个Docket分组
                .enable (true)   //是否启动swagger 如果为false则swagger不能再浏览器中访问
                .securitySchemes(Collections.singletonList(HttpAuthenticationScheme.JWT_BEARER_BUILDER
//                        显示用
                        .name("JWT")
                        .build()))
                .securityContexts(Collections.singletonList(SecurityContext.builder()
                        .securityReferences(Collections.singletonList(SecurityReference.builder()
                                .scopes(new AuthorizationScope[0])
                                .reference("JWT")
                                .build()))
                        // 声明作用域
                        .operationSelector(o -> o.requestMappingPattern().matches("/.*"))
                        .build()))
                .select ()
                .apis (RequestHandlerSelectors.basePackage("com.demo.mybatis_plus.mybatis_plus_demo.controller"))
                //.paths (PathSelectors.ant ("/ji/**"))
                .paths(PathSelectors.any())
                .build ();
    }
//    @Bean
//    public Docket docket1(){
//        return new Docket (DocumentationType.SWAGGER_2)
//                .apiInfo (apiInfo ())
//                .groupName ("hcy");   //配置Api文档分组
//    }
//    @Bean
//    public Docket docket2(){
//        return new Docket (DocumentationType.SWAGGER_2)
//                .apiInfo (apiInfo ())
//                .groupName ("zzz");   //配置Api文档分组
//    }
    //配置swagger信息
    private ApiInfo apiInfo(){
        return new ApiInfo ("Jsp SwaggerLogger",
                "学习",
                "17.0",
                "https://www.cnblogs.com/Liuyunsan/",
                new Contact("jsp", "https://www.cnblogs.com/Liuyunsan/", "2315510122@qq.com"),   //作者信息
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
