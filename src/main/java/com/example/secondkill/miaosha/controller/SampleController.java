package com.example.secondkill.miaosha.controller;

import com.example.secondkill.miaosha.domain.MiaoshaUser;
import com.example.secondkill.miaosha.redis.RedisService;
import com.example.secondkill.miaosha.redis.UserKey;
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

    @Autowired
    RedisService redisService;

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<MiaoshaUser> dbGet() {
        MiaoshaUser miaoshaUser = userService.getById(0);
        return Result.success(miaoshaUser);
    }

    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> tx() {
        userService.tx();
        return Result.success(true);
    }


    @RequestMapping("/db/getall")
    @ResponseBody
    public Result<MiaoshaUser> dbGetAll() {
        MiaoshaUser miaoshaUser = userService.getUsers();
        return Result.success(miaoshaUser);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet() {
        MiaoshaUser user = new MiaoshaUser();
        user.setId(1);
        user.setName("name1");
        redisService.set(UserKey.getById, "" + 1, user);
        return Result.success(true);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<MiaoshaUser> redisGet() {
        MiaoshaUser user = redisService.get(UserKey.getById, "" + 1, MiaoshaUser.class);
        return Result.success(user);
    }


}
