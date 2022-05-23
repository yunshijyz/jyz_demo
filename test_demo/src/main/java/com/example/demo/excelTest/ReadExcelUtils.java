package com.example.demo.excelTest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReadExcelUtils {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final String EXCEL_XLS = ".xls";
    private static final String EXCEL_XLSX = ".xlsx";

    public static void main(String[] args) {

        List<List<String>> lists = null;
        try {
             lists = readExcelInfo("/Users/marinecol/excelTest/demo2.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (List<String> list : lists) {
            System.out.println(list);
        }

    }

    /**
     * 读取excel数据
     *
     * @throws Exception
     */
    public static List<List<String>> readExcelInfo(String fileName) throws Exception {
        /*
         * workbook:工作簿,就是整个Excel文档
         * sheet:工作表
         * row:行
         * cell:单元格
         */

        checkExcelValid(fileName);
        Workbook workbook = getWorkBook(fileName);
        List<List<String>> dataList = null;
        if (workbook != null) {
            int sheetNum = workbook.getNumberOfSheets();
            //创建二维数组保存所有读取到的行列数据，外层存行数据，内层存单元格数据
            dataList = new ArrayList<>();
            //遍历工作簿中的sheet,第一层循环所有sheet表
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            for (int index = 0; index < sheetNum; index++) {
                Sheet sheet = workbook.getSheetAt(index);
                if (sheet == null) {
                    continue;
                }
                //如果当前行没有数据跳出循环，第二层循环单sheet表中所有行
                for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    Row row = sheet.getRow(rowIndex);
                    //根据文件头可以控制从哪一行读取，在下面if中进行控制
                    if (row == null) {
                        continue;
                    }
                    //遍历每一行的每一列，第三层循环行中所有单元格
                    List<String> cellList = new ArrayList<>();
                    for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
                        Cell cell = row.getCell(cellIndex);
                        cellList.add(getCellValue(cell, evaluator));
                    }
                    dataList.add(cellList);
                }

            }
        }

        return dataList;
    }

    /**
     * 获取单元格的数据,暂时不支持公式
     */
    private static String getCellValue(Cell cell, FormulaEvaluator evaluator) {
        if (cell == null || cell.toString().trim().equals("")) {
            return null;
        }
        CellType cellType = cell.getCellType();
        String cellValue;
        if (cellType == CellType.STRING) {
            cellValue = cell.getStringCellValue().trim();
            cellValue = StringUtils.isEmpty(cellValue) ? "" : cellValue;
            return cellValue;
        }
        if (cellType == CellType.NUMERIC) {
            if (DateUtil.isCellDateFormatted(cell)) { //判断日期类型
                long time = cell.getDateCellValue().getTime();
                LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(time / 1000, (int) (time % 1000),
                        ZoneOffset.ofHours(8));
                cellValue = localDateTime.format(DATE_TIME_FORMATTER);
            } else { //否
                cellValue = new DecimalFormat("#.######").format(cell.getNumericCellValue());
            }
            return cellValue;
        }
        if (cellType == CellType.BOOLEAN) {
            cellValue = String.valueOf(cell.getBooleanCellValue());
            return cellValue;
        }
        if (cellType == CellType.FORMULA) {
            CellValue evaluate = evaluator.evaluate(cell);
            cellValue = evaluate.getStringValue();
            return cellValue;
        }
        return null;
    }

    /**
     * 判断excel的版本，并根据文件流数据获取workbook
     *
     * @throws IOException
     */
    private static Workbook getWorkBook(String fileName) throws Exception {
        Workbook workbook = null;
        if (fileName.endsWith(EXCEL_XLS)) {
            workbook = new HSSFWorkbook(new FileInputStream(fileName));
        } else if (fileName.endsWith(EXCEL_XLSX)) {
            workbook = new XSSFWorkbook(new FileInputStream(fileName));
        }
        return workbook;
    }

    /**
     * 校验文件是否为excel
     *
     * @throws Exception
     */
    private static void checkExcelValid(String fileName) throws Exception {
        if (!fileName.endsWith(EXCEL_XLS) && !fileName.endsWith(EXCEL_XLSX)) {
            throw new Exception("文件不是Excel");
        }
    }

}
