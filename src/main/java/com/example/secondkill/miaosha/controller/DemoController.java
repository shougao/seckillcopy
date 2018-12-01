package com.example.secondkill.miaosha.controller;

import com.example.secondkill.miaosha.result.CodeMsg;
import com.example.secondkill.miaosha.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.example.secondkill.miaosha.result.Result.success;

@Controller
@RequestMapping("/miaosha")
public class DemoController {

    /**
     * coontroller 设计的角色是
     * 1 restapi 的基本接口json 输出。 2 返回页面。
     *
     *
     * {
     *     "code": 0, 500100
     *     "msg":成功， 没有库存
     *     "data":{json对象} 或者 [json数组]
     * }
     * @return
     */
    @GetMapping("/demo")
    public @ResponseBody Result<String> home(){
        return Result.success("hello miaosha demo");
    }

    @GetMapping("/error")
    public @ResponseBody Result<String> error(){
        return Result.error(CodeMsg.SERVER_ERROR);
    }

}
