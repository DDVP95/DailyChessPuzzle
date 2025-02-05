package com.chessgg.chessapp.maven.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Map only static resources, exclude dynamic endpoints like `/logout`
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
