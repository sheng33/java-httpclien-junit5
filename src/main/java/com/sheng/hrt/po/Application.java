package com.sheng.hrt.po;

import lombok.Data;

@Data
public class Application {
    private String app_id;
    private String app_name;
    private String app_code;
    private String app_subtitle;
    private String app_img;
    private String app_url;
    private int sort;
    private int app_status;
    private String last_operator_id;
    private String test_id;

}
