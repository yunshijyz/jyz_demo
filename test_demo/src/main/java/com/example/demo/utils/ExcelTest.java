package com.example.demo.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.fastjson.JSON;
import com.example.demo.entity.UserExcel;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;
import java.util.Map;

@Slf4j
public class ExcelTest {

    public static void main(String[] args) {

        String fileName = TestFileUtil.getPath() + "demo1" + File.separator + "demo1.xlsx";
        //File file = new File("/Users/marinecol/excelTest/demo1.xlsx");
        //String name = file.getName();
        String name = "/Users/marinecol/excelTest/demo1.xlsx";
        log.info("name:{}",name);
        excelTest2(name);
    }

    public static void readExcel(String fileName){
        EasyExcel.read(fileName, UserExcel.class,new UserExcelListener()).sheet().doRead();
    }



    public static void excelTest2(String fileName){

//        fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, UserExcel.class, new ReadListener<UserExcel>() {
            /**
             * 单次缓存的数据量
             */
            public static final int BATCH_COUNT = 100;
            /**
             *临时存储
             */
            private List<UserExcel> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);


            @Override
            public void invoke(UserExcel data, AnalysisContext context) {
                log.info("接收到一条数据:{}", JSON.toJSONString(data));
                cachedDataList.add(data);
                if (cachedDataList.size() >= BATCH_COUNT) {
                    saveData();
                    // 存储完成清理 list
                    cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
                }
            }


            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                saveData();
            }

            /**
             * 加上存储数据库
             */
            private void saveData() {
                log.info("{}条数据，开始存储数据库！", cachedDataList.size());
                log.info("存储数据库成功！");
            }
        }).sheet().doRead();
    }
}
