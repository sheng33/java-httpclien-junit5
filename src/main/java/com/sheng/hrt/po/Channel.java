package com.sheng.hrt.po;

import lombok.Data;

@Data
public class Channel {
    private String channel_id;
    private String channel_name;
    private String channel_daily_threshold;
    private String channel_daily_user_threshold;
    private String channel_start_time;
    private String channel_end_time;
    private String point_id;
    private String channel_status;
    private String test_name;
}
