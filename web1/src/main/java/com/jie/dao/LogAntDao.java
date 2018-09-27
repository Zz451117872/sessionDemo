package com.jie.dao;

import com.jie.model.LogAnt;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LogAntDao {

    @Select("select * from logAnt where id = #{logAntId}")
    @Results({
            @Result( id = true , property = "aid" , column = "id" ),
            @Result( property = "changeAnt" , column =  "change_ant"),
            @Result( property = "changeTime" , column =  "change_time"),
            @Result( property = "orderId" , column =  "order_id"),
            @Result( property = "version" , column =  "version"),
    })
    public LogAnt selectOne( Integer logAntId);

    @Select("select * from logAnt")
    @Results({
            @Result( id = true , property = "aid" , column = "id" ),
            @Result( property = "changeAnt" , column =  "change_ant"),
            @Result( property = "changeTime" , column =  "change_time"),
            @Result( property = "orderId" , column =  "order_id"),
            @Result( property = "version" , column =  "version"),
    })
    public List<LogAnt> selectAll();

    @Insert("insert into logAnt(change_ant,change_time,order_id,version) values ( #{logAnt.changeAnt} ,#{logAnt.changeTime} ,#{logAnt.orderId} ,#{logAnt.version})")
    public Integer insertLogAnt( @Param("logAnt")LogAnt logAnt);

    @Update("update logAnt set version = #{version} where id = #{logAntId}")
    public Integer updateLogAnt(@Param("logAntId")Integer logAntId , @Param("version")Long version);

}
