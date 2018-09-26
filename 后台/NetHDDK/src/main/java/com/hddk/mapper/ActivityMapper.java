package com.hddk.mapper;

import com.hddk.entity.Activity;
import com.hddk.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ActivityMapper {
    //添加活动
    @Insert("INSERT INTO activity(a_id,theme,score,description,tips,releaseState,releaseTime,needStuSignUp,signUpStartTime,signUpEndTime,startTime,endTime,signInState,a_state,signInTimes)" +
            "VALUES(#{a_id},#{theme},#{score},#{description},#{tips},#{releaseState},#{releaseTime},#{needStuSignUp},#{signUpStartTime},#{signUpEndTime},#{startTime},#{endTime},#{signInState},#{a_state},#{signInTimes})")
    @Options(useGeneratedKeys = true, keyProperty = "a_id")
    void addActivity(Activity activity);

    //查询所有活动信息
    @Select("SELECT * FROM activity")
    List<Activity> getAllActivities();

    //删除活动
    @Delete("DELETE FROM activity WHERE a_id=#{a_id}")
    void deleteActivity(int a_id);

    //修改活动
    @Update("Update activity SET theme=#{theme},score=#{score},description=#{description},tips=#{tips},releaseState=#{releaseState},releaseTime=#{releaseTime},needStuSignUp=#{needStuSignUp},signUpStartTime=#{signUpStartTime},signUpEndTime=#{signUpEndTime},startTime=#{startTime},endTime=#{endTime},signInState=#{signInState},a_state=#{a_state} WHERE a_id=#{a_id}")
    void updateActivity(Activity activity);

    //查询活动的报名学生,signState='0'
    @Select("SELECT * FROM student WHERE s_id IN(SELECT student_id FROM sign WHERE signState='0' and activity_id=#{activity_id})")
    List<Student> getSignUpStu(int activity_id);

    //查询活动的信息(带场地信息)
    @Select("SELECT * FROM activity WHERE a_id=#{a_id}")
    @Results({
            @Result(column = "a_id",property = "fields",many = @Many(select = "com.hddk.mapper.FieldMapper.getFieldByA_id"))
    })
    Activity getActivityAndFiled(int a_id);
}
