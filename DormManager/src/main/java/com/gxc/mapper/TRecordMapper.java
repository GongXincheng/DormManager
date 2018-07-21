package com.gxc.mapper;

import com.gxc.entity.TRecord;
import com.gxc.entity.TRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRecordMapper {
    int countByExample(TRecordExample example);

    int deleteByExample(TRecordExample example);

    int deleteByPrimaryKey(Integer recordid);

    int insert(TRecord record);

    int insertSelective(TRecord record);

    List<TRecord> selectByExample(TRecordExample example);

    TRecord selectByPrimaryKey(Integer recordid);

    int updateByExampleSelective(@Param("record") TRecord record, @Param("example") TRecordExample example);

    int updateByExample(@Param("record") TRecord record, @Param("example") TRecordExample example);

    int updateByPrimaryKeySelective(TRecord record);

    int updateByPrimaryKey(TRecord record);
}