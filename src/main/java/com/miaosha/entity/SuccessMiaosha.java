package com.miaosha.entity;

import java.util.Date;

public class SuccessMiaosha {
    private long miaoshaId;

    private long userPhone;

    private short state;

    private Date createTime;

    //变通
    //一对多
    private Miaosha  miaosha;

    public Miaosha getMiaosha() {
        return miaosha;
    }

    public void setMiaosha(Miaosha miaosha) {
        this.miaosha = miaosha;
    }

    public long getMiaoshaId() {
        return miaoshaId;
    }

    public void setMiaoshaId(long miaoshaId) {
        this.miaoshaId = miaoshaId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SuccessMiaosha{" +
                "miaoshaId=" + miaoshaId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }
}
