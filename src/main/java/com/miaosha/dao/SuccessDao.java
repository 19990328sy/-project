package com.miaosha.dao;

import com.miaosha.entity.SuccessMiaosha;
import org.apache.ibatis.annotations.Param;

public interface SuccessDao {

    /**
     * 插入秒杀明细，过滤重复的
     * @param miaoshaId
     * @param userPhone
     * @return
     * 插入的行数
     */
    int insertSuccessMiaosha(@Param("miaoshaId") long miaoshaId, @Param("userPhone") long userPhone);

    /**
     * 根据id查询successMiaosha并携带秒杀商品对象实体类
     * @param miaoshaId
     * @return
     */
    SuccessMiaosha queryByIdWithMiaosha(@Param("miaoshaId") long miaoshaId, @Param("userPhone") long userPhone);

}
