package com.hddk.service.impl;

import com.hddk.entity.*;
import com.hddk.mapper.ActivityMapper;
import com.hddk.mapper.FieldMapper;
import com.hddk.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<ActivityQueryVo_PC> getTotalSignUpStu() {
        return activityMapper.getTotalSignUpStu();
    }

    public void releaseActivity(int a_id) {
        activityMapper.releaseActivity(a_id);
    }

    public void startSignUp(int a_id) {
        activityMapper.startSignUp(a_id);
    }

    public void endSignUp(int a_id) {
        activityMapper.endSignUp(a_id);
    }

    public void startActivity(int a_id) {
        activityMapper.startActivity(a_id);
    }

    public void endActivity(int a_id) {
        activityMapper.endActivity(a_id);
        int score = activityMapper.findScore(a_id);
        List<Student> students = activityMapper.getActivityStu(a_id);
        for (int i = 0; i < students.size(); i++) {
            Long s_id = students.get(i).getS_id();
            activityMapper.addScore(s_id, score);
        }
    }

    public List<ActivityQueryVo_APP> getAllActivity() {
        return activityMapper.getAllActivity();
    }

    public ActivityQueryVo_APP getActivityDetail(int a_id) {
        return activityMapper.getActivityDetail(a_id);
    }

    public Activity getActByA_id(int a_id) {
        return activityMapper.getActByA_id(a_id);
    }

    public List<ActivityQueryVo_task> getTimes() {
        return activityMapper.getTimes();
    }
}
