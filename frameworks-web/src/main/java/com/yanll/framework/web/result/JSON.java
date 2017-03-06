package com.yanll.framework.web.result;


import com.yanll.framework.util.exception.BizCode;

import java.util.Date;

/**
 * Created by YAN on 2015/10/27.
 */
public class JSON<T> {


    private Integer code;
    private String desc = "";
    private T data;
    private Date datetime = new Date();

    public JSON() {

    }

    public JSON(Integer code) {
        this.code = code;
    }

    public JSON(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public JSON(T data) {
        this.code = BizCode.OK.getValue();
        this.data = data;
    }

    public JSON(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public JSON(int code, String desc, T data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
