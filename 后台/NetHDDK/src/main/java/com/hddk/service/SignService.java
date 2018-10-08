package com.hddk.service;

import com.hddk.entity.Sign;

import java.util.List;

public interface SignService {

    void studentSignUp(Sign signUp);

    void setPersonSate(Long s_id, int a_id);

    boolean isPerson(Long s_id);

    void startSignIn(int a_id,Long s_id);

    void endSignIn(int a_id);

    List<Sign> findActivitySign(int a_id);
}
