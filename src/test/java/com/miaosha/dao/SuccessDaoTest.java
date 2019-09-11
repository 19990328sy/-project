package com.miaosha.dao;

import com.miaosha.entity.SuccessMiaosha;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessDaoTest {

    @Resource
    private SuccessDao successDao;

    @Test
    public void insertSuccessMiaosha() {
        long id=2343L;
        long phone=13244567896L;
        int insertCount=successDao.insertSuccessMiaosha(id,phone);
        System.out.println("insertCount="+ insertCount);
    }

    @Test
    public void queryByIdWithMiaosha() {
        long id=1000L;
        long phone=13244567896L;
        SuccessMiaosha successMiaosha=successDao.queryByIdWithMiaosha(id,phone);
        System.out.println(successMiaosha);
        System.out.println(successMiaosha.getMiaosha());

    }
}