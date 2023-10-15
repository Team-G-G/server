package com.jobpair.G.G;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("/*") // 모든 도메인에서 접근 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 모든 요청 방식 허용
                .allowedHeaders("Authorization", "Content-Type", "X-Requested-With", "X-CSRF-TOKEN")
                .allowCredentials(true)
                .maxAge(3600); // CORS preflight 요청 캐싱 시간 설정
    }
}
