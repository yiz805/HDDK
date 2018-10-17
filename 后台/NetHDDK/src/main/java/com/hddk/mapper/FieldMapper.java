package com.hddk.mapper;

import com.hddk.entity.Field;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FieldMapper {
    //创建新的场地(改SQL片段拼接)
    //@Insert("INSERT INTO field VALUES(#{f_id},#{f_info},#{signUpNumLimit},#{t_name},#{t_tel},#{activity_id})")
    @InsertProvider(type = SqlProvider.class, method = "INSERT_Field")
    @Options(useGeneratedKeys = true, keyProperty = "f_id")
    void newField(Field field);

    //查询活动的场地
    @Select("SELECT * FROM field WHERE activity_id=#{a_id}")
    List<Field> getFieldByA_id(int a_id);

    //删除场地
    @Delete("DELETE FROM field WHERE f_id=#{f_id}")
    void deleteFiled(int f_id);

    //修改场地信息(改SQL片段拼接)
    //@Update("UPDATE field SET f_info=#{f_info},signUpNumLimit=#{signUpNumLimit},t_name=#{t_name},t_tel=#{t_tel}")
    @UpdateProvider(type = SqlProvider.class, method = "UPDATE_Field")
    void updateField(Field field);

    //通过id查场地
    @Select("SELECT * FROM field WHERE f_id=#{f_id}")
    Field getFieldByF_id(int f_id);

    //删除活动的场地
    @Delete("DELETE FROM field WHERE activity_id=#{a_id}")
    void deleteActField(int a_id);
}
