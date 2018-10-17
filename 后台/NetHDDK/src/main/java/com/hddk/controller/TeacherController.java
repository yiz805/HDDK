package com.hddk.controller;

import com.hddk.QueryVo.ActivityQueryVo_PC;
import com.hddk.QueryVo.StudentQueryVo_PC;
import com.hddk.entity.*;
import com.hddk.service.ActivityService;
import com.hddk.service.FieldService;
import com.hddk.service.SignService;
import com.hddk.util.AjaxResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        return AjaxResult.getOK();
    }

    /**
     * 查询所有活动
     *
     * @return activities
     */
    @ResponseBody
    @RequestMapping(value = "/getAllActivity", method = RequestMethod.GET)
    public AjaxResult getAllActivity(@Param("page")int page) {
        List<ActivityQueryVo_PC> activities = activityService.getTotalSignUpStu(page);
        int totalNum=activityService.actNum();
        int totalPage=(totalNum+7-1)/7;//(总页数+每页条数-1)/每页条数
        Map map=new HashMap();
        map.put("activity",activities);
        map.put("totalPage",totalPage);
        return AjaxResult.getOK(map);
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
        List<StudentQueryVo_PC> students = activityService.getSignUpStu(a_id);
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
     * 取消签到负责人
     *
     * @param a_id
     * @param s_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setPersonState0", method = RequestMethod.GET)
    public AjaxResult setPersonState2(@RequestParam(value = "a_id") int a_id, @RequestParam(value = "s_id") Long s_id) {
        signService.setPersonState2(s_id, a_id);
        return AjaxResult.getOK();
    }

    /**
     * 添加新的场地
     *
     * @param field
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addField", method = RequestMethod.POST)
    public AjaxResult newField(@RequestBody Field field) {
        fieldService.newField(field);
        return AjaxResult.getOK();
    }

    /**
     * 删除场地
     *
     * @param f_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteFiled", method = RequestMethod.GET)
    public AjaxResult deleteFiled(@RequestParam(value = "f_id") int f_id) {
        fieldService.deleteFiled(f_id);
        return AjaxResult.getOK();
    }

    /**
     * 修改场地
     *
     * @param field
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateField", method = RequestMethod.GET)
    public AjaxResult updateField(@RequestBody Field field) {
        fieldService.updateField(field);
        return AjaxResult.getOK();
    }

    /**
     * 搜索
     * @param state
     * @param content
     * @param page
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public AjaxResult search(@Param(value = "state") int state, @Param("content") String content,@Param("page") int page) {
        List<ActivityQueryVo_PC> activity = activityService.getActByCondition(state, content ,page);
        int totalNum=activity.size();
        int totalPage=(totalNum+7-1)/7;
        //List<ActivityQueryVo_PC> activity2=activity.subList((page-1)*7,page*7);
        Map map=new HashMap();
        map.put("activity",activity);
        map.put("totalPage",totalPage);
        return AjaxResult.getOK(map);
    }
}
