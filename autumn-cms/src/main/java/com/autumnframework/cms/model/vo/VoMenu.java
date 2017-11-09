package com.autumnframework.cms.model.vo;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 10:26 2017/9/5.
 */
public class VoMenu {
    private Integer id;
    private String sys;
    private String name;
    private String namee;
    private String namec;
    private String status;
    private Integer disporder;
    private String type;
    private String level;
    private String parent_name;
    private String icon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSys() {
        return sys;
    }

    public void setSys(String sys) {
        this.sys = sys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamee() {
        return namee;
    }

    public void setNamee(String namee) {
        this.namee = namee;
    }

    public String getNamec() {
        return namec;
    }

    public void setNamec(String namec) {
        this.namec = namec;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDisporder() {
        return disporder;
    }

    public void setDisporder(Integer disporder) {
        this.disporder = disporder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "VoMenu{" +
                "id=" + id +
                ", sys='" + sys + '\'' +
                ", name='" + name + '\'' +
                ", namee='" + namee + '\'' +
                ", namec='" + namec + '\'' +
                ", status='" + status + '\'' +
                ", disporder=" + disporder +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", parent_name='" + parent_name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
