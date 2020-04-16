package cn.chen.user_org_system.gateway.aspect;

import cn.chen.user_org_system.common.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class UserLog {
    @Before(value = "execution(* cn.chen.user_org_system.gateway.login.UserContainer.addUser(String, cn.chen.user_org_system.common.entity.User)) && args(token, user)", argNames = "token,user")
    void addUser(String token, User user) {
        log.info("add user: {} -> {}", token, user.getUsername());
    }
    @Before(value = "execution(* cn.chen.user_org_system.gateway.login.UserContainer.deleteUser(String)) && args(token)", argNames = "token")
    void deleteUser(String token) {
        log.info("delete user: {}", token);
    }
}
