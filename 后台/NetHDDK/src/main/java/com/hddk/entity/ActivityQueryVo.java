package com.hddk.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityQueryVo {
    private Integer a_id;
    private String theme;
    private Date signUpStartTime;
    private Date startTime;
    private int a_state;
    private Long num;

    public ActivityQueryVo() {

    }

    public ActivityQueryVo(Integer a_id, String theme, Date signUpStartTime, Date startTime, int a_state, Long num) {
        this.a_id = a_id;
        this.theme = theme;
        this.signUpStartTime = signUpStartTime;
        this.startTime = startTime;
        this.a_state = a_state;
        this.num = num;
    }

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSignUpStartTime() {
        SimpleDateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = bf.format(signUpStartTime);

        return format;
    }

    public void setSignUpStartTime(Date signUpStartTime) {
        SimpleDateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = bf.format(signUpStartTime);
        try {
            Date date = bf.parse(format);
            this.signUpStartTime = date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public String getStartTime() {
        SimpleDateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//多态
        String format = bf.format(startTime);

        return format;
    }

    public void setStartTime(Date startTime) {
        SimpleDateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//多态
        String format = bf.format(startTime);
        try {
            Date date = bf.parse(format);
            this.startTime = date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public int getA_state() {
        return a_state;
    }

    public void setA_state(int a_state) {
        this.a_state = a_state;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}
