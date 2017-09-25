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
package com.yxb.cms.domain.bo;


import com.yxb.cms.architect.view.ExcelView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * excel sheet导出条件封装类
 * @author yangxiaobing
 * @date 2017/8/5
 */
public class ExcelExport {
	/**
	 * excel导出的表头(必填)
	 */
	private List<String> titles = new ArrayList<String>();
	
	/**
	 * excel导出的列名(必填)
	 */
	private List<String> columns = new ArrayList<String>();
	/**
	 * excel导出的列的类型，目前支持String, Date, SysParameter, User<br>
	 * 例如列表的每一项可以是:<br>
	 * String(原始值)<br>
	 * Date或者Date_yyyy-MM(默认yyyy-MM-dd，可以自定义，下划线带上即可)<br>
	 * SysParameter_COMMON_STATUS(返回参数对应的参数descr)<br>
	 * User(返回id对应的用户名)<br>
	 * 如果不写，默认全部为String
	 */
	private List<String> columnTypes = new ArrayList<String>();
	
	/**
	 * 查询sql，这里禁用hql(必填)
	 */
	private String sql;
	
	/**
	 * 查询sql的参数，对象数组形式
	 */
	private Object[] paramsObj;
	
	/**
	 * 查询sql的参数，map形式
	 */
	private Map<String, Object> paramsMap;
	
	/**
	 * 数据列表（有数据，就不需要设置sql了）
	 */
	private List<?> dataList;
	
	/**
	 * 默认为"Export"，完整格式为："Export_N"，N为sheet下标，从1开始，每5w条记录换一个sheet
	 */
	private String sheetName;
	
	/**
	 * 添加列信息
	 * 
	 * @param title
	 * @param column
	 * @param columnType
	 */
	public void addColumnInfo(String title, String column, String columnType){
		titles.add(title);
		columns.add(column);
		columnTypes.add(columnType);
	}
	
	/**
	 * 添加列信息
	 * @param title
	 * @param column
	 */
	public void addColumnInfo(String title, String column){
		addColumnInfo(title, column, ExcelView.COLUMN_TYPE_STRING);
	}

	/**
	 * @return Returns the titles.
	 */
	public List<String> getTitles() {
		return titles;
	}

	/**
	 * @return Returns the columns.
	 */
	public List<String> getColumns() {
		return columns;
	}

	/**
	 * @return Returns the columnTypes.
	 */
	public List<String> getColumnTypes() {
		return columnTypes;
	}

	/**
	 * @return Returns the sql.
	 */
	public String getSql() {
		return sql;
	}

	/**
	 * @param sql The sql to set.
	 */
	public void setSql(String sql) {
		this.sql = sql;
	}

	/**
	 * @return Returns the paramsObj.
	 */
	public Object[] getParamsObj() {
		return paramsObj;
	}

	/**
	 * @param paramsObj The paramsObj to set.
	 */
	public void setParamsObj(Object[] paramsObj) {
		this.paramsObj = paramsObj;
	}

	/**
	 * @return Returns the paramsMap.
	 */
	public Map<String, Object> getParamsMap() {
		return paramsMap;
	}

	/**
	 * @param paramsMap The paramsMap to set.
	 */
	public void setParamsMap(Map<String, Object> paramsMap) {
		this.paramsMap = paramsMap;
	}

	/**
	 * @return Returns the sheetName.
	 */
	public String getSheetName() {
		return sheetName;
	}

	/**
	 * @param sheetName The sheetName to set.
	 */
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	/**
	 * @return Returns the dataList.
	 */
	public List<?> getDataList() {
		return dataList;
	}

	/**
	 * @param dataList The dataList to set.
	 */
	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}
}
