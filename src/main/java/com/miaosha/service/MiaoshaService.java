package com.miaosha.service;


import com.miaosha.dto.Exposer;
import com.miaosha.dto.MiaoshaExecution;
import com.miaosha.entity.Miaosha;
import com.miaosha.exception.MiaoshaCloseException;
import com.miaosha.exception.MiaoshaException;
import com.miaosha.exception.RepeatMiaoshaException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 使用者的角度设计接口
 * 三个方面: 1.方法粒度 ,2,参数 3,返回类型(return 类型/异常)
 */
public interface MiaoshaService {

    /**
     * 查询所有的秒杀记录
     * @return
     */
    List<Miaosha> getMiaoshaList();
    /**
     * 查询单个的秒杀记录
     * @param miaoshaId
     * @return
     */
    Miaosha getById(long miaoshaId);

    /**
     * 秒杀开始的时候暴露秒杀的接口
     * @param miaoshaId
     */
   Exposer exportMiaoshaUrl(long miaoshaId);

    /**
     * 执行秒杀操作
     * @param miaoshaId
     * @param userPhone
     * @param md5
     */
   MiaoshaExecution executeMiaosha(long miaoshaId, long userPhone, String md5)
   throws MiaoshaException, RepeatMiaoshaException, MiaoshaCloseException;
}
