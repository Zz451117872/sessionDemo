package com.jie.model;

import java.io.Serializable;

public class LogScore implements Serializable {

    private Integer sid;
    private Double changeScore;
    private Integer changeTime;
    private Integer orderId;
    private Long version;

    @Override
    public String toString() {
        return "LogScore{" +
                "sid=" + sid +
                ", changeScore=" + changeScore +
                ", changeTime=" + changeTime +
                ", orderId=" + orderId +
                ", version=" + version +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Double getChangeScore() {
        return changeScore;
    }

    public void setChangeScore(Double changeScore) {
        this.changeScore = changeScore;
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
