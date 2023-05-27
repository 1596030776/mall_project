package com.softwarelearn.lite_mall_backend.controller.mall;

import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.pojo.mall.VisitNumInfo;
import com.softwarelearn.lite_mall_backend.service.VisitNumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 访问量控制器
 * @author ww
 * @data 2023/04/22
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/mall")
public class VisitNumController{

    @Autowired
    private VisitNumService visitNumService;

    @PostMapping("/orderVisitIncrease")
    public R visitNumIncrease(){
        return visitNumService.updateVisitNum();
    }

    @GetMapping("/getVisitNum")
    public R getVisitNum(){
        return visitNumService.getVisitNum();
    }

    @PostMapping("/visitNumReset")
    public R visitNumReset(){
        return visitNumService.resetVisitNum();
    }

    @PostMapping("/visitNumSub")
    public R visitNumSub(){
        return visitNumService.subVisitNum();
    }

}