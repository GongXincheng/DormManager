package com.gxc.service;

import com.gxc.entity.TRecord;
import com.gxc.utils.MyResult;
import com.gxc.utils.Page;
import com.gxc.utils.pojo.RecordConditionBean;

public interface RecordService {

	/**
	 * 条件，分页，查询缺勤列表
	 * @param page
	 * @param size
	 * @param conditionBean
	 * @return
	 */
	Page<TRecord> findRecordListByCondition(Integer page, Integer size, RecordConditionBean conditionBean);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	MyResult deleteRecordById(Integer id);

	/**
	 * 添加缺勤记录
	 * @param record
	 * @return
	 */
	MyResult addRecord(TRecord record);

}
