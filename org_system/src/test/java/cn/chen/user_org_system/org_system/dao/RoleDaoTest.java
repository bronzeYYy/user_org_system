package cn.chen.user_org_system.org_system.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleDaoTest {
    @Autowired
    private OrgDao orgDao;
    @Test
    public void test() {
        System.out.println(orgDao.count());
    }
}
