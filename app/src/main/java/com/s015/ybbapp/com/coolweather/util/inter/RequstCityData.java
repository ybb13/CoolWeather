package com.s015.ybbapp.com.coolweather.util.inter;

import com.s015.ybbapp.com.coolweather.demo.City.demo1.City_info;

import java.util.List;

/**
 * Created by Administrator on 2016/3/2.
 */
public interface RequstCityData {
    void getData(List<City_info> list);

    void error(Exception e);
}
