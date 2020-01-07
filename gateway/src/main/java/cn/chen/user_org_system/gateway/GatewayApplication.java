package cn.chen.user_org_system.gateway;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@EnableEurekaClient
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(GatewayApplication.class, args);
        log.info("globalFilter -> {}", run.containsBean("myGlobalFilter"));
    }
}
