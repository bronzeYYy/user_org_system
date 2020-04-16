package cn.chen.user_org_system.gateway.login;

import cn.chen.user_org_system.common.entity.RoleButton;
import cn.chen.user_org_system.common.entity.User;
import cn.chen.user_org_system.common.model.UserModel;
import cn.chen.user_org_system.common.response.BaseResponse;
import cn.chen.user_org_system.common.response.DataResponse;

import java.util.List;

public interface SSO {
    /**
     * 提供用户名密码 进行登陆
     *
     * @param user 用户名密码
     *
     * @return 登陆成功的用户
     */
    BaseResponse login(User user);

    void logout(String token);

    BaseResponse user(String token);


    BaseResponse update(String token);
}
