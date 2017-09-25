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
package com.yxb.cms.architect.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 对象转换解析工具类
 *
 * @author yangxiaobing
 * @date 2017/4/7
 */
public class ParseObjectUtils {
	
	
	/**
	 * 将以逗号分割的字符串数组转换为Int型数组
	 * @param strs 逗号分割字符
	 * @return
	 */
	public static Integer[] strArrayToIntArray(String strs){
		if(StringUtils.isNotEmpty(strs)){
			String[] str=strs.split(",");
			
			Integer[] intArray = new Integer[str.length];
			for (int i = 0; i < str.length; i++) {
				intArray[i] = Integer.parseInt(str[i]);
			}
			return intArray;
		}
		return new Integer[0];
	}
		
	

}
