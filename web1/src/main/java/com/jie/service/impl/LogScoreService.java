package com.jie.service.impl;

import com.jie.dao.LogScoreDao;
import com.jie.model.LogScore;
import com.jie.service.ILogScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("logScoreService")
public class LogScoreService implements ILogScoreService{

    @Autowired
    private LogScoreDao logScoreDao;


    public Object selectLogAntJoinLogScore(Integer orderId) {
        return logScoreDao.selectLogAntJoinLogScore( orderId );
    }

    public Object selectOne2map(Integer sid) {
        return logScoreDao.selectOne2map( sid );
    }

    public Object addLogScore(LogScore logScore) {
        return logScoreDao.insertLogScore( logScore );
    }

    public Object selectOne(Integer sid) {
        return logScoreDao.selectOne( sid );
    }

    public Object selectAll() {
        return logScoreDao.selectAll();
    }

    public Object updateLogScore(Integer sid, Long version) {
        return logScoreDao.updateLogScore( sid , version );
    }
}
