package cn.chen.user_org_system.gateway.dao;
import cn.chen.user_org_system.common.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User findByUsernameAndPassword(String username, String password);
    User findById(Integer id);
}
