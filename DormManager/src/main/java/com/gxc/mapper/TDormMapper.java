package com.gxc.mapper;

import com.gxc.entity.TDorm;
import com.gxc.entity.TDormExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDormMapper {
    int countByExample(TDormExample example);

    int deleteByExample(TDormExample example);

    int deleteByPrimaryKey(Integer dormid);

    int insert(TDorm record);

    int insertSelective(TDorm record);

    List<TDorm> selectByExample(TDormExample example);

    TDorm selectByPrimaryKey(Integer dormid);

    int updateByExampleSelective(@Param("record") TDorm record, @Param("example") TDormExample example);

    int updateByExample(@Param("record") TDorm record, @Param("example") TDormExample example);

    int updateByPrimaryKeySelective(TDorm record);

    int updateByPrimaryKey(TDorm record);
}