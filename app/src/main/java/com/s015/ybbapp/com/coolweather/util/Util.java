package com.s015.ybbapp.com.coolweather.util;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/3/3.
 */
public class Util {
    /*
     *获取本机IP
     */
    public static String getLocalHost() {
        // TODO Auto-generated method stub
        InetAddress ia = null;
        String localip = "";
        try {
            ia = ia.getLocalHost();
            localip = ia.getHostAddress();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return localip;
    }

    public static String HttpRightUrl(String errorUrl) {
        String ip = getLocalHost();
        if("".equals(ip)){
            ip="192.168.3.24";
        }
        return errorUrl.replace("LocalHost", ip);
    }

    //数组中插入元素
    public static String[] insertString(String[] ori, String val, int index) {
        //增加ruby
        List<String> list = new ArrayList<String>();
        for (int i=0; i<ori.length; i++) {
            list.add(ori[i]);
        }
        list.add(index, val); //list.add("ruby")
        String[] newStr =  list.toArray(new String[1]); //返回一个包含所有对象的指定类型的数组
        return newStr;
    }

}

