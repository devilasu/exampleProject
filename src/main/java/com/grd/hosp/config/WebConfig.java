package com.grd.hosp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.grd.hosp.interceptor.ApiAuthInterceptor;
import com.grd.hosp.interceptor.AuthInterceptor;
import com.grd.hosp.interceptor.InfoInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ApiAuthInterceptor())
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/error")
                .excludePathPatterns("/api/login")
                .excludePathPatterns("/api/join");
        
        registry.addInterceptor(new InfoInterceptor())
        		.addPathPatterns("/**");
        
        registry.addInterceptor(new AuthInterceptor())
		.addPathPatterns("/web/**")
		.excludePathPatterns("/web/login")
		.excludePathPatterns("/web/join")
        .addPathPatterns("/form/doctor");
    }
}
