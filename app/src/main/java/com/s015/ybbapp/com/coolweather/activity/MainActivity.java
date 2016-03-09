package com.s015.ybbapp.com.coolweather.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.s015.ybbapp.com.coolweather.R;
import com.s015.ybbapp.com.coolweather.application.LocationApplication;
import com.s015.ybbapp.com.coolweather.db.dbCity.CityDB;
import com.s015.ybbapp.com.coolweather.demo.Weather.HeWeather;
import com.s015.ybbapp.com.coolweather.location.LocationService;
import com.s015.ybbapp.com.coolweather.util.dwon.DownCity;
import com.s015.ybbapp.com.coolweather.util.dwon.DownWeather;
import com.s015.ybbapp.com.coolweather.util.inter.RequstWeatherData;

import java.util.List;

/**
 * Created by Administrator on 2016/2/29.
 */
public class MainActivity extends Activity{
    private static final String LOG = "Weather";
    private static final int WeatherData = 1;
    private static final int WeatherError = 2;
    private static final String UrlCity = "";
    private CityDB cityDB;
    private LocationService locationService;

    private TextView cityname;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case WeatherData:
                    HeWeather heWeather = (HeWeather)msg.obj;
                    //Toast.makeText(MainActivity.this,heWeather.toString(),Toast.LENGTH_SHORT).show();
                    break;
                case WeatherError:
                    ((Exception)msg.obj).printStackTrace();
                    break;
            }
        }
    };

    private BDLocationListener listener = new BDLocationListener() {
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            if(bdLocation != null && bdLocation.getLocType() != BDLocation.TypeServerError) {
                cityname.setText(bdLocation.getCity());

                String url = "http://apis.baidu.com/heweather/pro/weather";
                String httpArg = "city="+bdLocation.getCity().replace("市","");
                DownWeather.request(url, httpArg, new RequstWeatherData() {
                    @Override
                    public void getData(List<HeWeather> list) {
                        for (HeWeather h:list) {
                            h.getNow().getCond().getTxt();
                        }
                    }

                    @Override
                    public void error(Exception e) {

                    }
                });
                locationService.stop();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(this,"出发",Toast.LENGTH_SHORT).show();
        cityDB = CityDB.getInstance(this);
        cityname = (TextView)findViewById(R.id.city_name);
    }

    @Override
    protected void onStart() {
        super.onStart();
        locationService = ((LocationApplication) getApplication()).locationService;
        locationService.registerListener(listener);
        locationService.setLocationOption(locationService.getDefaultLocationClientOption());
        locationService.start();
        cityname.setText("正在定位...");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.creat_City:
                DownCity.request("","",cityDB);
                break;
            case R.id.load_City:
                break;
            case R.id.query_City:
                Intent i = new Intent(MainActivity.this,QueryCityActivity.class);
                startActivity(i);
                break;
            case R.id.update_City:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
