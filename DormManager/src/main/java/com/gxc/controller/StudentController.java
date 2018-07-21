package com.gxc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxc.entity.TDormbuild;
import com.gxc.entity.TDormmanager;
import com.gxc.entity.TStudent;
import com.gxc.service.DormBuildService;
import com.gxc.service.StudentService;
import com.gxc.utils.MyResult;
import com.gxc.utils.Page;
import com.gxc.utils.pojo.AddRecordUI;
import com.gxc.utils.pojo.StuConditionBean;

@Controller
public class StudentController {
	
	@Autowired
	private DormBuildService buildService;
	@Autowired
	private StudentService studentService;
	
	/**
	 * 查询学生列表
	 * @param page
	 * @param size
	 * @param model
	 * @param condiBean
	 * @return
	 */
	@RequestMapping("/admin/studentList")
	public String studentList(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="12")Integer size, Model model, StuConditionBean condiBean){
		
		//先查询出所有的宿舍楼
		List<TDormbuild> list = buildService.findAllDormBuild();
		model.addAttribute("dormBuildList", list);
		
		//条件分页查询学生信息
		Page<TStudent> pageBean = this.studentService.findStuList(page,size,condiBean);
		model.addAttribute("page", pageBean);
		//条件数据回显
		model.addAttribute("condition", condiBean);
		return "admin/studentManager";
	}
	
	/**
	 * 添加学生信息
	 * @param student
	 * @return
	 */
	@RequestMapping("/admin/addStudent")
	@ResponseBody
	public MyResult addStudent(TStudent student){
		MyResult result = studentService.addStudent(student);
		return result;
	}
	
	/**
	 * 查询该学号是否存在
	 * @param stuNum
	 * @return
	 */
	@RequestMapping("/admin/hasStudent")
	@ResponseBody
	public MyResult hasStudent(String stuNum){
		MyResult result = studentService.hasStudent(stuNum);
		return result;
	}
	
	/**
	 * 根据学生id查询学生信息
	 * @param stuId
	 * @return
	 */
	@RequestMapping("/admin/findStudent")
	@ResponseBody
	public MyResult findStudent(Integer stuId){
		MyResult result = studentService.findStudentById(stuId);
		return result;
	}
	
	/**
	 * 更新学生信息
	 * @param student
	 * @return
	 */
	@RequestMapping("/admin/updateStudent")
	@ResponseBody
	public MyResult updateStudent(TStudent student){
		MyResult result = studentService.updateStudentInfo(student);
		return result;
	}
	
	/**
	 * 根据学生id删除学生
	 * @param id
	 * @return
	 */
	@RequestMapping("/admin/deleteStudent/{id}")
	@ResponseBody
	public MyResult deleteStudent(@PathVariable Integer id){
		MyResult result = studentService.deleteStudent(id);
		return result;
	}
	
	/**
	 * 根据宿舍楼id，条件分页查询学生列表
	 * @param page
	 * @param size
	 * @param request
	 * @param model
	 * @param condiBean
	 * @return
	 */
	@RequestMapping("/dorm/allStuList")
	public String findStudentByDromBId(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="10")Integer size, HttpServletRequest request,
			Model model, StuConditionBean condiBean){
		
		//从session中获取登录的宿舍管理员
		TDormmanager dormManager = (TDormmanager)request.getSession().getAttribute("loginUser");
		//查询该管理员所在宿舍楼的学生列表
		Page<TStudent> pageBean = this.studentService.findStuListByDromBuildId(page,size,condiBean,dormManager.getBordbuildid());
		
		//将数据放入model中(学生列表，数据回显，宿舍楼名称)
		model.addAttribute("page", pageBean);
		model.addAttribute("condiBean", condiBean);
		
		//TODO 根据宿舍楼id查询宿舍楼名称
		//获取当前 DormbuildId的宿舍楼名称
		MyResult myResult = buildService.findDormBuildById(dormManager.getBordbuildid());
		TDormbuild dormBuild = (TDormbuild)myResult.getData();
		if(dormBuild != null){
			model.addAttribute("buildName", dormBuild.getDormbuildname());
		}else{
			model.addAttribute("buildName", null);
		}
		return "dorm/studentManager";
	}
	
	/**
	 * 添加前UI
	 * @param studentId
	 * @return
	 */
	@RequestMapping("/dorm/addRecordUI")
	@ResponseBody
	public MyResult addRecordUI(Integer studentId){
		//创建实体类对象
		AddRecordUI addRecordUI = new AddRecordUI();
		if(studentId==null){
			addRecordUI.setStuNum(null);
			addRecordUI.setNowDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			return MyResult.build(200, "OK", addRecordUI);
		}
		//数据库获取学生信息
		MyResult result = this.studentService.findStudentById(studentId);
		TStudent dbStudent = (TStudent)result.getData();
		//添加数据
		addRecordUI.setStuNum(dbStudent.getStunum());
		addRecordUI.setNowDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		result.setData(addRecordUI);
		return result;
	}

}
