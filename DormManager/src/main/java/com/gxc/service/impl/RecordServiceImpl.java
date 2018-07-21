package com.gxc.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxc.entity.TRecord;
import com.gxc.entity.TRecordExample;
import com.gxc.entity.TRecordExample.Criteria;
import com.gxc.entity.TStudent;
import com.gxc.mapper.TRecordMapper;
import com.gxc.service.RecordService;
import com.gxc.service.StudentService;
import com.gxc.utils.MyResult;
import com.gxc.utils.Page;
import com.gxc.utils.pojo.RecordConditionBean;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private TRecordMapper recordMapper;
	@Autowired
	private StudentService studentService;

	@Override
	public Page<TRecord> findRecordListByCondition(Integer page, Integer size, RecordConditionBean cdBean) {
		//分页设置
		PageHelper.startPage(page, size);
		//拼装查询条件
		TRecordExample example = new TRecordExample();
		Criteria criteria = example.createCriteria();
		//选了宿舍楼
		if(cdBean.getDormBuildId()!=null){
			criteria.andDormbuildidEqualTo(cdBean.getDormBuildId());
		}
	
		//1、姓名，2、学号，3、寝室
		//注意：此处可能会出现空指针，传来的conditionId可能为null
		if(cdBean.getConditionId() != null && StringUtils.isNotBlank(cdBean.getConditionValue())){
			if(cdBean.getConditionId() == 1){
				criteria.andStudentnameLike("%"+ cdBean.getConditionValue().trim() +"%");
			}
			if(cdBean.getConditionId() == 2){
				criteria.andStudentnumberLike("%"+ cdBean.getConditionValue().trim() +"%");
			}
			if(cdBean.getConditionId() == 3){
				criteria.andDormnameLike("%"+ cdBean.getConditionValue().trim() +"%");
			}
		}
		//日期判断，如果开始不为空，结束为空
		if(cdBean.getStartDate()!=null && cdBean.getEndDate()==null){
			criteria.andDateBetween(cdBean.getStartDate(), new Date());
		}
		//日期都不为空
		if(cdBean.getStartDate()!=null && cdBean.getEndDate()!=null){
			criteria.andDateBetween(cdBean.getStartDate(), cdBean.getEndDate());
		}
		if(cdBean.getStudentNumber()!=null){
			criteria.andStudentnumberEqualTo(cdBean.getStudentNumber());
		}
		//查询缺勤列表
		List<TRecord> list = this.recordMapper.selectByExample(example);
		PageInfo<TRecord> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		//创建Page对象
		Page<TRecord> pageBean = new Page<>();
		pageBean.setPage(page);
		pageBean.setTotal((int) total);
		pageBean.setSize(size);
		pageBean.setRows(list);
		return pageBean;
	}

	/**
	 * 删除
	 */
	@Override
	public MyResult deleteRecordById(Integer id) {
		int i = this.recordMapper.deleteByPrimaryKey(id);
		if(i>0){
			return MyResult.build(200, "记录删除成功！");
		}
		return MyResult.build(201, "网络连接失败！");
	}

	/**
	 * 添加缺勤记录
	 */
	@Override
	public MyResult addRecord(TRecord record) {
		if(StringUtils.isBlank(record.getStudentnumber())){
			return MyResult.build(201, "请输入学号！");
		}
		//根据学号查询学生信息
		TStudent dbStudent = studentService.findStudentByStuNum(record.getStudentnumber());
		if(dbStudent == null){	//判断学号是否存在
			return MyResult.build(201, "该学号学生不存在!");
		}
		//完善TRecord对象的信息
		record.setStudentname(dbStudent.getName());
		record.setDormbuildid(dbStudent.getDormbuildid());
		record.setDormname(dbStudent.getDormname());
		//添加到数据库
		int i = this.recordMapper.insertSelective(record);
		if(i>0){
			return MyResult.build(200, "记录添加成功！");
		}
		return MyResult.build(201, "网络连接失败！");
	}
	
}
