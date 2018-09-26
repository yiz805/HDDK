package com.hddk.entity;

import java.util.Date;
import java.util.List;

public class Activity {
    private Integer a_id;//活动id
    private String theme;//活动主题
    private Double score;//思政分
    private String description;//活动描述
    private String tips;//注意事项
    private String releaseState;//活动发布方式:'0':直接发布,'1':定时发布
    private Date releaseTime;//活动发布时间
    private String needStuSignUp;//是否需要学生报名?'0':否,'1':是
    private Date signUpStartTime;//报名开始时间
    private Date signUpEndTime;//报名结束时间
    private Date startTime;//活动开始时间
    private Date endTime;//活动结束时间
    private String signInState;//活动签到状态?'0':签到未开始,'1':正在签到
    private String a_state;//活动状态?'0':草稿,"1":未开始,'2':报名中,'3':正在进行,'4':结束
    private List<Field> fields;//场地
    private Integer signInTimes;//签到次数

    public Activity() {
    }

    public Activity(Integer a_id, String theme, Double score, String description, String tips, String releaseState, Date releaseTime, String needStuSignUp, Date signUpStartTime, Date signUpEndTime, Date startTime, Date endTime, String signInState, String a_state, List<Field> fields, Integer signInTimes) {
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

    public String getReleaseState() {
        return releaseState;
    }

    public void setReleaseState(String releaseState) {
        this.releaseState = releaseState;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getNeedStuSignUp() {
        return needStuSignUp;
    }

    public void setNeedStuSignUp(String needStuSignUp) {
        this.needStuSignUp = needStuSignUp;
    }

    public Date getSignUpStartTime() {
        return signUpStartTime;
    }

    public void setSignUpStartTime(Date signUpStartTime) {
        this.signUpStartTime = signUpStartTime;
    }

    public Date getSignUpEndTime() {
        return signUpEndTime;
    }

    public void setSignUpEndTime(Date signUpEndTime) {
        this.signUpEndTime = signUpEndTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getSignInState() {
        return signInState;
    }

    public void setSignInState(String signInState) {
        this.signInState = signInState;
    }

    public String getA_state() {
        return a_state;
    }

    public void setA_state(String a_state) {
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
