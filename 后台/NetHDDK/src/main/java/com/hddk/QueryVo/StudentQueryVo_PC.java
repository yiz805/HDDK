package com.hddk.QueryVo;

public class StudentQueryVo_PC {
    private Long s_id;//学生id
    private String s_name;//学生姓名
    private int personState;//是否为签到负责人
    private String signTime;//报名时间

    public StudentQueryVo_PC() {
    }

    public StudentQueryVo_PC(Long s_id, String s_name, int personState, String signTime) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.personState = personState;
        this.signTime = signTime;
    }

    public StudentQueryVo_PC(Long s_id, String s_name, int personState) {

        this.s_id = s_id;
        this.s_name = s_name;
        this.personState = personState;
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

    public int getPersonState() {
        return personState;
    }

    public void setPersonState(int personState) {
        this.personState = personState;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }
}
