package com.sheng.hrt.dao;

import com.sheng.hrt.po.Channel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ChannelDao {
    @Select("select * from channel")
    List<Channel> getAllChannel();
    @Insert("insert into channel(channel_id,channel_name,channel_daily_threshold,channel_daily_user_threshold,channel_start_time," +
            "channel_end_time,point_id,channel_status,test_name)" +
            "values(null,#{channel_name},#{channel_daily_threshold},#{channel_daily_user_threshold},#{channel_start_time}" +
            ",#{channel_end_time},#{point_id},#{channel_status},#{test_name})")
    void addChannel(@Param("channel_name") String channel_name, @Param("channel_daily_threshold") String channel_daily_threshold,
                    @Param("channel_daily_user_threshold") String channel_daily_user_threshold, @Param("channel_start_time") String channel_start_time,
                    @Param("channel_end_time") String channel_end_time, @Param("point_id") String point_id, @Param("channel_status") String channel_status,
                    @Param("test_name") String test_name);
    @Delete("delete from channel where channel_id=#{channel_id}")
    void delChannel(@Param("channel_id") String channel_id);
}
