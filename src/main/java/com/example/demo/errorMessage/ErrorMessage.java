package com.example.demo.errorMessage;

import lombok.Data;

public @Data class ErrorMessage {
    private String message;

   
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorMessage(String message) {
        this.message = message;
    }

    public ErrorMessage() {
    }

    

}
