package cn.urbanwall.config;

import cn.urbanwall.quervo.UserToken;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.slf4j.SLF4JLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {
    @Value("${spring.redis.timeout}")
    private Long redisTimeout;
    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }
//    @Bean
//    @Override
//    public KeyGenerator keyGenerator() {
//        //  设置自动key的生成规则，配置spring boot的注解，进行方法级别的缓存
//        // 使用：进行分割，可以很多显示出层级关系
//        // 这里其实就是new了一个KeyGenerator对象，只是这是lambda表达式的写法，我感觉很好用，大家感兴趣可以去了解下
//        return (target, method, params) -> {
//            StringBuilder sb = new StringBuilder();
//            sb.append(target.getClass().getName());
//            sb.append(":");
//            sb.append(method.getName());
//            for (Object obj : params) {
//                sb.append(":" + String.valueOf(obj));
//            }
//            String rsToUse = String.valueOf(sb);
//            return rsToUse;
//        };
//    }


    /**
     * 管理缓存
     * @param factory
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisCacheManager cacheManager = RedisCacheManager.create(factory);
        return cacheManager;
    }


    /**
     * redis模板，存储关键字是字符串，值是Jdk序列化,这个写法和我com.jary.util中的RedisObjectSerializer写法更简单，测试后选择使用那个
     * @Description:
     * @param factory
     * @return
     */
    @Bean("StringConfigRedis")
    public RedisTemplate<?,?> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<?,?> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        //key序列化方式;但是如果方法上有Long等非String类型的话，会报类型转换错误；
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();//Long类型不可以会出现异常信息;
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);

        //JdkSerializationRedisSerializer序列化方式;
        JdkSerializationRedisSerializer jdkRedisSerializer=new JdkSerializationRedisSerializer();
        redisTemplate.setValueSerializer(jdkRedisSerializer);
        redisTemplate.setHashValueSerializer(jdkRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean("ObjectConfigRedis")
    public RedisTemplate<String, Object> tokenRedisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        Jackson2JsonRedisSerializer<Object> jdkRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        redisTemplate.setValueSerializer(jdkRedisSerializer);
        redisTemplate.setHashValueSerializer(jdkRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }



}
