package com.miaosha.dao;

import com.miaosha.entity.Miaosha;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 配置spring和junit整合,
 * spring-test,junit
 *
 * * */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class MiaoshaDaoTest {

    //注入dao实现类依赖
    @Resource
    private MiaoshaDao miaoshaDao;

    @org.junit.Test
    public void reduceNumber() throws Exception{
        Date miaoshaTime=new Date();
        int updateCount=miaoshaDao.reduceNumber(1000L,miaoshaTime);
        System.out.println("updateCount="+ updateCount);
    }

    @org.junit.Test
    public void queryById() throws Exception{
        long id=1000;
        Miaosha miaosha=miaoshaDao.queryById(id);
        System.out.println(miaosha.getName());
        System.out.println(miaosha);
    }

    @org.junit.Test
    public void queryAll() throws Exception{
        List<Miaosha> miaoshas=miaoshaDao.queryAll(0,100);
        for (Miaosha miaosha:miaoshas){
            System.out.println(miaosha);
        }
    }
}