package com.miaosha.dao;

import com.miaosha.entity.Miaosha;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MiaoshaDao {

    /**
     * 减库存
     * @param miaoshaId
     * @param miaoshaTime
     * @return 如果影响行数>1,表示这个数据已经更新
     */
    int reduceNumber(@Param("miaoshaId")long miaoshaId, @Param("miaoshaTime")Date miaoshaTime);

    /**
     *根据id查询秒杀对象
     * @param miaoshaId
     * @return
     */
    Miaosha queryById(long miaoshaId);

    /**
     * 根据偏移量查询秒杀商品
     * @param offset
     * @param limit
     * @return
     */
    List<Miaosha> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
