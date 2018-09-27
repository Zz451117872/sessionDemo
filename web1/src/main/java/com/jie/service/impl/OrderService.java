package com.jie.service.impl;

import com.jie.dao.OrderDao;
import com.jie.model.Order;
import com.jie.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderService implements IOrderService{

    @Autowired
    private OrderDao orderDao;

    public Object addOrder(Order order) {
        return orderDao.insertOrder( order );
    }

    public Object selectOne(Integer oid) {
        return orderDao.selectOne( oid );
    }

    public Object selectAll() {
        return orderDao.selectAll();
    }

    public Object updateOrder(Integer oid, Long version) {
        return orderDao.updateOrder( oid ,version );
    }
}
