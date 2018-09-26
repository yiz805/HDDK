package com.hddk.mapper;

import com.hddk.entity.Field;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FieldMapper {
    //创建新的场地
    @Insert("INSERT INTO field VALUES(#{f_id},#{f_info},#{signUpNumLimit},#{t_name},#{t_tel},#{a_id})")
    @Options(useGeneratedKeys = true, keyProperty = "f_id")
    void newField(Field field);

    //查询活动的场地
    @Select("SELECT * FROM field WHERE activity_id=#{a_id}")
    List<Field> getFieldByA_id(int a_id);

    //删除场地
    @Delete("DELETE FROM field WHERE f_id=#{f_id}")
    void deleteFiled(int f_id);

    //修改场地信息
    @Update("UPDATE field SET f_info=#{f_info},signUpNumLimit=#{signUpNumLimit},t_name=#{t_name},t_tel=#{t_tel}")
    void updateField(Field field);
}
