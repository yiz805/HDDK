package com.hddk.entity;

public class Student {
    private Long s_id;//学生id
    private String s_name;//学生姓名

    public Student() {
    }

    public Student(Long s_id, String s_name) {
        this.s_id = s_id;
        this.s_name = s_name;

    }

    public Long getS_id() {
        return s_id;
    }

    public void setS_id(Long s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

}
