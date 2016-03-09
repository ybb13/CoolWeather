package com.s015.ybbapp.com.coolweather.application;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;
import com.s015.ybbapp.com.coolweather.location.LocationService;

/**
 * Created by Administrator on 2016/3/8.
 */
public class LocationApplication extends Application{

    public LocationService locationService;
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        locationService = new LocationService(getApplicationContext());
        SDKInitializer.initialize(getApplicationContext());
    }

    public static Context getContext(){
        return context;
    }
}
