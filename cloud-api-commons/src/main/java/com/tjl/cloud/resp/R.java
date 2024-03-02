package com.tjl.cloud.resp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * 统一返回类
 * @author TJL
 */
@Data
@Accessors(chain = true) //链式调用
public class R<T> implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;
    private Integer code;
    private String msg;
    private T data;
    private final long timestamp = System.currentTimeMillis();


    public R(){
    }
    public R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> R<T> ok(T data) {
        return new R<>(ReturnCodeEnum.RC200.getCode(), ReturnCodeEnum.RC200.getMsg(), data);
    }
    public static <T> R<T> ok() {
        return new R<>(ReturnCodeEnum.RC200.getCode(), ReturnCodeEnum.RC200.getMsg(), null);
    }
    public static <T> R<T> ok(String msg, T data) {
        return new R<>(ReturnCodeEnum.RC200.getCode(), msg, data);
    }

    public static <T> R<T> error() {
        return new R<>(ReturnCodeEnum.RC500.getCode(), ReturnCodeEnum.RC500.getMsg(), null);
    }
    public static <T> R<T> error(String msg) {
        return new R<>(ReturnCodeEnum.RC500.getCode(),msg, null);
    }

}
