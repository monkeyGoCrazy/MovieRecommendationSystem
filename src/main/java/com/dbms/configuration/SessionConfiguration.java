package com.dbms.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.session.web.http.HttpSessionStrategy;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * Created by mengleisun on 4/12/16.
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfiguration {
//    @Bean
//    public JedisConnectionFactory connectionFactory() {
//        return new JedisConnectionFactory();  // <2>
//    }
//
//    @Bean
//    public HttpSessionStrategy httpSessionStrategy() {
//        return new HeaderHttpSessionStrategy(); // <3>
//    }
}
