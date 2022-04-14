package com.demo.mybatis_plus.mybatis_plus_demo.controller;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.mybatis_plus.mybatis_plus_demo.entity.TestJson;
import com.demo.mybatis_plus.mybatis_plus_demo.entity.WarnMes;
import com.demo.mybatis_plus.mybatis_plus_demo.utils.HttpClientUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jyz
 * @since 2022-03-06
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final String url = "http://localhost:8085/testHttp/tset1";

    @PostMapping("/http")
    public String testHttp(){


        //String message = "{sql_full_text='UPDATE `PRODUCT_STATUS` SET `SALE_DATE`=0,`EXPIRE_DATE`=0,`STATUS`=0 WHERE `PRODUCT_ID`='#'',host='null', facility='null', tags='null', severity_label='null', facility_label='null', type='null', priority='null', severity='null', id=0, occurrenceTime='Mon Mar 28 15:07:13 CST 2022', session_server_ip='172.20.7.248', session_server_port='3306', session_db_instance_name='mysql', db_name='zjyz_db', session_db_edition='32', app_clientip='172.20.7.243', app_clientport='0', session_client_mac='FA163E7636B3', client_program='MySQL Connector Java', client_system_user='nwonknu', app_client_username='N/A', db_username='ROOT', risk_type='N/A', risk_level='高危', level='', term='', engine_action='放行', rule_name='asdasdasd', description='', operation_type='UPDATE', access_object='PRODUCT_STATUS', exec_cost_us='62', results_enforcement='成功', affect_rows='0',  department='中国电信浙江公司信息服务业务系统云销系统', branch='客户经营事业部', idx=16484339692933, count_pin=''}";
        String message = "{\n" +
                "    \"access_object\":\"N/A\",\n" +
                "    \"affect_rows\":\"0\",\n" +
                "    \"app_client_username\":\"N/A\",\n" +
                "    \"app_clientip\":\"172.20.9.55\",\n" +
                "    \"app_clientport\":\"38352\",\n" +
                "    \"branch\":\"数字生活中心\",\n" +
                "    \"client_program\":\"MySQL Connector/J\",\n" +
                "    \"client_system_user\":\"N/A\",\n" +
                "    \"count_pin\":\"\",\n" +
                "    \"db_name\":\"sms\",\n" +
                "    \"db_username\":\"ZJDHMDR\",\n" +
                "    \"department\":\"中国电信浙江公司信息服务业务系统号百智能秘书系统\",\n" +
                "    \"description\":\"\",\n" +
                "    \"engine_action\":\"放行\",\n" +
                "    \"exec_cost_us\":\"30\",\n" +
                "    \"facility\":\"0\",\n" +
                "    \"facility_label\":\"kernel\",\n" +
                "    \"host\":\"172.22.137.58\",\n" +
                "    \"id\":0,\n" +
                "    \"idx\":16486378428560,\n" +
                "    \"level\":\"\",\n" +
                "    \"occurrenceTime\":\"2022-03-30 18:55:50\",\n" +
                "    \"operation_type\":\"COMMIT \",\n" +
                "    \"priority\":\"0\",\n" +
                "    \"results_enforcement\":\"成功\",\n" +
                "    \"risk_level\":\"高危\",\n" +
                "    \"risk_type\":\"N/A\",\n" +
                "    \"rule_name\":\"TEST\",\n" +
                "    \"session_client_mac\":\"005056A363E1\",\n" +
                "    \"session_db_edition\":\"5700\",\n" +
                "    \"session_db_instance_name\":\"mysql\",\n" +
                "    \"session_server_ip\":\"172.20.9.57\",\n" +
                "    \"session_server_port\":\"3306\",\n" +
                "    \"severity\":\"0\",\n" +
                "    \"severity_label\":\"Emergency\",\n" +
                "    \"sql_full_text\":\"COMMIT\",\n" +
                "    \"tags\":\"[\\\"_grokparsefailure_sysloginput\\\"]\",\n" +
                "    \"term\":\"\",\n" +
                "    \"type\":\"syslog\"\n" +
                "}";
        //System.out.println(message);


        WarnMes warnMes = JSONUtil.toBean(message, WarnMes.class);
        System.out.println(warnMes);

//        JsonObject respJson=new JsonParser().parse(message).getAsJsonObject();
//        System.out.println(respJson);
//        HashMap hashMap = JSONObject.parseObject(message, HashMap.class);
//        System.out.println(hashMap);
//        WarnMes warnMes = JSONObject.parseObject(message, WarnMes.class);
//        System.out.println(warnMes);


        //JSONObject jsonObject1 = JSONUtil.parseObj(message);
        //System.out.println(jsonObject1);

        System.out.println("=============================");

//        JSONObject jsonObject = new JSONObject();
//        jsonObject.set("city","hangzhou");
//        jsonObject.set("play","langrensha");
//        String s = JSONUtil.toJsonStr(jsonObject);
//        System.out.println(s);
//        com.alibaba.fastjson.JSONObject jsonObject2 = com.alibaba.fastjson.JSONObject.parseObject(s);
//        System.out.println(jsonObject2);
//
//        TestJson testJson = JSONUtil.toBean(s, TestJson.class);
//        System.out.println(testJson);
//
//        com.alibaba.fastjson.JSONObject jsonObject1 = HttpClientUtils.httpPost(url, s);
//        System.out.println(jsonObject1);
        return "success";

//        HttpResponse execute = HttpRequest.post(url)
//                .contentType("application/json;charset=utf-8")
//                .body(s)
//                .timeout(20000)//超时，毫秒
//                .execute();
//        System.out.println(execute.body());
//
//        //String post = HttpUtil.post(url, objectObjectHashMap);
//
//        return execute;
    }

}
