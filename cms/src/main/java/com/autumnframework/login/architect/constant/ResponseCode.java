package com.autumnframework.login.architect.constant;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 15:55 2017/9/5.
 */
public enum ResponseCode {

    //  get data success
    GET_DATA_SUCCESS(0, "successfully");

    private int code;
    private String msg;
    ResponseCode(int code, String msg){
        this.code = code;
        this.msg = msg;
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
}
