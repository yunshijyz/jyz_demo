package com.example.demo.com;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

public class ExcelTest4 {

    public static void main(String[] args) {

        long l = System.currentTimeMillis();
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet();
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("自定义 XSSF 颜色");
        XSSFCellStyle style1 = wb.createCellStyle();
        style1.setFillForegroundColor(new XSSFColor(new java.awt.Color(128, 0, 128), new DefaultIndexedColorMap()));
        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);


        ExcelTest3.outPut(l, wb);

    }
}
