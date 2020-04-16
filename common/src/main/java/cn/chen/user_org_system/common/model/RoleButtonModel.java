package cn.chen.user_org_system.common.model;

import cn.chen.user_org_system.common.entity.Button;
import cn.chen.user_org_system.common.entity.Role;

import java.util.Set;


public class RoleButtonModel {
    private Integer id;

    private Integer roleId;
    private Role role;


    private Set<Integer> buttonIds;

    public Integer getId() {
        return id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Integer> getButtonIds() {
        return buttonIds;
    }

    public void setButtonIds(Set<Integer> buttonIds) {
        this.buttonIds = buttonIds;
    }
}
