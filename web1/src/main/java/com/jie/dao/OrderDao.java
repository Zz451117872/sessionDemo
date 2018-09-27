package com.jie.dao;

import com.jie.model.LogScore;
import com.jie.model.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDao {


    @Select("select * from orders where id = #{orderId}")
    @Results({
            @Result( id = true  , property = "oid" , column = "id") ,
            @Result( property = "changeAnt" , column = "change_ant"),
            @Result( property = "changeScore" , column = "change_score"),
            @Result( property = "changeTime" , column = "change_time"),
            @Result( property = "version" , column = "version")
    })
    public Order selectOne(Integer orderId);

    @Select("select * from orders")
    @Results({
            @Result( id = true  , property = "oid" , column = "id") ,
            @Result( property = "changeAnt" , column = "change_ant"),
            @Result( property = "changeScore" , column = "change_score"),
            @Result( property = "changeTime" , column = "change_time"),
            @Result( property = "version" , column = "version")
    })
    public List<Order> selectAll();

    @Insert("insert into orders(change_ant,change_score,change_time,version) values (#{order.changeAnt},#{order.changeScore},#{order.changeTime},#{order.version})")
    public Integer insertOrder(@Param("order") Order order);

    @Update("update orders set version = #{version} where id = #{orderId}")
    public Integer updateOrder(@Param("orderId") Integer orderId ,@Param("version") Long version);
}
