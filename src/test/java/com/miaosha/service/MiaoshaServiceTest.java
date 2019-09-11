package com.miaosha.service;

import com.miaosha.dto.Exposer;
import com.miaosha.dto.MiaoshaExecution;
import com.miaosha.entity.Miaosha;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring.xml"
})
public class MiaoshaServiceTest {
    private final Logger logger=LoggerFactory.getLogger( this.getClass());

    @Autowired
    private MiaoshaService miaoshaService;

    @Test
    public void getMiaoshaList() {
        List<Miaosha> list=miaoshaService.getMiaoshaList();
        logger.info( "list={}",list );
    }


    @Test
    public void getById() {
        long id=1000;
        Miaosha miaosha=miaoshaService.getById( id );
        logger.info( "miaosha={}",miaosha );
    }

    @Test
    public void exportMiaoshaUrl() {
         long id=1000;
         Exposer exposer =miaoshaService.exportMiaoshaUrl( id );
         logger.info( "exposer={}",exposer );

    }

    @Test
    public void executeMiaosha() {
        long id=1000;
        long phone=18211748049L;
        String md5="1hge0zoa578ctew14iir2k";
       MiaoshaExecution miaoshaExecution= miaoshaService.executeMiaosha(id,phone,md5);
       logger.info( "result={}",miaoshaExecution);

    }
}