package org.design.bonpellz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//public class CorsConfig {
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("http://localhost:3000/")
//                        .allowedOrigins("*")
//                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS");
//            }
//        };
//    }
//
//}

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS");
            }
        };
    }
}

//
//@Configuration
//public class WebMVCConfig implements WebMvcConfigurer {
//    public void addCorsMapping(CorsRegistry corsRegistry) {
//        final long MAX_AGE = 3000;
//        String allowedOrigin = "localhost:3000";
//        corsRegistry.addMapping("/**")
//                .allowedOrigins(allowedOrigin)
//                .allowedMethods("GET", "POST", "PUT", "DELETE")
//                .allowedHeaders("*")
//                .maxAge(MAX_AGE);
//    }
//}
