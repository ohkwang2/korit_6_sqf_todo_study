package com.study.todolist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    // 기본이 자기 자신(springboot 서버에서 요청과 응답을 처리할 수 있게 되어 있어 외부에서 요청이 들어오게 하기 위함
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .allowedHeaders("*")   // 향후 Token 같은 것들도 헤더에 넣어서 보내줄 예정
                .allowCredentials(true);
    }
}
