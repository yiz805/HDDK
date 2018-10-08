package com.hddk.mapper;

import com.hddk.entity.Sign;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SignMapper {
    //学生报名,signState=0
    @Insert("INSERT INTO sign(id,signState,signTime,personState,activity_id,student_id)"
            + "VALUES(#{id},0,#{signTime},#{personState},#{activity_id},#{student_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void studentSignUp(Sign signUp);

    //将学生设为'签到负责人',personState=1
    @Update("UPDATE sign SET personState=1 WHERE student_id=#{s_id} AND activity_id=#{a_id}")
    void setPersonSate(Long s_id, int a_id);

    // 查询学生状态(是否为签到负责人)
    @Select("SELECT personState FROM sign WHERE student_id=#{s_id}")
    int findPersonState(Long s_id);

    //签到负责人发起签到(改两个表):signState=1;signInState=1,signInTimes+1;自己签到
    @Update("UPDATE activity SET signInTimes=signInTimes+1 AND signInState=1 WHERE a_id=#{a_id}")
    void addSignInTimes(int a_id);

    @Update("UPDATE sign SET signState=1 WHERE activity_id=#{a_id} AND student_id=#{s_id}")
    void personSignIn(Long s_id, int a_id);

    //结束签到signState=0
    @Update("UPDATE activity SET signInState=0 WHERE a_id=#{a_id}")
    void endSignIn(int a_id);

    //查询活动签到记录
    @Select("SELECT * FROM sign WHERE activity_id=#{a_id} AND signState=1")
    List<Sign> findActivitySign(int a_id);

}
