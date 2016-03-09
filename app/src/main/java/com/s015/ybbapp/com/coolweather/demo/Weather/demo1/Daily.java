package com.s015.ybbapp.com.coolweather.demo.Weather.demo1;


import com.s015.ybbapp.com.coolweather.demo.Weather.demo2.Astro;
import com.s015.ybbapp.com.coolweather.demo.Weather.demo2.Cond;
import com.s015.ybbapp.com.coolweather.demo.Weather.demo2.Tmp;
import com.s015.ybbapp.com.coolweather.demo.Weather.demo2.Wind;

public class Daily {
	
	private String data;
	private Astro astro;
	private Cond cond;
	private String hum;
	private String pcpn;
	private String pop;
	private String pres;
	private Tmp tmp;
	private String vis;
	private Wind wind;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Astro getAstro() {
		return astro;
	}
	public void setAstro(Astro astro) {
		this.astro = astro;
	}
	public Cond getCond() {
		return cond;
	}
	public void setCond(Cond cond) {
		this.cond = cond;
	}
	public String getHum() {
		return hum;
	}
	public void setHum(String hum) {
		this.hum = hum;
	}
	public String getPcpn() {
		return pcpn;
	}
	public void setPcpn(String pcpn) {
		this.pcpn = pcpn;
	}
	public String getPop() {
		return pop;
	}
	public void setPop(String pop) {
		this.pop = pop;
	}
	public String getPres() {
		return pres;
	}
	public void setPres(String pres) {
		this.pres = pres;
	}
	public Tmp getTmp() {
		return tmp;
	}
	public void setTmp(Tmp tmp) {
		this.tmp = tmp;
	}
	public String getVis() {
		return vis;
	}
	public void setVis(String vis) {
		this.vis = vis;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	
	

}
