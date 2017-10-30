package com.autumnframework.cms.model.vo;

import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 16:21 2017/9/4.
 */
public class SysMenu {
    public class ChildMenu{
        private String menu_name;
        private String href;

        public String getMenu_name() {
            return menu_name;
        }

        public void setMenu_name(String menu_name) {
            this.menu_name = menu_name;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        @Override
        public String toString() {
            return "ChildMenu{" +
                    "menu_name='" + menu_name + '\'' +
                    ", href='" + href + '\'' +
                    '}';
        }
    }
    private String menu_name;
    private String href;
    private Integer child_num;
    private List<ChildMenu> childes;

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getChild_num() {
        return child_num;
    }

    public void setChild_num(Integer child_num) {
        this.child_num = child_num;
    }

    public List<ChildMenu> getChildes() {
        return childes;
    }

    public void setChildes(List<ChildMenu> childes) {
        this.childes = childes;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "menu_name='" + menu_name + '\'' +
                ", href='" + href + '\'' +
                ", child_num=" + child_num +
                ", childs=" + childes +
                '}';
    }
}
