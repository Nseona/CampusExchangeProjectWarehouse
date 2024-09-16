package com.example.campusexchange.exception;

public class MapperException extends RuntimeException{
    private int statusCode;
    private String message;

    public MapperException(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public MapperException() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
