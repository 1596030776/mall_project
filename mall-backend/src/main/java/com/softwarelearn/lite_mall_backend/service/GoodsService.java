package com.softwarelearn.lite_mall_backend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.pojo.mall.GoodsInfo;

/**
 * 商品服务接口
 * @author lyh
 * @data 2023/04/16
 */
public interface GoodsService extends IService<GoodsInfo> {
    /**
     * 获取商品信息
     * @return R
     */
     R getAllGoods();

    /**
     * 获取商品信息
     * @param goodsInfo
     * @return
     */
     R getGoods(GoodsInfo goodsInfo);
}
