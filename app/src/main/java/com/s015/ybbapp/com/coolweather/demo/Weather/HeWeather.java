package com.s015.ybbapp.com.coolweather.demo.Weather;


import com.s015.ybbapp.com.coolweather.demo.Weather.demo1.Alarms;
import com.s015.ybbapp.com.coolweather.demo.Weather.demo1.Aqi;
import com.s015.ybbapp.com.coolweather.demo.Weather.demo1.Basic;
import com.s015.ybbapp.com.coolweather.demo.Weather.demo1.Daily;
import com.s015.ybbapp.com.coolweather.demo.Weather.demo1.Hourly;
import com.s015.ybbapp.com.coolweather.demo.Weather.demo1.Now;
import com.s015.ybbapp.com.coolweather.demo.Weather.demo1.Suggestion;

import java.util.List;

public class HeWeather {
	
	private String status;
	private List<Alarms> alarms;
	private Basic basic;
	private Now now;
	private Aqi aqi;
	private List<Daily> daily_forecast;
	private List<Hourly> hourly_forecast;
	private Suggestion suggestion;
	
	
	
	public HeWeather() {
		super();
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Alarms> getAlarms() {
		return alarms;
	}
	public void setAlarms(List<Alarms> alarms) {
		this.alarms = alarms;
	}
	public Basic getBasic() {
		return basic;
	}
	public void setBasic(Basic basic) {
		this.basic = basic;
	}
	public Now getNow() {
		return now;
	}
	public void setNow(Now now) {
		this.now = now;
	}
	public Aqi getAqi() {
		return aqi;
	}
	public void setAqi(Aqi aqi) {
		this.aqi = aqi;
	}
	
	public List<Daily> getDaily_forecast() {
		return daily_forecast;
	}
	public void setDaily_forecast(List<Daily> daily_forecast) {
		this.daily_forecast = daily_forecast;
	}
	public List<Hourly> getHourly_forecast() {
		return hourly_forecast;
	}
	public void setHourly_forecast(List<Hourly> hourly_forecast) {
		this.hourly_forecast = hourly_forecast;
	}
	public Suggestion getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(Suggestion suggestion) {
		this.suggestion = suggestion;
	}
	
	public String toString(){
		return status+basic.getCity()+now.getHum()+suggestion.getComf().getBrf();
	}

}
