package com.hddk.service;

import com.hddk.entity.Activity;
import com.hddk.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ActivityService {
    void addActivity(Activity activity);

    List<Activity> getAllActivities();

    void deleteActivity(int a_id);

    void updateActivity(Activity activity);

    List<Student> getSignUpStu(int activity_id);

    Activity getActivityAndFiled(int a_id);
}
