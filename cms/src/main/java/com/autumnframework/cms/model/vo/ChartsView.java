package com.autumnframework.cms.model.vo;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 16:44 2017/11/2.
 */
public class ChartsView {
    private String x;
    private Integer y;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "ChartsView{" +
                "x='" + x + '\'' +
                ", y=" + y +
                '}';
    }
}
