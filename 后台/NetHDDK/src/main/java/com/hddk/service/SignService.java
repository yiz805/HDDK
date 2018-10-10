package com.hddk.service;

import com.hddk.entity.Sign;

import java.util.List;

public interface SignService {

    void studentSignUp(Long s_id, int f_id, int a_id);

    void setPersonSate(Long s_id, int a_id);

    int findPersonState(Long s_id, int a_id);

    void startSignIn(int a_id, Long s_id);

    void endSignIn(int a_id);

    List<Sign> findActivitySign(int a_id);

    void deleteSign(Long s_id, int a_id);
}
