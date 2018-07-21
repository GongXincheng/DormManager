package com.gxc.service;

import com.gxc.entity.TStudent;
import com.gxc.utils.MyResult;
import com.gxc.utils.Page;
import com.gxc.utils.pojo.StuConditionBean;

public interface StudentService {

	/**
	 * 添加学生信息
	 * @param student
	 * @return
	 */
	MyResult addStudent(TStudent student);

	/**
	 * 条件分页查询学生信息
	 * @param page
	 * @param size
	 * @param condiBean
	 * @return
	 */
	Page<TStudent> findStuList(Integer page, Integer size, StuConditionBean condiBean);

	/**
	 * 查询该学号是否存在
	 * @param stuNum
	 * @return
	 */
	MyResult hasStudent(String stuNum);

	/**
	 * 根据学生id查询学生信息
	 * @param stuId
	 * @return
	 */
	MyResult findStudentById(Integer stuId);

	/**
	 * 更新学生信息
	 * @param student
	 * @return
	 */
	MyResult updateStudentInfo(TStudent student);

	/**
	 * 根据学生id删除学生
	 * @param id
	 * @return
	 */
	MyResult deleteStudent(Integer id);

	/**
	 * 根据宿舍楼id，条件分页查询学生列表
	 * @param page
	 * @param size
	 * @param condiBean
	 * @param buildId
	 * @return
	 */
	Page<TStudent> findStuListByDromBuildId(Integer page, Integer size, StuConditionBean condiBean,Integer buildId);

	/**
	 * 根据学号查询学生信息
	 * @param studentnumber
	 * @return
	 */
	TStudent findStudentByStuNum(String studentnumber);


}
