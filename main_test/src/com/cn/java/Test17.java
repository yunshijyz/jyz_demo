package com.cn.java;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Test17 {

    public static void main(String[] args) {
        Boolean iPsForIpv4 = findIPsForIpv4("192.168.0.1", "192.168.0.255");
        System.out.println(iPsForIpv4);


    }

    //ip v4的正则表达式
    private final static String IP_V4_REG = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)" +
            "\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)" +
            "\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    private final static Pattern IP_V4_PATTERN = Pattern.compile(IP_V4_REG);

    /**
     * 是否是正确的IP地址
     */
    public static boolean isIpV4(String str) {

        return IP_V4_PATTERN.matcher(str).matches();
    }

    public static boolean ipCheck(String text) {
        if (text != null && !text.isEmpty()) {
            // 定义正则表达式
            String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                    + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                    + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                    + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
            // 判断ip地址是否与正则表达式匹配
            if (text.matches(regex)) {
                // 返回判断信息
                return true;
            } else {
                // 返回判断信息
                return false;
            }
        }
        return false;
    }

    /**
     * 查找两个IP地址之间的IP ipv6
     * @param startIp
     * @param endIp
     * @return
     */
    public static List<String> findIPsForIpv6(String startIp, String endIp) {
        BigInteger startNumber = ipv6ToNumber(startIp);
        BigInteger endNumber = ipv6ToNumber(endIp).add(BigInteger.valueOf(1));
        List<String> ips = new ArrayList<String>();
        while (startNumber.compareTo(endNumber) < 0) {
            ips.add(numberToIpv6(startNumber));
            startNumber = startNumber.add(BigInteger.valueOf(1));
        }
        return ips;
    }

    /**
     * 查找两个IP地址之间的IP ipv4
     * @param startIp
     * @param endIp
     * @return
     */
    public static Boolean findIPsForIpv4(String startIp, String endIp) {
        long startNumber = ipv4ToNumber(startIp);
        long endNumber = ipv4ToNumber(endIp) + 1;
        List<String> ips = new ArrayList<String>();
        Integer count = 0;
        for (long i = startNumber; i < endNumber; i++) {
            String s = numberToIpv4(i);
            ips.add(s);
            count += 1;
            if(count >= 256){
                System.out.println("超过数量");
                return false;
            }
        }
        return true;
    }

    /**
     * IPv6地址转换成数字
     * @param ip
     * @return
     */
    public static BigInteger ipv6ToNumber(String ip) {
        String[] ips = ip.split(":");
        BigInteger rs = new BigInteger("0");

        for (int i = 0; i < ips.length; i++) {
            BigInteger a = BigInteger.valueOf(Integer.parseInt(ips[i], 16));
            BigInteger b = BigInteger.valueOf(65536).pow(7 - i);
            BigInteger c = a.multiply(b);
            rs = rs.add(c);
        }
        return rs;
    }

    /**
     * 数字转换成IPV6地址
     * @param number
     * @return
     */
    public static String numberToIpv6(BigInteger number) {
        String ip = "";
        List<String> ips = new ArrayList<String>();

        for (int i = 0; i < 8; i++) {
            ips.add(Integer.toHexString(number.divideAndRemainder(BigInteger.valueOf(65536))[1].intValue()));
            number = number.shiftRight(16);
        }

        for (int i = ips.size() - 1; i >= 0; i--) {
            ip = ip.concat(ips.get(i));
            if (i > 0) {
                ip = ip.concat(":");
            }
        }
        return ip;
    }
    /**
     * 数字转换成IPv4地址
     * @param number
     * @return
     */
    public static String numberToIpv4(long number) {
        String ip = "";
        List<String> ips = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            ips.add(String.valueOf(number % 256));
            number = number >> 8;
        }
        for (int i = ips.size() - 1; i >= 0; i--) {
            ip = ip.concat(ips.get(i));
            if (i > 0) {
                ip = ip.concat(".");
            }
        }
        return ip;
    }
    /**
     * IPv4地址转换成数字
     * @param ip
     */
    public static long ipv4ToNumber(String ip) {
        long rs = 0;
        if (ip == null || ip.isEmpty()) {
            return rs;
        }
        String[] ips = ip.split("\\.");
        for (int i = 0; i < ips.length; i++) {
            rs += Integer.parseInt(ips[i]) * Math.pow(256, (3 - i));
        }
        return rs;
    }

}
