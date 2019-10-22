package com.study.annotation.service.impl;

import com.study.annotation.dao.ExperimentMapper;
import com.study.annotation.entity.Experiment;
import com.study.annotation.entity.ExperimentVo;
import com.study.annotation.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.UUID;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/12 15:07
 */
@Service
public class ExperimentServiceImpl implements ExperimentService {

    @Autowired
    ExperimentMapper experimentMapper;

    @Override
    public void saveExperiment(ExperimentVo experimentVo) {
        // 检查实验code是否重复
        checkExperimentCode(experimentVo.getExperimentCode());
        experimentVo.setExperimentId(UUID.randomUUID().getLeastSignificantBits());
        experimentMapper.insertSelective(experimentVo);
    }

    /**
     * 修改实验记录
     * @param experimentVo 入参
     */
    @Override
    public void updateExperiment(ExperimentVo experimentVo) {
        checkExperimentCode(experimentVo.getExperimentCode());
        if (Objects.isNull(experimentVo.getExperimentId())) {
            throw new RuntimeException("主键为空");
        }
        if (experimentMapper.selectByPrimaryKeyVersion(experimentVo.getExperimentId(), experimentVo.getVersion()) <= 0) {
            throw new RuntimeException("版本数据不存在");
        }
        int rows = experimentMapper.updateByPrimaryKeySelective(experimentVo);
        if(rows < 1){
            throw new RuntimeException("版本数据修改失败");
        }
    }

    /**
     * 检查实验CODE是否重复
     * @param code 实验code
     */
    private void checkExperimentCode(String code){
        if(Objects.nonNull(experimentMapper.selectByCode(code))){
            throw new RuntimeException("版本数据存在");
        }
    }
}
