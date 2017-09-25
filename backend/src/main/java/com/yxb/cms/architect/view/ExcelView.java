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
package com.yxb.cms.architect.view;

import com.yxb.cms.domain.bo.ExcelExport;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;


/**
 * Excel导出view
 *
 * @author yangxiaobing
 * @date 2017/8/5
 *
 */
public class ExcelView extends AbstractExcelView {

	/**
	 * 定义excel export Bean在model中的key
	 */
	public static final String EXCEL_EXPORT_BEAN = "EXCEL_EXPORT_BEAN";
	
	/**
	 * 定义excel export 的excel名字
	 */
	public static final String EXCEL_EXPORT_NAME = "EXCEL_EXPORT_NAME";
	
	/**
	 * 定义excel export 的type:1:单sheet， 2：多sheet
	 */
	public static final String EXCEL_EXPORT_TYPE = "EXCEL_EXPORT_TYPE";
	
	/**
	 * excel export type 1：单sheet
	 */
	public static final String EXCEL_EXPORT_TYPE_SINGLE_SHEET = "1";
	
	/**
	 * excel export type 2：多sheet
	 */
	public static final String EXCEL_EXPORT_TYPE_MULTIPLE_SHEET = "2";

	/**
	 * 定义excel每个sheet展示的记录数
	 */
	private static final int EXCEL_SHEET_RECORD_NUM = 50000;

	/** 定义字段类型:String **/
	public static final String COLUMN_TYPE_STRING = "String";
	/** 定义字段类型:Date， 可以按需要跟下划线和format格式，默认yyyy-MM-dd **/
	public static final String COLUMN_TYPE_DATE = "Date";
	/** 定义字段类型:SysParameter，必须跟下划线和参数name **/
	public static final String COLUMN_TYPE_SYS_PARAMETER = "SysParameter";
	/** 定义字段类型:User，根据用户id获取名称 **/
	public static final String COLUMN_TYPE_USER = "User";

	/** 定义字段分隔符,当日期或系统参数类型的时候，用下划线分隔 **/
	public static final String COLUMN_TYPE_SEPERATOR = "_";

	/**
	 * 实现基类的excel生成方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 设置excelName
		String excelName = (String) model.get(EXCEL_EXPORT_NAME);
		excelName = excelName == null ? "Export" : excelName;
		
		//获取导出类型
		String excelExportType = (String)model.get(EXCEL_EXPORT_TYPE);
		
		if(EXCEL_EXPORT_TYPE_SINGLE_SHEET.equals(excelExportType)){
			// 取得excel export实体类
			ExcelExport excelExport = (ExcelExport) model.get(EXCEL_EXPORT_BEAN);
			generateSheetByExcelExport(workbook, excelExport);
		}else{
			// 取得excel export实体类
			List<ExcelExport> excelExportList = (List<ExcelExport>) model.get(EXCEL_EXPORT_BEAN);
			for(ExcelExport excelExport : excelExportList){
				generateSheetByExcelExport(workbook, excelExport);
			}
		}


		response.setHeader("Content-Disposition", "attachment;Filename="
				+ URLEncoder.encode(excelName, "UTF-8") + ".xls");
		// 设置缓冲
		response.setBufferSize(1024 * 1024);

		// no need to flush the output stream, the parent class has done it
	}

	/**
	 * 根据 excel export生成sheet
	 * 
	 * @param workbook
	 * @param excelExport
	 * @throws Exception
	 */
	private void generateSheetByExcelExport(HSSFWorkbook workbook,
			ExcelExport excelExport) throws Exception {
		// 设置sheetName
		String sheetName = excelExport.getSheetName();
		sheetName = sheetName == null ? "Export" : sheetName;

		// 查询记录
		List<?> resultList = queryResult(excelExport);
		int recordNum = resultList.size();

		// 创建sheet
		HSSFSheet currentSheet = null;
		for (int i = 0; i < (recordNum / EXCEL_SHEET_RECORD_NUM + 1); i++) {
			String currentSheetName = sheetName;
			if (recordNum > EXCEL_SHEET_RECORD_NUM) {
				currentSheetName += "_" + (i + 1);
			}
			currentSheet = workbook.createSheet(currentSheetName);
			int fromIndex = i * EXCEL_SHEET_RECORD_NUM;
			int toIndex = (i + 1) * EXCEL_SHEET_RECORD_NUM;
			if (toIndex > recordNum) {
				toIndex = recordNum;
			}
			writeSheet(workbook, currentSheet, excelExport,
					resultList.subList(fromIndex, toIndex));
		}
	}

