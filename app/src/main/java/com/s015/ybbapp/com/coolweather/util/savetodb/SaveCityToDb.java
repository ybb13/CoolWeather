package com.s015.ybbapp.com.coolweather.util.savetodb;

import com.s015.ybbapp.com.coolweather.db.dbCity.CityDB;
import com.s015.ybbapp.com.coolweather.demo.City.demo1.City_info;

import java.util.List;

/**
 * Created by Administrator on 2016/3/2.
 */
public class SaveCityToDb {
    public static boolean handleCityResponse(CityDB cityDB, List<City_info> list){
        if(list!=null && list.size()>0){
            //cityDB.saveCity(list);
            return true;
        }
        return false;
    }
}

