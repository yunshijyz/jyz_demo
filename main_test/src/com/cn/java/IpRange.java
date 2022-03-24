package com.cn.java;

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

    public static void main(String[] args) {

        String ip = "192.168.0.0";

        String startIp = "192.168.0.0";

        String endIp = "192.168.0.255";

        boolean b = ipInRange(ip, startIp, endIp);
        System.out.println(ip2Long(ip));
        System.out.println(getIp2long(ip));
        System.out.println(b);
    }


}
