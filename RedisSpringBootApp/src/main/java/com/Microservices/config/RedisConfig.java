package com.Microservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.Microservices.model.Country;

@Configuration
public class RedisConfig {

	// Jedis connection Factory
	
	@Bean
	public JedisConnectionFactory jedisConnection() {
		
		// redis server config
		JedisConnectionFactory jedis = new JedisConnectionFactory();
		
		return jedis;
		
	}
	
	// Redis Template
	
	@Bean
	public RedisTemplate<String, Country> redisTemplate(){
		
		RedisTemplate<String, Country> redis = new RedisTemplate<>();
		
		redis.setConnectionFactory(jedisConnection());
		return redis;
	}
	
}
