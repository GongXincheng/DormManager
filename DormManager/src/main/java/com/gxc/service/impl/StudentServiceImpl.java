package com.gxc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxc.entity.TStudent;
import com.gxc.entity.TStudentExample;
import com.gxc.entity.TStudentExample.Criteria;
import com.gxc.mapper.TStudentMapper;
import com.gxc.service.StudentService;
import com.gxc.utils.MyResult;
import com.gxc.utils.Page;
import com.gxc.utils.pojo.StuConditionBean;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private TStudentMapper studentMapper;
	
	/**
	 * 添加学生信息
	 */
	@Override
	public MyResult addStudent(TStudent student) {
		int i = studentMapper.insertSelective(student);
		if(i>0){
			return MyResult.build(200, "学生添加成功！");
		}
		return MyResult.build(201, "网络连接失败！");
	}

	/**
	 * 条件分页查询学生信息
	 */
	@Override
	public Page<TStudent> findStuList(Integer page, Integer size, StuConditionBean condiBean) {
		//分页
		PageHelper.startPage(page, size);
		TStudentExample example = new TStudentExample();
		Criteria criteria = example.createCriteria();
		//如果选择了宿舍楼
		if(condiBean.getCon_dormBuildid() != null){
			criteria.andDormbuildidEqualTo(condiBean.getCon_dormBuildid());
		}
		
		if(condiBean.getCon_chooseId()!=null){
			//1：如果按照姓名查询，并且vaule不为空
			if(condiBean.getCon_chooseId()==1 && StringUtils.isNotBlank(condiBean.getCon_value())){
				criteria.andNameLike("%"+condiBean.getCon_value()+"%");
			}
			//2：如果按照姓名学号，并且vaule不为空
			if(condiBean.getCon_chooseId()==2 && StringUtils.isNotBlank(condiBean.getCon_value())){
				criteria.andStunumLike("%"+condiBean.getCon_value()+"%");
			}
			//3：如果按照姓名查询，并且vaule不为空
			if(condiBean.getCon_chooseId()==3 && StringUtils.isNotBlank(condiBean.getCon_value())){
				criteria.andDormnameLike("%"+condiBean.getCon_value()+"%");
			}
		}
		
		//数据库查询
		List<TStudent> list = this.studentMapper.selectByExample(example);
		//获取总记录数
		PageInfo<TStudent> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		//创建Page对象
		Page<TStudent> pageBean = new Page<>();
		pageBean.setPage(page);
		pageBean.setSize(size);
		pageBean.setRows(list);
		pageBean.setTotal((int) total);
		return pageBean;
	}

	/**
	 * 查询该学号是否存在
	 */
	@Override
	public MyResult hasStudent(String stuNum) {
		TStudentExample example = new TStudentExample();
		example.createCriteria().andStunumEqualTo(stuNum);
		List<TStudent> list = this.studentMapper.selectByExample(example);
		if(list.size()>0){
			return MyResult.build(201, "该学号已经存在！");
		}
		return MyResult.build(200, "学号可用！");
	}

	/**
	 * 根据学生id查询学生信息
	 */
	@Override
	public MyResult findStudentById(Integer stuId) {
		TStudent student = this.studentMapper.selectByPrimaryKey(stuId);
		if(student==null){
			return MyResult.build(201, "网络连接失败");
		}
		return MyResult.build(200, "成功", student);
	}

	/**
	 * 更新学生信息
	 */
	@Override
	public MyResult updateStudentInfo(TStudent student) {
		int i = this.studentMapper.updateByPrimaryKeySelective(student);
		if(i>0){
			return MyResult.build(200, "学生信息更新成功！");
		}
		return MyResult.build(201, "网络连接失败！");
	}

	/**
	 * 根据学生id删除学生
	 */
	@Override
	public MyResult deleteStudent(Integer id) {
		int i = this.studentMapper.deleteByPrimaryKey(id);
		if(i>0){
			return MyResult.build(200, "学生删除成功！");
		}
		return MyResult.build(201, "网络连接失败！");
	}

	/**
	 * 根据宿舍楼id，条件分页查询学生列表
	 */
	@Override
	public Page<TStudent> findStuListByDromBuildId(Integer page, Integer size, 
						StuConditionBean condiBean, Integer buildId) {
		//如果管理员的buildId为null，会产生NullPointer
		if(buildId == null){
			Page<TStudent> pageBean = new Page<>();
			pageBean.setPage(page);
			pageBean.setRows(new ArrayList<TStudent>());
			pageBean.setSize(size);
			pageBean.setTotal(0);
			return pageBean;
		}
		//分页设置
		PageHelper.startPage(page, size);
		//拼接查询条件
		TStudentExample example = new TStudentExample();
		Criteria criteria = example.createCriteria();
		//先判断 StuConditionBean对象的 con_value属性是否为空，如果不为null
		if(StringUtils.isNotBlank(condiBean.getCon_value())){
			//1：如果按照姓名查询，并且vaule不为空
			if(condiBean.getCon_chooseId()==1){
				criteria.andNameLike("%"+condiBean.getCon_value().trim()+"%");
			}
			//2：如果按照姓名学号，并且vaule不为空
			if(condiBean.getCon_chooseId()==2){
				criteria.andStunumLike("%"+condiBean.getCon_value().trim()+"%");
			}
			//3：如果按照姓名查询，并且vaule不为空
			if(condiBean.getCon_chooseId()==3){
				criteria.andDormnameLike("%"+condiBean.getCon_value().trim()+"%");
			}
		}
		
		//根据宿舍楼id
		criteria.andDormbuildidEqualTo(buildId);
		//查询数据库
		List<TStudent> list = this.studentMapper.selectByExample(example);
		PageInfo<TStudent> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		//创建Page对象
		Page<TStudent> pageBean = new Page<>();
		pageBean.setPage(page);
		pageBean.setRows(list);
		pageBean.setSize(size);
		pageBean.setTotal((int) total);
		return pageBean;
	}

	/**
	 * 根据学号查询学生信息
	 */
	@Override
	public TStudent findStudentByStuNum(String studentnumber) {
		TStudentExample example = new TStudentExample();
		example.createCriteria().andStunumEqualTo(studentnumber);
		List<TStudent> list = this.studentMapper.selectByExample(example);
		if(list==null || list.size()==0){
			return null;
		}
		return list.get(0);
	}


}
