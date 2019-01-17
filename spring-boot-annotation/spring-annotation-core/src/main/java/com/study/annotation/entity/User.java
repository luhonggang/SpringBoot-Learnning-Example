package com.study.annotation.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/17 13:48
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class User {
    private String customerId;
    private String useId;
    private String phoneNum;
    private String tokenCode;
    private String password;
    private String salt;
    private String verifyCode;
    private String deviceId;
    private String osVersion;
    private String appVersion;
    private String sdkVersion;
    private String market;
    private String pushToken;
    private String nickName;
    private String lng;
    private String lat;
    private String source;
    private String userAvatar;
    private Integer loginCounts;
    private Integer loginErrorCounts;
    private String lastLoginTime;
    private String loginState;
    private String gesturePass;
    private String inviter;
    private String tokenEffective;
    private String tokenExpired;
    private Integer appNum;
    private String state;
    private String createTime;
    private String createMan;
    private String modifyTime;
    private String modifyMan;
    private String remark;
    private String phoneNumEncrypt;
    private String phoneShaEncrypt;
    private String blackBox;
    private Integer origin;
    private String lastAppVersion;
    private String lastMarket;
}
