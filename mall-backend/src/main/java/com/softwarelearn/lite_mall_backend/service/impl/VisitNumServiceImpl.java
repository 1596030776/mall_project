package com.softwarelearn.lite_mall_backend.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.constant.ResultCode;
import com.softwarelearn.lite_mall_backend.mapper.VisitNumInfoMapper;
import com.softwarelearn.lite_mall_backend.pojo.mall.VisitNumInfo;
import com.softwarelearn.lite_mall_backend.service.VisitNumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 * @author ww
 * @data 2023/04/22
 */
@Slf4j
@Service
@DS("visit_order_info")
public class VisitNumServiceImpl extends ServiceImpl<VisitNumInfoMapper, VisitNumInfo> implements VisitNumService {
    @Autowired
    private VisitNumInfoMapper visitNumInfoMapper;

    @Override
    public R updateVisitNum() {
        LambdaQueryWrapper<VisitNumInfo> queryWrapper = new LambdaQueryWrapper<>();
        VisitNumInfo temp= visitNumInfoMapper.selectOne(queryWrapper);
        if (temp == null) {
            temp = new VisitNumInfo();
            temp.setVisitNum(1);
            visitNumInfoMapper.insert(temp);
            return R.success(ResultCode.VISITNUM_INCREASE_SUCCESS,null);
        }
        temp.setVisitNum(temp.getVisitNum() + 1);
        visitNumInfoMapper.updateById(temp);
        return R.success(ResultCode.VISITNUM_INCREASE_SUCCESS,null);
    }

    @Override
    public R getVisitNum() {
        LambdaQueryWrapper<VisitNumInfo> queryWrapper = new LambdaQueryWrapper<>();
        VisitNumInfo temp = visitNumInfoMapper.selectOne(queryWrapper);
        if (temp == null) {
            return R.success(ResultCode.VISITNUM_SEARCH_SUCCESS, 0);
        }
        return R.success(ResultCode.VISITNUM_SEARCH_SUCCESS, temp.getVisitNum());
    }

    @Override
    public R subVisitNum() {
        LambdaQueryWrapper<VisitNumInfo> queryWrapper = new LambdaQueryWrapper<>();
        VisitNumInfo temp = visitNumInfoMapper.selectOne(queryWrapper);
        if (temp == null) {
            return R.success(ResultCode.VISITNUM_SUB_SUCCESS, 0);
        }
        temp.setVisitNum(temp.getVisitNum() - 1);
        visitNumInfoMapper.updateById(temp);
        return R.success(ResultCode.VISITNUM_SUB_SUCCESS, temp.getVisitNum());
    }

    @Override
    public R resetVisitNum() {
        LambdaQueryWrapper<VisitNumInfo> queryWrapper = new LambdaQueryWrapper<>();
        VisitNumInfo temp = visitNumInfoMapper.selectOne(queryWrapper);
        if (temp == null) {
            return R.success(ResultCode.VISITNUM_RESET_SUCCESS, 0);
        }
        temp.setVisitNum(0);
        visitNumInfoMapper.updateById(temp);
        return R.success(ResultCode.VISITNUM_RESET_SUCCESS, temp.getVisitNum());
    }
}