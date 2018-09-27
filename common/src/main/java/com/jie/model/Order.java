package com.jie.model;

import java.io.Serializable;

public class Order implements Serializable{

    private Integer oid;
    private Double changeAnt;
    private Double changeScore;
    private Integer changeTime;
    private Long version;

    @Override
    public String
    toString() {
        return "Order{" +
                "oid=" + oid +
                ", changeAnt=" + changeAnt +
                ", changeScore=" + changeScore +
                ", changeTime=" + changeTime +
                ", version=" + version +
                '}';
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Double getChangeAnt() {
        return changeAnt;
    }

    public void setChangeAnt(Double changeAnt) {
        this.changeAnt = changeAnt;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
