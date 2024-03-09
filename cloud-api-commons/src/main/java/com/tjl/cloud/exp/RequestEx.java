package com.tjl.cloud.exp;

import lombok.Data;

@Data
public class RequestEx extends RuntimeException{
    int code;
    String msg;

    public RequestEx() {
        super();
    }

    public RequestEx(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public RequestEx(String message, int code, String msg) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public RequestEx(String message, Throwable cause, int code, String msg) {
        super(message, cause);
        this.code = code;
        this.msg = msg;
    }
}