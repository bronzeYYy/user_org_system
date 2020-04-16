package cn.chen.user_org_system.role_system.service;

import cn.chen.user_org_system.common.response.BaseResponse;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    /**
     * 根据用户的id查询用户对应的菜单和按钮
     * 1.查询用户的权限
     * 2.根据权限查询对应的按钮
     * 3.根据按钮查询所在菜单
     * 4.组装数据
     * @param id 用户id
     * @return 返回结果
     */
    public BaseResponse getMenus(String id) {

        // todo 根据用户id查询用户权限对应的菜单、按钮

        return new BaseResponse();
    }
}
