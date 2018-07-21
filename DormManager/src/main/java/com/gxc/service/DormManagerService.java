package com.gxc.service;

import java.util.List;

import com.gxc.entity.TDormmanager;
import com.gxc.utils.MyResult;
import com.gxc.utils.Page;

public interface DormManagerService {

	/**
	 * 分页条件查询
	 * @param conditionId	
	 * @param conditionValue
	 * @param page
	 * @param size
	 * @return
	 */
	Page<TDormmanager> findDormMngList(Integer conditionId, String conditionValue, Integer page, Integer size);

	/**
	 * 根据宿舍管理员id查询信息
	 * @param id
	 * @return
	 */
	MyResult findDormMsgById(Integer id);

	/**
	 * 更新宿舍管理员信息
	 * @param dormManager
	 * @return
	 */
	MyResult updateDormMsg(TDormmanager dormManager);

	/**
	 * 删除宿舍管理员
	 * @param dormId
	 * @return
	 */
	MyResult deleteDormById(Integer dormId);

	/**
	 * 添加宿舍管理员
	 * @param dormManager
	 * @return
	 */
	MyResult addDormMng(TDormmanager dormManager);

	/**
	 * 判断用户名是否存在
	 * @param username
	 * @return
	 */
	MyResult findDormMsgByUsername(String username);

	/**
	 * 根据宿舍楼id查询宿舍管理员列表
	 * @param dormBuildId
	 * @return
	 */
	List<TDormmanager> findDormMngByDornBuildId(Integer dormBuildId);

	/**
	 * 查询 bordBuildId为null的宿舍管理员
	 * @return
	 */
	List<TDormmanager> findDormMngByDornBuildIdIsNull();

	/**
	 * 取消宿舍管理员所管理的宿舍楼
	 * @param id
	 * @return
	 */
	MyResult deleteMngFromDormBuild(Integer id);

	/**
	 * 为宿舍楼添加管理员
	 * @param bordbuildid
	 * @param dormmanid
	 */
	void addMngForDormBuild(Integer bordbuildid, Integer dormmanid);

}
