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
package com.autumnframework.common.architect.constant;


/**
 * 系统管理平台业务常量定义
 *
 * @author yangxiaobing
 * @date   2016/8/15
 */
public enum BusinessConstants {

	/**用户状态*/
	SYS_USER_STATUS_0(0,"0-无效"),
	SYS_USER_STATUS_1(1,"1-有效"),



	/**角色状态*/
	SYS_ROLE_STATUS_0(0,"0-有效"),
	SYS_ROLE_STATUS_1(1,"1-失效"),
	
	
	/**菜单资源类型*/
	SYS_RES_TYPE_0(0,"0-菜单"),
	SYS_RES_TYPE_1(1,"1-按钮"),
	
	/**菜单资源状态*/
	SYS_RES_STATUS_0(0,"0-有效"),
	SYS_RES_STATUS_1(1,"1-失效"),

    /**菜单级别*/
    SYS_RES_LEVEL_1(1,"一级菜单"),
    SYS_RES_LEVEL_2(2,"二级菜单"),
    SYS_RES_LEVEL_3(3,"三级菜单"),

	/**菜单状态*/
	SYS_MENU_STATUS_0(0,"失效"),
	SYS_MENU_STATUS_1(1,"有效");


	BusinessConstants(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	private Integer code;

	private String msg;
	

	
	
	public String toJson(){

	return "{\"code\":\"" + code + "\",\"msg\":\"" + msg + "!\"}";
		
	}
	
	
	
	
	public BusinessConstants getByCode(Integer code){
		for(BusinessConstants mc : values()){
			if(mc.getCode().equals(code)){
				return mc;
			}
		}
		return null;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public static void main(String[] args){
		for (BusinessConstants msg : values()) {
			System.out.println(msg.getCode()+"\t"+msg.getMsg());
		}
	}
}
