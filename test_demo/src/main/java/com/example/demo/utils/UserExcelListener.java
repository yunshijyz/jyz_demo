package com.example.demo.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.example.demo.entity.UserExcel;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class UserExcelListener extends AnalysisEventListener {

    /**
     * 批处理阈值
     */
    private static final int BATCH_COUNT = 3;
    List<UserExcel> list = new ArrayList<UserExcel>(BATCH_COUNT);



    @Override
    public void invoke(Object user, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(user));
        UserExcel userExcel = (UserExcel) user;
        list.add(userExcel);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("进入doAfterAllAnalysed");
        saveData();
        log.info("所有数据解析完成！");
    }

    private void saveData(){
        log.info("{}条数据，开始存储数据库！", list.size());
        log.info("存储数据库成功！");
    }


}
