package com.example.demo.excelTest;

import com.example.demo.entity.Question;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wcyong
 *
 * @date   2013-6-21
 */
public class TestReadMergeRegionExcel {

    public static void main(String[] args) throws IOException {


        FileInputStream fileInputStream = new FileInputStream("/Users/marinecol/excelTest/demo4.xlsx");

        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
//
//        Row row = sheet.getRow(0);
//        Cell cell = row.getCell(0);
//        String stringCellValue = cell.getStringCellValue();
//        System.out.println(stringCellValue);
//        Cell cell1 = row.getCell(3);
//        String stringCellValue1 = cell1.getStringCellValue();
//        System.out.println(stringCellValue1);
//
//        Row row1 = sheet.getRow(3);
//        int physicalNumberOfCells = row1.getPhysicalNumberOfCells();
//
//        System.out.println(physicalNumberOfCells);

        sheet.removeRow(sheet.getRow(1));
        /**
         * 获取内容部分
         */
        //获取所有的行数
        List<Question> questions = new ArrayList<>();
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < rows; i++) {
        //获取对应的行
            int num = 1;
            Row row = sheet.getRow(i);
            if (row != null) {
                // 获取所有的列数
                int cells = row.getPhysicalNumberOfCells();

                for (int j = 0; j < cells; j++) {
                    // 打印一下 行-列 号
                    System.out.print("[" + i + "-" + j + "]");

                    // 获取对应的列
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        CellType cellType = cell.getCellType();
                        Object value = "";
                        // 字符串类型
                        switch (cellType) {
                            case STRING:
                                value = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                // 转成字符串，以防止过长无法显示
                                value = cell.getNumericCellValue();
                                break;
                            case ERROR:
                                throw new RuntimeException("数据类型错误");
                            default:
                        }

                        if(2 == j){
                            Question question = new Question();
                            question.setContext(value.toString());
                            question.setType(1);
                            questions.add(question);
                        }
                        if(3 == j){
                            Question question = new Question();
                            question.setContext(value.toString());
                            question.setType(2);
                            questions.add(question);
                        }

                        System.out.println(value);
                    }


                }
            }

        }

    }



}
