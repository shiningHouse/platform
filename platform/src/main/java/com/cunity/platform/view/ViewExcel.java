package com.cunity.platform.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractExcelView;

@Component
public class ViewExcel extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		Sheet sheet = workbook.createSheet("sheet 1");
		CellStyle style = workbook.createCellStyle();
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		
		Row row = null;
		Cell cell = null;
		
		int rowCount = 0;
		int colCount = 0;
		
		// create header cells
		row = sheet.createRow(rowCount++);
		
		cell = row.createCell(colCount++);
		cell.setCellStyle(style);
		cell.setCellValue("name");
		
		cell = row.createCell(colCount++);
		cell.setCellStyle(style);
		cell.setCellValue("score");
		
		// create data cell
		row = sheet.createRow(rowCount++);
		
		
		
	}

}
