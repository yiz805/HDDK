package com.hddk.service.impl;

import com.hddk.domain.Teacher;
import com.hddk.mapper.TeacherMapper;
import com.hddk.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService implements ITeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public Teacher getTeacherByT_id(Long t_id) {
        return teacherMapper.getTeacherByT_id(t_id);
    }
}
