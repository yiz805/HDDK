package com.hddk.service.impl;

import com.hddk.entity.Activity;
import com.hddk.entity.ActivityQueryVo;
import com.hddk.entity.Student;
import com.hddk.entity.StudentQueryVo;
import com.hddk.mapper.ActivityMapper;
import com.hddk.mapper.FieldMapper;
import com.hddk.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private FieldMapper fieldMapper;

    public void addActivity(Activity activity) {
        //设置默认值
        activity.setA_state(0);//活动状态:草稿
        activity.setSignInState(0);//签到状态:未开始签到
        activity.setSignInTimes(0);//签到数为0
        activityMapper.addActivity(activity);
        if (activity.getFields() != null) {
            for (int i = 0; i < activity.getFields().size(); i++) {
                activity.getFields().get(i).setActivity_id(activity.getA_id());
                fieldMapper.newField(activity.getFields().get(i));
            }
        }
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

    public List<StudentQueryVo> getSignUpStu(int activity_id) {
        return activityMapper.getSignUpStu(activity_id);
    }

    public Activity getActivityAndField(int a_id) {
        return activityMapper.getActivityAndField(a_id);
    }

    public List<ActivityQueryVo> getTotalSignUpStu() {
        return activityMapper.getTotalSignUpStu();
    }

    public void releaseActivity(int a_id) {
        activityMapper.releaseActivity(a_id);
    }

    public void startSignUp(int a_id) {
        activityMapper.startSignUp(a_id);
    }

    public void startActivity(int a_id) {
        activityMapper.startActivity(a_id);
    }

    public void endActivity(int a_id) {
        activityMapper.endActivity(a_id);
        int score = activityMapper.findScore(a_id);
        activityMapper.addScore(a_id, score);
    }
}
