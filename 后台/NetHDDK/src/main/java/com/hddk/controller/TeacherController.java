package com.hddk.controller;

import com.hddk.entity.*;
import com.hddk.service.ActivityService;
import com.hddk.service.FieldService;
import com.hddk.service.SignService;
import com.hddk.util.AjaxResult;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private SignService signService;
    @Autowired
    private FieldService fieldService;

    /**
     * 添加活动
     *
     * @param activity
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addActivity", method = RequestMethod.POST)
    public AjaxResult addActivity(@RequestBody Activity activity) {
        activityService.addActivity(activity);
        System.out.println(activity.getTheme());
        return AjaxResult.getOK();
    }

    /**
     * 查询所有活动
     *
     * @return activities
     */
    @ResponseBody
    @RequestMapping(value = "/getAllActivity", method = RequestMethod.GET)
    public AjaxResult getAllActivity() {
        List<ActivityQueryVo> activities = activityService.getTotalSignUpStu();
        return AjaxResult.getOK(activities);
    }

    /**
     * 删除活动
     *
     * @param a_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteActivity", method = RequestMethod.GET)
    public AjaxResult deleteActivity(@RequestParam(value = "a_id") int a_id) {
        activityService.deleteActivity(a_id);
        return AjaxResult.getOK();
    }

    /**
     * 修改活动
     *
     * @param activity
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateActivity", method = RequestMethod.POST)
    public AjaxResult updateActivity(@RequestBody Activity activity) {
        activityService.updateActivity(activity);
        return AjaxResult.getOK();
    }

    /**
     * 查询活动详情
     *
     * @param a_id
     * @return activity
     */
    @ResponseBody
    @RequestMapping(value = "/getActivityField", method = RequestMethod.GET)
    public AjaxResult getActivityField(@RequestParam(value = "a_id") int a_id) {
        Activity activity = activityService.getActivityAndField(a_id);
        return AjaxResult.getOK(activity);
    }

    /**
     * 获取活动报名学生名单,及学生是否为签到负责人
     *
     * @param a_id
     * @return students
     */
    @ResponseBody
    @RequestMapping(value = "/getSignUpStu", method = RequestMethod.GET)
    public AjaxResult getSignUpStu(@RequestParam(value = "a_id") int a_id) {
        List<StudentQueryVo> students = activityService.getSignUpStu(a_id);
        return AjaxResult.getOK(students);
    }

    /**
     * 将学生设置为活动签到负责人
     *
     * @param a_id
     * @param s_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setPersonState", method = RequestMethod.GET)
    public AjaxResult setPersonState(@RequestParam(value = "a_id") int a_id, @RequestParam(value = "s_id") Long s_id) {
        signService.setPersonSate(s_id, a_id);
        return AjaxResult.getOK();
    }

    /**
     * 添加新的场地
     * @param field
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/newField", method = RequestMethod.POST)
    public AjaxResult newField(@RequestBody Field field) {
        fieldService.newField(field);
        return AjaxResult.getOK();
    }

    /**
     * 删除场地
     * @param a_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteFiled", method = RequestMethod.POST)
    public AjaxResult deleteFiled(@RequestParam(value = "a_id")int a_id) {
        fieldService.deleteFiled(a_id);
        return AjaxResult.getOK();
    }
    /**
     * 定时任务
     *
     * @param a_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/releaseActivity", method = RequestMethod.POST)
    public AjaxResult releaseActivity(@RequestParam(value = "a_id") int a_id) {
        activityService.releaseActivity(a_id);
        return AjaxResult.getOK();
    }

    @ResponseBody
    @RequestMapping(value = "/startSignUp", method = RequestMethod.POST)
    public AjaxResult startSignUp(@RequestParam(value = "a_id") int a_id) {
        activityService.startSignUp(a_id);
        return AjaxResult.getOK();
    }

    @ResponseBody
    @RequestMapping(value = "/startActivity", method = RequestMethod.POST)
    public AjaxResult startActivity(@RequestParam(value = "a_id") int a_id) {
        activityService.startActivity(a_id);
        return AjaxResult.getOK();
    }

    @ResponseBody
    @RequestMapping(value = "/endActivity", method = RequestMethod.POST)
    public AjaxResult endActivity(@RequestParam(value = "a_id") int a_id) {
        activityService.endActivity(a_id);
        return AjaxResult.getOK();
    }


}
