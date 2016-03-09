package com.s015.ybbapp.com.coolweather.demo.Allcond;

import java.util.List;

/**
 * Created by Administrator on 2016/3/8.
 */
public class CondCode {
    private String status;
    private List<Cond_info> cond_info;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Cond_info> getCond_info() {
        return cond_info;
    }

    public void setCond_info(List<Cond_info> cond_info) {
        this.cond_info = cond_info;
    }
}
