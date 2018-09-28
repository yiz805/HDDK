package com.hddk.entity;

import java.util.Date;

public class Sign {
    private Long id;
    private int signState;//签到状态?'0':报名,'1':过审,'2':签到
    private Date signTime;//签到时间
    private Activity activity;
    private Student student;
    private Sign sign;
    private int personState;//是否为签到负责人,'0':否,'1':是


    public Sign(Long id, int signState, Date signTime, Activity activity, Student student, Sign sign, int personState) {
        this.id = id;
        this.signState = signState;
        this.signTime = signTime;
        this.activity = activity;
        this.student = student;
        this.sign = sign;
        this.personState = personState;
    }

    public Sign() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSignState() {
        return signState;
    }

    public void setSignState(int signState) {
        this.signState = signState;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getPersonState() {
        return personState;
    }

    public void setPersonState(int personState) {
        this.personState = personState;
    }

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }
}
