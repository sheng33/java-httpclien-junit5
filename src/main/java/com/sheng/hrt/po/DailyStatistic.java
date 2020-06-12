package com.sheng.hrt.po;

import lombok.Data;

@Data
public class DailyStatistic {
    private String id;
    private String point_id;
    private String create_time;
    private String issue_amount;
    private String consume_amount;
    private String commision_amount;
    private String register_num;
    private String issue_count;
    private String issue_people_num;
    private String test_name;
}
