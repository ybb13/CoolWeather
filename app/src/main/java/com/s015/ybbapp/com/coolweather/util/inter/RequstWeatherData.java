package com.s015.ybbapp.com.coolweather.util.inter;

import com.s015.ybbapp.com.coolweather.demo.Weather.HeWeather;

import java.util.List;

/**
 * Created by Administrator on 2016/3/2.
 */
public interface RequstWeatherData {
    void getData(List<HeWeather> list);
    void error(Exception e);
}
