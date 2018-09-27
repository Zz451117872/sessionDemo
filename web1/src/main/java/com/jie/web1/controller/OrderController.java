package com.jie.web1.controller;

import com.jie.model.Order;
import com.jie.service.IOrderService;
import com.jie.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/addOrder")
    @ResponseBody
    public Object addOrder( Order order){
        System.out.println( "order: " + order.toString() );
        return orderService.addOrder( order );
    }

    @RequestMapping(value = "/selectOne")
    @ResponseBody
    public Object selectOne( Integer oid){
       return orderService.selectOne( oid );
    }

    @RequestMapping(value = "/selectAll")
    @ResponseBody
    public Object selectAll( ){
        return orderService.selectAll();
    }

    @RequestMapping(value = "/updateOrder")
    @ResponseBody
    public Object updateOrder( Integer oid , Long version){
        return orderService.updateOrder( oid , version );
    }
}
