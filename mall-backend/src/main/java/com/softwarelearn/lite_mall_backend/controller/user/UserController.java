package com.softwarelearn.lite_mall_backend.controller.user;

import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.pojo.user.UserInfo;
import com.softwarelearn.lite_mall_backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器
 * @author linorman
 * @data 2023/04/16
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public R register(@RequestBody UserInfo userInfo){
        return userService.register(userInfo);
    }

    @PostMapping("/userSignIn")
    public R signIn(@RequestBody UserInfo userInfo){
        return userService.signIn(userInfo);
    }

    @PostMapping("/getUserInfo")
    public R getUserInfo(@RequestBody UserInfo userInfo){
        return userService.getUserInfo(userInfo);
    }

    @PostMapping("/userLogout")
    public R logout(@RequestBody UserInfo userInfo){
        return userService.logout(userInfo);
    }
}
