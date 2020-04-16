package cn.chen.user_org_system.role_system;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@MapperScan("cn.chen.user_org_system.role_system.dao")
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "cn.chen.user_org_system")
public class RoleSystemApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(RoleSystemApplication.class, args);
        log.info("gatewayFilter -> {}", run.containsBean("gatewayFilter"));
    }
}
