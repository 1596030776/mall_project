package com.softwarelearn.lite_mall_backend.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.pojo.user.UserInfo;
import com.softwarelearn.lite_mall_backend.service.UserService;
import com.softwarelearn.lite_mall_backend.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softwarelearn.lite_mall_backend.constant.ResultCode;

/**
 * 用户服务实现类
 * @author linorman tt
 * @data 2023/04/16
 */
@Slf4j
@Service
@DS("user_info")
public class UserServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public R register(UserInfo userInfo) {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        String username = userInfo.getUsername();
        queryWrapper.eq(UserInfo::getUsername, username);
        UserInfo tempName = userInfoMapper.selectOne(queryWrapper);
        if (tempName != null) {
            log.info("用户名已存在");
            return R.error(ResultCode.USER_EXISTS, null);
        }
        String phoneNumber = userInfo.getPhoneNumber();
        queryWrapper.eq(UserInfo::getPhoneNumber, phoneNumber);
        UserInfo tempPhone = userInfoMapper.selectOne(queryWrapper);
        if (tempPhone != null) {
            log.info("手机号已存在");
            return R.error(ResultCode.USER_PHONENUMBER_EXISTS, null);
        }
        userInfoMapper.insert(userInfo);
        log.info("用户注册成功");
        return R.success(ResultCode.USER_REGISTER_SUCCESS, null);

    }

    @Override
    public R signIn(UserInfo userInfo) {
        String username = userInfo.getUsername();
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUsername, username);
        UserInfo temp = userInfoMapper.selectOne(queryWrapper);
        if (temp == null) {
            log.info("用户不存在");
            return R.error(ResultCode.USER_NOT_EXISTS, null);
        }else if(!temp.getPhoneNumber().equals(userInfo.getPhoneNumber())) {
            log.info("用户名与手机号不匹配");
            return R.error(ResultCode.USER_NAME_PHONE_NOT_MATCH, null);
        }else if(!temp.getPassword().equals(userInfo.getPassword())) {
            log.info("密码错误");
            return R.error(ResultCode.USER_PASSWORD_WRONG, null);
        }else if(temp.getIsLogined() == 1) {
            log.info("用户已登录");
            return R.error(ResultCode.USER_ALREADY_LOGINED, null);
        }
        temp.setIsLogined(1);
        userInfoMapper.updateById(temp);
        log.info("用户登录成功");
        return R.success(ResultCode.USER_SIGHIN_SUCCESS, null);
    }

    @Override
    public R getUserInfo(UserInfo userInfo) {
        String username = userInfo.getUsername();
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUsername, username);
        UserInfo temp = userInfoMapper.selectOne(queryWrapper);
        if (temp == null) {
            log.info("用户不存在");
            return R.error(ResultCode.USER_NOT_EXISTS, null);
        }
        log.info("获取用户信息成功");
        return R.success(ResultCode.SUCCESS, temp);
    }

    @Override
    public R logout(UserInfo userInfo) {
        String username = userInfo.getUsername();
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUsername, username);
        UserInfo temp = userInfoMapper.selectOne(queryWrapper);
        if (temp == null) {
            log.info("用户不存在");
            return R.error(ResultCode.USER_NOT_EXISTS, null);
        }else if(temp.getIsLogined() == 0) {
            log.info("用户已登出");
            return R.error(ResultCode.USER_ALREADY_LOGOUT, null);
        }
        temp.setIsLogined(0);
        userInfoMapper.updateById(temp);
        log.info("用户退出登录成功");
        return R.success(ResultCode.USER_LOGOUT_SUCCESS, null);
    }
}
