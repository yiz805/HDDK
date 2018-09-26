package com.hddk.mapper;

import com.hddk.entity.Sign;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

public interface SignMapper {
    //学生报名,signState='0'
    @Insert("INSERT INTO sign(id,signState,signTime,personState,activity_id,student_id)"
            + "VALUES(#{id},0,#{signTime},#{personState},#{activity_id},#{student_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void studentSignUp(Sign signUp);

    //将学生设为'签到负责人',personState='1'
    @Update("UPDATE sign SET personState='1' WHERE student_id=#{s_id}")
    void setPersonSate(Long s_id);


}
