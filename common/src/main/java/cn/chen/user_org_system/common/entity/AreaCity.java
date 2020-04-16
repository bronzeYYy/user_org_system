package cn.chen.user_org_system.common.entity;

/**
 * 城市
 */
public class AreaCity {
    private Integer id;
    private String name;
    /**
     * 所属省
     * 直辖市该字段为null
     */
    private AreaProvince areaProvince;

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

    public AreaProvince getAreaProvince() {
        return areaProvince;
    }

    public void setAreaProvince(AreaProvince areaProvince) {
        this.areaProvince = areaProvince;
    }
}
