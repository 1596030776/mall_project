package com.softwarelearn.lite_mall_backend.pojo.user;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 用户信息类
 * @author linorman
 * @data 2023/04/16
 */
@Slf4j
@Data
public class UserInfo implements Serializable {
    private int id;
    private String username;
    private String password;
    private String imageUrl;
    private String phoneNumber;
    private int account;
    private int isLogined;
}
