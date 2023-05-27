package com.softwarelearn.lite_mall_backend.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.constant.ResultCode;
import com.softwarelearn.lite_mall_backend.mapper.OnlineUserNumMapper;
import com.softwarelearn.lite_mall_backend.pojo.mall.OnlineUserNumInfo;
import com.softwarelearn.lite_mall_backend.service.OnlineUserNumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 在线用户数量服务实现类
 * @author linorman
 * @data 2023/05/08
 */
@Slf4j
@Service
@DS("online_user_info")
public class OnlineUserNumServiceImpl extends ServiceImpl<OnlineUserNumMapper, OnlineUserNumInfo> implements OnlineUserNumService {
    @Autowired
    private OnlineUserNumMapper onlineUserNumMapper;

    @Override
    public R updateOnlineUserNum() {
        LambdaQueryWrapper<OnlineUserNumInfo> queryWrapper = new LambdaQueryWrapper<>();
        OnlineUserNumInfo temp= onlineUserNumMapper.selectOne(queryWrapper);
        if (temp == null) {
            temp = new OnlineUserNumInfo();
            temp.setOnlineUserNum(1);
            onlineUserNumMapper.insert(temp);
            return R.success(ResultCode.ONLINEUSERNUM_INCREASE_SUCCESS, temp.getOnlineUserNum());
        }
        temp.setOnlineUserNum(temp.getOnlineUserNum() + 1);
        onlineUserNumMapper.updateById(temp);
        return R.success(ResultCode.ONLINEUSERNUM_INCREASE_SUCCESS, temp.getOnlineUserNum());
    }

    @Override
    public R getOnlineUserNum() {
        LambdaQueryWrapper<OnlineUserNumInfo> queryWrapper = new LambdaQueryWrapper<>();
        OnlineUserNumInfo temp = onlineUserNumMapper.selectOne(queryWrapper);
        if (temp == null) {
            return R.success(ResultCode.ONLINEUSERNUM_SEARCH_SUCCESS, 0);
        }
        return R.success(ResultCode.ONLINEUSERNUM_SEARCH_SUCCESS, temp.getOnlineUserNum());
    }

    @Override
    public R subOnlineUserNum() {
        LambdaQueryWrapper<OnlineUserNumInfo> queryWrapper = new LambdaQueryWrapper<>();
        OnlineUserNumInfo temp = onlineUserNumMapper.selectOne(queryWrapper);
        if (temp == null) {
            return R.success(ResultCode.ONLINEUSERNUM_SUB_SUCCESS, 0);
        }
        temp.setOnlineUserNum(temp.getOnlineUserNum() - 1);
        onlineUserNumMapper.updateById(temp);
        return R.success(ResultCode.ONLINEUSERNUM_SUB_SUCCESS, temp.getOnlineUserNum());
    }

    @Override
    public R resetOnlineUserNum() {
        LambdaQueryWrapper<OnlineUserNumInfo> queryWrapper = new LambdaQueryWrapper<>();
        OnlineUserNumInfo temp = onlineUserNumMapper.selectOne(queryWrapper);
        if (temp == null) {
            return R.success(ResultCode.ONLINEUSERNUM_RESET_SUCCESS, 0);
        }
        temp.setOnlineUserNum(0);
        onlineUserNumMapper.updateById(temp);
        return R.success(ResultCode.ONLINEUSERNUM_RESET_SUCCESS, temp.getOnlineUserNum());
    }
}
