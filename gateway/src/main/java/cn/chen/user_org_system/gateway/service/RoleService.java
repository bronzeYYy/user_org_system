package cn.chen.user_org_system.gateway.service;

import cn.chen.user_org_system.common.entity.Button;
import cn.chen.user_org_system.common.entity.User;
import cn.chen.user_org_system.common.model.MenuModel;
import cn.chen.user_org_system.common.response.BaseResponse;
import cn.chen.user_org_system.common.response.DataResponse;
import cn.chen.user_org_system.gateway.dao.RoleDao;
import cn.chen.user_org_system.gateway.login.UserContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class RoleService {
    public RoleService() {
        systemMap.put("user", 1);
        systemMap.put("role", 2);
        systemMap.put("org", 3);
    }
    @Autowired
    private UserContainer userContainer;
    @Autowired
    private RoleDao roleDao;

    private Map<String, Integer> systemMap = new HashMap<>();
    public BaseResponse updateRole() {
        userContainer.addRoleButtons(roleDao.findAll());
        return BaseResponse.SUCCESS;
    }

    public BaseResponse getMenus(String token) {
        User user = userContainer.get(token);
        if (user == null) {
            return BaseResponse.PLEASE_LOGIN_RESPONSE;
        }
        if (user.getRoleId() == null) {
            return BaseResponse.fail("请先申请权限");
        }
        Set<Integer> buttonIds = userContainer.getButtonIds(user.getRoleId());
        Set<MenuModel> menuModels = roleDao.findMenuByButtonIds(buttonIds);
        List<Button> buttons = roleDao.findButtonByIds(buttonIds);
        menuModels.forEach(menuModel -> {
            List<Button> buttons1 = new LinkedList<>();
            buttons.forEach(button -> {
                if (button.getMenuId().equals(menuModel.getId())) {
                    buttons1.add(button);
                }
            });
            menuModel.setButtons(buttons1);
        });
        return new DataResponse<>(menuModels);
    }

    public BaseResponse getButtons(String token, String system) {
        Integer menuId;
        if ((menuId = systemMap.get(system)) == null) {
            return BaseResponse.fail("参数错误");
        }
        User user = userContainer.get(token);
        if (user == null) {
            return BaseResponse.PLEASE_LOGIN_RESPONSE;
        }
        if (user.getRoleId() == null) {
            return BaseResponse.fail("请先申请权限");
        }
        Set<Integer> buttonIds = userContainer.getButtonIds(user.getRoleId());
        Set<Integer> collect = buttonIds.stream().filter(buttonId -> menuId.equals((buttonId - 1) / 4 + 1)).collect(Collectors.toSet());
        return new DataResponse<>(collect);
    }
}