	/**
	 * 查询结果
	 * 
	 * @param excelExport
	 * @return 查询结果
	 */
	private List<?> queryResult(ExcelExport excelExport) {
		// 如果直接设置了数据列表，直接返回数据列表
		if (excelExport.getDataList() != null) {
			return excelExport.getDataList();
		}
		return null;
	}

	/**
	 * 根据对象获取列值
	 * 
	 * @param obj
	 * @param column
	 * @return 列值
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	private Object getColumnValue(Object obj, String column) throws Exception {
		if (obj instanceof Map) {
			return ((Map) obj).get(column);

		} else {
			Method method = obj.getClass().getMethod(getMethodName(column));
			return ReflectionUtils.invokeMethod(method, obj);
		}
	}

	/**
	 * 写excel sheet的数据
	 * 
	 * @param workbook
	 * @param currentSheet
	 * @param excelExport
	 * @param data
	 * @throws Exception
	 */
	private void writeSheet(HSSFWorkbook workbook, HSSFSheet currentSheet,
			ExcelExport excelExport, List<?> data) throws Exception {
		// 创建列头
		HSSFRow row = currentSheet.createRow(0);

		// 设置表头颜色
		HSSFCellStyle cellStyle = workbook.createCellStyle();

		cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT
				.getIndex());
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		// 设置title
		List<String> titles = excelExport.getTitles();
		for (int i = 0; i < titles.size(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(titles.get(i));
			cell.setCellStyle(cellStyle);
		}

		// 设置行值
		List<String> columns = excelExport.getColumns();
		List<String> columnTypes = excelExport.getColumnTypes();
		for (int i = 0; i < data.size(); i++) {
			HSSFRow dataRow = currentSheet.createRow(i + 1);
			for (int j = 0; j < columns.size(); j++) {
				// 创建单元格
				HSSFCell dataCell = dataRow.createCell(j);

				// 当前单元格的type, 默认string，这里不允许也不可能为空
				String columnType = COLUMN_TYPE_STRING;
				if (columnTypes.size() == columns.size()) {
					columnType = columnTypes.get(j);
				}

				// 当前单元格的值
				Object columnValue = getColumnValue(data.get(i), columns.get(j));

				if (columnType.startsWith(COLUMN_TYPE_DATE)) {
					SimpleDateFormat sdf;
					if (columnType.startsWith(COLUMN_TYPE_DATE
							+ COLUMN_TYPE_SEPERATOR)) {
						sdf = new SimpleDateFormat(
								columnType
										.substring((COLUMN_TYPE_DATE + COLUMN_TYPE_SEPERATOR)
												.length()));
					} else {
						sdf = new SimpleDateFormat("yyyy-MM-dd");
					}
					dataCell.setCellValue(columnValue == null ? "" : sdf
							.format(columnValue));
				} else {
					if(columnValue instanceof Double){
						dataCell.setCellValue(columnValue == null ? "" : BigDecimal
								.valueOf((Double)columnValue).toString());
					}else if(columnValue instanceof Long){
						dataCell.setCellValue(columnValue == null ? "" : BigDecimal
								.valueOf((Long)columnValue).toString());
					}else{
						dataCell.setCellValue(columnValue == null ? "" : String
								.valueOf(columnValue));
					}
				}
			}
		}
	}

	/**
	 * 获得column的get方法的名字
	 * 
	 * @param column
	 * @return get方法的名字
	 */
	private String getMethodName(String column) {
		return "get" + column.substring(0, 1).toUpperCase() + column.substring(1);
	}
}
