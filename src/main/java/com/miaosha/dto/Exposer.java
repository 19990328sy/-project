package com.miaosha.dto;

public class Exposer {

    private boolean exposed;

    private String md5;

    private long miaoshaId;

    private long now;

    private long start;

    private long end;

    public Exposer(boolean exposed, long miaoshaId) {
        this.exposed = exposed;
        this.md5 = this.md5;
        this.miaoshaId = miaoshaId;
    }

    public Exposer(boolean exposed, long now, long start, long end) {
        this.exposed = exposed;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean exposed, long id, long nowTimeTime, long time, long miaoshaId) {
        this.exposed = exposed;
        this.miaoshaId = miaoshaId;
    }

    public Exposer(boolean b, String md5, long miaoshaId) {
    }
}
