package com.gxc.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxc.entity.TDormmanager;
import com.gxc.entity.TDormmanagerExample;
import com.gxc.mapper.TDormmanagerMapper;
import com.gxc.service.DormManagerService;
import com.gxc.utils.MyResult;
import com.gxc.utils.Page;

@Service
public class DormManagerServiceImpl implements DormManagerService {

	@Autowired
	private TDormmanagerMapper dormManagerMapper;
	
	/**
	 * conditionId：1:姓名查询，2:用户名查询
	 */
	@Override
	public Page<TDormmanager> findDormMngList(Integer conditionId, String conditionValue,
			Integer page, Integer size) {
		
		//分页
		PageHelper.startPage(page, size);
		
		TDormmanagerExample example = new TDormmanagerExample();
		//如果conditionValue为null，查询全部
		if(StringUtils.isBlank(conditionValue)){
		}
		//如果conditionValue不为null判断是按照什么条件查询
		//如果按照姓名查询(模糊)
		else if(conditionId==1){
			example.createCriteria().andNameLike("%"+conditionValue+"%");
		}
		//如果用户名查询
		else{
			example.createCriteria().andUsernameLike("%"+conditionValue+"%");
		}
		//从数据库获取列表
		List<TDormmanager> list = dormManagerMapper.selectByExample(example);
		
		//获取总记录数
		PageInfo<TDormmanager> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		
		//创建Page对象，封装数据
		Page<TDormmanager> pageBean = new Page<>();
		pageBean.setTotal((int) total);
		pageBean.setRows(list);
		pageBean.setSize(size);
		pageBean.setPage(page);
		
		return pageBean;
	}

	/**
	 * 根据宿舍管理员id查询信息
	 */
	@Override
	public MyResult findDormMsgById(Integer id) {
		TDormmanager dormManager = this.dormManagerMapper.selectByPrimaryKey(id);
		return MyResult.build(200, "", dormManager);
	}

	/**
	 * 更新宿舍管理员信息
	 */
	@Override
	public MyResult updateDormMsg(TDormmanager dormManager) {
		int i = this.dormManagerMapper.updateByPrimaryKeySelective(dormManager);
		if(i>0){
			return MyResult.build(200, "更新成功!");
		}
		return MyResult.build(201, "网络连接失败！");
	}

	/**
	 * 删除宿舍管理员
	 */
	@Override
	public MyResult deleteDormById(Integer dormId) {
		int i = this.dormManagerMapper.deleteByPrimaryKey(dormId);
		if(i>0){
			return MyResult.build(200, "删除成功!");
		}
		return MyResult.build(201, "网络连接失败！");
	}

	/**
	 * 添加宿舍管理员
	 */
	@Override
	public MyResult addDormMng(TDormmanager dormManager) {
		int i = this.dormManagerMapper.insertSelective(dormManager);
		if(i>0){
			return MyResult.build(200, "添加成功!");
		}
		return MyResult.build(201, "网络连接失败！");
	}

	/**
	 * 判断用户名是否存在
	 */
	@Override
	public MyResult findDormMsgByUsername(String username) {
		TDormmanagerExample example = new TDormmanagerExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<TDormmanager> list = this.dormManagerMapper.selectByExample(example);
		if(list.size() > 0){
			return MyResult.build(201, "该用户名已存在！");
		}
		return MyResult.build(200, "成功");
	}

	/**
	 * 根据宿舍楼id查询宿舍管理员列表
	 */
	@Override
	public List<TDormmanager> findDormMngByDornBuildId(Integer dormBuildId) {
		TDormmanagerExample example = new TDormmanagerExample();
		example.createCriteria().andBordbuildidEqualTo(dormBuildId);
		List<TDormmanager> list = this.dormManagerMapper.selectByExample(example);
		return list;
	}

	/**
	 * 查询 bordBuildId为null的宿舍管理员
	 */
	@Override
	public List<TDormmanager> findDormMngByDornBuildIdIsNull() {
		TDormmanagerExample example = new TDormmanagerExample();
		example.createCriteria().andBordbuildidIsNull();
		List<TDormmanager> list = this.dormManagerMapper.selectByExample(example);
		return list;
	}

	@Override
	public MyResult deleteMngFromDormBuild(Integer id) {
		TDormmanager dormManager = this.dormManagerMapper.selectByPrimaryKey(id);
		dormManager.setBordbuildid(null);
		int i = dormManagerMapper.updateByPrimaryKey(dormManager);
		if(i > 0){
			return MyResult.build(200, "删除成功！");
		}
		return MyResult.build(201, "网络连接失败！");
	}

	/**
	 * 为宿舍楼添加管理员
	 */
	@Override
	public void addMngForDormBuild(Integer bordbuildid, Integer dormmanid) {
		//为宿舍楼添加管理员,更新宿舍管理员的bordbuildid字段
		TDormmanager dormManager = this.dormManagerMapper.selectByPrimaryKey(dormmanid);
		dormManager.setBordbuildid(bordbuildid);
		this.dormManagerMapper.updateByPrimaryKeySelective(dormManager);
	}

}
