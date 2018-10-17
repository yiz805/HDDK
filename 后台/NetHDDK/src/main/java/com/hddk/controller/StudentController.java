package com.hddk.controller;


import com.hddk.QueryVo.ActivityQueryVo_APP;
import com.hddk.QueryVo.StudentQueryVo_sign;
import com.hddk.entity.Sign;
import com.hddk.service.ActivityService;
import com.hddk.service.SignService;
import com.hddk.util.AjaxResult;
import com.hddk.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private SignService signService;

    /**
     * 获取所有活动数据
     *
     * @return activity
     */
    @ResponseBody
    @RequestMapping(value = "/getAllActivity", method = RequestMethod.GET)
    public AjaxResult getAllActivity() {
        List<ActivityQueryVo_APP> activity = activityService.getAllActivity();
        return AjaxResult.getOK(activity);
    }

    /**
     * 查询活动详情
     *
     * @param a_id
     * @return activity
     */
    @ResponseBody
    @RequestMapping(value = "/getActivityDetail", method = RequestMethod.GET)
    public AjaxResult getActivityDetail(@RequestParam(value = "a_id") int a_id) {
        ActivityQueryVo_APP activity = activityService.getActivityDetail(a_id);
        return AjaxResult.getOK(activity);
    }


    /**
     * 取消报名
     *
     * @param a_id
     * @param s_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cancelSignUp", method = RequestMethod.GET)
    public AjaxResult cancelSignUp(@RequestParam(value = "a_id") int a_id, @RequestParam(value = "s_id") Long s_id) {
        signService.deleteSign(s_id, a_id);
        return AjaxResult.getOK();
    }

    /**
     * 学生报名活动,选场地
     *
     * @param a_id
     * @param s_id
     * @param f_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/stuSignUp", method = RequestMethod.GET)
    public AjaxResult stuSignUp(@RequestParam(value = "a_id") int a_id, @RequestParam(value = "s_id") Long s_id, @RequestParam(value = "f_id") int f_id) {
        int actState = activityService.getActState(a_id);
        if (actState == 2) {
            signService.studentSignUp(s_id, f_id, a_id);
            return AjaxResult.getOK();
        } else {
            return AjaxResult.getError(ResultCode.MyException, "未开始报名或报名已结束!", null);
        }
    }

    /**
     * 签到负责人发起签到
     *
     * @param a_id
     * @param s_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/startSignIn", method = RequestMethod.GET)
    public AjaxResult startSignIn(@RequestParam(value = "a_id") int a_id, @RequestParam(value = "s_id") Long s_id) {
        int personState = signService.findPersonState(s_id, a_id);
        int actState = activityService.getActState(a_id);
        if (actState == 4) {//活动开始
            if (personState == 1) {//签到负责人
                signService.startSignIn(a_id, s_id);
                return AjaxResult.getOK();
            } else {
                return AjaxResult.getError(ResultCode.MyException, "你不是签到负责人!", null);
            }
        } else {
            return AjaxResult.getError(ResultCode.MyException, "活动未开始!", null);
        }

    }

    /**
     * 学生签到
     *
     * @param a_id
     * @param s_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/stuSignIn", method = RequestMethod.GET)
    public AjaxResult stuSignIn(@RequestParam(value = "a_id") int a_id, @RequestParam(value = "s_id") Long s_id) {
        int signInState = signService.getActSignInState(a_id);
        if (signInState == 0) {
            return AjaxResult.getError(ResultCode.MyException, "签到未开始!", null);
        } else {
            signService.stuSignIn(a_id, s_id);
            return AjaxResult.getOK();
        }
    }

    /**
     * 结束签到
     *
     * @param a_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/endSignIn", method = RequestMethod.GET)
    public AjaxResult endSignIn(@RequestParam(value = "a_id") int a_id) {
        signService.endSignIn(a_id);
        return AjaxResult.getOK();
    }

    /**
     * 查询活动签到记录
     *
     * @param a_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findActivitySign", method = RequestMethod.GET)
    public AjaxResult findActivitySign(@RequestParam(value = "a_id") int a_id) {
        List<StudentQueryVo_sign> signs = signService.findActivitySign(a_id);
        return AjaxResult.getOK(signs);
    }
}
