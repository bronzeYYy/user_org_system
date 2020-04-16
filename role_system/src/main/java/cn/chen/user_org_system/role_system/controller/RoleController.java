package cn.chen.user_org_system.role_system.controller;

import cn.chen.user_org_system.common.entity.Role;
import cn.chen.user_org_system.common.response.BaseResponse;
import cn.chen.user_org_system.role_system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping
    public BaseResponse find(@RequestParam(value = "id", required = false) Integer id,
                             @RequestParam(value = "page", required = false) Integer page) {
        return roleService.find(id, page);
    }
    @PostMapping
    public BaseResponse update(@RequestBody Role role) {
        return roleService.update(role);
    }
    @PutMapping
    public BaseResponse insert(@RequestBody Role role) {
        return roleService.insert(role);
    }
    @DeleteMapping
    public BaseResponse delete(Integer id) {
        return roleService.delete(id);
    }
}
