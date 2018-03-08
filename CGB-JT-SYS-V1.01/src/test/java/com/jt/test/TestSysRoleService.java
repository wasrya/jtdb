package com.jt.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jt.sys.pojo.SysRole;
import com.jt.sys.service.SysRoleService;


public class TestSysRoleService {
	 ClassPathXmlApplicationContext ctx;
	 @Before
	 public void init(){
		 ctx=new ClassPathXmlApplicationContext(
				 "spring-configs.xml");
	 }
	 @Test
	 public void testSaveObject(){
		 SysRoleService rs=
		 ctx.getBean("sysRoleServiceImpl",
				 SysRoleService.class);
		 SysRole e=new SysRole();
		 e.setName("K");
		 e.setNote("KKKKK");
		 e.setCreatedUser("admin");
		 e.setModifiedUser("admin");
		 int rows=rs.saveObject(e);
		 Assert.assertEquals(1, rows);
	 }
	 @After
	 public void destory(){
		 
	 }
}
