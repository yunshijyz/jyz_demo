package com.cn.java;

import org.openjsse.sun.net.util.IPAddressUtil;

public class IpRange {

    public static long ip2Long(String strIp){
        long[] ip = new long[4];
        int posi1 = strIp.indexOf(".");
        int posi2 = strIp.indexOf(".",posi1+1);
        int posi3 = strIp.indexOf(".",posi2+1);

        ip[0] = Long.parseLong(strIp.substring(0, posi1));
        ip[1] = Long.parseLong(strIp.substring(posi1+1, posi2));
        ip[2] = Long.parseLong(strIp.substring(posi2+1, posi3));
        ip[3] = Long.parseLong(strIp.substring(posi3+1));
        return (ip[0]<<24)+(ip[1]<<16)+(ip[2]<<8)+ip[3];
    }


    public static long getIp2long(String ip){
        ip = ip.trim();
        String[] ips = ip.split("\\.");
        int i1 = Integer.parseInt(ips[0]);
        int i2 = Integer.parseInt(ips[1]);
        int i3 = Integer.parseInt(ips[2]);
        int i4 = Integer.parseInt(ips[3]);
        long ip2long = 1L * i1 * 256 * 256 * 256 + i2 * 256 * 256 + i3 * 256 + i4;
        return ip2long;
    }


    public static boolean ipInRange(String ip,String startIp,String endIp){
        return (getIp2long(startIp)<=getIp2long(ip)) && (getIp2long(ip)<=getIp2long(endIp));
    }

    /**
     * IP v4转 数字 long型的
     * @param ipStr ipStr
     */
    public static long ipV4StrToLong(String ipStr) {

        String[] arr = ipStr.split("\\.");

        long result = 0;

        for (int i = 0; i < arr.length; i++) {

            long ip = Long.parseLong(arr[3 - i]);

            result |= ip << (i * 8);
        }

        return result;
    }

    /**
     * 比较ip段起始ip大小
     * @param startIp
     * @param endIp
     * @return
     */
    public static Boolean checkStartEndIpSize(String startIp,String endIp){
        long start = ipV4StrToLong(startIp);
        long end = ipV4StrToLong(endIp);
        return start >= end;
    }

    public static void main(String[] args) {

        String ip = "192.168.0.0";

        String startIp = "193.168.0.1";

        String endIp = "194.168.1.0";
        System.out.println(checkStartEndIpSize(startIp, endIp));

//        boolean b = ipInRange(ip, startIp, endIp);
//        System.out.println(ipV4StrToLong(ip));
//        System.out.println(ip2Long(ip));
//        System.out.println(getIp2long(ip));
//        System.out.println(b);


    }


}
