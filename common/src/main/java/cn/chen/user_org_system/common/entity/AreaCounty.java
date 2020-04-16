package cn.chen.user_org_system.common.entity;

/**
 * 城区、县
 */
public class AreaCounty {
    private Integer id;
    private String name;
    /**
     * 所在市
     */
    private AreaCity areaCity;

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

    public AreaCity getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(AreaCity areaCity) {
        this.areaCity = areaCity;
    }

}
