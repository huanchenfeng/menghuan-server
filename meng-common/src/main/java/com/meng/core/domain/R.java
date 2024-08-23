package com.meng.core.domain;

import lombok.Data;

import static com.meng.core.constant.HttpStatus.*;

@Data
public class R<T> {
    private Integer code;
    private String msg;
    private T data;
    public static <T> R<T> ok()
    {
        return restResult(null, SUCCESS, "操作成功");
    }

    public static <T> R<T> ok(T data)
    {
        return restResult(data, SUCCESS, "操作成功");
    }

    public static <T> R<T> ok(T data, String msg)
    {
        return restResult(data, SUCCESS, msg);
    }

    public static <T> R<T> fail()
    {
        return restResult(null, ERROR, "操作失败");
    }

    public static <T> R<T> fail(String msg)
    {
        return restResult(null, ERROR, msg);
    }

    public static <T> R<T> fail(T data)
    {
        return restResult(data, ERROR, "操作失败");
    }

    public static <T> R<T> fail(T data, String msg)
    {
        return restResult(data, ERROR, msg);
    }

    public static <T> R<T> fail(int code, String msg)
    {
        return restResult(null, code, msg);
    }




    public static <T> R<T> warn(String msg)
    {
        return restResult(null, WARN, msg);
    }

    private static <T> R<T> restResult(T data, int code, String msg)
    {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
