package com.softwarelearn.lite_mall_backend.pojo.mall;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 订单量
 * @author ww
 * @data 2023/04/22
 */
@Slf4j
@Data
public class OrderNumInfo implements Serializable {
    private int id;
    private int orderNum;
}
