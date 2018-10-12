package com.hddk.mapper;

import com.hddk.QueryVo.ActivityQueryVo_APP;
import com.hddk.QueryVo.ActivityQueryVo_PC;
import com.hddk.QueryVo.ActivityQueryVo_task;
import com.hddk.QueryVo.StudentQueryVo_PC;
import com.hddk.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ActivityMapper {
    //添加活动(改SQL片段拼接)
//    @Insert("INSERT INTO activity(a_id,theme,score,description,tips,releaseState,releaseTime,signUpStartTime,signUpEndTime,startTime,endTime,signInState,a_state,signInTimes)" +
//            "VALUES(#{a_id},#{theme},#{score},#{description},#{tips},#{releaseState},#{releaseTime},#{signUpStartTime},#{signUpEndTime},#{startTime},#{endTime},#{signInState},#{a_state},#{signInTimes})")
    @InsertProvider(type = SqlProvider.class, method = "INSET_Activity")
    @Options(useGeneratedKeys = true, keyProperty = "a_id")
    void addActivity(Activity activity);

    //    查询所有活动信息
//    @Select("SELECT * FROM activity")
//    List<Activity> getAllActivities();
    //删除活动
    @Delete("DELETE FROM activity WHERE a_id=#{a_id}")
    void deleteActivity(int a_id);

    //修改活动(改SQL片段拼接)
    //@Update("Update activity SET theme=#{theme},score=#{score},description=#{description},tips=#{tips},releaseState=#{releaseState},releaseTime=#{releaseTime},signUpStartTime=#{signUpStartTime},signUpEndTime=#{signUpEndTime},startTime=#{startTime},endTime=#{endTime},signInState=#{signInState},a_state=#{a_state} WHERE a_id=#{a_id}")
    @UpdateProvider(type = SqlProvider.class, method = "UPDATE_Activity")
    void updateActivity(Activity activity);

    //查询活动的报名学生和是否为签到负责人报名时间,signState=0
    @Select("SELECT stu.*,personState,signTime FROM(SELECT * FROM student)stu RIGHT JOIN(SELECT personState,signTime,student_id FROM sign WHERE activity_id=#{activity_id})s ON stu.s_id=s.student_id GROUP BY stu.s_id")
    List<StudentQueryVo_PC> getSignUpStu(int activity_id);

    //查询活动的信息(带场地信息)
    @Select("SELECT * FROM activity WHERE a_id=#{a_id}")
    @Results({
            @Result(column = "a_id", property = "fields", many = @Many(select = "com.hddk.mapper.FieldMapper.getFieldByA_id"))
    })
    Activity getActivityAndField(int a_id);

    //查询活动报名总人数
    //    @Select("SELECT COUNT(*) FROM sign WHERE signState=0 and activity_id=#{a_id}")
    //    Long getTotalSignUpStu(int a_id);
    @Select("SELECT a.a_id,a.theme,a.signUpStartTime,a.startTime,a.a_state,count(s.activity_id) num from (select a_id,theme,signUpStartTime,startTime,a_state,releaseTime from activity ) a left join (select activity_id from sign ) s on a.a_id = s.activity_id GROUP BY a.a_id ORDER BY a.releaseTime DESC")
    List<ActivityQueryVo_PC> getTotalSignUpStu();

    //发布活动:a_state=1
    @Update("UPDATE activity SET a_state=1 WHERE a_id=#{a_id}")
    void releaseActivity(int a_id);

    //活动开始报名
    @Update("UPDATE activity SET a_state=2 WHERE a_id=#{a_id}")
    void startSignUp(int a_id);

    //报名结束
    @Update("UPDATE activity SET a_state=3 WHERE a_id=#{a_id}")
    void endSignUp(int a_id);

    //活动开始
    @Update("UPDATE activity SET a_state=4 WHERE a_id=#{a_id}")
    void startActivity(int a_id);

    //活动结束,学生加思政分
    @Update("UPDATE activity SET a_state=5 WHERE a_id=#{a_id}")
    void endActivity(int a_id);

    @Select("SELECT score FROM activity WHERE a_id=#{a_id}")
    int findScore(int a_id);

    @Update("UPDATE student SET s_score=s_score+#{score} WHERE s_id=#{s_id}")
    void addScore(@Param("s_id") Long s_id, @Param("score") int score);

    /*
        //查询活动报名人数限制
        @Select("SELECT signUpNumLimit FROM field WHERE activity_id=#{a_id}")
        List<Integer> findActivityLimit(int a_id);

        //查询活动的报名人数
        @Select("SELECT count(*) FROM sign WHERE activity_id=#{a_id}")
        int findActivitySignNum(int a_id);
    */
    //查询所有活动(APP端)
    @Select("SELECT ac.*,sum(signUpNumLimit)lim FROM(SELECT a.*,count(s.activity_id) num from (select a_id,theme,description,a_state from activity ) a left join (select activity_id from sign ) s on a.a_id = s.activity_id GROUP BY a.a_id ORDER BY a.a_state) ac LEFT JOIN(SELECT signUpNumLimit,activity_id FROM field)f ON ac.a_id=f.activity_id GROUP BY ac.a_id")
    List<ActivityQueryVo_APP> getAllActivity();

    //查询活动详情(APP)
    @Select("SELECT ac.*,sum(signUpNumLimit)lim FROM(SELECT a.*,count(s.activity_id) num from (select a_id,theme,description,a_state,tips,score,startTime,endTime,signUpStartTime,signUpEndTime from activity WHERE a_id=#{a_id}) a left join (select activity_id from sign ) s on a.a_id = s.activity_id GROUP BY a.a_id ORDER BY a.a_state) ac LEFT JOIN(SELECT signUpNumLimit,activity_id FROM field)f ON ac.a_id=f.activity_id GROUP BY ac.a_id")
    @Results({
            @Result(column = "a_id", property = "fields", many = @Many(select = "com.hddk.mapper.FieldMapper.getFieldByA_id"))
    })
    ActivityQueryVo_APP getActivityDetail(int a_id);

    //按id查activity
    @Select("SELECT * FROM activity WHERE a_id=#{a_id}")
    Activity getActByA_id(int a_id);

    //查询所有时间(Task)
    @Select("SELECT a_id,releaseTime,signUpStartTime,signUpEndTime,startTime,endTime,a_state FROM activity")
    List<ActivityQueryVo_task> getTimes();

    //查询活动报名的所有学生
    @Select("SELECT * FROM student WHERE s_id IN (SELECT s_id FROM sign WHERE activity_id=#{a_id})")
    List<Student> getActivityStu(int a_id);

    //查询活动的签到次数
    @Select("SELECT signInTimes FROM activity WHERE a_id=#{a_id}")
    int getActSignInTimes(int a_id);

    //查询活动状态
    @Select("SELECT a_state FROM activity WHERE a_id=#{a_id}")
    int getActState(int a_id);
}
