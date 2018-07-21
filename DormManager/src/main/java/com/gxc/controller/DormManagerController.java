package com.gxc.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxc.entity.TDormmanager;
import com.gxc.service.DormManagerService;
import com.gxc.utils.MyResult;
import com.gxc.utils.Page;

@Controller
public class DormManagerController {

	
	@Autowired
	private DormManagerService dormManagerService;
	
	/**
	 * 条件分页查询宿舍管理员列表
	 * @param conditionId
	 * @param conditionValue
	 * @param page
	 * @param size
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/dormMngList")
	public String dormMngList(@RequestParam(defaultValue="0")Integer conditionId,String conditionValue,
			@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="12")Integer size,Model model){
		
		//分页，条件查询
		Page<TDormmanager> dormMngList = 
				dormManagerService.findDormMngList(conditionId,conditionValue,page,size);
		
		//返回集合，及其查询条件的回显
		model.addAttribute("page", dormMngList);
		model.addAttribute("conditionId", conditionId);
		model.addAttribute("conditionValue", conditionValue);
		return "admin/dormManager";
	}
	
	/**
	 * 根据宿舍管理员id查询信息
	 * 编辑前UI
	 * @param id
	 * @return
	 */
	@RequestMapping("/admin/dormMng/{id}")
	@ResponseBody
	public MyResult findDormMngById(@PathVariable Integer id){
		MyResult result = this.dormManagerService.findDormMsgById(id);
		return result;
	}
	
	/**
	 * 更新宿舍管理员信息
	 * @param dormManager
	 * @return
	 */
	@RequestMapping("/admin/updateDormMsg")
	@ResponseBody
	public MyResult updateDormMsg(TDormmanager dormManager){
		MyResult result = this.dormManagerService.updateDormMsg(dormManager);
		return result;
	}
	
	/**
	 * 删除宿舍管理员
	 * @param dormId
	 * @return
	 */
	@RequestMapping("/admin/deleteDorm")
	@ResponseBody
	public MyResult deleteDorm(Integer dormId){
		MyResult result = this.dormManagerService.deleteDormById(dormId);
		return result;
	}
	
	/**
	 * 添加宿舍管理员
	 * @param dormManager
	 * @return
	 */
	@RequestMapping("/admin/addDormMsg")
	@ResponseBody
	public MyResult addDormMsg(TDormmanager dormManager){
		MyResult result = this.dormManagerService.addDormMng(dormManager);
		return result;
	}
	
	/**
	 * 添加管理员时，判断用户名是否存在
	 * @param username
	 * @return
	 */
	@RequestMapping("/admin/hasDormMsg")
	@ResponseBody
	public MyResult hasDormMsg(String username){
		if(StringUtils.isBlank(username)){
			return MyResult.build(201, "网络连接失败");
		}
		MyResult result = this.dormManagerService.findDormMsgByUsername(username);
		return result;
	}
	
	/**
	 * 根据宿舍楼id查询宿舍管理员列表
	 * @param dormBuildId
	 * @return
	 */
	@RequestMapping("/admin/dbAddDormMng/{dormBuildId}")
	public String forDormBuildAddMng(@PathVariable Integer dormBuildId, Model model){
		//根据宿舍楼id查询宿舍管理员列表
		List<TDormmanager> list = this.dormManagerService.findDormMngByDornBuildId(dormBuildId);
		//查询 bordBuildId为null的宿舍管理员
		List<TDormmanager> noWorkList = this.dormManagerService.findDormMngByDornBuildIdIsNull();
		model.addAttribute("mngList", list);
		model.addAttribute("noWorkList", noWorkList);
		model.addAttribute("currentDBId", dormBuildId);
		return "admin/addDormManager";
	}
	
	/**
	 * 取消宿舍管理员所管理的宿舍楼
	 * @param id
	 * @return
	 */
	@RequestMapping("/admin/delMngFromDormBuild")
	@ResponseBody
	public MyResult delMngFromDormBuild(Integer id){
		MyResult result = this.dormManagerService.deleteMngFromDormBuild(id);
		return result;
	}
	
	/**
	 * 为宿舍楼添加管理员
	 * @param bordbuildid 宿舍楼id
	 * @param dormmanid	管理员id
	 * @return
	 */
	@RequestMapping("/admin/setDormMng")
	public String setDormMng(Integer bordbuildid, Integer dormmanid){
		this.dormManagerService.addMngForDormBuild(bordbuildid,dormmanid);
		return "redirect:/admin/dbAddDormMng/" + bordbuildid + ".html";
	}
}
