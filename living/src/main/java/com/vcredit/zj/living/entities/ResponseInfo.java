package com.vcredit.zj.living.entities;

import java.io.Serializable;

/**
 * Created by shibenli on 2016/11/16.
 */

public class ResponseInfo<T> implements Serializable{
    public int code;

    public String message;

    public T data;

    public int getCode() {
        return code;
    }

    public ResponseInfo setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseInfo setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseInfo setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "ResponseInfo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
