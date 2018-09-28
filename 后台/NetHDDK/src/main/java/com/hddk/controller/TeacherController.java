package com.hddk.controller;

import com.hddk.entity.Activity;
import com.hddk.entity.ActivityQueryVo;
import com.hddk.entity.Student;
import com.hddk.service.ActivityService;
import com.hddk.util.AjaxResult;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addActivity(@RequestBody Activity activity) {
        activityService.addActivity(activity);

    }

    @ResponseBody
    @RequestMapping(value = "/getAllActivity", method = RequestMethod.POST)
    public void getAllActivity(HttpServletRequest req, HttpServletResponse res) {
        List<ActivityQueryVo> activities = activityService.getTotalSignUpStu();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", activities);
        try {
            res.getWriter().write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/deleteActivity", method = RequestMethod.POST)
    public void deleteActivity(int a_id) {
        activityService.deleteActivity(a_id);

    }

    @ResponseBody
    @RequestMapping(value = "/updateActivity", method = RequestMethod.POST)
    public void updateActivity(@RequestBody Activity activity) {
        activityService.updateActivity(activity);

    }

    @ResponseBody
    @RequestMapping(value = "/getActivityField", method = RequestMethod.POST)
    public void getActivityField(@RequestParam int a_id, HttpServletRequest req, HttpServletResponse res) {
        Activity activity = activityService.getActivityAndField(a_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", activity);
        try {
            res.getWriter().write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getSignUpStu", method = RequestMethod.POST)
    public void getSignUpStu(int a_id) {
        List<Student> students = activityService.getSignUpStu(a_id);

    }

}
