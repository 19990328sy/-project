package com.miaosha.exception;

/**
 * 重复秒杀异常(运行的时候异常)
 */
public class RepeatMiaoshaException extends MiaoshaException{

    public RepeatMiaoshaException(String message){
        super(message);
    }

    public RepeatMiaoshaException(String message,Throwable cause){
        super(message,cause);
    }
}
