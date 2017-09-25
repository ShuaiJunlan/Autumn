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
package com.autumnframework.login.architect.constant;

/**
 * 后台管理系统平台业返回状态码和状态描述<br>
 * 状态码概况:  状态码为4位    分割为2部分 状态码第一位为 模块信息，后面三位为 范围信息<br>
 * 模块信息:    0.通用（如系统）  1.系统管理(角色、资源、用户)等<br>
 * 范围信息:    1.操作成功范围 001-500，2.操作失败范围 501-999 特殊：0000 成功，9999异常<br>
 * 
 * @author yangxiaobing
 * @date   2016/8/15
 *
 *
 */
public enum BussinessCode {
	// 成功
	GLOBAL_SUCCESS("0000","成功"),
	//失败
	GLOBAL_ERROR("9999", "系统正在维护中,请稍后再试!"),



	/**通用 */
    GLOBAL_LOGIN_NAME_NULL("0501","用户名不能为空"),
    GLOBAL_LOGIN_PASS_NULL("0502","密码不能为空"),

	GLOBAL_LOGIN_FAIL("0503","用户名或密码不匹配"),

	GLOBAL_LOGIN_ERROR("0504","系统登录异常"),

    GLOBAL_CAPTCHA_NULL("0505","验证码不能为空"),

    GLOBAL_CAPTCHA_ERROR("0506","验证码输入错误"),




	RES_SAVE_ERROR("1501","菜单资源信息保存失败"),
	ROLE_SAVE_ERROR("1502","角色信息保存失败"),
	USER_SAVE_ERROR("1503","用户信息保存失败"),
	USER_ROLE_SAVE_ERROR("1504","用户分配角色信息失败"),
	USER_FAIL_ERROR("1505","失效用户失败,程序异常"),
	ROLE_FAILK_ERROR("1506","失效角色失败,程序异常"),
	RES_FAILK_ERROR("1507","失效资源失败,程序异常"),
    USER_LOGIN_NAME_EXIST("1508","用户账号已存在，请重新输入"),
    ROLE_RES_SAVE_ERROR("1509","角色分配菜单失败"),
    ROLE_NAME_EXIST("1508","角色名称已存在，请重新输入"),

    ;

	BussinessCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	private String code;

	private String msg;
	

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
