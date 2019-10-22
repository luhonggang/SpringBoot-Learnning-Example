package com.study.annotation.dao;

import com.study.annotation.entity.Experiment;
import com.study.annotation.entity.ExperimentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExperimentMapper {
    int deleteByPrimaryKey(Long experimentId);

    int insert(Experiment record);

    int insertSelective(ExperimentVo experimentVo);

    int selectByPrimaryKeyVersion(@Param("experimentId") Long experimentId, @Param("version") Integer version);

    int updateByPrimaryKeySelective(ExperimentVo experimentVo);

    int updateByPrimaryKey(Experiment record);

    /**
     * 查询实验code记录是否存在
     * @param code 实验code
     * @return Experiment
     */
    Experiment selectByCode(String code);
}