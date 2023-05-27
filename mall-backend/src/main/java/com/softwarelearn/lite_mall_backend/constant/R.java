package com.softwarelearn.lite_mall_backend.constant;

import lombok.Data;

import java.util.HashMap;

/**
 * 结果通用类
 * @author linorman
 * @data 2023/04/16
 */
@Data
public class R {
    private int success;
    private int code;
    private String message;
    private Object data;
    private HashMap<Object, Object> map = new HashMap<>();

    public static R success(ResultCode resultCode, Object data) {
        R r = new R();
        r.success = 1;
        r.setCode(resultCode.getCode());
        r.setMessage(resultCode.getMsg());
        r.setData(data);
        return r;
    }

    public static R error(ResultCode resultCode, Object data) {
        R r = new R();
        r.success = 0;
        r.setCode(resultCode.getCode());
        r.setMessage(resultCode.getMsg());
        r.setData(data);
        return r;
    }

    public R put(Object key, Object value) {
        map.put(key, value);
        return this;
    }
}
