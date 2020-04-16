package cn.chen.user_org_system.user_system;

import cn.chen.user_org_system.common.response.BaseResponse;
import cn.chen.user_org_system.common.utils.JsonUtils;
import cn.chen.user_org_system.user_system.dao.UserDao;
import cn.chen.user_org_system.user_system.feign.RoleFeign;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserSystemApplicationTests {

    @Autowired
    private RoleFeign roleFeign;
    @Autowired
    private UserDao userDao;
    @Test
    void contextLoads() {
        System.out.println(JsonUtils.toJsonString(userDao.findUser(0, 10)));
    }

}
