package com.example.campusexchange.utils;

/**
 * @author Lucky
 * @version 1.0.0
 *
 * 该类用于规范化前后端信息交流
 *
 */

public class Result {
    private int statusCode;
    private Object data;
    private String message;

    public Result() {
    }

    public Result(int statusCode, Object data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public Result(int statusCode, Object data, String message) {
        this.statusCode = statusCode;
        this.data = data;
        this.message = message;
    }

    public Result(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "statusCode=" + statusCode +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
