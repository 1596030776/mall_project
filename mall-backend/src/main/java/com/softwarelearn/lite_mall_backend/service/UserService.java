package com.softwarelearn.lite_mall_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.pojo.user.UserInfo;

/**
 * 用户服务接口
 * @author linorman tt
 * @data 2023/04/16
 */
public interface UserService extends IService<UserInfo> {
    /**
     * 用户注册
     * @param userInfo
     * @return R
     */
    public R register(UserInfo userInfo);

    /**
     * 用户登录
     * @param userInfo
     * @return R
     */
    public R signIn(UserInfo userInfo);

    /**
     * 获取用户信息
     * @param userInfo
     * @return R
     */
    public R getUserInfo(UserInfo userInfo);

    /**
     * 退出登录
     * @param userInfo
     * @return R
     */
    public R logout(UserInfo userInfo);

}
