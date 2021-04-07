package com.oeong.exception;

import com.oeong.enums.ResultEnum;

public class PhoneException extends RuntimeException {
    public PhoneException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
    }

    public PhoneException(String error) {
        super(error);
    }
}
