package com.test.serviceTest;


import com.hddk.entity.Activity;
import com.hddk.entity.Field;
import com.hddk.entity.Student;
import com.hddk.service.FieldService;
import com.hddk.service.StudentService;
import com.hddk.service.impl.ActivityServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * create by Liujishuai on 2015年9月21日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TeacherServerTest {
    @Autowired
    private ActivityServiceImpl activityService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private FieldService fieldService;

    @Test
    public void testAddActivity() {
        Activity activity = new Activity();
        // activity.setA_id(2);
        activity.setTheme("商务英语");
        activity.setDescription("啊啊啊啊");
        activity.setScore(2D);
        activity.setTips("");
        activity.setA_state("0");
        activity.setNeedStuSignUp("1");
        activity.setReleaseState("0");
        activity.setNeedStuSignUp("1");
        Date signupStatTime = new Date();
        activity.setSignUpStartTime(signupStatTime);
        activity.setSignUpEndTime(signupStatTime);
        activity.setStartTime(signupStatTime);
        activity.setEndTime(signupStatTime);
        activity.setSignInState("0");
        activity.setSignInTimes(1);
        activityService.addActivity(activity);
    }

    @Test
    public void testGetAllActivity() {
        List<Activity> activities = activityService.getAllActivities();
        System.out.println(activities.get(0));
    }

    @Test
    public void testDeleteActivity() {
        activityService.deleteActivity(2L);
    }

    @Test
    public void testUpdateActivity() {
        Activity activity = new Activity();
        activity.setA_id(3);
        activity.setTheme("商务英语");
        activity.setDescription("啊啊啊啊");
        activity.setScore(2D);
        activity.setTips("asdf");
        activity.setA_state("0");
        activity.setNeedStuSignUp("1");
        activity.setReleaseState("0");
        activity.setNeedStuSignUp("1");
        Date signupStatTime = new Date();
        activity.setSignUpStartTime(signupStatTime);
        activity.setSignUpEndTime(signupStatTime);
        activity.setStartTime(signupStatTime);
        activity.setEndTime(signupStatTime);
        activity.setSignInState("0");

        activityService.updateActivity(activity);
    }

    @Test
    public void testGetActivityAndField() {
        Activity activity = activityService.getActivityAndFiled(1);
        System.out.println(activity.getFields().get(0).getF_info());
    }

    @Test
    public void testGetActivityField() {
        List<Field> fields = fieldService.getFieldByA_id(1);
        System.out.println(fields.get(0).getF_info());
    }
}
