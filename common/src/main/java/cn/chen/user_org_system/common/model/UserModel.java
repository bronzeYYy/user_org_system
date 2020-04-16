package cn.chen.user_org_system.common.model;

import cn.chen.user_org_system.common.entity.Org;
import cn.chen.user_org_system.common.entity.Role;
import cn.chen.user_org_system.common.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 用来传输的用户模型
 */
public class UserModel {
    public UserModel() {}
    public UserModel(User user) {
        setId(user.getId());
        setUsername(user.getUsername());
        setNickname(user.getNickname());
        setPhone(user.getPhone());
        setOrgId(user.getOrgId());
        setRoleId(user.getRoleId());
        setStatus(user.getStatus());
        setLoginTime(user.getLoginTime());
        setCreateTime(user.getCreateTime());
        setPasswordUpdateTime(user.getPasswordUpdateTime());
    }
    private Integer id;
    /**
     * 登陆的用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    private String phone;
    /**
     * 所在机构id
     */
    @JsonIgnore
    private Integer orgId;
    private Org org;
    /**
     * 角色id
     */
    @JsonIgnore
    private Integer roleId;
    private Role role;
    /**
     * 账号状态
     * 1正常
     * 0锁定
     * 秘密输入次数超过5次锁定账号
     */
    private int status;
    /**
     * 这一次的登陆时间
     * 下次登陆时获取这个时间即为上次登陆时间
     */
    private String loginTime;
    /**
     * 登陆成功后的token
     */
    private String token;
    private String createTime;
    /**
     * 最近一次密码更新时间
     */
    private String passwordUpdateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPasswordUpdateTime() {
        return passwordUpdateTime;
    }

    public void setPasswordUpdateTime(String passwordUpdateTime) {
        this.passwordUpdateTime = passwordUpdateTime;
    }

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
