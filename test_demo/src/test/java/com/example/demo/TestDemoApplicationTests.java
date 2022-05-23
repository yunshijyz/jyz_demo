package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Question;
import com.example.demo.entity.TestExcel;
import com.example.demo.utils.ImportExcelHelper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@SpringBootTest
class TestDemoApplicationTests {

    @Test
    void contextLoads() throws IOException {
        File file = new File("/Users/marinecol/excelTest/demo3.xlsx");
        MultipartFile multipartFile = new MockMultipartFile("/Users/marinecol/excelTest/demo4.xlsx", new FileInputStream("/Users/marinecol/excelTest/demo4.xlsx"));
        ImportExcelHelper<Question> helper = new ImportExcelHelper<>();
        List<Question> list = helper.getList(multipartFile, Question.class, 0, 2);
        System.out.println(JSON.toJSONString(list));
    }

}
