package kp.cmsc.common.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kp.cmsc.common.interceptor.LoggerInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//특정메소드 호출
                //.allowedOriginPatterns("http://localhost:3000")
                .allowedOriginPatterns("/**")
                .allowedMethods("GET", "POST")
                .allowCredentials(false);//원하는 시간만큼 pre-flight 리퀘스트를 캐싱
    }

    @Autowired
    private LoggerInterceptor loggerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggerInterceptor).addPathPatterns("/**");
    }


}
