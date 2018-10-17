package com.hddk.mapper;

import com.hddk.QueryVo.StudentQueryVo_sign;
import com.hddk.entity.Sign;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SignMapper {
    //学生报名,signState=0
    //@Insert("INSERT INTO sign(id,signState,signTime,personState,activity_id,student_id,field_id)"
    //      + "VALUES(#{id},#{signState},#{signTime},#{personState},#{activity.a_id},#{student.s_id},#{field.f_id})")
    @InsertProvider(type = SqlProvider.class, method = "INSERT_Sign")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void studentSignUp(Sign signUp);

    //将学生设为'签到负责人',personState=1
    @Update("UPDATE sign SET personState=1 WHERE student_id=#{s_id} AND activity_id=#{a_id}")
    void setPersonSate(@Param("s_id") Long s_id, @Param("a_id") int a_id);

    // 查询学生状态(是否为签到负责人)
    @Select("SELECT personState FROM sign WHERE student_id=#{s_id} AND activity_id=#{a_id}")
    int findPersonState(@Param("s_id") Long s_id, @Param("a_id") int a_id);

    //签到负责人发起签到(改两个表):signState+1;signInState=1,signInTimes+1;自己签到
    @Update("UPDATE activity SET signInTimes=signInTimes+1 AND signInState=1 WHERE a_id=#{a_id}")
    void addSignInTimes(int a_id);

    @Update("UPDATE sign SET signState=signState+1 WHERE activity_id=#{a_id} AND student_id=#{s_id}")
    void stuSignIn(@Param("s_id") Long s_id, @Param("a_id") int a_id);

    //结束签到signState=0
    @Update("UPDATE activity SET signInState=0 WHERE a_id=#{a_id}")
    void endSignIn(int a_id);

    //查询活动签到记录
    @Select("SELECT sc.s_name,sc.c_name,si.signTime FROM(SELECT s_id,s_name,c_name FROM(SELECT s_id,s_name,class_id FROM student)s LEFT JOIN(SELECT c_name,c_id FROM class)c ON s.class_id=c.c_id GROUP BY s.s_id)sc RIGHT JOIN(SELECT signTime,student_id FROM sign WHERE signState=#{times} AND activity_id=#{a_id})si ON si.student_id=sc.s_id GROUP BY sc.s_id")
    List<StudentQueryVo_sign> findActivitySign(@Param("times") int signInTimes, @Param("a_id") int a_id);

    //取消报名:删除记录
    @Delete("DELETE FROM sign WHERE student_id=#{s_id} AND activity_id=#{a_id}")
    void deleteSign(@Param("s_id") Long s_id, @Param("a_id") int a_id);

    //删除活动的记录
    @Delete("DELETE FROM sign WHERE activity_id=#{a_id}")
    void deleteActSign(int a_id);

    //查询活动的签到状态
    @Select("SELECT signInState FROM activity WHERE a_id=#{a_id}")
    int getActSignInState(int a_id);

    //取消签到负责人
    @Update("UPDATE sign SET personState=0 WHERE student_id=#{s_id} AND activity_id=#{a_id}")
    void setPersonState2(@Param("s_id") Long s_id, @Param("a_id") int a_id);
}
