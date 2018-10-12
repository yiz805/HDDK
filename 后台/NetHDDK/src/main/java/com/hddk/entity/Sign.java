package com.hddk.entity;

import java.util.Date;

public class Sign {
    private Long id;
    private Integer signState;//签到状态?'0':报名,'1':签到1次,'2':签到2次,'3':签到3次
    private String signTime;//签到时间
    private Activity activity;
    private Student student;
    private Field field;
    private Integer personState;//是否为签到负责人,'0':否,'1':是


    public Sign(Long id, Integer signState, String signTime, Activity activity, Student student, Field field, Integer personState) {
        this.id = id;
        this.signState = signState;
        this.signTime = signTime;
        this.activity = activity;
        this.student = student;
        this.field = field;
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

    public Integer getSignState() {
        return signState;
    }

    public void setSignState(Integer signState) {
        this.signState = signState;
    }


    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
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

    public Integer getPersonState() {
        return personState;
    }

    public void setPersonState(Integer personState) {
        this.personState = personState;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
