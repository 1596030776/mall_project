package com.softwarelearn.lite_mall_backend.controller.mall;

import com.softwarelearn.lite_mall_backend.constant.R;

import com.softwarelearn.lite_mall_backend.pojo.mall.GoodsInfo;
import com.softwarelearn.lite_mall_backend.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品控制器
 * @author lyh
 * @data 2023/04/16
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/mall")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @GetMapping("/getAllGoods")
    public R getAllGoods(){
        return goodsService.getAllGoods();
    }

    @PostMapping("/getGoods")
    public R getGoods(@RequestBody GoodsInfo goodsInfo){
        return goodsService.getGoods(goodsInfo);
    }
}

