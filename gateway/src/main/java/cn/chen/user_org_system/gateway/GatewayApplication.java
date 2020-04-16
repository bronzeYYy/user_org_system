package cn.chen.user_org_system.gateway;

import cn.chen.user_org_system.common.entity.User;
import cn.chen.user_org_system.gateway.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
@EnableAspectJAutoProxy
@EnableEurekaClient
@MapperScan("cn.chen.user_org_system.gateway.dao")
@SpringBootApplication(scanBasePackages = "cn.chen.user_org_system.gateway")
public class GatewayApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(GatewayApplication.class, args);
        //  读取所有的角色-按钮信息到内存或者redis
        log.info("读取所有的角色-按钮信息到内存或者redis {}", run.getBean(RoleService.class).updateRole());
    }

    @Bean
    public Properties roleProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(ResourceUtils.getFile("classpath:role.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    @Bean
    public RedisTemplate<String, User> userRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, User> userRedisTemplate = new RedisTemplate<>();
        userRedisTemplate.setConnectionFactory(connectionFactory);
        userRedisTemplate.setKeySerializer(RedisSerializer.string());
        userRedisTemplate.setHashKeySerializer(RedisSerializer.string());
        userRedisTemplate.setValueSerializer(RedisSerializer.json());
        userRedisTemplate.setHashValueSerializer(RedisSerializer.json());
        return userRedisTemplate;
    }
    @Bean("roleButtonsRedisTemplate")
    public RedisTemplate<Integer, Integer> roleButtonsRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Integer, Integer> roleButtonsRedisTemplate = new RedisTemplate<>();
        roleButtonsRedisTemplate.setConnectionFactory(connectionFactory);
        roleButtonsRedisTemplate.setKeySerializer(new IntegerRedisSerializer());
        roleButtonsRedisTemplate.setValueSerializer(RedisSerializer.json());
        return roleButtonsRedisTemplate;
    }
    static class IntegerRedisSerializer implements RedisSerializer<Integer>{
        @Override
        public byte[] serialize(Integer integer) throws SerializationException {
            return String.valueOf(integer).getBytes();
        }

        @Override
        public Integer deserialize(byte[] bytes) throws SerializationException {
            return Integer.parseInt(new String(bytes));
        }
    }
}
