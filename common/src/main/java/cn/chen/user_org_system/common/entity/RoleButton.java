package cn.chen.user_org_system.common.entity;


/**
 * 角色与按钮对应关系
 */
public class RoleButton {
    private Integer id;
    private Role role;
    /**
     * 一个角色可能有很多按钮
     * todo 更改类型为list
     */
    private Button button;

    public Integer getId() {
        return id;
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

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
