package cn.com.yijuan.configuration.spring.cache;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author CheneyL
 * 缓存配置
 */
@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

    /**
     * spring boot redis默认序列化方式
     * @return RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Object> getRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * spring redis 默认生成key方式,包含::号
     * @param prefix
     * @param key
     * @return
     */
    public String simpleKeyGenerator(String prefix, String key) {
        return CacheKeyPrefix.simple().compute(prefix) + key;
    }
}
