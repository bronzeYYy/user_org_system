package cn.chen.user_org_system.gateway.controller;

import cn.chen.user_org_system.common.response.BaseResponse;
import cn.chen.user_org_system.gateway.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping("/role")
    public BaseResponse updateRole() {
        return roleService.updateRole();
    }
    @GetMapping("/menus")
    public BaseResponse getMenus(@RequestHeader("Token") String token) {
        return roleService.getMenus(token);
    }

    @GetMapping("/buttons")
    public BaseResponse getButtons(@RequestHeader("Token") String token, String system) {
        return roleService.getButtons(token, system);
    }
}
