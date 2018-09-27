package com.jie.service.impl;

import com.jie.dao.LogAntDao;
import com.jie.model.LogAnt;
import com.jie.service.ILogAntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("logAntService")
public class LogAntService implements ILogAntService {

    @Autowired
    private LogAntDao logAntDao;

    public Object addLogAnt(LogAnt logAnt) {
        return logAntDao.insertLogAnt( logAnt );
    }

    public Object selectOne(Integer aid) {
        return logAntDao.selectOne( aid );
    }

    public Object selectAll() {
        return logAntDao.selectAll();
    }

    public Object updateLogAnt(Integer aid, Long version) {
        return logAntDao.updateLogAnt( aid , version );
    }
}
