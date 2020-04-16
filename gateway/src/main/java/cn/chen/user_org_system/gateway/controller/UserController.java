package cn.chen.user_org_system.gateway.controller;

import cn.chen.user_org_system.common.entity.User;
import cn.chen.user_org_system.common.response.BaseResponse;
import cn.chen.user_org_system.gateway.login.SSO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 与用户相关的登陆等操作
 */
@RestController
@RequestMapping("/SSO")
public class UserController {
    @Autowired
    private SSO sso;
    @PostMapping("/login")
    public BaseResponse login(@RequestBody User user) {
        return sso.login(user);
    }
    @RequestMapping("/logout")
    public void logout(@RequestHeader("Token") String token) {
        sso.logout(token);
    }
    @RequestMapping("/user")
    public BaseResponse user(@RequestHeader("Token") String token) {
        return sso.user(token);
    }


    /**
     * 对用户的信息更改后远征调用进行更新用户信息
     * @param token
     * @return
     */
    @RequestMapping("/update")
    public BaseResponse update(@RequestHeader("Token") String token) {

        return sso.update(token);
    }

}
