package com.autumnframework.login.model.vo;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 10:26 2017/9/5.
 */
public class VoMenu {
    private Integer id;
    private Integer sys;
    private String name;
    private String Status;
    private Integer disporder;
    private String type;
    private String level;
    private String parent_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSys() {
        return sys;
    }

    public void setSys(Integer sys) {
        this.sys = sys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
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

    @Override
    public String toString() {
        return "VoMenu{" +
                "id=" + id +
                ", sys=" + sys +
                ", name='" + name + '\'' +
                ", Status='" + Status + '\'' +
                ", disporder=" + disporder +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", parent_name='" + parent_name + '\'' +
                '}';
    }
}
