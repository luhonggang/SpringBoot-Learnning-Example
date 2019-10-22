package com.study.annotation.entity;

import lombok.*;

import java.util.Date;

/**
 * @author luhonggang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Experiment {
    private Long experimentId;

    private String experimentCode;

    private String experimentName;

    private String flowData;

    private Integer status;

    private Integer version;

    private String createMan;

    private Date createTime;

    private String updateMan;

    private Date updateTime;
}