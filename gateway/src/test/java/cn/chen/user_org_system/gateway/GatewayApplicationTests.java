package cn.chen.user_org_system.gateway;

import cn.chen.user_org_system.common.entity.User;
import cn.chen.user_org_system.gateway.dao.RoleDao;
import cn.chen.user_org_system.gateway.login.UserContainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collections;

@SpringBootTest
class GatewayApplicationTests {

    @Autowired
    @Qualifier("userRedisTemplate")
    private RedisTemplate<String, User> template;
    @Autowired
    private UserContainer container;
    @Autowired
    private RoleDao roleDao;
    @Test
    void contextLoads() {
        System.out.println(roleDao.findAll());
        container.addRoleButtons(roleDao.findAll());
    }
    @Test
    void test() {
        System.out.println(roleDao.findMenuByButtonIds(Collections.singleton(1)).size());
    }

}
