package cn.chen.user_org_system.common.entity;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * 省
 */
public class AreaProvince {
    private Integer id;
    private String name;

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

    @Override
    public String toString() {
        return "AreaProvince{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
