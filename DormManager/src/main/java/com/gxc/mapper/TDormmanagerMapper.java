package com.gxc.mapper;

import com.gxc.entity.TDormmanager;
import com.gxc.entity.TDormmanagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDormmanagerMapper {
    int countByExample(TDormmanagerExample example);

    int deleteByExample(TDormmanagerExample example);

    int deleteByPrimaryKey(Integer dormmanid);

    int insert(TDormmanager record);

    int insertSelective(TDormmanager record);

    List<TDormmanager> selectByExample(TDormmanagerExample example);

    TDormmanager selectByPrimaryKey(Integer dormmanid);

    int updateByExampleSelective(@Param("record") TDormmanager record, @Param("example") TDormmanagerExample example);

    int updateByExample(@Param("record") TDormmanager record, @Param("example") TDormmanagerExample example);

    int updateByPrimaryKeySelective(TDormmanager record);

    int updateByPrimaryKey(TDormmanager record);
}