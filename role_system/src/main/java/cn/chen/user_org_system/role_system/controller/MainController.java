package cn.chen.user_org_system.role_system.controller;

import cn.chen.user_org_system.common.response.BaseResponse;
import cn.chen.user_org_system.role_system.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 当前登陆用户的角色相关操作
 * 网关已经验证请求用户的token 无需再次验证
 */
@RestController
public class MainController {
    @Autowired
    private MainService mainService;
    @GetMapping("/menus")
    public BaseResponse getMenus(String id) {
        return mainService.getMenus(id);
    }
}
