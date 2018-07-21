package com.gxc.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxc.entity.TDormbuild;
import com.gxc.entity.TDormbuildExample;
import com.gxc.mapper.TDormbuildMapper;
import com.gxc.service.DormBuildService;
import com.gxc.utils.MyResult;
import com.gxc.utils.Page;

@Service
public class DormBuildServiceImpl implements DormBuildService {

	@Autowired
	private TDormbuildMapper dormBuildMapper;
	
	/**
	 * 判断是否已经存在
	 */
	@Override
	public MyResult findDormBuildByName(String dormBuildName) {
		
		TDormbuildExample example = new TDormbuildExample();
		example.createCriteria().andDormbuildnameEqualTo(dormBuildName);
		List<TDormbuild> list = dormBuildMapper.selectByExample(example);
		if(list.size()>0){
			return MyResult.build(201, "该宿舍楼已经存在！");
		}
		return MyResult.build(200, "成功");
	}

	/**
	 * 添加宿舍楼
	 */
	@Override
	public MyResult insertDormBuild(TDormbuild dormBuild) {
		int i = this.dormBuildMapper.insertSelective(dormBuild);
		if(i>0){
			return MyResult.build(200, "宿舍楼添加成功！");
		}
		return MyResult.build(201, "网络连接失败！");
	}

	/**
	 * 分页，条件查询列表
	 */
	@Override
	public Page<TDormbuild> findDormBuildList(Integer page, Integer size, String condition) {
		//设置分页
		PageHelper.startPage(page, size);
		TDormbuildExample example = new TDormbuildExample();
		//添加查询条件
		if(StringUtils.isNotBlank(condition)){
			example.createCriteria().andDormbuildnameLike("%"+condition+"%");
		}
		//查询
		List<TDormbuild> list = this.dormBuildMapper.selectByExample(example);
		//获取总条数
		PageInfo<TDormbuild> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		//封装对象数据到Page中
		Page<TDormbuild> pageBean = new Page<>();
		pageBean.setPage(page);
		pageBean.setSize(size);
		pageBean.setTotal((int) total);
		pageBean.setRows(list);
		return pageBean;
	}

	/**
	 * 根据宿舍楼id查询宿舍楼信息
	 */
	@Override
	public MyResult findDormBuildById(Integer dormBuildId) {
		TDormbuild dormBuild = this.dormBuildMapper.selectByPrimaryKey(dormBuildId);
		if(dormBuild!=null){
			return MyResult.build(200, "成功",dormBuild);
		}
		return MyResult.build(201, "网络连接失败！",null);
	}

	/**
	 * 更新宿舍楼信息
	 */
	@Override
	public MyResult updateDormBuild(TDormbuild dormBuild) {
		int i = this.dormBuildMapper.updateByPrimaryKeySelective(dormBuild);
		if(i>0){
			return MyResult.build(200, "宿舍楼信息更新成功！");
		}
		return MyResult.build(201, "网络连接失败！");
	}

	/**
	 * 删除
	 */
	@Override
	public MyResult deleteDormBuildById(Integer id) {
		int i = this.dormBuildMapper.deleteByPrimaryKey(id);
		if(i>0){
			return MyResult.build(200, "宿舍楼删除成功！");
		}
		return MyResult.build(201, "网络连接失败！");
	}

	/**
	 * 查询所有宿舍楼
	 */
	@Override
	public List<TDormbuild> findAllDormBuild() {
		TDormbuildExample example = new TDormbuildExample();
		List<TDormbuild> list = this.dormBuildMapper.selectByExample(example);
		return list;
	}
	
}
