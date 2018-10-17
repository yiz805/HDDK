package com.hddk.service.impl;

import com.hddk.QueryVo.ActivityQueryVo_APP;
import com.hddk.QueryVo.ActivityQueryVo_PC;
import com.hddk.QueryVo.ActivityQueryVo_task;
import com.hddk.QueryVo.StudentQueryVo_PC;
import com.hddk.entity.*;
import com.hddk.mapper.ActivityMapper;
import com.hddk.mapper.FieldMapper;
import com.hddk.mapper.SignMapper;
import com.hddk.mapper.StudentMapper;
import com.hddk.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private FieldMapper fieldMapper;
    @Autowired
    private SignMapper signMapper;
    @Autowired
    private StudentMapper studentMapper;

    public void addActivity(Activity activity) {
        //设置默认值
        activity.setSignInState(0);//签到状态:未开始签到
        activity.setSignInTimes(0);//签到数为0
        if (activity.getReleaseState() == 0) {//直接发布
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String date = sdf.format(now);
            activity.setA_state(1);//发布状态
            activity.setReleaseTime(date);//发布时间为当前时间
        } else {//定时发布
            activity.setA_state(0);//草稿状态
        }
        activityMapper.addActivity(activity);
        if (activity.getFields() != null) {
            for (int i = 0; i < activity.getFields().size(); i++) {
                activity.getFields().get(i).setActivity_id(activity.getA_id());
                fieldMapper.newField(activity.getFields().get(i));
            }
        }
    }

    public void deleteActivity(int a_id) {
        signMapper.deleteActSign(a_id);
        fieldMapper.deleteActField(a_id);
        activityMapper.deleteActivity(a_id);
    }

    public void updateActivity(Activity activity) {
        activityMapper.updateActivity(activity);
    }

    public List<StudentQueryVo_PC> getSignUpStu(int activity_id) {
        return activityMapper.getSignUpStu(activity_id);
    }

    public Activity getActivityAndField(int a_id) {
        return activityMapper.getActivityAndField(a_id);
    }

    public List<ActivityQueryVo_PC> getTotalSignUpStu(int page) {
        int p=(page-1)*7;
        return activityMapper.getTotalSignUpStu(p);
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
            int stuSignInTimes = studentMapper.getStuSignInTimes(s_id, a_id);
            int actSignInTimes = activityMapper.getActSignInTimes(a_id);
            if (stuSignInTimes == actSignInTimes)
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

    public int getActState(int a_id) {
        return activityMapper.getActState(a_id);
    }

    public List<ActivityQueryVo_PC> getActByCondition(int state, String content,int page) {
        int p=(page-1)*7;
        return activityMapper.getActByCondition(state, content,p);
    }
    public int actNum(){
        return activityMapper.actNum();
    }
}
