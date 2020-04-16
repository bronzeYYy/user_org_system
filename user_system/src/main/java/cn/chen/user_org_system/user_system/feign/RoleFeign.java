package cn.chen.user_org_system.user_system.feign;

import cn.chen.user_org_system.common.entity.Role;
import cn.chen.user_org_system.common.response.DataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("role")
public interface RoleFeign {
    @GetMapping("/role")
    DataResponse<Role> find(@RequestParam(value = "id", required = false) Integer id,
                            @RequestParam(value = "page", required = false) Integer page);
}
