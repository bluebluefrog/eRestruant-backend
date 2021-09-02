package com.wjb.eRestruant.enums;

import lombok.Getter;

@Getter
public enum ResponseEnum {

    ERROR(-1,"ERROR"),

    SUCCESS(0,"SUCCESS"),

    PASSWORD_ERROR(1,"PASSWORD_ERROR"),

    USERNAME_EXIST(2,"USERNAME_EXIST"),

    PARAM_ERROR(3,"PARAM_ERROR"),

    EMAIL_EXIST(4,"EMAIL_EXIST"),

    USERNAME_OR_PASSWORD_ERROR(5,"USERNAME_OR_PASSWORD_ERROR"),

    NEED_LOGIN(10,"NEED_LOGIN"),

    UPDATE_FAIL(20,"UPDATE_FAIL"),
                    ;
    Integer code;

    String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
