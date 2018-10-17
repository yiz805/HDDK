package com.hddk.QueryVo;

public class StudentQueryVo_sign {
    private String s_name;
    private String c_name;
    private String signTime;

    public StudentQueryVo_sign() {
    }

    public StudentQueryVo_sign(String s_name, String c_name, String signTime) {

        this.s_name = s_name;
        this.c_name = c_name;
        this.signTime = signTime;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }
}
