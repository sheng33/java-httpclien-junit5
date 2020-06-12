package com.sheng.hrt.po;

import lombok.Data;

@Data
public class ThirdChannel {
    private Integer channel_id;
    private String channel_name;
    private Integer channel_daily_threshold;
    private Integer channel_daily_user_threshold;
    private String channel_key;
    private String point_name;
    private String point_exchange_rate;
    private Integer charge_ratio;
    private Integer last_operator_id;
    private Integer channel_status;
    private String create_time;
}
