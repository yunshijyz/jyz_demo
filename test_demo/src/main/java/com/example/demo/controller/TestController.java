package com.example.demo.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.*;
import cn.hutool.crypto.symmetric.DES;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.com.User;
import com.example.demo.entity.*;
import com.example.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;

import static cn.hutool.crypto.KeyUtil.generateKey;
import static org.apache.catalina.manager.Constants.CHARSET;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @PostMapping("/test/demo")
    public NewDemo test(@RequestBody Demo demo){

        BigDecimal amount = demo.getAmount().subtract(demo.getNewAmount());
        NewDemo newDemo = new NewDemo();
        newDemo.setAmount(amount);
        String[] strs = demo.getStrs();
        for (String str : strs) {
            System.out.println(str);
        }
        return newDemo;

    }

    @GetMapping("/very")
    public String testVery() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {



        String l = "1649935051723";
        log.info("l:{}",l);

//        User user = new User();
//
//        user.setName("李进");
//        user.setId(23);
        //user.setArr(Arrays.asList(64,57,89));


        JSONObject json = new JSONObject();

//        String s1 = JSONObject.toJSONString(user);

        json.put("name","李进");
        json.put("id",23);

        String data = json.toJSONString();



        //第一层
        String pk1 = "1";

        String s2 = data+l+pk1;


        //第二层
        String pk2 = "2";

        String pass = s2;
        log.info("pass:{}",pass);


        Digester md5 = new Digester(DigestAlgorithm.MD5);

        String s = md5.digestHex(s2,StandardCharsets.UTF_8);

        log.info("first:{}",s);


//        byte[] key = l.getBytes(StandardCharsets.UTF_8);
//
//        HMac mac = new HMac(HmacAlgorithm.HmacMD5,key);
//
//        String s = mac.digestHex(s1,StandardCharsets.UTF_8);

        Digester md51 = new Digester(DigestAlgorithm.MD5);
        String ss2 = s+pk2;

        String finalMd5 = md51.digestHex(ss2,StandardCharsets.UTF_8);


//        byte[] key2 = pk2.getBytes(StandardCharsets.UTF_8);
//
//        HMac mac2 = new HMac(HmacAlgorithm.HmacMD5,key2);
//        String finalMd5 = mac2.digestHex(s,StandardCharsets.UTF_8);

        log.info("finalMd5:{}",finalMd5);

        String sec = "7a93681513590d61ed0b9b3ceeef998dedf967ea6f13b4bc";
        String pk3 = "12345678zxcvbnma";


        try {
            String s1 = decrypt_info(sec, pk3);
            System.out.println("解密结果："+s1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }







        return finalMd5;

    }

    /**
     *
     */
    public String decrypt_info(String hexStr,String key) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        byte[] decode = cn.hutool.core.codec.Base64.decode(hexStr);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF-8"),"AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE,keySpec);
        return new String(cipher.doFinal(decode));

    }




    /**
     * DES解密字符串
     *
     * @param password 解密密码，长度不能够小于8位
     * @param data 待解密字符串
     * @return 解密后内容
     */
    public String decrypt1(String password, String data) {
        if (password== null || password.length() < 8) {
            throw new RuntimeException("加密失败，key不能小于8位");
        }
        if (data == null)
            return null;
        try {
            Key secretKey = generateKey(password);
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            IvParameterSpec iv = new IvParameterSpec("0".getBytes(CHARSET));
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
            return new String(cipher.doFinal(Base64.getDecoder().decode(data.getBytes(CHARSET))), CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }



    /**
     * 进行解密操作
     * 参数一：待解密的字符串，参数二：加密密钥
     * 返回解密后的字符串
     */
    public String decrypt(String decryptionBase64Str, String password) {
        try {
            //byte[] decryptionbytes = Base64.getDecoder().decode(decryptionBase64Str);
            byte[] decryptionbytes = decryptionBase64Str.getBytes();
            // DES算法要求有一个可信任的随机数源
            SecureRandom random = new SecureRandom();
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            // 创建一个密钥工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密钥初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            // 开始解密操作
            return new String(cipher.doFinal(decryptionbytes), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    @PostMapping("/test/rock")
    public String test2(@RequestBody RockBack rockBack){
        System.out.println(rockBack.getStatisticsTime().getCode());
        System.out.println(rockBack.getStatisticsTime().getInfo());
        return "ok";
    }

    @PostMapping("/test/localdate")
    public Void test3(@RequestBody RockBack rockBack){

        WeekRes week = getWeek(rockBack.getDate());
        log.info("monday:{}",week.getMonday());
        log.info("sunday:{}",week.getSunDay());

        return null;
    }

    @PostMapping("/test/map")
    public Void test4(){

        Map<String,ProvinceUseRes> map = new HashMap<>();
        List<Region> list = testService.getList();
        for (Region region : list) {
            ProvinceUseRes res = new ProvinceUseRes();
            res.setProvince(Integer.valueOf(region.getCode()));
            res.setProvinceName(region.getName());
            map.put(region.getCode(),res);
        }

        for (String s : map.keySet()) {
            System.out.println(s+": "+map.get(s));
        }

        return null;
    }


    @GetMapping("insert")
    public String testMybatis(){


        testService.insertList();
        return "ok";
    }

    @PostMapping("province")
    public List<ProvinceRes> testMybatis1(@RequestBody UsageDistributionVo usageDistributionVo){

        List<ProvinceRes> provinceRes = testService.selectProvince(usageDistributionVo);
        log.info("provinceRes:{}",provinceRes);
        return provinceRes;
    }

    @GetMapping("/getTree")
    public List<OverviewPermissions> getTree(){
        List<OverviewPermissions> menu = testService.getMenu();
        Map<Long, OverviewPermissions> nodeMap = new HashMap<>(menu.size());
        List<OverviewPermissions> treeNode = new ArrayList<>();
        for (OverviewPermissions sysMenu : menu) {
            OverviewPermissions node = new OverviewPermissions();
            BeanUtil.copyProperties(sysMenu,node);
            nodeMap.put(node.getId(),node);
        }
        for (OverviewPermissions node : nodeMap.values()){
            Integer parentId = node.getParentId();
            OverviewPermissions parentNode = nodeMap.get(Long.valueOf(parentId));
            if(parentNode != null){
                parentNode.getChildren().add(node);
            } else {
                treeNode.add(node);
            }
        }

        return treeNode;
    }


    @GetMapping ("/tree")
    public List<Treeselect> tree(){

        List<OverviewPermissions> pers = testService.selectTree();

        List<OverviewPermissions> returnList = new ArrayList<>();
        List<Long> tempList = new ArrayList<>();
        for (OverviewPermissions overviewPermissions : pers) {
            tempList.add(overviewPermissions.getId());
        }
        for (Iterator<OverviewPermissions> iterator = pers.iterator(); iterator.hasNext();) {
            OverviewPermissions dept = (OverviewPermissions) iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(dept.getParentId().longValue())) {
                recursionFn(pers, dept);
                returnList.add(dept);
            }
        }
        if (returnList.isEmpty()) {
            returnList = pers;
        }
        List<Treeselect> collect = returnList.stream().map(Treeselect::new).collect(Collectors.toList());
        return collect;

    }


    /**
     * 递归列表
     */
    private void recursionFn(List<OverviewPermissions> list, OverviewPermissions t)
    {
        // 得到子节点列表
        List<OverviewPermissions> childList = getChildList(list, t);
        t.setChildren(childList);
        for (OverviewPermissions tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<OverviewPermissions> list, OverviewPermissions t)
    {
        return getChildList(list, t).size() > 0;
    }


    /**
     * 得到子节点列表
     */
    private List<OverviewPermissions> getChildList(List<OverviewPermissions> list, OverviewPermissions t)
    {
        List<OverviewPermissions> tlist = new ArrayList<OverviewPermissions>();
        Iterator<OverviewPermissions> it = list.iterator();
        while (it.hasNext())
        {
            OverviewPermissions n = (OverviewPermissions) it.next();
            if (n.getParentId() != null && n.getParentId().longValue() == t.getId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }







    private static WeekRes getWeek(String date){
        WeekRes weekRes = new WeekRes();
        LocalDateTime localDateTime = null;
        if(ObjectUtil.isNotEmpty(date)){
            String queryTime = date + " 00:00:00";
            localDateTime = LocalDateTime.parse(queryTime, dateTimeFormatter);
        } else {
            localDateTime = LocalDateTime.now();
        }
        LocalDateTime monday = localDateTime.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).plusDays(1).withHour(0).withMinute(0).withSecond(0);
        LocalDateTime sunday = localDateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).minusDays(1).withHour(23).withMinute(59).withSecond(59);
        weekRes.setMonday(dateTimeFormatter.format(monday));
        weekRes.setSunDay(dateTimeFormatter.format(sunday));
        return weekRes;
    }
}
