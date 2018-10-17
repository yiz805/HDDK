package com.hddk.service.impl;

import com.hddk.QueryVo.StudentQueryVo_sign;
import com.hddk.entity.Sign;
import com.hddk.mapper.ActivityMapper;
import com.hddk.mapper.FieldMapper;
import com.hddk.mapper.SignMapper;
import com.hddk.mapper.StudentMapper;
import com.hddk.service.ActivityService;
import com.hddk.service.FieldService;
import com.hddk.service.SignService;
import com.hddk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SignServiceImpl implements SignService {
    @Autowired
    private SignMapper signMapper;
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private FieldMapper fieldMapper;

    public void studentSignUp(Long s_id, int f_id, int a_id) {
        //设置默认值
        Sign signUp = new Sign();
        signUp.setActivity(activityMapper.getActByA_id(a_id));
        signUp.setStudent(studentMapper.getStuByS_id(s_id));
        signUp.setField(fieldMapper.getFieldByF_id(f_id));
        signUp.setSignState(0);//状态:报名
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        signUp.setSignTime(sdf.format(date));
        signUp.setPersonState(0);//是否负责人:否
        signMapper.studentSignUp(signUp);
    }

    public void setPersonSate(Long s_id, int a_id) {
        signMapper.setPersonSate(s_id, a_id);
    }

    public int findPersonState(Long s_id, int a_id) {
        return signMapper.findPersonState(s_id, a_id);
    }

    public void startSignIn(int a_id, Long s_id) {
        signMapper.addSignInTimes(a_id);
        signMapper.stuSignIn(s_id, a_id);
    }

    public void endSignIn(int a_id) {
        signMapper.endSignIn(a_id);
    }

    public List<StudentQueryVo_sign> findActivitySign(int a_id) {
        int signInTimes = activityMapper.getActSignInTimes(a_id);
        return signMapper.findActivitySign(signInTimes, a_id);
    }

    public void deleteSign(Long s_id, int a_id) {
        signMapper.deleteSign(s_id, a_id);
    }

    public int getActSignInState(int a_id) {
        return signMapper.getActSignInState(a_id);
    }

    public void stuSignIn(int a_id, Long s_id) {
        signMapper.stuSignIn(s_id, a_id);
    }

    public void setPersonState2(Long s_id, int a_id) {
        signMapper.setPersonState2(s_id, a_id);
    }
}
