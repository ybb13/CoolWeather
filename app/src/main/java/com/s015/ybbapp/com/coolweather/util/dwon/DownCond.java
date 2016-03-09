package com.s015.ybbapp.com.coolweather.util.dwon;

import android.util.Log;

import com.s015.ybbapp.com.coolweather.db.dbCity.CityDB;
import com.s015.ybbapp.com.coolweather.demo.Allcond.Cond_info;
import com.s015.ybbapp.com.coolweather.demo.City.demo1.City_info;
import com.s015.ybbapp.com.coolweather.util.parse.json.Parse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Administrator on 2016/3/8.
 */
public class DownCond {
    private static final String LOG = "Weather";
    public static void request(final CityDB cityDB) {

        new  Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader reader = null;
                String result = null;
                StringBuffer sbf = new StringBuffer();
                try {
                    URL url = new URL("https://api.heweather.com/x3/condition?search=allcond&key=440c0f15392e4141b1c0c40e6b716998");
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
                    List<Cond_info> list = Parse.getConds(result);
                    cityDB.saveCond(list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
