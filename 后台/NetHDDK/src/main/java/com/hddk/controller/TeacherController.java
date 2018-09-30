package com.hddk.controller;

import com.hddk.entity.Activity;
import com.hddk.entity.ActivityQueryVo;
import com.hddk.entity.Student;
import com.hddk.service.ActivityService;
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

    @ResponseBody
    @RequestMapping(value = "/addActivity", method = RequestMethod.POST)
    public AjaxResult addActivity(@RequestBody Activity activity) {
        activityService.addActivity(activity);
        System.out.println(activity.getTheme());
        return AjaxResult.getOK();
    }

    @ResponseBody
    @RequestMapping(value = "/getAllActivity", method = RequestMethod.POST)
    public AjaxResult getAllActivity() {
        List<ActivityQueryVo> activities = activityService.getTotalSignUpStu();
        return AjaxResult.getOK(activities);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteActivity", method = RequestMethod.GET)
    public AjaxResult deleteActivity(@RequestParam(value = "a_id") int a_id) {
        activityService.deleteActivity(a_id);
        return AjaxResult.getOK();
    }

    @ResponseBody
    @RequestMapping(value = "/updateActivity", method = RequestMethod.POST)
    public AjaxResult updateActivity(@RequestBody Activity activity) {
        activityService.updateActivity(activity);
        return AjaxResult.getOK();
    }

    @ResponseBody
    @RequestMapping(value = "/getActivityField", method = RequestMethod.POST)
    public AjaxResult getActivityField(@RequestParam(value = "a_id") int a_id) {
        Activity activity = activityService.getActivityAndField(a_id);
        return AjaxResult.getOK(activity);
    }

    @ResponseBody
    @RequestMapping(value = "/getSignUpStu", method = RequestMethod.POST)
    public AjaxResult getSignUpStu(@RequestParam(value = "a_id") int a_id) {
        List<Student> students = activityService.getSignUpStu(a_id);
        return AjaxResult.getOK(students);
    }

}
