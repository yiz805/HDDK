package com.hddk.mapper;

import com.hddk.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ActivityMapper {
    //添加活动(改SQL片段拼接)
    @Insert("INSERT INTO activity(a_id,theme,score,description,tips,releaseState,releaseTime,signUpStartTime,signUpEndTime,startTime,endTime,signInState,a_state,signInTimes)" +
            "VALUES(#{a_id},#{theme},#{score},#{description},#{tips},#{releaseState},#{releaseTime},#{signUpStartTime},#{signUpEndTime},#{startTime},#{endTime},#{signInState},#{a_state},#{signInTimes})")
    @Options(useGeneratedKeys = true, keyProperty = "a_id")
    void addActivity(Activity activity);

    //查询所有活动信息
    @Select("SELECT * FROM activity")
    List<Activity> getAllActivities();

    //删除活动
    @Delete("DELETE FROM activity WHERE a_id=#{a_id}")
    void deleteActivity(int a_id);

    //修改活动(改SQL片段拼接)
    @Update("Update activity SET theme=#{theme},score=#{score},description=#{description},tips=#{tips},releaseState=#{releaseState},releaseTime=#{releaseTime},needStuSignUp=#{needStuSignUp},signUpStartTime=#{signUpStartTime},signUpEndTime=#{signUpEndTime},startTime=#{startTime},endTime=#{endTime},signInState=#{signInState},a_state=#{a_state} WHERE a_id=#{a_id}")
    void updateActivity(Activity activity);

    //查询活动的报名学生和是否为签到负责人,signState=0
    @Select("SELECT stu.*,personState FROM(SELECT * FROM student)stu LEFT JOIN(SELECT id,personState FROM sign WHERE signState=0 AND activity_id=#{activity_id})s ON stu.s_id=s.id GROUP BY stu.s_id")
    List<StudentQueryVo> getSignUpStu(int activity_id);

    //查询活动的信息(带场地信息)
    @Select("SELECT * FROM activity WHERE a_id=#{a_id}")
    @Results({
            @Result(column = "a_id", property = "fields", many = @Many(select = "com.hddk.mapper.FieldMapper.getFieldByA_id"))
    })
    Activity getActivityAndField(int a_id);

    //查询活动报名总人数
    //    @Select("SELECT COUNT(*) FROM sign WHERE signState=0 and activity_id=#{a_id}")
    //    Long getTotalSignUpStu(int a_id);
    @Select("SELECT a.a_id,a.theme,a.signUpStartTime,a.startTime,a.a_state,count(s.activity_id) num from (select a_id,theme,signUpStartTime,startTime,a_state from activity ) a left join (select activity_id from sign ) s on a.a_id = s.activity_id GROUP BY a.a_id ORDER BY a.a_state")
    List<ActivityQueryVo> getTotalSignUpStu();

    //发布活动:a_state=1
    @Update("UPDATE activity SET a_state=1 WHERE a_id=#{a_id}")
    void releaseActivity(int a_id);

    //活动开始报名
    @Update("UPDATE activity SET a_state=2 WHERE a_id=#{a_id}")
    void startSignUp(int a_id);

    //活动开始
    @Update("UPDATE activity SET a_state=3 WHERE a_id=#{a_id}")
    void startActivity(int a_id);

    //活动结束,学生加思政分
    @Update("UPDATE activity SET a_state=4 WHERE a_id=#{a_id}")
    void endActivity(int a_id);

    @Select("SELECT score FROM activity WHERE a_id=#{a_id}")
    int findScore(int a_id);

    @Update("UPDATE student SET s_score=s_score+#{score}")
    void addScore(int a_id, int score);
}
