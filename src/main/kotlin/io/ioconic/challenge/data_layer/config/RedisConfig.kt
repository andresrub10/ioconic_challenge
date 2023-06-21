package io.ioconic.challenge.data_layer.config

import org.springframework.context.annotation.Bean
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

class RedisConfig {

    @Bean
    fun jedisConnectionFactory(): JedisConnectionFactory {
        var jedisConnectionFactory: JedisConnectionFactory = JedisConnectionFactory()
        jedisConnectionFactory.afterPropertiesSet()
        return jedisConnectionFactory
    }

    @Bean
    fun redisTemplate(): RedisTemplate<String, Any> {
        var template: RedisTemplate<String, Any> = RedisTemplate()
        template.setConnectionFactory(jedisConnectionFactory())
        return template
    }
}
