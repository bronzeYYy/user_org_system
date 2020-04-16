package cn.chen.user_org_system.user_system.controller;

import cn.chen.user_org_system.common.entity.User;
import cn.chen.user_org_system.common.response.BaseResponse;
import cn.chen.user_org_system.user_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public BaseResponse findUser(@RequestParam(value = "id", required = false) Integer id,
                                 @RequestParam(value = "page", required = false) Integer page) {
        return userService.findUser(id, page);
    }
    @PostMapping
    public BaseResponse updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
    @DeleteMapping
    public BaseResponse deleteUser(Integer id) {
        return userService.deleteUser(id);
    }
    @PutMapping
    public BaseResponse insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }
}
