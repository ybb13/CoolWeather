package com.s015.ybbapp.com.coolweather.util.dwon;

import android.util.Log;

import com.s015.ybbapp.com.coolweather.demo.City.demo1.City_info;
import com.s015.ybbapp.com.coolweather.demo.Weather.HeWeather;
import com.s015.ybbapp.com.coolweather.util.inter.RequstCityData;
import com.s015.ybbapp.com.coolweather.util.inter.RequstWeatherData;
import com.s015.ybbapp.com.coolweather.util.parse.json.Parse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/2.
 *
 *
 */
public class DownWeather {
    private static final String LOG = "Weather";

    public static void request(final String httpUrl,final String httpArg ,final RequstWeatherData requstData) {

        new  Thread(new Runnable() {
            @Override
            public void run() {
                String strurl = null;
                BufferedReader reader = null;
                String result = null;
                StringBuffer sbf = new StringBuffer();
                strurl = httpUrl + "?" + httpArg;

                try {
                    URL url = new URL(strurl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    // 填入apikey到HTTP header
                    connection.setRequestProperty("apikey", "a1da9df63c01750a00e683b9589313e0");
                    connection.connect();
                    InputStream is = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String strRead = null;
                    while ((strRead = reader.readLine()) != null) {
                        Log.d(LOG,strRead);
                        sbf.append(strRead);
                        sbf.append("\r\n");
                    }
                    reader.close();
                    result = sbf.toString();
                    Map<String,List<HeWeather>> mapheWeather = Parse.getHeWeather(result);
                    if(requstData!=null){
                        requstData.getData(mapheWeather.get("HeWeather data service 3.0"));
                    }
                } catch (Exception e) {
                    if(requstData!=null){
                        requstData.error(e);
                    }
                }
            }
        }).start();

    }

}
