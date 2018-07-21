package com.gxc.mapper;

import com.gxc.entity.TDormbuild;
import com.gxc.entity.TDormbuildExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDormbuildMapper {
    int countByExample(TDormbuildExample example);

    int deleteByExample(TDormbuildExample example);

    int deleteByPrimaryKey(Integer dormbuildid);

    int insert(TDormbuild record);

    int insertSelective(TDormbuild record);

    List<TDormbuild> selectByExample(TDormbuildExample example);

    TDormbuild selectByPrimaryKey(Integer dormbuildid);

    int updateByExampleSelective(@Param("record") TDormbuild record, @Param("example") TDormbuildExample example);

    int updateByExample(@Param("record") TDormbuild record, @Param("example") TDormbuildExample example);

    int updateByPrimaryKeySelective(TDormbuild record);

    int updateByPrimaryKey(TDormbuild record);
}