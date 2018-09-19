package com.test.serviceTest;


import com.google.gson.Gson;
import com.hddk.domain.Teacher;
import com.hddk.service.ITeacherService;
import com.hddk.service.impl.TeacherService;
import com.test.base.BaseControllerTest;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 
 * create by Liujishuai on 2015年9月21日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TeacherServerTest{
	@Autowired
	private TeacherService teacherService;
	@Test
	public void testGetTeacherByT_id(){
		Teacher teacher=teacherService.getTeacherByT_id(1L);
		System.out.println(teacher.getT_name());
	}
}
