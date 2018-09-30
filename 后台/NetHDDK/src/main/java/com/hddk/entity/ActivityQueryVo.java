package com.hddk.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityQueryVo {
    private Integer a_id;
    private String theme;
    private String signUpStartTime;
    private String startTime;
    private int a_state;
    private Long num;

    public ActivityQueryVo() {

    }

    public ActivityQueryVo(Integer a_id, String theme, String signUpStartTime, String startTime, int a_state, Long num) {
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
        return signUpStartTime;
    }

    public void setSignUpStartTime(String signUpStartTime) {
        this.signUpStartTime = signUpStartTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
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
