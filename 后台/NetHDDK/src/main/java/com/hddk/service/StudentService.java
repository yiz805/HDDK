package com.hddk.service;

import com.hddk.entity.Activity;
import com.hddk.entity.Sign;
import com.hddk.entity.Student;

import java.util.List;

public interface StudentService {
    List<Activity> getSignUpActivity(Long student_id);
}
