package com.autumnframework.cms.architect.constant;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 15:55 2017/9/5.
 */
public enum ResponseCode {

    //  get data success
    REQUEST_SUCCESS("1111", "successfully"),
    REQUEST_FAIL("0000", "fail");

    private String code;
    private String msg;
    ResponseCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

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
}
