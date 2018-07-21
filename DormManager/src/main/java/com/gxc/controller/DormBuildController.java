package com.gxc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxc.entity.TDormbuild;
import com.gxc.service.DormBuildService;
import com.gxc.utils.MyResult;
import com.gxc.utils.Page;

/**
 * 宿舍楼管理
 * @author 宫新程
 */
@Controller
public class DormBuildController {
	
	@Autowired
	private DormBuildService dormBuildService;
	
	/**
	 * 判断该宿舍楼是否存在
	 * @param dormBuildName
	 * @return
	 */
	@RequestMapping("/admin/hasDormBuild")
	@ResponseBody
	public MyResult hasDormBuild(String dormBuildName){
		MyResult result = dormBuildService.findDormBuildByName(dormBuildName);
		return result;
	} 
	
	/**
	 * 添加宿舍楼
	 * @param dormBuild
	 * @return
	 */
	@RequestMapping("/admin/addDormBuild")
	@ResponseBody
	public MyResult addDormBuild(TDormbuild dormBuild){
		MyResult result = this.dormBuildService.insertDormBuild(dormBuild);
		return result;
	}
	
	/**
	 * 查询宿舍楼列表
	 * 条件，分页查询
	 * @param page
	 * @param size
	 * @param model
	 * @param condition
	 * @return
	 */
	@RequestMapping("/admin/dormBuildList")
	public String dormBuildList(@RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="12")Integer size, Model model,String condition){
		//条件分页查询数据
		Page<TDormbuild> pageList = this.dormBuildService.findDormBuildList(page,size,condition);
		model.addAttribute("page", pageList);
		//数据回显
		model.addAttribute("condition", condition);
		return "admin/dormBuildManager";
	}
	
	/**
	 * 根据宿舍楼id查询宿舍楼信息
	 * 编辑前ui
	 * @param dormBuildId
	 * @return
	 */
	@RequestMapping("/admin/dormBuildInfo")
	@ResponseBody
	public MyResult findDormBuildById(Integer dormBuildId){
		MyResult result = this.dormBuildService.findDormBuildById(dormBuildId);
		return result;
	}
	
	/**
	 * 更新宿舍楼信息
	 * @param dormBuild
	 * @return
	 */
	@RequestMapping("/admin/UpdataDormBuild")
	@ResponseBody
	public MyResult updateDormBuild(TDormbuild dormBuild){
		MyResult result = this.dormBuildService.updateDormBuild(dormBuild);
		return result;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/admin/deleteDormBuild/{id}")
	@ResponseBody
	public MyResult deleteDormBuildById(@PathVariable Integer id){
		MyResult result = this.dormBuildService.deleteDormBuildById(id);
		return result;
	}

}
