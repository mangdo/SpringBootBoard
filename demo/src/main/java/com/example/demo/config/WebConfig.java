package com.example.demo.config;

import com.example.demo.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

        // LoginUserArgumentResolver가 스프링 내에서 인식될 수 있게한다.
        // HandlerMethodArgumentResolver는 항상 addArgumentResolvers()통해 추가해야한다.
        resolvers.add(loginUserArgumentResolver);
    }
}
