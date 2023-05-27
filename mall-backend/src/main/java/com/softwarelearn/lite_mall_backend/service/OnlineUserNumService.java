package com.softwarelearn.lite_mall_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.pojo.mall.OnlineUserNumInfo;

/**
 * 在线用户数量接口
 * @author linorman
 * @data 2023/05/08
 */
public interface OnlineUserNumService extends IService<OnlineUserNumInfo> {
    /**
     * 在线用户数量加一
     * @return R
     */
    R updateOnlineUserNum();

    /**
     * 获取在线用户数量
     * @return R
     */
    R getOnlineUserNum();

    /**
     * 在线用户数量减一
     * @return R
     */
    R subOnlineUserNum();

    /**
     * 在线用户数量重置
     * @return R
     */
    R resetOnlineUserNum();
}
