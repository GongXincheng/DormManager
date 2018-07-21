package com.gxc.utils.pojo;

public class StuConditionBean {

	private Integer con_dormBuildid;//宿舍楼ID
	private Integer con_chooseId;	//选择查询的条件字段 1：姓名，2：学号,3：寝室
	private String con_value;
	
	public Integer getCon_dormBuildid() {
		return con_dormBuildid;
	}
	public void setCon_dormBuildid(Integer con_dormBuildid) {
		this.con_dormBuildid = con_dormBuildid;
	}
	public Integer getCon_chooseId() {
		return con_chooseId;
	}
	public void setCon_chooseId(Integer con_chooseId) {
		this.con_chooseId = con_chooseId;
	}
	public String getCon_value() {
		return con_value;
	}
	public void setCon_value(String con_value) {
		this.con_value = con_value;
	}
}
