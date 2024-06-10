package kp.cmsc.common.config;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.ContentCachingRequestWrapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kp.cmsc.common.interceptor.LoggerInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//특정메소드 호출
                .allowedOriginPatterns("http://localhost:3000")
                .allowedMethods("GET", "POST")
                .allowCredentials(true);//원하는 시간만큼 pre-flight 리퀘스트를 캐싱
    }

    @Autowired
    private LoggerInterceptor loggerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggerInterceptor).addPathPatterns("/**");
    }

    @Bean
    public OncePerRequestFilter requestCachingFilter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                HttpServletRequest cachedRequest = new ContentCachingRequestWrapper(request);
                filterChain.doFilter(cachedRequest, response);
            }
        };
    }
}
