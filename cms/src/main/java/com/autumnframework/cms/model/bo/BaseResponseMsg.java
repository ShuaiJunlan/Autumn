package com.autumnframework.cms.model.bo;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 16:02 2017/9/5.
 */
public class BaseResponseMsg {
    private int code;
    private String msg;
    private Object data;

    public BaseResponseMsg() {
    }

    public BaseResponseMsg(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    @Override
    public String toString() {
        return "BaseResponseMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
