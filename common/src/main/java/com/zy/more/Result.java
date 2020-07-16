package com.zy.more;

import lombok.Data;

/**
 * @author: zhangyao
 * @create:2020-06-28 15:12
 **/
@Data
public class Result<T> {
    private String code;
    private String message;
    private T data;

    private Result(){}

    public String getCode() {
        return code;
    }

    public Result<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static Result ok(){
        Result result = new Result();
        result.setCode("200");
        result.setMessage("成功");
        return result;
    }

    public static Result failed(){
        Result result = new Result();
        result.setCode("500");
        result.setMessage("失败");
        return result;
    }



}
