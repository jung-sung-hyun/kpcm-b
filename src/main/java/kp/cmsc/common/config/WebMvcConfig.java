package kp.cmsc.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kp.cmsc.common.interceptor.LoggerInterceptor;



@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoggerInterceptor(ObjectMapper objectMapper)).excludePathPatterns("/css/**", "/images/**", "/js/**");
//    }
    @Autowired
    private LoggerInterceptor loggerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggerInterceptor);
    }

}