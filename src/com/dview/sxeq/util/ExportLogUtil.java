package com.dview.sxeq.util;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.dview.sxeq.model.Log;
import com.dview.sxeq.service.LogManager;

public class ExportLogUtil {

	public static Workbook getInputStream(LogManager logManager){
		
		Workbook wb = new HSSFWorkbook();
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet("系统日志");
		sheet.setAutobreaks(true);
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("操作人");
		row.createCell(1).setCellValue("内容");
		row.createCell(2).setCellValue("操作时间");
		
		sheet.setColumnWidth(2, 5000);
		sheet.setColumnWidth(3, 7000);
		row.createCell(3).setCellValue("备注");
		List<Log> logs = logManager.logList();
		
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setDataFormat(
		createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
		
		for(int i=0;i<logs.size();i++){
			Log log = logs.get(i);
			Row ro = sheet.createRow(i+1);
			ro.createCell(0).setCellValue(log.getUser().getUserName());
			ro.createCell(1).setCellValue(log.getContent());
			Cell cell = ro.createCell(2);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(log.getDate());
			
			ro.createCell(3).setCellValue(log.getRemark());
		}
		
		return wb;
	}
}
