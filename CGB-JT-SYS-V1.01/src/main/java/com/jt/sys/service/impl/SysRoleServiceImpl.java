package com.jt.sys.service.impl;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysRoleDao;
import com.jt.sys.pojo.SysRole;
import com.jt.sys.service.SysRoleService;
@Service
public class SysRoleServiceImpl 
         implements SysRoleService {
	@Autowired
	private SysRoleDao sysRoleDao;
	
	@Override
	public int updateObject(SysRole entity) {
		if(entity==null)
		throw new RuntimeException("更新对象不能为空");
		if(entity.getId()==null)
		throw new RuntimeException("更新对象的id不能为空");
		return sysRoleDao.updateObject(entity);
	}
	
	@Override
	public SysRole findObjectById(Integer id) {
		if(id==null)
		throw new RuntimeException("id is null");
		SysRole role=sysRoleDao.findObjectById(id);
		return role;
	}
	
	
	@Override
	public int saveObject(SysRole entity) {
		//log,transaction
		int rows=sysRoleDao.insertObject(entity);
		//log
		return rows;
	}
	
    @Override
    public int deleteObject(String ids) {
    	//1.验证参数有效性
    	if(ids==null||ids.length()==0)
    	throw new RuntimeException("选中的记录不能为null");
    	//2.对参数数据进行转换
    	String[] checkedIds=ids.split(",");
    	//3.执行删除操作
    	int rows=sysRoleDao.deleteObject(checkedIds);
    	return rows;
    }
	
	@Override
	public List<SysRole> findPageObjects(String name) {
		//log
		List<SysRole> list=
			sysRoleDao.findPageObjects(name);
	    //log
		return list;
	}
	@Override
	public PageObject findPageObjects(
			Integer pageCurrent, 
			String name) {
		//1.获取当前页数据
		//1.1定义每页最多显示3条记录
		int pageSize=3;
		//1.2计算每页查询的起始位置(limit startIndex,pageSize)
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysRole> list=
		sysRoleDao.findPageObjects(name,
				startIndex,//查询的起始位置
				pageSize);
		//2.获取总记录数,计算总页数
		int rowCount=sysRoleDao.getRowCount(name);
		int pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0){
			pageCount++;
		}
		//3.封装数据(封装到pageObject)
		PageObject pageObject=new PageObject();
		pageObject.setRecords(list);
		pageObject.setRowCount(rowCount);
		pageObject.setPageCount(pageCount);
		pageObject.setPageCurrent(pageCurrent);
		return pageObject;//pageObject
	}
	
	
	
	
	
	
}
