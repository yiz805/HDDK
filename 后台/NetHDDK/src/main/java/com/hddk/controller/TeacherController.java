package com.hddk.controller;

import com.hddk.domain.Teacher;
import com.hddk.service.ITeacherService;
import com.hddk.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private ITeacherService iTeacherService;

    @ResponseBody
    @RequestMapping(value = "/getTeacher", method = RequestMethod.POST)
    public AjaxResult getTeacherByT_id(Long t_id) {
        Teacher teacher = iTeacherService.getTeacherByT_id(t_id);
        return AjaxResult.getOK(teacher);
    }
}
