package com.autumnframework.cms.extern.utils;

import com.autumnframework.cms.extern.constant.ResponseCode;
import com.autumnframework.cms.model.bo.DataPageResponseMsg;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 16:09 2017/9/5.
 */
public class ResponseMsgUtil {
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
