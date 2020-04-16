package cn.chen.user_org_system.gateway.model;

import java.util.List;

public class NavModel {
    private String name;
    private String path;
    private String redirect;
    private String component;
    private Boolean alwaysShow;
    private MetaModel meta;
    private List<NavModel> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Boolean getAlwaysShow() {
        return alwaysShow;
    }

    public void setAlwaysShow(Boolean alwaysShow) {
        this.alwaysShow = alwaysShow;
    }

    public MetaModel getMeta() {
        return meta;
    }

    public void setMeta(MetaModel meta) {
        this.meta = meta;
    }

    public List<NavModel> getChildren() {
        return children;
    }

    public void setChildren(List<NavModel> children) {
        this.children = children;
    }
}
