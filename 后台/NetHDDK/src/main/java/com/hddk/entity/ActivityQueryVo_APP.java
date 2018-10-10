package com.hddk.entity;

public class ActivityQueryVo_APP {
    private int a_id;
    private String theme;
    private String description;
    private int a_state;
    private int score;
    private String tips;
    private String signUpStartTime;//报名开始时间
    private String signUpEndTime;//报名结束时间
    private String startTime;//活动开始时间
    private String endTime;//活动结束时间
    private int num;
    private int lim;

    public ActivityQueryVo_APP() {
    }

    public ActivityQueryVo_APP(int a_id, String theme, String description, int a_state, int num, int lim) {

        this.a_id = a_id;
        this.theme = theme;
        this.description = description;
        this.a_state = a_state;
        this.num = num;
        this.lim = lim;
    }

    public ActivityQueryVo_APP(int a_id, String theme, String description, int a_state, int score, String tips, String signUpStartTime, String signUpEndTime, String startTime, String endTime, int num, int lim) {
        this.a_id = a_id;
        this.theme = theme;
        this.description = description;
        this.a_state = a_state;
        this.score = score;
        this.tips = tips;
        this.signUpStartTime = signUpStartTime;
        this.signUpEndTime = signUpEndTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.num = num;
        this.lim = lim;
    }

    public ActivityQueryVo_APP(int a_id, String theme, String description, int a_state, int score, String tips, String startTime, String endTime, int num, int lim) {
        this.a_id = a_id;
        this.theme = theme;
        this.description = description;
        this.a_state = a_state;
        this.score = score;
        this.tips = tips;
        this.startTime = startTime;
        this.endTime = endTime;
        this.num = num;
        this.lim = lim;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getA_state() {
        return a_state;
    }

    public void setA_state(int a_state) {
        this.a_state = a_state;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getLim() {
        return lim;
    }

    public void setLim(int lim) {
        this.lim = lim;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSignUpStartTime() {
        return signUpStartTime;
    }

    public void setSignUpStartTime(String signUpStartTime) {
        this.signUpStartTime = signUpStartTime;
    }

    public String getSignUpEndTime() {
        return signUpEndTime;
    }

    public void setSignUpEndTime(String signUpEndTime) {
        this.signUpEndTime = signUpEndTime;
    }
}
