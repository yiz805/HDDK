package com.hddk.service.impl;

import com.hddk.entity.Sign;
import com.hddk.mapper.SignMapper;
import com.hddk.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SignServiceImpl implements SignService {
    @Autowired
    private SignMapper signMapper;

    public void studentSignUp(Sign signUp) {
        //设置默认值
        signUp.setSignState("0");
        signUp.setSignTime(new Date());
        signUp.setPersonState("0");
        signMapper.studentSignUp(signUp);
    }

    public void setPersonSate(Long s_id) {
        signMapper.setPersonSate(s_id);
    }

}
