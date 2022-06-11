package com.ps.cardPayment.CreditCardProcessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableRedisRepositories
@RestController
public class CreditCardProcessingApplication {
    private static final Logger logger = LoggerFactory.getLogger(CreditCardProcessingApplication.class);

    public static void main(String[] args) {
        logger.info("Invoking Spring Framework");
        try {
            SpringApplication.run(CreditCardProcessingApplication.class, args);
        } catch (Exception e) {
            logger.error("Error staring server::", e);
        }
    }

    public void run(ApplicationArguments arg0) throws Exception {
        System.out.println("Server started at port:: 8080");
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/addCard").allowedOrigins("http://localhost*");
                registry.addMapping("/getAllCards").allowedOrigins("http://localhost*");
            }
        };
    }
//    @RequestMapping(value = "/health")
//    public String health() {
//        return "{\"Success\":true,\"Message\":\"Healthy\"}";
//    }
}
