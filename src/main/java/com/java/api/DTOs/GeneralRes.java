package com.java.api.DTOs;

public class GeneralRes {

    private Boolean error;
    private String message;

    public GeneralRes () {
        this.error = false;
        this.message = "";
    }

    public GeneralRes(Boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "GeneralRes{" +
                "error=" + error +
                ", message='" + message + '\'' +
                '}';
    }
}
