package com.miaosha.dto;

import com.miaosha.entity.SuccessMiaosha;
import com.miaosha.enums.MiaoshaStatEnum;

/**
 * 封装执行秒杀后的接口
 */
public class MiaoshaExecution {

    //秒杀执行结果状态
    private long miaoshaId;

    //状态表示
    private int state;

    //秒杀成功对象
    private String stateInfo;

    private SuccessMiaosha successMiaosha;

    public MiaoshaExecution(long miaoshaId, MiaoshaStatEnum statEnum, SuccessMiaosha successMiaosha) {
        this.miaoshaId = miaoshaId;
        this.state = state;
        this.stateInfo=statEnum.getStateInfo();
        this.successMiaosha = successMiaosha;
    }

    public MiaoshaExecution(long miaoshaId,MiaoshaStatEnum statEnum) {
        this.miaoshaId = miaoshaId;
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public long getMiaoshaId() {
        return miaoshaId;
    }

    public void setMiaoshaId(long miaoshaId) {
        this.miaoshaId = miaoshaId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessMiaosha getSuccessMiaosha() {
        return successMiaosha;
    }

    public void setSuccessMiaosha(SuccessMiaosha successMiaosha) {
        this.successMiaosha = successMiaosha;
    }
}
