package com.gxc.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxc.entity.TAdmin;
import com.gxc.entity.TAdminExample;
import com.gxc.entity.TDormmanager;
import com.gxc.entity.TDormmanagerExample;
import com.gxc.entity.TStudent;
import com.gxc.entity.TStudentExample;
import com.gxc.mapper.TAdminMapper;
import com.gxc.mapper.TDormmanagerMapper;
import com.gxc.mapper.TStudentMapper;
import com.gxc.service.LoginService;
import com.gxc.utils.MyResult;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private TAdminMapper adminMapper;
	@Autowired
	private TDormmanagerMapper dormManagerMapper;
	@Autowired
	private TStudentMapper studentMapper;
	
	/**
	 * 根据role，判断是哪个用户类型登录
	 * role：1:系统管理员，2:宿舍管理员，3:学生
	 */
	@Override
	public MyResult login(String username, String password, int role) {
		//如果是系统管理员登录
		if(role==1){
			TAdminExample example = new TAdminExample();
			example.createCriteria().andUsernameEqualTo(username);
			List<TAdmin> adminList = adminMapper.selectByExample(example);
			if(adminList == null || adminList.size()==0){
				return MyResult.build(201, "用户名或密码错误！");
			}
			TAdmin admin = adminList.get(0);
			if(!admin.getPassword().equals(password)){
				return MyResult.build(201, "用户名或密码错误！");
			}
			//登录成功
			return MyResult.build(200, "admin/index.html", admin);
		}
		
		//如果是宿舍管理员登录
		else if(role==2){
			TDormmanagerExample example = new TDormmanagerExample();
			example.createCriteria().andUsernameEqualTo(username);
			List<TDormmanager> dormList = dormManagerMapper.selectByExample(example);
			if(dormList == null || dormList.size()==0){
				return MyResult.build(201, "用户名或密码错误！");
			}
			TDormmanager dormManager = dormList.get(0);
			if(!dormManager.getPassword().equals(password)){
				return MyResult.build(201, "用户名或密码错误！");
			}
			//登录成功
			return MyResult.build(200, "dorm/index.html", dormManager);
		}
		
		//学生登录
		else{
			TStudentExample example = new TStudentExample();
			example.createCriteria().andStunumEqualTo(username);
			List<TStudent> stuList = studentMapper.selectByExample(example);
			if(stuList == null || stuList.size()==0){
				return MyResult.build(201, "用户名或密码错误！");
			}
			TStudent student = stuList.get(0);
			if(!student.getPassword().equals(password)){
				return MyResult.build(201, "用户名或密码错误！");
			}
			//登录成功
			return MyResult.build(200, "stu/index.html", student);
		}
	}

	/**
	 * 更新密码(超管)
	 */
	@Override
	public MyResult updatePassword(String oldPassword, String newPassword, TAdmin admin) {
		if(StringUtils.isBlank(oldPassword) || StringUtils.isBlank(newPassword)){
			return MyResult.build(201, "网络连接失败！");
		}
		//首先从数据库中查询出登录用户名的admin信息
		TAdminExample example = new TAdminExample();
		example.createCriteria().andUsernameEqualTo(admin.getUsername());
		List<TAdmin> list = this.adminMapper.selectByExample(example);
		if(list == null || list.size() == 0){
			return MyResult.build(201, "网络连接失败！");
		}
		//获取数据库的admin信息
		TAdmin dbAdmin = list.get(0);
		if(!dbAdmin.getPassword().equals(oldPassword)){
			return MyResult.build(201, "原密码错误！");
		}
		//设置新的密码
		dbAdmin.setPassword(newPassword);
		//数据库更新admin信息
		int i = adminMapper.updateByPrimaryKeySelective(dbAdmin);
		if(i>0){
			return MyResult.build(200, "密码更新成功，请重新登录!");
		}
		return MyResult.build(201, "网络连接失败！");
	}

	/**
	 * 宿管
	 */
	@Override
	public MyResult updatePassword(String oldPassword, String newPassword, TDormmanager dormManager) {
		if(StringUtils.isBlank(oldPassword) || StringUtils.isBlank(newPassword)){
			return MyResult.build(201, "网络连接失败！");
		}
		//首先从数据库中查询出登录用户名的dormManager信息
		TDormmanagerExample example = new TDormmanagerExample();
		example.createCriteria().andUsernameEqualTo(dormManager.getUsername());
		List<TDormmanager> list = this.dormManagerMapper.selectByExample(example);
		if(list == null || list.size() == 0){
			return MyResult.build(201, "网络连接失败！");
		}
		//获取数据库的admin信息
		TDormmanager dbDormManager = list.get(0);
		if(!dbDormManager.getPassword().equals(oldPassword)){
			return MyResult.build(201, "原密码错误！");
		}
		//设置新的密码
		dbDormManager.setPassword(newPassword);
		//数据库更新admin信息
		int i = this.dormManagerMapper.updateByPrimaryKeySelective(dbDormManager);
		if(i>0){
			return MyResult.build(200, "密码更新成功，请重新登录!");
		}
		return MyResult.build(201, "网络连接失败！");
	}

	/**
	 * 更新密码(学生)
	 */
	@Override
	public MyResult updatePassword(String oldPassword, String newPassword, TStudent student) {
		if(StringUtils.isBlank(oldPassword) || StringUtils.isBlank(newPassword)){
			return MyResult.build(201, "网络连接失败！");
		}
		//首先从数据库中查询出登录用户名的student信息
		TStudentExample example = new TStudentExample();
		example.createCriteria().andStunumEqualTo(student.getStunum());
		List<TStudent> list = this.studentMapper.selectByExample(example);
		
		if(list == null || list.size() == 0){
			return MyResult.build(201, "网络连接失败！");
		}
		//获取数据库的admin信息
		TStudent dbStudent = list.get(0);
		if(!dbStudent.getPassword().equals(oldPassword)){
			return MyResult.build(201, "原密码错误！");
		}
		//设置新的密码
		dbStudent.setPassword(newPassword);
		//数据库更新admin信息
		int i = this.studentMapper.updateByPrimaryKeySelective(dbStudent);
		if(i>0){
			return MyResult.build(200, "密码更新成功，请重新登录!");
		}
		return MyResult.build(201, "网络连接失败！");
	}

}
