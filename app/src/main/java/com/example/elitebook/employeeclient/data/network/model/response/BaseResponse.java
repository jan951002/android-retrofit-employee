package com.example.elitebook.employeeclient.data.network.model.response;

import java.io.Serializable;

public class BaseResponse implements Serializable {

    private int status;
    private String message;
    private boolean success;

    public BaseResponse(int status, String message, boolean success) {
        this.status = status;
        this.message = message;
        this.success = success;
    }

    public BaseResponse() {

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
