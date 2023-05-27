package com.softwarelearn.lite_mall_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.pojo.mall.OrderNumInfo;


/**
 * 订单量接口
 * @author ww
 * @data 2023/04/22
 */

public interface OrderNumService extends IService<OrderNumInfo> {
    /**
     * 订单量加一
     * @return R
     */
    R updateOrderNum();

    /**
     * 获取订单量
     * @return R
     */
    R getOrderNum();

    /**
     * 订单量减一
     * @return R
     */
    R subOrderNum();

    /**
     * 订单量重置
     * @return R
     */
    R resetOrderNum();
}
