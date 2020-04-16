package cn.chen.user_org_system.common.entity;

/**
 * 对应数据库中的user表
 * 增加、修改时使用
 */
public class User {
    private Integer id;
    /**
     * 登陆的用户名
     */
    private String username;
    /**
     * md5加密后的密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    private String phone;
    /**
     * 所在机构id
     */
    private Integer orgId;
    /**
     * 角色id
     */
    private Integer roleId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


}
