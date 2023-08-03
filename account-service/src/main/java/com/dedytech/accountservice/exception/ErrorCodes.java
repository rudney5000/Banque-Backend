package com.dedytech.accountservice.exception;

public enum ErrorCodes {

    ACCOUNT_NOT_FOUND(12000),
    ACCOUNT_NOT_VALID(12001),
    ACCOUNT_ALREADY_EXISTS(12002);

    private int code;

    ErrorCodes(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
