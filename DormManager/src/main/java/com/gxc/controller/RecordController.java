package com.gxc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxc.entity.TDormbuild;
import com.gxc.entity.TDormmanager;
import com.gxc.entity.TRecord;
import com.gxc.entity.TStudent;
import com.gxc.service.DormBuildService;
import com.gxc.service.RecordService;
import com.gxc.utils.CheckDateUtil;
import com.gxc.utils.MyResult;
import com.gxc.utils.Page;
import com.gxc.utils.pojo.RecordConditionBean;

@Controller
public class RecordController {

	@Autowired
	private DormBuildService dormBuildService;
	@Autowired
	private RecordService recordService;
	@Autowired
	private DormBuildService buildService;
	/**
	 * 条件，分页，查询缺勤列表
	 * @param page
	 * @param size
	 * @param molde
	 * @param conditionBean: 条件
	 * @return
	 */
	@RequestMapping("/admin/recordList")
	public String recordList(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="10")Integer size,Model model,
			RecordConditionBean conditionBean){
		
		//获取所有的宿舍楼列表
		List<TDormbuild> dormBuildList = dormBuildService.findAllDormBuild();
		//获取缺勤列表
		Page<TRecord> pageBean = recordService.findRecordListByCondition(page,size,conditionBean);
		//将列表，条件放入Model中
		model.addAttribute("dormBuildList", dormBuildList);
		model.addAttribute("page", pageBean);
		model.addAttribute("conditionBean", conditionBean);
		
		return "admin/recordManager";
	}
	
	/**
	 * 条件，分页，查询缺勤列表
	 * @param page
	 * @param size
	 * @param molde
	 * @param conditionBean: 条件
	 * @return
	 */
	@RequestMapping("/dorm/recordList")
	public String recordList2(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="10")Integer size,Model model,HttpServletRequest request,
			RecordConditionBean conditionBean){
		HttpSession session = request.getSession();
		
		//1、从session中获取登录的管理员获取宿舍id，并放入RecordConditionBean对象中
		TDormmanager dormManager = (TDormmanager)session.getAttribute("loginUser");
		conditionBean.setDormBuildId(dormManager.getBordbuildid());
		
		//搜索条件回显
		model.addAttribute("conditionBean", conditionBean);
		
		//如果 DormBuildId为空
		if(dormManager.getBordbuildid() == null){
			model.addAttribute("buildName", null);
			Page<TRecord> pageBean = new Page<>();
			pageBean.setPage(page);
			pageBean.setTotal(0);
			pageBean.setSize(size);
			pageBean.setRows(new ArrayList<TRecord>());
			model.addAttribute("page", pageBean);
			return "dorm/recordManager";
		}
		
		//2、获取当前 DormbuildId的宿舍楼名称
		MyResult myResult = buildService.findDormBuildById(dormManager.getBordbuildid());
		TDormbuild dormBuild = (TDormbuild)myResult.getData();
		model.addAttribute("buildName", dormBuild.getDormbuildname());
		
		//3、Service层处理
		Page<TRecord> pageBean = recordService.findRecordListByCondition(page, size, conditionBean);
		model.addAttribute("page", pageBean);
		
		return "dorm/recordManager";
	}
	
	/**
	 * 条件，分页，查询缺勤列表（学生）
	 * @param page
	 * @param size
	 * @param conditionBean
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/stu/recordList")
	public String recordList3(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="10")Integer size,RecordConditionBean conditionBean,
			HttpServletRequest request,Model model){
		
		//根据登录的学生获取学生的学号
		TStudent loginStudent = (TStudent)request.getSession().getAttribute("loginUser");
		//根据学号等条件查询
		conditionBean.setStudentNumber(loginStudent.getStunum());
		Page<TRecord> pageBean = this.recordService.findRecordListByCondition(page, size, conditionBean);
		model.addAttribute("page", pageBean);
		model.addAttribute("conditionBean", conditionBean);
		return "stu/recordManager";
	}
	
	/**
	 * 检测日期错误
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@RequestMapping("/checkDate")
	@ResponseBody
	public MyResult checkDate(Date startDate, Date endDate){
		MyResult result = CheckDateUtil.dateCheck(startDate, endDate);
		return result;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/admin/deleteRecord/{id}")
	@ResponseBody
	public MyResult deleteRecord1(@PathVariable Integer id){
		MyResult result = recordService.deleteRecordById(id);
		return result;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/dorm/deleteRecord/{id}")
	@ResponseBody
	public MyResult deleteRecord2(@PathVariable Integer id){
		MyResult result = recordService.deleteRecordById(id);
		return result;
	}
	
	/**
	 * 添加缺勤记录
	 * @param record
	 * @return
	 */
	@RequestMapping("/dorm/addRecord")
	@ResponseBody
	public MyResult addRecord(TRecord record){
		MyResult result = recordService.addRecord(record);
		return result;
	}
	
}
