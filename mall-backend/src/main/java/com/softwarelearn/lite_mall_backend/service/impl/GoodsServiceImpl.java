package com.softwarelearn.lite_mall_backend.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.constant.ResultCode;
import com.softwarelearn.lite_mall_backend.mapper.GoodsInfoMapper;
import com.softwarelearn.lite_mall_backend.pojo.mall.GoodsInfo;
import com.softwarelearn.lite_mall_backend.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品服务实现类
 * @author lyh
 * @data 2023/04/16
 */
@Slf4j
@Service
@DS("goods_info")
public class GoodsServiceImpl extends ServiceImpl<GoodsInfoMapper, GoodsInfo> implements GoodsService {
    @Autowired
    private GoodsInfoMapper goodsInfoMapper;

    @Override
    public R getAllGoods() {
        String tableName = "goods_info";
        if (goodsInfoMapper.selectGoodsInfo(tableName) == null) {
            log.info("商品不存在");
            return R.error(ResultCode.GOODS_NOT_EXISTS, null);
        }
        List<GoodsInfo> temp = goodsInfoMapper.selectGoodsInfo(tableName);
        return R.success(ResultCode.GOODS_SEARCH_SUCCESS, temp);
    }

    @Override
    public R getGoods(GoodsInfo goodsInfo) {
        String goodsName = goodsInfo.getGoodsName();
        LambdaQueryWrapper<GoodsInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(GoodsInfo::getGoodsName, goodsName);
        List temp = goodsInfoMapper.selectList(queryWrapper);
        if (temp == null) {
            log.info("商品不存在");
            return R.error(ResultCode.GOODS_NOT_EXISTS, null);
        }
        goodsInfoMapper.insert(goodsInfo);
        log.info("商品查找成功");
        return R.success(ResultCode.GOODS_SEARCH_SUCCESS, temp);

    }
}