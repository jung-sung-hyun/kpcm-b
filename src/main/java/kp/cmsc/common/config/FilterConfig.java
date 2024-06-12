//package kp.cmsc.common.config;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class FilterConfig implements WebMvcConfigurer{
//
////    @Bean
////    public FilterRegistrationBean<?> ipRestrictionFilter() {
////        FilterRegistrationBean<IpRestrictionFilter> registrationBean = new FilterRegistrationBean<>();
////        registrationBean.setFilter(new IpRestrictionFilter());
////        registrationBean.addUrlPatterns("/*"); // 모든 URL 패턴에 대해 필터를 적용합니다.
////        return registrationBean;
////    }
////    @Autowired
////    private LoggerInterceptor loggerInterceptor;
////
////    @Override
////    public void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(loggerInterceptor).addPathPatterns("/**");
////    }
//}