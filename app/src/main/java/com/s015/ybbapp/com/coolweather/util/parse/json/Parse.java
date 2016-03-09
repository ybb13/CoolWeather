package com.s015.ybbapp.com.coolweather.util.parse.json;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.s015.ybbapp.com.coolweather.demo.Allcond.CondCode;
import com.s015.ybbapp.com.coolweather.demo.Allcond.Cond_info;
import com.s015.ybbapp.com.coolweather.demo.City.CityList;
import com.s015.ybbapp.com.coolweather.demo.City.demo1.City_info;
import com.s015.ybbapp.com.coolweather.demo.Weather.HeWeather;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/2.
 */
public class Parse {
    private static final String LOG = "Weather";
    public static Map<String,List<HeWeather>>  getHeWeather(String strjson) throws Exception{
        Map<String,List<HeWeather>> list = new HashMap<String,List<HeWeather>>();
            Gson gson = new Gson();
            list = gson.fromJson(strjson,new TypeToken<Map<String,List<HeWeather>>>(){}.getType());
        return list;
    }

    public static List<City_info> getCitys(String strjson) throws Exception{
        //Map<String,CityList> cityListMap = new HashMap<String,CityList>();
        List<City_info> list = new ArrayList<City_info>();
        Gson gson = new Gson();
        Log.d(LOG,"start parse");
        CityList cityList = gson.fromJson(strjson, new TypeToken<CityList>(){}.getType());
        for (City_info city:cityList.getCity_infos()) {
            Log.d(LOG,city.getCity());
        }
        list = cityList.getCity_infos();
        return list;
    }

    public static List<Cond_info> getConds(String strjson) throws Exception{
        List<Cond_info> list = new ArrayList<Cond_info>();
        Gson gson = new Gson();
        CondCode condcode = gson.fromJson(strjson, new TypeToken<CondCode>(){}.getType());
        for (Cond_info city:condcode.getCond_info()) {
            Log.d(LOG,city.getTxt());
        }
        list = condcode.getCond_info();
        return list;
    }

}
