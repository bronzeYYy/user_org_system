package cn.chen.user_org_system.role_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RoleSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoleSystemApplication.class, args);
    }

}
