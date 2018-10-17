package com.hddk.service;

import com.hddk.QueryVo.ActivityQueryVo_APP;
import com.hddk.QueryVo.ActivityQueryVo_PC;
import com.hddk.QueryVo.ActivityQueryVo_task;
import com.hddk.QueryVo.StudentQueryVo_PC;
import com.hddk.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ActivityService {
    void addActivity(Activity activity);

    void deleteActivity(int a_id);

    void updateActivity(Activity activity);

    List<StudentQueryVo_PC> getSignUpStu(int activity_id);

    Activity getActivityAndField(int a_id);

    List<ActivityQueryVo_PC> getTotalSignUpStu(int page);

    void releaseActivity(int a_id);

    void startSignUp(int a_id);

    void endSignUp(int a_id);

    void startActivity(int a_id);

    void endActivity(int a_id);

    List<ActivityQueryVo_APP> getAllActivity();

    ActivityQueryVo_APP getActivityDetail(int a_id);

    Activity getActByA_id(int a_id);

    List<ActivityQueryVo_task> getTimes();

    int getActState(int a_id);

    List<ActivityQueryVo_PC> getActByCondition(int state, String content);

    int actNum();
}
