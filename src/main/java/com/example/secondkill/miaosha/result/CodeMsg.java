package com.example.secondkill.miaosha.result;

/**
 * 封装的用于统一处理的错误。
 *
 */
public class CodeMsg {
    private int code;
    private String msg;

    //通用异常
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务器内部错误");

    //登陆模块5002xx

    //商品模块 5003xx

    //订单模块 5004xx

    //秒杀模块 5005xx



    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
