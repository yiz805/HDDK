package com.hddk.entity;

import java.util.List;

public class Classes {
    private Integer c_id;//班级id
    private String c_name;//班级名
    private List<Student> students;//班级的学生

    public Classes() {
    }

    public Classes(Integer c_id, String c_name) {

        this.c_id = c_id;
        this.c_name = c_name;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
