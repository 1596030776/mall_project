package com.softwarelearn.lite_mall_backend.pojo.mall;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 在线用户信息类
 * @author linorman
 * @data 2023/05/08
 */
@Slf4j
@Data
public class OnlineUserNumInfo implements Serializable {
    private int id;
    private int onlineUserNum;
}
