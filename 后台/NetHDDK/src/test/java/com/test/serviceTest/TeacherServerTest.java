package com.test.serviceTest;


import com.hddk.QueryVo.*;
import com.hddk.entity.*;
import com.hddk.service.FieldService;
import com.hddk.service.SignService;
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
    @Autowired
    private SignService signService;

    @Test
    public void testAddActivity() {
        Activity activity = new Activity();
        // activity.setA_id(2);
        activity.setTheme("商务英语");
        activity.setDescription("啊啊啊啊");
        activity.setScore(2D);
        activity.setTips("----------");
        activity.setA_state(0);
        activity.setReleaseState(0);
        //  Date signupStatTime = new Date();
        activity.setSignUpStartTime("2018-10-10 18:16:08");
        activity.setSignUpEndTime("2018-10-10 18:16:08");
        activity.setStartTime("2018-10-10 18:16:08");
        activity.setEndTime("2018-10-10 18:16:08");
        activity.setSignInState(0);
        activity.setSignInTimes(1);
        activityService.addActivity(activity);
    }


    //    @Test
//    public void testDeleteActivity() {
//        activityService.deleteActivity(2L);
//    }

    @Test
    public void testUpdateActivity() {
        Activity activity = new Activity();
        activity.setA_id(3);
        activity.setTheme("商务英语");
        activity.setDescription("啊啊啊啊");
        activity.setScore(2D);
        activity.setTips("asdf");
        activity.setA_state(0);

        activity.setReleaseState(0);
        Date signupStatTime = new Date();
        activity.setSignUpStartTime("2018-10-11 18:00:00");
        activity.setSignUpEndTime("2018-10-11 18:00:00");
        activity.setStartTime("2018-10-11 18:00:00");
        activity.setEndTime("2018-10-11 18:00:00");
        activity.setSignInState(0);

        activityService.updateActivity(activity);
    }

    @Test
    public void testGetActivityAndField() {
        Activity activity = activityService.getActivityAndField(1);
        System.out.println(activity.getA_id());
    }

    @Test
    public void testGetActivityField() {
        List<Field> fields = fieldService.getFieldByA_id(1);
        System.out.println(fields.get(0).getF_info());
    }

    @Test
    public void testGetTotal() {
        List<ActivityQueryVo_APP> total = activityService.getAllActivity();
        System.out.println(total.get(0).getTheme());
    }

    @Test
    public void teststartSignIn() {

        signService.setPersonSate(1L, 1);
    }

    @Test
    public void testGetTimes() {
        List<ActivityQueryVo_task> activityQueryVo_tasks = activityService.getTimes();
        for (int i = 0; i < activityQueryVo_tasks.size(); i++) {
            System.out.println(activityQueryVo_tasks.get(i).getReleaseTime());
        }
    }

    @Test
    public void testGetSignUpStudent() {
        List<StudentQueryVo_PC> studentQueryVos = activityService.getSignUpStu(1);
        for (int i = 0; i < studentQueryVos.size(); i++) {
            System.out.println(studentQueryVos.get(i).getS_name());
        }
    }

    @Test
    public void testGetActivityDetail() {
        ActivityQueryVo_APP activityQueryVo_app = activityService.getActivityDetail(1);
        System.out.println(activityQueryVo_app.getFields().get(0).getF_info());
    }

    @Test
    public void testStuSignUp() {
        signService.studentSignUp(1L, 1, 1);
    }

    @Test
    public void testfindActivitySign() {
        List<StudentQueryVo_sign> signs = signService.findActivitySign(1);
    }

    @Test
    public void testGetActByCondition() {
        List<ActivityQueryVo_PC> activityQueryVo_pcs = activityService.getActByCondition(1, " ,2018-10-16");
        for (int i = 0; i < activityQueryVo_pcs.size(); i++) {
            System.out.println(activityQueryVo_pcs.get(i).getTheme());
        }
    }
}
