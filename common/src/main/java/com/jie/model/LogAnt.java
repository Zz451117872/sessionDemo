package com.jie.model;

import java.io.Serializable;

public class LogAnt implements Serializable{

    private Integer aid;
    private Double changeAnt;
    private Integer changeTime;
    private Integer orderId;
    private Long version;

    @Override
    public String toString() {
        return "LogAnt{" +
                "aid=" + aid +
                ", changeAnt=" + changeAnt +
                ", changeTime=" + changeTime +
                ", orderId=" + orderId +
                ", version=" + version +
                '}';
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Double getChangeAnt() {
        return changeAnt;
    }

    public void setChangeAnt(Double changeAnt) {
        this.changeAnt = changeAnt;
    }

    public Integer getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Integer changeTime) {
        this.changeTime = changeTime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
