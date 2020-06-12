package com.sheng.hrt.dao;

import com.sheng.hrt.po.TestPlan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ThirdChannelDao {
    @Select("select * from third_channel")
    List<TestPlan> getAllThirdChannel();
    @Insert("insert into third_channel(channel_id,channel_name,channel_daily_threshold,channel_daily_user_threshold,channel_key,point_name,point_exchange_rate,charge_ratio,last_operator_id,channel_status,create_time)" +
            "values(null,#{channel_name},#{channel_daily_threshold},#{channel_daily_user_threshold},#{channel_key},#{point_name},#{point_exchange_rate},#{charge_ratio},#{last_operator_id},#{channel_status},#{create_time})")
    void addThirdChannel(@Param("channel_name") String channel_name, @Param("channel_daily_threshold") String channel_daily_threshold,
                     @Param("channel_daily_user_threshold") String channel_daily_user_threshold, @Param("channel_key") String channel_key,
                     @Param("point_name") String point_name,@Param("point_exchange_rate") String point_exchange_rate,
                     @Param("charge_ratio") String charge_ratio,@Param("last_operator_id") String last_operator_id,
                     @Param("channel_status") String channel_status,@Param("create_time") String create_time);
    @Delete("delete from third_channel where id=#{channel_id}")
    void delThirdChannel(@Param("channel_id") String channel_id);

}
