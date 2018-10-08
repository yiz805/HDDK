package com.hddk.mapper;

import com.hddk.entity.Activity;
import com.hddk.entity.Sign;
import com.hddk.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
    //查询学生报名的所有活动,signState=0
    @Select("SELECT * FROM activity WHERE a_id IN(SELECT activity_id FROM sign WHERE signState=0 and student_id=#{student_id})")
    List<Activity> getSignUpActivity(Long student_id);

    //学生的签到记录
    @Select("SELECT * FROM sign WHERE student_id=#{s_is} AND activity_id=#{a_id}")
    List<Sign> getStuSignIn(Long s_id,int a_id);
}
