package com.jie.service;

import com.jie.model.Order;

public interface IOrderService {

    Object addOrder(Order order);

    Object selectOne(Integer oid);

    Object selectAll();

    Object updateOrder(Integer oid, Long version);
}
