package com.hddk.service.impl;

import com.hddk.entity.Activity;
import com.hddk.entity.ActivityQueryVo;
import com.hddk.entity.Student;
import com.hddk.mapper.ActivityMapper;
import com.hddk.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    public void addActivity(Activity activity) {
        //设置默认值
        activity.setA_state(0);//活动状态:草稿
        activity.setSignInState(0);//签到状态:未开始签到
        activity.setSignInTimes(0);//签到数为0
        activityMapper.addActivity(activity);
    }

    public List<Activity> getAllActivities() {
        return activityMapper.getAllActivities();
    }

    public void deleteActivity(int a_id) {
        activityMapper.deleteActivity(a_id);
    }

    public void updateActivity(Activity activity) {
        activityMapper.updateActivity(activity);
    }

    public List<Student> getSignUpStu(int activity_id) {
        return activityMapper.getSignUpStu(activity_id);
    }

    public Activity getActivityAndField(int a_id) {
        return activityMapper.getActivityAndField(a_id);
    }

    public List<ActivityQueryVo> getTotalSignUpStu() {
        return activityMapper.getTotalSignUpStu();
    }
}
