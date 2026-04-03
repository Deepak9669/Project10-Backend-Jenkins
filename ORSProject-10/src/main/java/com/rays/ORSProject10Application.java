package com.rays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Main class for ORS Project 10 Spring Boot Application.
 * <p>
 * This class bootstraps the Spring Boot application and also
 * provides global CORS configuration.
 * </p>
 * 
 * @author Deepak Verma
 */
@SpringBootApplication
public class ORSProject10Application {

    /**
     * Main method to start the Spring Boot application.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ORSProject10Application.class, args);
    }

    /**
     * Configures global CORS settings for the application.
     * <p>
     * Allows all origins, headers, and specified HTTP methods.
     * This is useful when frontend and backend are hosted on different domains.
     * </p>
     * 
     * @return WebMvcConfigurer instance with CORS mappings
     */
    @Bean
    public WebMvcConfigurer corsConfig() {

        WebMvcConfigurer w = new WebMvcConfigurer() {

            /**
             * Adds CORS mappings to allow cross-origin requests.
             * 
             * @param registry the CORS registry
             */
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };

        return w;
    }
}