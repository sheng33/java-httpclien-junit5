package com.sheng.hrt.urlConfig;

/** 记录管理Url配置
 *
 */
public class ChannelRecordsConfig {
    public static String baseUrl = BaseUrlConfig.baseUrl + "/manage/userPointBill";
    /** 获取发放渠道记录 GET
     *
     */
    public static String channelRecords = baseUrl + "/channelRecords";
    /** 获取抽佣记录 GET
     *
     */
    public static String commissionRecords = baseUrl + "/commissionRecords";
    /** 获取积分记录 GET
     *
     */
    public static String pointRecords = baseUrl + "/pointRecords";
    /** 获取回兑记录 GET
     *
     */
    public static String reExchangeRecords = baseUrl + "/reExchangeRecords";
}
