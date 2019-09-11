package com.miaosha.exception;

/**
 * 秒杀异常
 */
public class MiaoshaException extends RuntimeException{
    public MiaoshaException(String message) {
        super( message );
    }

    public MiaoshaException(String message, Throwable cause) {
        super( message, cause );
    }
}
