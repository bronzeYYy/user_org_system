package cn.chen.user_org_system.common.entity;

/**
 * 角色
 */
public class Button {
    private Integer id;
    private String name;
    /**
     * 所在菜单
     */
    private Menu menu;
    private Integer menuId;
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "Button{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", menu=" + menu +
                ", note='" + note + '\'' +
                '}';
    }
}
