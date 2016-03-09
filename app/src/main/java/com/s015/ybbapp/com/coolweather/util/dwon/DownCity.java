package com.s015.ybbapp.com.coolweather.util.dwon;

import android.util.Log;

import com.s015.ybbapp.com.coolweather.db.dbCity.CityDB;
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
 */
public class DownCity {
    private static final String LOG = "Weather";
    public static void request(final String httpUrl, final String httpArg, final CityDB cityDB) {

        new  Thread(new Runnable() {
            @Override
            public void run() {
                String strurl = null;
                BufferedReader reader = null;
                String result = null;
                StringBuffer sbf = new StringBuffer();
                strurl = httpUrl;

                try {
                    URL url = new URL("http://192.168.3.24:8888/coolweather/city.json");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    // 填入apikey到HTTP header
                    // connection.setRequestProperty("apikey", "您自己的apikey");
                    connection.setConnectTimeout(6*1000);
                    //connection.connect();
                    InputStream is = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String strRead = null;
                    while ((strRead = reader.readLine()) != null) {
                        sbf.append(strRead);
                        sbf.append("\r\n");
                    }
                    Log.d(LOG,"strRead is OK");
                    reader.close();
                    result = sbf.toString();
                    List<City_info> list = Parse.getCitys(result);
                    if(list.size()>0){
                        Log.d(LOG,"parse OK");
                    }
                    if(list!=null && list.size()>0){
                        cityDB.saveCity(list);
                    }
                } catch (Exception e) {
                  e.printStackTrace();
                }
            }
        }).start();

    }

}
