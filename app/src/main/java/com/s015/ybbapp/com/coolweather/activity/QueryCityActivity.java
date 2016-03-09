package com.s015.ybbapp.com.coolweather.activity;

import com.s015.ybbapp.com.coolweather.R;
import com.s015.ybbapp.com.coolweather.db.dbCity.CityDB;
import com.s015.ybbapp.com.coolweather.demo.City.demo1.City_info;
import com.s015.ybbapp.com.coolweather.util.Util;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/3.
 */
public class QueryCityActivity extends Activity implements View.OnClickListener{

    private static final String LOG = "Weather";
    private EditText et_city;
    private Button  btn_city;
    private CityDB cityDB;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_querycity);
        cityDB = CityDB.getInstance(QueryCityActivity.this);
        et_city = (EditText)findViewById(R.id.ET_querycity);
        btn_city = (Button)findViewById(R.id.BTN_querycity);
        btn_city.setOnClickListener(this);
        listView = (ListView)findViewById(R.id.list_view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BTN_querycity:
                String cityname = et_city.getText().toString();
                if("".equals(cityname)){
                    Toast.makeText(QueryCityActivity.this,"请输入城市名称",Toast.LENGTH_SHORT).show();
                }else{
                    List<City_info> list = new ArrayList<City_info>();
                    String[] data = {};
                    list = cityDB.queryCity(cityname);
                    for (City_info city : list) {
                        data = Util.insertString(data,city.getCity()+"-"+city.getProv()+"-"+city.getCnty(),0);
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                            QueryCityActivity.this, android.R.layout.simple_list_item_1, data);
                    listView.setAdapter(adapter);
                }
                break;
        }
    }
}
