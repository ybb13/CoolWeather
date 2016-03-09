package com.s015.ybbapp.com.coolweather.db.dbCity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.s015.ybbapp.com.coolweather.demo.Allcond.Cond_info;
import com.s015.ybbapp.com.coolweather.demo.City.demo1.City_info;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/2.
 */
public class CityDB {

    private static final String LOG = "Weather";
    //数据库名
    private static final String DB_NAME="Weather";
    public static final int VERSION = 1;
    private static CityDB cityDB;
    private SQLiteDatabase db;

    public CityDB(Context context){
        SQLCityHelper helper = new SQLCityHelper(context,DB_NAME,null,VERSION);
        db = helper.getReadableDatabase();
    }

    /**
     * 获取CoolWeatherDB的实例。
     */
    public synchronized static CityDB getInstance(Context context) {
        if (cityDB == null) {
            cityDB = new CityDB(context);
        }
        return cityDB;
    }
     /*
      *存储天气代码
      */

    public void saveCond(List<Cond_info> conds){
        for(Cond_info cond : conds){
            ContentValues values = new ContentValues();
            values.put("cond_code",cond.getCode());
            values.put("cond_txt",cond.getTxt());
            values.put("cond_txt_en",cond.getTxt_en());
            db.insert("Code",null,values);
        }
    }
    /*
    *查询天气代码
    */
    public String queryCond(String code){
        String result = "";
        Cursor cursor = db.query("Code",null,"cond_code = ?",new String[]{code},null,null,null);
        if(cursor.moveToFirst()){
            do{
                result = cursor.getString(cursor.getColumnIndex("cond_txt"));
            }while (cursor.moveToNext());
        }
        return result;
    }
    /*
     *存储城市列表
     */

    public void saveCity(List<City_info> listCity){
        for(City_info city : listCity){
            ContentValues values = new ContentValues();
            values.put("city_name",city.getCity());
            values.put("city_cnty",city.getCnty());
            values.put("city_id",city.getId());
            values.put("city_lat",city.getLat());
            values.put("city_lon",city.getLon());
            values.put("city_prov",city.getProv());
            db.insert("City",null,values);
        }
    }
       /*
        *读取城市列表
        */
    public List queryCity(String cityname){
        List<City_info>  list = new ArrayList<City_info>();
        Cursor cursor = db.query("City",null,"city_name = ?",new String[]{cityname},null,null,null);
        if(cursor.moveToFirst()){
            do{
                City_info city = new City_info();
                city.setId(cursor.getString(cursor.getColumnIndex("city_id")));
                city.setCity(cursor.getString(cursor.getColumnIndex("city_name")));
                city.setCnty(cursor.getString(cursor.getColumnIndex("city_cnty")));
                city.setProv(cursor.getString(cursor.getColumnIndex("city_prov")));
                list.add(city);
            }while (cursor.moveToNext());
        }
        return list;
    }

}
