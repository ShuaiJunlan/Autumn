package com.autumnframework.common.architect.constant;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 15:55 2017/9/5.
 */
public enum ResponseCode {

    //  请求失败
    REQUEST_FAIL("0000", "fail"),


    //  请求成功
    REQUEST_SUCCESS(    "1111", "successfully"),
    //  邮件发送成功
    MAIL_SEND_SUCCESS(  "1001", "send mail successfully"),
    //  认证成功
    AUTH_SUCCESS(       "1002", "auth successfully"),
    //  已认证
    HAVE_AUTH(          "1003", "have authentication"),
    //  邮箱验证成功
    EMAIL_VALID(        "1004", "email valid"),


    //  请求没有授权
    REQUEST_UNAUTHORIZED(   "3333", "fail"),
    //  没有权限获取数据
    GET_DATA_UNAUTHORIZED(  "3333", "unauthorized"),


    //  邮件发送失败
    MAIL_SEND_FAIL(     "4001", "send mail fairly"),
    //  认证失败
    AUTH_FAIL(          "4002", "auth fairly"),
    //  链接失效
    AUTH_LINK_TIMEOUT(  "4003", "link failure"),
    //  邮箱验证失败
    EMAIL_NOT_VALID(    "4004", "email not valid"),
    //  未认证
    HAVE_NOT_AUTH(      "4005", "have not authentication"),


    // 数据已存在
    DATA_EXIT("5000", "data exist")
    ;

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
