package com.sheng.hrt.dao;

import com.sheng.hrt.po.UserPointBill;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserPointBillDao {
    @Select("select * from user_point_bill")
    List<UserPointBill> getAllUserPointBill();
    @Insert("INSERT INTO user_point_bill(bill_id, point_id, channel_begin_points, channel_changed_points, channel_end_points, bill_type, relation_id, user_id, channel_name, create_time, app_name, change_reason, commission_ratio, fee_ratio, first_charge_mark, user_begin_points, user_changed_points, user_end_points, channel_id, target_point_name, test_name) " +
            "VALUES (null, #{point_id}, #{channel_begin_points}, #{channel_changed_points}, #{channel_end_points}, #{bill_type}, #{relation_id}, #{user_id}, #{channel_name}, #{create_time}, #{app_name}, #{change_reason}, #{commission_ratio}, #{fee_ratio}, #{first_charge_mark}, #{user_begin_points}, #{user_changed_points}, #{user_end_points}, #{channel_id}, #{target_point_name}, #{test_name})")
    void addUserPointBill(@Param("bill_id")String bill_id,
                            @Param("point_id")String point_id,
                            @Param("channel_begin_points")String channel_begin_points,
                            @Param("channel_changed_points")String channel_changed_points,
                            @Param("channel_end_points")String channel_end_points,
                            @Param("bill_type")String bill_type,
                            @Param("relation_id")String relation_id,
                            @Param("user_id")String user_id,
                            @Param("channel_name")String channel_name,
                            @Param("create_time")String create_time,
                            @Param("app_name")String app_name,
                            @Param("change_reason")String change_reason,
                            @Param("commission_ratio")String commission_ratio,
                            @Param("fee_ratio")String fee_ratio,
                            @Param("first_charge_mark")String first_charge_mark,
                            @Param("user_begin_points")String user_begin_points,
                            @Param("user_changed_points")String user_changed_points,
                            @Param("user_end_points")String user_end_points,
                            @Param("channel_id")String channel_id,
                            @Param("target_point_name")String target_point_name,
                            @Param("test_name")String test_name);
    @Delete("delete from user_point_bill where bill_id=#{bill_id}")
    void delUserPointBill(@Param("bill_id") String bill_id);
}