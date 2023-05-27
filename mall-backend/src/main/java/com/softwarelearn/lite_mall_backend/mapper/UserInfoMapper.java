package com.softwarelearn.lite_mall_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.softwarelearn.lite_mall_backend.pojo.user.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息映射接口
 * @author linorman
 * @data 2023/04/16
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
