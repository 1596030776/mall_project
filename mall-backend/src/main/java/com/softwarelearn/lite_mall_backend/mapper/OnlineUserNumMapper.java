package com.softwarelearn.lite_mall_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.softwarelearn.lite_mall_backend.pojo.mall.OnlineUserNumInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 在线用户数量mapper类
 * @author linorman
 * @data 2023/05/08
 */
@Mapper
public interface OnlineUserNumMapper extends BaseMapper<OnlineUserNumInfo> {
}
