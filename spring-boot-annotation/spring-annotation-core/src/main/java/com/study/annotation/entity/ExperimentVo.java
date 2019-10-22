package com.study.annotation.entity;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/12 14:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ExperimentVo {

    private Long experimentId;

    /**
     * 实验CODE 格式 : 字母+数字+"_"+"-";code不能重名
     */
    @NotBlank(message = "实验CODE不可为空")
    @Pattern(regexp = "^[\\w]$",message ="实验CODE格式有误" )
    private String experimentCode;

    @NotBlank(message = "实验名称不可为空")
    private String experimentName;

    /**
     * 流程数据
     */
    private String flowData;

    /**
     * 状态（0-失效，1-有效）
     */
    private Integer status;

    @NotNull(message = "版本号不可为空")
    private Integer version;

    private String createMan;

    private Date createTime;

    private String updateMan;

    private Date updateTime;
}
