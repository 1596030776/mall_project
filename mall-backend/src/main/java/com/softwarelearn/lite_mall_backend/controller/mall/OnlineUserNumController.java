package com.softwarelearn.lite_mall_backend.controller.mall;

import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.service.OnlineUserNumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 在线用户数量控制类
 * @author linorman
 * @data 2023/05/08
 */
@Slf4j
@RestController
@RequestMapping("/mall")
public class OnlineUserNumController {
    @Autowired
    private OnlineUserNumService onlineUserNumService;

    @PostMapping("/onlineUserNumIncrease")
    public R onlineUserNumIncrease(){
        return onlineUserNumService.updateOnlineUserNum();
    }

    @PostMapping("/onlineUserNumReset")
    public R onlineUserNumReset(){
        return onlineUserNumService.resetOnlineUserNum();
    }

    @PostMapping("/onlineUserNumSub")
    public R onlineUserNumSub(){
        return onlineUserNumService.subOnlineUserNum();
    }

    @GetMapping("/getOnlineUserNum")
    public R getOnlineUserNum(){
        return onlineUserNumService.getOnlineUserNum();
    }
}
