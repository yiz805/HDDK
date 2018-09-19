package com.hddk.domain;

public class Teacher {
    private Long t_id;
    private String t_name;
    private String tel;

    public Teacher() {
    }

    public Teacher(Long t_id, String t_name, String tel) {
        this.t_id = t_id;
        this.t_name = t_name;
        this.tel = tel;
    }

    public Long getT_id() {
        return t_id;
    }

    public void setT_id(Long t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
