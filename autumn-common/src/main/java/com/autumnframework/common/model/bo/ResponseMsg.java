package com.autumnframework.common.model.bo;

import java.io.Serializable;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 11:25 2017/8/30.
 */
public class ResponseMsg implements Serializable {
    //返回Code
    private String code;
    //返回描述
    private String msg;
    //返回数据
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
