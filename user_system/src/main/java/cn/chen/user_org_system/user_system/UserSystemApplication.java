package cn.chen.user_org_system.user_system;

import cn.chen.user_org_system.common.web.config.GatewayConfig;
import cn.chen.user_org_system.common.web.filter.GatewayFilter;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@MapperScan("cn.chen.user_org_system.user_system.dao")
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = "cn.chen.user_org_system")
public class UserSystemApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(UserSystemApplication.class, args);
        GatewayConfig gatewayConfig = cac.getBean(GatewayConfig.class);
        GatewayFilter gatewayFilter = cac.getBean(GatewayFilter.class);
        log.info("gatewayConfig -> ? {}", gatewayConfig);
        log.info("gatewayEnable -> {}", gatewayConfig.isEnable());
        log.info("gatewayFilter -> ? {}", gatewayFilter);
    }

}
