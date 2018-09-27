package com.jie.service;

import com.jie.model.LogScore;

public interface ILogScoreService {
    Object addLogScore(LogScore logScore);

    Object selectOne(Integer sid);

    Object selectAll();

    Object updateLogScore(Integer sid, Long version);

    Object selectOne2map(Integer sid);

    Object selectLogAntJoinLogScore(Integer orderId);
}
