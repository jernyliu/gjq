package com.chinamobile.js.sz.tvms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
@MapperScan(value={"com.chinamobile.js.sz.tvms.syscfg.pojo.mapper", "jerny.demo"})
public class GjqApplication {

	public static void main(String[] args) {
		SpringApplication.run(GjqApplication.class, args);
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(factory);
		redisTemplate.setKeySerializer(stringRedisSerializer());
		return redisTemplate;
	}

	private StringRedisSerializer stringRedisSerializer(){
		return StringRedisSerializer.UTF_8;
	}
}
