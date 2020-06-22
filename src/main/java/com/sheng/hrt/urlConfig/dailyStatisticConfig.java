package com.sheng.hrt.urlConfig;

/** 数据报表url配置表
 *
 */
public class dailyStatisticConfig {
    /** 数据报表 根目录
     *
     */
    public static String baseUrl = BaseUrl.BaseUrl + "/dailyStatistic";
    /** 获取数据报表聚合数据
     *
     */
    public static String getData = baseUrl + "/data";
    /** 导出数据报表
     *
     */
    public static String export  = baseUrl + "/export";
    /** 获取数据报表（分页）
     *
     */
    public static String page    = baseUrl + "/page";
}
