package com.example.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author kuanglifang
 * @date 2021/3/5 11:43
 * web 配置
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 当请求"/"时，转发到"design"视图
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("design");
    }
}
