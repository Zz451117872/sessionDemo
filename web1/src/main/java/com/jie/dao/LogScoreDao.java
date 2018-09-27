package com.jie.dao;

import com.jie.model.LogAnt;
import com.jie.model.LogScore;
import com.jie.model.ScoreJoinAnt;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface LogScoreDao {

    @Select("select * from logScore where id = #{logScoreId}")
    @Results({
            @Result( id = true ,property = "sid" , column =  "id"),
            @Result( property = "changeScore" , column =  "change_score"),
            @Result( property = "changeTime" , column =  "change_time"),
            @Result( property = "orderId" , column =  "order_id"),
            @Result( property = "version" , column =  "version"),
    })
    public LogScore selectOne(Integer logScoreId);

    @Select("select * from logScore")
//    @Results({
//            @Result( id = true ,property = "sid" , column =  "id"),
//            @Result( property = "changeScore" , column =  "change_score"),
//            @Result( property = "changeTime" , column =  "change_time"),
//            @Result( property = "orderId" , column =  "order_id"),
//            @Result( property = "version" , column =  "version"),
//    })
    @MapKey(value = "id")
    public Map selectAll();

    @Insert("insert into logScore(change_score,change_time,order_id,version) values ( #{logScore.changeScore} ,#{logScore.changeTime} ,#{logScore.orderId} ,#{logScore.version})  ")
    public Integer insertLogScore(@Param("logScore") LogScore logScore);

    @Update("update logScore set version = #{version} where id = #{logScoreId}")
    public Integer updateLogScore(@Param("logScoreId") Integer logScoreId ,@Param("version") Long version);

    @Select("select * from logScore where id = #{logScoreId}")
    @MapKey(value = "id")
    public Map selectOne2map(Integer logScoreId);

    @Select("select logScore.id as sid , logAnt.id as aid , logScore.order_id as oid , logScore.change_score as change_score, logAnt.change_ant as change_ant, logScore.change_time as change_time from logScore inner join logAnt  on logScore.order_id = logAnt.order_id")
//    @Results({
//            @Result( id = true , property = "oid" , column = "oid"),
//            @Result( property = "changeAnt" , column = "change_ant"),
//            @Result( property = "changeScore" , column = "change_score"),
//            @Result( property = "sid" , column = "sid"),
//            @Result( property = "changeTime" , column = "change_time"),
//            @Result( property = "aid" , column = "aid"),
//    })
    @MapKey(value = "oid")
    public Map selectLogAntJoinLogScore (Integer oid);

}
