package cn.chen.user_org_system.common.entity;

public class Org {
    private Integer id;
    private String name;
    private OrgType orgType;
    private Org parentOrg;
    private AreaProvince areaProvince;
    private AreaCity areaCity;
    private AreaCounty areaCounty;
    private String address;
    private String phone;

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

    public OrgType getOrgType() {
        return orgType;
    }

    public void setOrgType(OrgType orgType) {
        this.orgType = orgType;
    }

    public Org getParentOrg() {
        return parentOrg;
    }

    public void setParentOrg(Org parentOrg) {
        this.parentOrg = parentOrg;
    }

    public AreaProvince getAreaProvince() {
        return areaProvince;
    }

    public void setAreaProvince(AreaProvince areaProvince) {
        this.areaProvince = areaProvince;
    }

    public AreaCity getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(AreaCity areaCity) {
        this.areaCity = areaCity;
    }

    public AreaCounty getAreaCounty() {
        return areaCounty;
    }

    public void setAreaCounty(AreaCounty areaCounty) {
        this.areaCounty = areaCounty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
