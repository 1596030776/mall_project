package com.softwarelearn.lite_mall_backend.pojo.mall;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 商品信息类
 *
 * @author lyh
 * @data 2023/04/16
 */
@Slf4j
@Data
public class GoodsInfo implements Serializable {
    private String goodsName;
    private double goodsPrice;
    private long id;
    private String message;
    private String filePath;
}

