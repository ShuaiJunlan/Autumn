/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2017 © yangxiaobing, 873559947@qq.com
 *
 * This file is part of contentManagerSystem.
 * contentManagerSystem is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * contentManagerSystem is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with contentManagerSystem.  If not, see <http://www.gnu.org/licenses/>.
 *
 * 这个文件是contentManagerSystem的一部分。
 * 您可以单独使用或分发这个文件，但请不要移除这个头部声明信息.
 * contentManagerSystem是一个自由软件，您可以自由分发、修改其中的源代码或者重新发布它，
 * 新的任何修改后的重新发布版必须同样在遵守GPL3或更后续的版本协议下发布.
 * 关于GPL协议的细则请参考COPYING文件，
 * 您可以在contentManagerSystem的相关目录中获得GPL协议的副本，
 * 如果没有找到，请连接到 http://www.gnu.org/licenses/ 查看。
 *
 * - Author: yangxiaobing
 * - Contact: 873559947@qq.com
 * - License: GNU Lesser General Public License (GPL)
 * - source code availability: http://git.oschina.net/yangxiaobing_175/contentManagerSystem
 */
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
