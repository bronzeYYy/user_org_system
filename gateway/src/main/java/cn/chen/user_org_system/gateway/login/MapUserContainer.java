package cn.chen.user_org_system.gateway.login;

import cn.chen.user_org_system.common.entity.Button;
import cn.chen.user_org_system.common.entity.User;
import cn.chen.user_org_system.common.model.RoleButtonModel;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MapUserContainer implements UserContainer {
    private Map<String, User> container = new ConcurrentHashMap<>();
    // roleId -> set<buttonId>
    private Map<Integer, Set<Integer>> roleButtonsMap = new ConcurrentHashMap<>();
    @Override
    public void addUser(String token, User user) {
        container.put(token, user);
    }

    @Override
    public void deleteUser(String token) {
        container.remove(token);
    }

    @Override
    public User get(String token) {
        return container.get(token);
    }

    @Override
    public void addRoleButtons(List<RoleButtonModel> roleButtons) {
        roleButtonsMap.clear();
        roleButtons.forEach(rb -> {
            roleButtonsMap.put(rb.getRoleId(), rb.getButtonIds());
        });
    }

    @Override
    public boolean containsButton(Integer roleId, Integer buttonId) {
        Set<Integer> set = roleButtonsMap.get(roleId);

        return set != null && set.contains(buttonId);
    }

    @Override
    public Set<Integer> getButtonIds(Integer roleId) {
        return roleButtonsMap.get(roleId);
    }
}
