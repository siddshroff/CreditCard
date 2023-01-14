//package com.ps.cardPayment.CreditCardProcessing.utilities;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * This utility class configures redis connectivity and template.
// *
// * @author  Siddharth Shroff
// * @version 1.0
// * @since   13-06-2022
// */
//@Configuration
//@EnableRedisRepositories
//public class RedisClient {
//    private static final Logger logger = LoggerFactory.getLogger(RedisClient.class);
//
//    @Value("${spring.redis.host}")
//    private String redisHost;
//    @Value("${spring.redis.port}")
//    private int port;
//    @Value("${spring.redis.password}")
//    private String password;
//
//    /**
//     * This method is used to setup connection to redis
//     * @return JedisConnectionFactory This returns JedisConnectionFactory
//     */
//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//        RedisStandaloneConfiguration redisStandaloneConfiguration
//        = new RedisStandaloneConfiguration();
//        redisStandaloneConfiguration.setHostName(redisHost);
//        redisStandaloneConfiguration.setPort(port);
//        redisStandaloneConfiguration.setPassword(password);
//        return new JedisConnectionFactory(redisStandaloneConfiguration);
//    }
//    /**
//     * This method creates bean of redis template through which data access layer
//     * communicated with Redis
//     * @return RedisTemplate This returns RedisTemplate
//     */
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        try {
//            logger.info("Creating Redis connection and template");
//            template.setConnectionFactory(jedisConnectionFactory());
//            template.setKeySerializer(new StringRedisSerializer());
//            template.setHashKeySerializer((new StringRedisSerializer()));
//            template.setHashKeySerializer(new JdkSerializationRedisSerializer());
//            template.setValueSerializer(new JdkSerializationRedisSerializer());
//        } catch (Exception e) {
//            logger.error("Error connecting Redis server");
//        }
//        return template;
//    }
//}
