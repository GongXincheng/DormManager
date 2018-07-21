package com.gxc.service;

import com.gxc.entity.TAdmin;
import com.gxc.entity.TDormmanager;
import com.gxc.entity.TStudent;
import com.gxc.utils.MyResult;

public interface LoginService {

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @param role
	 * @return
	 */
	MyResult login(String username, String password, int role);

	/**
	 * 更新密码(超级管理员)
	 * @param oldPassword
	 * @param newPassword
	 * @param admin
	 * @return
	 */
	MyResult updatePassword(String oldPassword, String newPassword, TAdmin admin);

	/**
	 * 更新密码(宿舍管理员)
	 * @param oldPassword
	 * @param newPassword
	 * @param dormManager
	 * @return
	 */
	MyResult updatePassword(String oldPassword, String newPassword, TDormmanager dormManager);

	/**
	 * 更新密码(学生)
	 * @param oldPassword
	 * @param newPassword
	 * @param student
	 * @return
	 */
	MyResult updatePassword(String oldPassword, String newPassword, TStudent student);

}
