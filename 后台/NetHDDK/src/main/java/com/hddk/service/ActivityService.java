package com.hddk.service;

import com.hddk.entity.Activity;
import com.hddk.entity.ActivityQueryVo;
import com.hddk.entity.Student;
import com.hddk.entity.StudentQueryVo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ActivityService {
    void addActivity(Activity activity);

    List<Activity> getAllActivities();

    void deleteActivity(int a_id);

    void updateActivity(Activity activity);

    List<StudentQueryVo> getSignUpStu(int activity_id);

    Activity getActivityAndField(int a_id);

    List<ActivityQueryVo> getTotalSignUpStu();

    void releaseActivity(int a_id);

    void startSignUp(int a_id);

    void startActivity(int a_id);

    void endActivity(int a_id);
}
