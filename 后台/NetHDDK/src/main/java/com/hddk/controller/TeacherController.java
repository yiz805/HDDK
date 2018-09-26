package com.hddk.controller;

import com.hddk.entity.Activity;
import com.hddk.service.ActivityService;
import com.hddk.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return AjaxResult.getOK();
    }

    @ResponseBody
    @RequestMapping(value = "/getAllActivity", method = RequestMethod.POST)
    public AjaxResult getAllActivity() {
        List<Activity> activities = activityService.getAllActivities();
        return AjaxResult.getOK(activities);
    }
    @ResponseBody
    @RequestMapping(value = "/getAllActivity", method = RequestMethod.POST)
    public AjaxResult deleteActivity(int a_id) {
        activityService.deleteActivity(a_id);
        return AjaxResult.getOK();
    }
}
