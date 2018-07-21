package com.gxc.utils;

import java.util.Date;

public class CheckDateUtil {

	/**
	 * 检查时间是否输入正确
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static MyResult dateCheck(Date startDate, Date endDate) {
		//如果两个都为空
		if(startDate == null && endDate == null){
			return MyResult.build(200, "OK");
		}
		//1、如果开始时间为空
		if(startDate == null){
			return MyResult.build(201, "请输入起始日期！");
		}
		//2、如果endDate为空，如果日期超过当前日期
		if(endDate==null){
			int temp = startDate.compareTo(new Date());
			if(temp>0){
				return MyResult.build(201, "起始日期不能大于当天！");
			}
		}
		//3、判断两日期大小
		else{
			int temp = startDate.compareTo(endDate);
			if(temp>0){
				return MyResult.build(201, "起始日期不能大于结束日期！");
			}
		}
		return MyResult.build(200, "OK");
	}
	
}
