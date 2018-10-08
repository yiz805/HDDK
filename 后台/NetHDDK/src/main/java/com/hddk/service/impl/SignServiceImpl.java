package com.hddk.service.impl;

import com.hddk.entity.Sign;
import com.hddk.mapper.SignMapper;
import com.hddk.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SignServiceImpl implements SignService {
    @Autowired
    private SignMapper signMapper;

    public void studentSignUp(Sign signUp) {
        //设置默认值
        signUp.setSignState(0);//状态:报名
        signUp.setSignTime(new Date().toString());
        signUp.setPersonState(0);//是否负责人:否
        signMapper.studentSignUp(signUp);
    }

    public void setPersonSate(Long s_id, int a_id) {
        signMapper.setPersonSate(s_id, a_id);
    }

    public boolean isPerson(Long s_id) {
        int personState = signMapper.findPersonState(s_id);
        if (personState == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void startSignIn(int a_id, Long s_id) {
        signMapper.addSignInTimes(a_id);
        signMapper.personSignIn(s_id, a_id);
    }

    public void endSignIn(int a_id) {
        signMapper.endSignIn(a_id);
    }

    public List<Sign> findActivitySign(int a_id) {
        return signMapper.findActivitySign(a_id);
    }
}
