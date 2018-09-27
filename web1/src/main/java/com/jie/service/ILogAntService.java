package com.jie.service;

import com.jie.model.LogAnt;

public interface ILogAntService {
    Object addLogAnt(LogAnt logAnt);

    Object selectOne(Integer aid);

    Object selectAll();

    Object updateLogAnt(Integer aid, Long version);
}
