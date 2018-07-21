package com.gxc.service;

import java.util.List;

import com.gxc.entity.TDormbuild;
import com.gxc.utils.MyResult;
import com.gxc.utils.Page;

public interface DormBuildService {

	/**
	 * 判断该宿舍楼是否存在
	 * @param dormBuildName
	 * @return
	 */
	MyResult findDormBuildByName(String dormBuildName);

	/**
	 * 添加宿舍楼
	 * @param dormBuild
	 * @return
	 */
	MyResult insertDormBuild(TDormbuild dormBuild);

	/**
	 * 查询宿舍楼列表
	 * @param page
	 * @param size
	 * @param condition
	 * @return
	 */
	Page<TDormbuild> findDormBuildList(Integer page, Integer size, String condition);

	/**
	 * 根据宿舍楼id查询宿舍楼信息
	 * @param dormBuildId
	 * @return
	 */
	MyResult findDormBuildById(Integer dormBuildId);

	/**
	 * 更新宿舍楼信息
	 * @param dormBuild
	 * @return
	 */
	MyResult updateDormBuild(TDormbuild dormBuild);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	MyResult deleteDormBuildById(Integer id);

	/**
	 * 查询所有宿舍楼
	 * @return
	 */
	List<TDormbuild> findAllDormBuild();

}
