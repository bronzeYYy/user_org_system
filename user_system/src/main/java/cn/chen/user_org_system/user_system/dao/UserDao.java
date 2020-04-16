package cn.chen.user_org_system.user_system.dao;

import cn.chen.user_org_system.common.entity.User;
import cn.chen.user_org_system.common.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<UserModel> findUser(int start, int length);
    User findUserById(Integer id);
    UserModel findModelById(Integer id);
    int updateUser(User user);
    int deleteUser(Integer id);
    int insertUser(User user);
    int count();
}
