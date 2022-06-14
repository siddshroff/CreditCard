package com.ps.cardPayment.CreditCardProcessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This entry class invokes sprint framework for applications
 * dealing with card details
 *
 * @author  Siddharth Shroff
 * @version 1.0
 * @since   13-06-2022
 */
@SpringBootApplication
@EnableRedisRepositories
@RestController
public class CreditCardProcessingApplication {
    private static final Logger logger = LoggerFactory.getLogger(CreditCardProcessingApplication.class);
    @Value("${server.port}")
    private String port;
    /**
     * This main method invokes sprint framework for applications
     * dealing with card details
     * @param args This object has all arguments passed to start application.
     * @return void This returns nothing.
     */
    public static void main(String[] args) {
        logger.info("Invoking Spring Framework");
        try {
            SpringApplication.run(CreditCardProcessingApplication.class, args);
        } catch (Exception e) {
            logger.error("Error staring server::", e);
        }
    }
    /**
     * This method is invoked if executed from command line.
     * It prints a server startup log
     * @param arg0 This object has all arguments passed to start application.
     * @return void This returns nothing.
     */
    public void run(ApplicationArguments arg0) throws Exception {
        logger.info("Server started at port:: ", port);
    }

    /**
     * This method configures the CORS for endpoints
     * @return WebMvcConfigurer This returns WebMvcConfigurer object.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("v1/cards").allowedOrigins("http://localhost*");
            }
        };
    }
}
