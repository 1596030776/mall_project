package com.softwarelearn.lite_mall_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.softwarelearn.lite_mall_backend.pojo.mall.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 商品信息映射接口
 * @author lyh
 * @data 2023/04/16
 */
@Mapper
public interface GoodsInfoMapper extends BaseMapper<GoodsInfo> {
    @Select("SELECT * FROM ${tableName}")
    List<GoodsInfo> selectGoodsInfo(@Param("tableName") String tableName);
}
