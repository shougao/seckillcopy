package com.example.secondkill.miaosha.result;

/**
 * 封装的，用于统一处理的结果
 *
 * 1. 范型T用于支持各种数据类型
 * 2. 通过静态方法，返回范型类对象Result<T>, 方法带<T>表示位范型方法
 * 3. 构造函数不用带范型<T>
 *
 * @param <T>
 */
public class Result<T> {

    private int code;
    private String msg;
    private T data; //因为数据类型未知，所以定义为范型， 所以这个类处理的类型也就是这个范型，通过加<T>表示


    private Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    private Result(CodeMsg msg) {
        if (msg == null) {
            return;
        }
        this.code = msg.getCode();
        this.msg = msg.getMsg();
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    public static <T> Result<T> error(CodeMsg msg) {
        return new Result<T>(msg);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
