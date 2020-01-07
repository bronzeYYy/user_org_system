package cn.chen.user_org_system.user_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class TestController {
    @RequestMapping("/test")
    public Map<String, Object> test() {
        return Collections.singletonMap("张三", 3);
    }
}
