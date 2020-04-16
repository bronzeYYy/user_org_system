package cn.chen.user_org_system.common.model;

import cn.chen.user_org_system.common.entity.Button;

import java.util.List;
import java.util.Objects;

/**
 * 菜单传输的model
 */
public class MenuModel {
    private Integer id;
    private String name;
    private String note;
    private List<Button> buttons;

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuModel menuModel = (MenuModel) o;
        return Objects.equals(id, menuModel.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
