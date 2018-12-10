package com.example.secondkill.miaosha.controller;

import com.example.secondkill.miaosha.domain.MiaoshaUser;
import com.example.secondkill.miaosha.result.Result;
import com.example.secondkill.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dbdemo")
public class SampleController {

    @Autowired
    UserService userService;

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<MiaoshaUser> dbGet(){
        MiaoshaUser miaoshaUser = userService.getById(0);
        return Result.success(miaoshaUser);
    }


    @RequestMapping("/db/getall")
    @ResponseBody
    public Result<MiaoshaUser> dbGetAll(){
        MiaoshaUser miaoshaUser = userService.getUsers();
        return Result.success(miaoshaUser);
    }

}
