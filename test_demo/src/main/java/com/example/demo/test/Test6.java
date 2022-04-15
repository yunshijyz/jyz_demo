package com.example.demo.test;


import cn.hutool.core.codec.Base64;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.DesTest;
import com.example.demo.utils.DesUtil;

import org.apache.ibatis.logging.stdout.StdOutImpl;
import sun.security.krb5.internal.crypto.Des;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random;

public class Test6 {

    public static void main(String[] args) throws Exception {

        JSONObject json = new JSONObject();
        json.put("name","jyz");
        String sec = json.toJSONString();
        String pk3 = "12345678";

        byte[] bytes = pk3.getBytes("UTF-8");
        for (byte s : bytes) {
            System.out.print(s+",");
        }

        System.out.println();

        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DES.getValue()).getEncoded();
        for (byte b : key) {
            System.out.print(b+",");
        }
        System.out.println();
        String str = new String(key,"UTF-8");
        System.out.println(str);
        //构建
        DES des = SecureUtil.des(bytes);

        //加密解密
        byte[] encrypt = des.encrypt(sec);
        byte[] decrypt = des.decrypt(encrypt);


        //加密为16进制，解密为原字符串



        String encryptHex = des.encryptHex(sec);
        System.out.println(encryptHex);


        String sss = "5e4f50e72dd04b2cf84ff5820f915bc3a7d22184584a9eba9af9019f96ef9ef64a0a03beecde2ff47d5d6bbaa9ab0550950e317ca2ec6299e4020416e8e67901595efde3eab9b823404e8f557ee8c017deffede389e346575ded2c47c9f36068feb959b7d4642fcb";
        System.out.println(sss);
        String decryptStr = des.decryptStr(sss);

        System.out.println("string:"+decryptStr);

        String s = Base64.decodeStr(decryptStr);
        System.out.println(s);
        DesTest desTest = JSONUtil.toBean(s, DesTest.class);
        System.out.println(desTest);
    }

    /**
     * 解密数据
     * @param hexStr
     * @param sKey
     * @return
     * @throws Exception
     */
    public static String decrypt_loginInfo(String hexStr,String key) throws Exception {
        byte[] contentNew = Base64.decode(hexStr);
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        return new String(cipher.doFinal(contentNew));
    }


    /**
     * 随机生成加密串 length加密串长度
     * @return
     */
    public static String generateRandomKey(int length){
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789/=+";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }


}
