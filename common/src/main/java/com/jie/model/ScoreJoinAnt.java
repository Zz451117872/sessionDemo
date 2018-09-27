package com.jie.model;

import java.io.Serializable;

public class ScoreJoinAnt implements Serializable {

    private Integer aid;
    private Integer sid;
    private Integer oid;
    private Double changeAnt;
    private Double changeScore;
    private Integer changeTime;

    @Override
    public String toString() {
        return "ScoreJoinAnt{" +
                "aid=" + aid +
                ", sid=" + sid +
                ", oid=" + oid +
                ", changeAnt=" + changeAnt +
                ", changeScore=" + changeScore +
                ", changeTime=" + changeTime +
                '}';
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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
}
