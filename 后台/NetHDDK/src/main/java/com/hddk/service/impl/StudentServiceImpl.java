package com.hddk.service.impl;

import com.hddk.entity.Activity;
import com.hddk.entity.Sign;
import com.hddk.entity.Student;
import com.hddk.mapper.StudentMapper;
import com.hddk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Activity> getSignUpActivity(Long student_id) {
        return studentMapper.getSignUpActivity(student_id);
    }

    public List<Sign> getStuSignIn(Long s_id, int a_id) {
        return studentMapper.getStuSignIn(s_id, a_id);
    }
}
