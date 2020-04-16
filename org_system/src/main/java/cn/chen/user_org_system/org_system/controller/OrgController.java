package cn.chen.user_org_system.org_system.controller;

import cn.chen.user_org_system.common.entity.Org;
import cn.chen.user_org_system.common.response.BaseResponse;
import cn.chen.user_org_system.org_system.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/org")
public class OrgController {
    @Autowired
    private OrgService orgService;
    @GetMapping
    public BaseResponse findOrg(@RequestParam(value = "id", required = false) Integer id,
                                @RequestParam(value = "page", required = false) Integer page) {
        return orgService.findOrg(id, page);
    }
    @PostMapping
    public BaseResponse updateOrg(@RequestBody Org org) {
        return orgService.updateOrg(org);
    }
    @PutMapping
    public BaseResponse insertOrg(@RequestBody Org org) {
        return orgService.insertOrg(org);
    }
    @DeleteMapping
    public BaseResponse deleteOrg(Integer id) {
        return orgService.deleteOrg(id);
    }
}
