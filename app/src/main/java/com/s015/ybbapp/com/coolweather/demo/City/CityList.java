package com.s015.ybbapp.com.coolweather.demo.City;

import com.s015.ybbapp.com.coolweather.demo.City.demo1.City_info;

import java.util.List;

/**
 * Created by Administrator on 2016/3/2.
 */
public class CityList {

    private List<City_info> city_info;
    private String status;

    public List<City_info> getCity_infos() {
        return city_info;
    }

    public void setCity_infos(List<City_info> city_infos) {
        this.city_info = city_infos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
