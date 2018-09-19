package com.hddk.mapper;

import com.hddk.domain.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    //通过教师的id查询
    @Select("SELECT * FROM teacher WHERE t_id=#{t_id}")
    Teacher getTeacherByT_id(Long t_id);

    //查询所有教师信息
    List<Teacher> getAllTeacher();
}
