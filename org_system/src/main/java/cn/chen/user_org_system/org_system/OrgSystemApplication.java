package cn.chen.user_org_system.org_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OrgSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrgSystemApplication.class, args);
    }

}
