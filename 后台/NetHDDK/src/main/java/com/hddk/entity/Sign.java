package com.hddk.entity;

import java.util.Date;

public class Sign {
    private Long id;
    private String signState;//签到状态?'0':报名,'1':过审,'2':签到
    private Date signTime;//签到时间
    private Activity activity;
    private Student student;
    private String personState;//是否为签到负责人,'0':否,'1':是

    public Sign(Long id, String signState, Date signTime, Activity activity, Student student, String personState) {
        this.id = id;
        this.signState = signState;
        this.signTime = signTime;
        this.activity = activity;
        this.student = student;
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

    public String getSignState() {
        return signState;
    }

    public void setSignState(String signState) {
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

    public String getPersonState() {
        return personState;
    }

    public void setPersonState(String personState) {
        this.personState = personState;
    }
}
