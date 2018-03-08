package com.jt.sys.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.PageObject;
import com.jt.sys.pojo.SysRole;
import com.jt.sys.service.SysRoleService;
@RequestMapping("/role/")
@Controller
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;
	@RequestMapping("listUI")
	public String listUI(){
		return "sys/role_list";
	}
	@RequestMapping("editUI")
	public String editUI(){
		return "sys/role_edit";
	}
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public String doUpdateObject(SysRole entity){
		sysRoleService.updateObject(entity);
		return "update ok";
	}
	
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public SysRole doFindObjectById(Integer id){   
		return sysRoleService.findObjectById(id);
	}

	@RequestMapping("doSaveObject")
	@ResponseBody
	public String doSaveObject(SysRole entity){
		sysRoleService.saveObject(entity);
		return "save ok";
	}
	
	@RequestMapping("doDeleteObject.do")
	@ResponseBody
	public String doDeleteObject(String checkedIds){
		System.out.println("checkedIds="+checkedIds);
		sysRoleService.deleteObject(checkedIds);
		return "delete ok";
	}//controller-->service-->dao
	//表示层(view,controller)/业务层(service)/数据层(dao)
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public PageObject doFindPageObjects(
			Integer pageCurrent,String name){
		System.out.println("name="+name);
		//List<SysRole> list=
		//sysRoleService.findPageObjects(name);
		PageObject pageObject=
		sysRoleService.
		findPageObjects(pageCurrent, name);
		return pageObject;
	}//{pageCount:10,.....,records:[{id:1,name:'A',..},{}]}
}




