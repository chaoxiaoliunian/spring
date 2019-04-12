package com.sjqi.ssm.exception;

/**
 * @ClassName MyException
 * @Description 自定义异常
 * @Author sjqi
 * @Date 10:56 2019/4/12
 * @Version 1.0
 **/
public class MyException extends Exception {
    private String message;

    public MyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
