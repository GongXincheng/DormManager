package com.gxc.utils.pojo;

import java.util.Date;

/**
 * 缺勤记录条件
 * @author 宫新程
 */
public class RecordConditionBean {

	private Date startDate;
	private Date endDate;
	private Integer dormBuildId;
	private Integer conditionId;//1、姓名，2、学号，3、寝室
	private String conditionValue;
	private String studentNumber;
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getDormBuildId() {
		return dormBuildId;
	}
	public void setDormBuildId(Integer dormBuildId) {
		this.dormBuildId = dormBuildId;
	}
	public Integer getConditionId() {
		return conditionId;
	}
	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}
	public String getConditionValue() {
		return conditionValue;
	}
	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	
}
