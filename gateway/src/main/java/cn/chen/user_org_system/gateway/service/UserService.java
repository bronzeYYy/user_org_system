package cn.chen.user_org_system.gateway.service;

import cn.chen.user_org_system.common.entity.User;
import cn.chen.user_org_system.common.model.UserModel;
import cn.chen.user_org_system.common.response.BaseResponse;
import cn.chen.user_org_system.common.response.DataResponse;
import cn.chen.user_org_system.gateway.dao.UserDao;
import cn.chen.user_org_system.gateway.login.SSO;
import cn.chen.user_org_system.gateway.login.UserContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements SSO {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserContainer userContainer;
    public BaseResponse login(User user) {
        user = userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (user == null) {
            return BaseResponse.fail("用户名密码不匹配");
        }
        DataResponse<UserModel> dataResponse = new DataResponse<>();
        UserModel userModel = userModel(user);
        dataResponse.setData(userModel);
        String token = UUID.randomUUID().toString();
        userModel.setToken(token);
        userContainer.addUser(token, user);
        return dataResponse;
    }

    @Override
    public void logout(String token) {
        userContainer.deleteUser(token);
    }

    @Override
    public BaseResponse user(String token) {
        User user = userContainer.get(token);
        if (user == null) {
            return BaseResponse.PLEASE_LOGIN_RESPONSE;
        }
        return new DataResponse<>(userModel(user));
    }

    public BaseResponse update(String token) {
        User user = userContainer.get(token);
        if (user == null) {
            return BaseResponse.fail("用户不存在");
        }
        userContainer.deleteUser(token);
        userContainer.addUser(token, userDao.findById(user.getId()));
        return BaseResponse.SUCCESS;
    }

    public UserModel userModel(User user) {
        return user == null ? null : new UserModel(user);
    }
}
