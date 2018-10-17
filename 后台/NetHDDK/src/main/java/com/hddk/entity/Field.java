package com.hddk.entity;

public class Field {
    private Integer f_id;//场地id
    private String f_info;//场地信息
    private Integer signUpNumLimit;//报名人数上限
    private String t_name;//负责教师姓名
    private String t_tel;//电话
    private Integer activity_id;

    public Field() {
    }

    public Field(String f_info, Integer signUpNumLimit, String t_name, String t_tel, Integer activity_id) {
        this.f_info = f_info;
        this.signUpNumLimit = signUpNumLimit;
        this.t_name = t_name;
        this.t_tel = t_tel;
        this.activity_id = activity_id;
    }

    public Field(Integer f_id, String f_info, Integer signUpNumLimit, String t_name, String t_tel, Integer activity_id) {
        this.f_id = f_id;
        this.f_info = f_info;
        this.signUpNumLimit = signUpNumLimit;
        this.t_name = t_name;
        this.t_tel = t_tel;
        this.activity_id = activity_id;
    }

    public Integer getF_id() {
        return f_id;
    }

    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }

    public String getF_info() {
        return f_info;
    }

    public void setF_info(String f_info) {
        this.f_info = f_info;
    }

    public Integer getSignUpNumLimit() {
        return signUpNumLimit;
    }

    public void setSignUpNumLimit(Integer signUpNumLimit) {
        this.signUpNumLimit = signUpNumLimit;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_tel() {
        return t_tel;
    }

    public void setT_tel(String t_tel) {
        this.t_tel = t_tel;
    }

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }
}
