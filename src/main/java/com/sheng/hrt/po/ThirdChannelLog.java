package com.sheng.hrt.po;

import lombok.Data;

@Data
public class ThirdChannelLog {
    private String id;
    private String create_time;
    private String state_change;
    private String operator_id;
    private String remark;
    private String test_name;
}