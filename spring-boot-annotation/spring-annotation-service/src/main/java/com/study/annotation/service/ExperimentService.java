package com.study.annotation.service;

import com.study.annotation.entity.ExperimentVo;

/**
 * @author luhonggang
 */
public interface ExperimentService {

    /**
     * 实验保存
     * @param experimentVo 入参
     */
    void saveExperiment(ExperimentVo experimentVo);

    /**
     * 实验修改
     * @param experimentVo 入参
     * @return  成功失败
     */
    void updateExperiment(ExperimentVo experimentVo);
}
