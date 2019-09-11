package com.miaosha.service.impl;

import com.miaosha.dao.MiaoshaDao;
import com.miaosha.dao.SuccessDao;
import com.miaosha.dto.Exposer;
import com.miaosha.dto.MiaoshaExecution;
import com.miaosha.entity.Miaosha;
import com.miaosha.entity.SuccessMiaosha;
import com.miaosha.enums.MiaoshaStatEnum;
import com.miaosha.exception.MiaoshaCloseException;
import com.miaosha.exception.MiaoshaException;
import com.miaosha.exception.RepeatMiaoshaException;
import com.miaosha.service.MiaoshaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;


@Service
@Transactional
public class MiaoshaServiceImpl implements MiaoshaService {
    @Autowired
    private MiaoshaDao miaoshaDao;

    @Autowired
    private SuccessDao successDao;

    //用于混淆md5,
    private static final String slat = "sdcbbdguyg^&^$%^*GSQGSI!US*&wd?dwJHW@^^&g";

    public List<Miaosha> getMiaoshaList() {
        return miaoshaDao.queryAll( 0,4 );
    }

    public Miaosha getById(long miaoshaId) {
        return miaoshaDao.queryById( miaoshaId );
    }

    public Exposer exportMiaoshaUrl(long miaoshaId) {
        Miaosha miaosha=miaoshaDao.queryById( miaoshaId );
        if (miaosha==null){
            return new Exposer( false,miaoshaId );
        }
        Date startTime=miaosha.getStartTime();
        Date endTime=miaosha.getEndTime();
        Date nowTime=new Date();
        if (nowTime.getTime()<startTime.getTime()|| nowTime.getTime()>endTime.getTime()){
            return new Exposer( false,miaoshaId,nowTime.getTime(),startTime.getTime(),endTime.getTime() );
        }
        //转化指定的字符串
        String md5=getMD5( miaoshaId );
        return new Exposer( true, md5,miaoshaId);
    }

    private String getMD5(long miaoshaId){
        String base=miaoshaId+"/"+slat;
        String md5= DigestUtils.md5DigestAsHex( base.getBytes() );
        return md5;
    }

    public MiaoshaExecution executeMiaosha(long miaoshaId, long userPhone, String md5) throws MiaoshaException, RepeatMiaoshaException, MiaoshaCloseException {
        if (md5==null || !md5.equals( getMD5( miaoshaId ) )){
            throw new MiaoshaException( "miaosha data rewrite" );
        }
        Date nowTime=new Date();
        try {
            int updateCount =miaoshaDao.reduceNumber( miaoshaId,nowTime );
            if (updateCount<=0){
                throw new MiaoshaCloseException( "miaosha is close" );
            }else {
                //记录购买的行为
                int insertCount=successDao.insertSuccessMiaosha( miaoshaId,userPhone );
                //唯一的
                if (insertCount<=0){
                    throw new RepeatMiaoshaException( "秒杀重复" );
                }else {
                    SuccessMiaosha successMiaosha=successDao.queryByIdWithMiaosha( miaoshaId,userPhone);
                    return new MiaoshaExecution(miaoshaId, MiaoshaStatEnum.SUCCESS,successMiaosha);
                }
            }
        }catch (MiaoshaCloseException e1){
            throw e1;
        }catch (RepeatMiaoshaException e2){
            throw e2;
        }
        catch (Exception e){
            //所有运行期的异常，转化为运行期异常
            throw  new MiaoshaException( "秒杀失败"+e.getMessage() );

        }
    }
}
