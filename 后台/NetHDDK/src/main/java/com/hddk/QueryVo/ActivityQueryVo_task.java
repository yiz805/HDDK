package com.hddk.QueryVo;


public class ActivityQueryVo_task {
    private Integer a_id;
    private String releaseTime;
    private String signUpStartTime;
    private String signUpEndTime;
    private String startTime;
    private String endTime;
    private int a_state;

    public ActivityQueryVo_task(Integer a_id, String releaseTime, String signUpStartTime, String signUpEndTime, String startTime, String endTime, int a_state) {
        this.a_id = a_id;
        this.releaseTime = releaseTime;
        this.signUpStartTime = signUpStartTime;
        this.signUpEndTime = signUpEndTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.a_state = a_state;
    }

    public ActivityQueryVo_task() {
    }

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
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

    public int getA_state() {
        return a_state;
    }

    public void setA_state(int a_state) {
        this.a_state = a_state;
    }
}
