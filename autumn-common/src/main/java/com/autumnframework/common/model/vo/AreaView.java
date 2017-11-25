package com.autumnframework.common.model.vo;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 15:48 2017/11/9.
 */
public class AreaView {
    private String name;
    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AreaView{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
