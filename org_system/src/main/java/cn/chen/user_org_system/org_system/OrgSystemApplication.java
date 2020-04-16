package cn.chen.user_org_system.org_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("cn.chen.user_org_system.org_system.dao")
@EnableEurekaClient
@SpringBootApplication
public class OrgSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrgSystemApplication.class, args);
    }

}
