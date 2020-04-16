package cn.chen.user_org_system.gateway.login;

import cn.chen.user_org_system.common.entity.Button;
import cn.chen.user_org_system.common.entity.User;
import cn.chen.user_org_system.common.model.RoleButtonModel;

import java.util.List;
import java.util.Set;

public interface UserContainer {
    void addUser(String token, User user);
    void deleteUser(String token);
    User get(String token);

    /***                权限相关操作                ***/
    void addRoleButtons(List<RoleButtonModel> roleButtons);

    boolean containsButton(Integer roleId, Integer buttonId);

    Set<Integer> getButtonIds(Integer roleId);
}
