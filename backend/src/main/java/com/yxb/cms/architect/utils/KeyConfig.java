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

import java.util.ArrayList;
import java.util.List;

/**
 * 定义一些code的生成方式,生成随机数，根据每次的随机结果定义
 *
 * @author yangxiaobing
 * @date 2017/8/15
 */
public class KeyConfig {
		
	static char[] seeds={'1','2','3','4','5','6','7','8','9','0','a','b','c','d','e','f','g','h','i',
        'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E',
        'F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	
	/**
	 * 生成八位资源菜单CODE
	 * @return
	 */
	 public static synchronized String randomResourceModeCode(){
			
			StringBuffer seed= new StringBuffer();
			for (int i = 0; i < 8; i++) {
				//生成一个62内的随机数
				Integer random =  (int) (Math.random()*62);			
				seed.append(seeds[random]);			
			}						
			return seed.toString();
	 }
	
	public static void main(String[] args) throws InterruptedException {
		Integer i=0;
		List<String> seeds= new ArrayList<String>();
		while(i<1000){
			seeds.add(randomResourceModeCode());
			i++;
			Thread.sleep(1L);
		}
	    
	      List<String>  result = new ArrayList<String>();
	      
	     
	     for (String string : seeds) {
			if(result.contains(string)){
				
				System.out.println("seed 重复："+string);			
			}else{
				result.add(string);
				System.out.println(string);
			}
	    	 
		}	     	     	     
	   
		}
	
	
	}
