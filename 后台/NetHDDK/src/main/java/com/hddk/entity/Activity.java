package com.hddk.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Activity {
    private Integer a_id;//活动id
    private String theme;//活动主题
    private Double score;//思政分
    private String description;//活动描述
    private String tips;//注意事项
    private int releaseState;//活动发布方式:'0':直接发布,'1':定时发布
    private Date releaseTime;//活动发布时间
    private int needStuSignUp;//是否需要学生报名?'0':否,'1':是
    private Date signUpStartTime;//报名开始时间
    private Date signUpEndTime;//报名结束时间
    private Date startTime;//活动开始时间
    private Date endTime;//活动结束时间
    private int signInState;//活动签到状态?'0':签到未开始,'1':正在签到
    private int a_state;//活动状态?'0':草稿,"1":未开始,'2':报名中,'3':正在进行,'4':结束
    private List<Field> fields;//场地
    private Integer signInTimes;//签到次数

    public Activity() {
    }

    public Activity(Integer a_id, String theme, Double score, String description, String tips, int releaseState, Date releaseTime, int needStuSignUp, Date signUpStartTime, Date signUpEndTime, Date startTime, Date endTime, int signInState, int a_state, List<Field> fields, Integer signInTimes) {
        this.a_id = a_id;
        this.theme = theme;
        this.score = score;
        this.description = description;
        this.tips = tips;
        this.releaseState = releaseState;
        this.releaseTime = releaseTime;
        this.needStuSignUp = needStuSignUp;
        this.signUpStartTime = signUpStartTime;
        this.signUpEndTime = signUpEndTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.signInState = signInState;
        this.a_state = a_state;
        this.fields = fields;
        this.signInTimes = signInTimes;
    }

    public Activity(String theme, Double score, String description, String tips, int releaseState, Date releaseTime, Date signUpStartTime, Date signUpEndTime, Date startTime, Date endTime) {
        this.theme = theme;
        this.score = score;
        this.description = description;
        this.tips = tips;
        this.releaseState = releaseState;
        this.releaseTime = releaseTime;
        this.signUpStartTime = signUpStartTime;
        this.signUpEndTime = signUpEndTime;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public int getReleaseState() {
        return releaseState;
    }

    public void setReleaseState(int releaseState) {
        this.releaseState = releaseState;
    }

    public String getReleaseTime() {
        SimpleDateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = bf.format(releaseTime);
        return format;
    }

    public void setReleaseTime(Date releaseTime) {
        SimpleDateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = bf.format(releaseTime);
        try {
            Date date = bf.parse(format);
            this.releaseTime = date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getNeedStuSignUp() {
        return needStuSignUp;
    }

    public void setNeedStuSignUp(int needStuSignUp) {
        this.needStuSignUp = needStuSignUp;
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

    public String getSignUpEndTime() {
        SimpleDateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = bf.format(signUpEndTime);
        return format;
    }

    public void setSignUpEndTime(Date signUpEndTime) {
        SimpleDateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = bf.format(signUpEndTime);
        try {
            Date date = bf.parse(format);
            this.signUpEndTime = date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getStartTime() {
        SimpleDateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = bf.format(startTime);
        return format;
    }

    public void setStartTime(Date startTime) {
        SimpleDateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = bf.format(startTime);
        try {
            Date date = bf.parse(format);
            this.startTime = date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getEndTime() {
        SimpleDateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = bf.format(endTime);
        return format;
    }

    public void setEndTime(Date endTime) {
        SimpleDateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = bf.format(endTime);
        try {
            Date date = bf.parse(format);
            this.endTime = date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getSignInState() {
        return signInState;
    }

    public void setSignInState(int signInState) {
        this.signInState = signInState;
    }

    public int getA_state() {
        return a_state;
    }

    public void setA_state(int a_state) {
        this.a_state = a_state;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public Integer getSignInTimes() {
        return signInTimes;
    }

    public void setSignInTimes(Integer signInTimes) {
        this.signInTimes = signInTimes;
    }
}
