package com.sheng.test.urlConfig;

/** 数据报表url配置表
 *
 */
public class dailyStatisticConfig {
    /** 数据报表 根目录
     *
     */
    public static String baseUrl = BaseUrlConfig.baseUrl + "/manage/dailyStatistic";
    /** 抽佣面板
     *
     */
    public static String commissionData = baseUrl + "/commissionData";
    /** 抽佣面板(根据时间区间查询按日数据)
     *
     */
    public static String commissionDataDaily = baseUrl + "/commissionDataDaily";
    /** 查询消耗数据面板
     *
     */
    public static String consumeBoardData = baseUrl + "/consumeBoardData";
    /** 查询消耗数据面板(根据时间区间查询按日数据)
     *
     */
    public static String consumeBoardDataDaily = baseUrl + "/consumeBoardDataDaily";
    /** 服务费面板
     *
     */
    public static String feeData = baseUrl + "/feeData";
    /** 服务费面板(根据时间区间查询按日数据)
     *
     */
    public static String feeDataDaily = baseUrl + "/feeDataDaily";
    /** 查询发放数据面板
     *
     */
    public static String issueBoardData = baseUrl + "/issueBoardData";
    /** 查询发放数据面板(根据时间区间查询按日数据)
     *
     */
    public static String issueBoardDataDaily = baseUrl + "/issueBoardDataDaily";
    /** 获取数据报表聚合数据
     *
     */
    public static String data = baseUrl + "/data";
    /** 导出数据报表
     *
     */
    public static String export = baseUrl + "/export";
    /** 获取数据报表（分页）
     *
     */
    public static String pages = baseUrl + "/pages";
}
