package com.autumnframework.common.architect.utils;



import com.autumnframework.common.architect.constant.BussinessCode;
import com.autumnframework.common.architect.constant.ResponseCode;
import com.autumnframework.common.model.bo.DataPageResponseMsg;
import com.autumnframework.common.model.bo.ResponseMsg;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 16:09 2017/9/5.
 */

public class ResponseMsgUtil {

    /**
     * 返回消息代码code 和 message
     *
     * @param bussinessCode 返回码
     * @return
     */
    public static ResponseMsg returnCodeMessage(BussinessCode bussinessCode) {
        return returnCodeMessage(bussinessCode, null);
    }
    /**
     * 返回消息代码code 和 message
     *
     * @param responseCode 返回码
     * @return
     */
    public static ResponseMsg returnCodeMessage(ResponseCode responseCode) {
        return returnCodeMessage(responseCode, null);
    }


    /**
     * 返回消息代码和数据
     *
     * @param bussinessCode 返回码
     * @param returnData    返回数据
     * @return
     */
    public static ResponseMsg returnCodeMessage(BussinessCode bussinessCode, Object returnData) {
        ResponseMsg ResponseMsg = new ResponseMsg();
        ResponseMsg.setCode(bussinessCode.getCode());
        ResponseMsg.setMsg(bussinessCode.getMsg());
        ResponseMsg.setData(returnData);
        return ResponseMsg;
    }
    /**
     * 返回消息代码和数据
     *
     * @param responseCode 返回码
     * @param returnData    返回数据
     * @return
     */
    public static ResponseMsg returnCodeMessage(ResponseCode responseCode, Object returnData) {
        ResponseMsg ResponseMsg = new ResponseMsg();
        ResponseMsg.setCode(responseCode.getCode());
        ResponseMsg.setMsg(responseCode.getMsg());
        ResponseMsg.setData(returnData);
        return ResponseMsg;
    }

    /**
     * 前端分页插件要求格式数据
     * @param responseCode
     * @param returnData
     * @param count
     * @return
     */
    public static DataPageResponseMsg returnCodeMessage(ResponseCode responseCode, Object returnData, int count) {
        DataPageResponseMsg dataPageResponseMsg = new DataPageResponseMsg(responseCode.getCode(), responseCode.getMsg(), returnData, count);
        return dataPageResponseMsg;
    }

}
