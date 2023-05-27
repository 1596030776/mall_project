package com.softwarelearn.lite_mall_backend.controller.mall;

import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.pojo.mall.OrderNumInfo;
import com.softwarelearn.lite_mall_backend.service.OrderNumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单量控制器
 * @author ww
 * @data 2023/04/22
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/mall")
public class OrderNumController{

    @Autowired
    private OrderNumService orderNumService;

    @PostMapping("/orderNumIncrease")
    public R orderNumIncrease(){
        return orderNumService.updateOrderNum();
    }
    @GetMapping("/getOrderNum")
    public R getOrderNum(){
        return orderNumService.getOrderNum();
    }

    @PostMapping("/orderNumReset")
    public R orderNumReset(){
        return orderNumService.resetOrderNum();
    }

    @PostMapping("/orderNumSub")
    public R orderNumSub(){
        return orderNumService.subOrderNum();
    }

}
