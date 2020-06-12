package com.sheng.hrt.dao;


import com.sheng.hrt.po.ChannelLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ChannelLogDao {
    @Select("select * from channel_log")
    List<ChannelLog> getAllChannelLog();
    @Insert("insert into channel_log(id,create_time,state_change,operator_id,remark)" +
            "values(null,#{create_time},#{state_change},#{operator_id},#{remark})")
    void addChannelLog(@Param("create_time") String create_time, @Param("state_change") String state_change,
                    @Param("operator_id") String operator_id, @Param("remark") String remark);
    @Delete("delete from channel_log where id=#{id}")
    void delChannelLog(@Param("id") String id);
}
