package cn.chen.user_org_system.role_system;

import cn.chen.user_org_system.common.utils.JsonUtils;
import cn.chen.user_org_system.role_system.dao.MainDao;
import cn.chen.user_org_system.role_system.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class RoleSystemApplicationTests {

    @Autowired
    private MainDao mainDao;
    @Autowired
    private RoleService roleService;
    @Test
    void contextLoads() {
    }

    @Test
    public void test() {
        String s = JsonUtils.toJsonString(roleService.find(1, null));
        System.out.println(s);

    }
}
