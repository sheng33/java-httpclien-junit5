package com.sheng.hrt.urlConfig;

/** 积分Url配置表
 *
 */
public class PointUrlConfig {
    /** 积分管理根目录
     *
     */
    public static String baseUrl = BaseUrlConfig.baseUrl + "/manage/point";
    /** 查询积分 GET
     *
     */
    public static String getPoint = baseUrl;
    /** 新增积分 POST
     *
     */
    public static String addPoint = baseUrl;
    /** 修改积分 PUT
     *
     */
    public static String updataPoint = baseUrl;
    /** 分页积分列表 GET
     *
     */
    public static String points = baseUrl + "/points";


}
