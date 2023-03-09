package com.youlai.mall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.pms.pojo.dto.CheckPriceDTO;
import com.youlai.mall.pms.pojo.dto.SkuDTO;
import com.youlai.mall.pms.pojo.entity.PmsSku;
import com.youlai.mall.pms.pojo.dto.LockStockDTO;


/**
 * 商品库存单元接口
 *
 * @author haoxr
 * @date 2022/2/5 17:11
 */
public interface SkuService extends IService<PmsSku> {

    /**
     * 获取商品的库存数量
     *
     * @param skuId
     * @return
     */
    Integer getStockNum(Long skuId);

    /**
     * 获取商品库存信息
     *
     * @param skuId
     * @return
     */
    SkuDTO getSkuInfo(Long skuId);


    /**
     * 锁定库存
     */
    boolean lockStock(LockStockDTO lockStockDTO);

    /**
     * 解锁库存
     */
    boolean unlockStock(String orderSn);

    /**
     * 扣减库存
     */
    boolean deductStock(String orderSn);


    /**
     * 商品验价
     *
     * @param checkPriceDTO
     * @return
     */
    boolean checkPrice(CheckPriceDTO checkPriceDTO);


    /**
     * 「实验室」修改商品库存数量
     *
     * @param skuId
     * @param stockNum 商品库存数量
     * @return
     */
    boolean updateStockNum(Long skuId, Integer stockNum);

    /**
     * 「实验室」扣减商品库存
     *
     * @param skuId
     * @param num 商品库存数量
     * @return
     */
    boolean deductStock(Long skuId, Integer num);
}
