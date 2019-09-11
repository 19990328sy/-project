package com.miaosha.exception;

/**
 * 秒杀关闭后异常
 */
public class MiaoshaCloseException extends MiaoshaException{
    public MiaoshaCloseException(String message) {
        super( message );
    }

    public MiaoshaCloseException(String message, Throwable cause) {
        super( message, cause );
    }
}
