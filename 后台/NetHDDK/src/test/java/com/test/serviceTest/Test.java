package com.test.serviceTest;
import com.hddk.domain.Teacher;
import com.hddk.mapper.TeacherMapper;
import com.test.util.DBTool;
import org.apache.ibatis.session.SqlSession;
public class Test {
    public static void main(String args[]){
        testGetTeacherByT_id();
    }

    public static void testGetTeacherByT_id(){
        SqlSession session = DBTool.getSession();
        TeacherMapper mapper=session.getMapper(TeacherMapper.class);
        try{
            Teacher teacher=mapper.getTeacherByT_id(1L);
            System.out.println(teacher.getT_name());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
