package com.sheng.hrt.po;

import lombok.Data;

@Data
public class UserPointBill {
    private String bill_id;
    private String point_id;
    private String channel_begin_points;
    private String channel_changed_points;
    private String channel_end_points;
    private String bill_type;
    private String relation_id;
    private String user_id;
    private String channel_name;
    private String create_time;
    private String app_name;
    private String change_reason;
    private String commission_ratio;
    private String fee_ratio;
    private String first_charge_mark;
    private String user_begin_points;
    private String user_changed_points;
    private String user_end_points;
    private String channel_id;
    private String target_point_name;
    private String test_name;
}
