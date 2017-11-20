package com.autumnframework.common.architect.constant;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 15:55 2017/9/5.
 */
public enum ResponseCode {

    //  没有权限获取数据
    GET_DATA_UNAUTHORIZED("3333", "unauthorized"),
    //  请求成功
    REQUEST_SUCCESS("1111", "successfully"),
    //  请求失败
    REQUEST_FAIL("0000", "fail"),

    //  请求没有授权
    REQUEST_UNAUTHORIZED("3333", "fail"),

    // 数据已存在
    DATA_EXIT("5000", "data exist");


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
