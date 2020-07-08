package com.sheng.test.urlConfig;


/** 渠道表Url配置表
 *
 */
public class ChannelUrlConfig {
    public static String baseUrl = BaseUrlConfig.baseUrl + "/manage/channel";
    /** 获取单个积分渠道信息 GET
     *
     */
    public static String getChannel = baseUrl;
    /** 新增 积分渠道 POST
     *
     */
    public static String addChannel = baseUrl;
    /** 修改 积分渠道 PUT
     *
     */
    public static String updataChannel = baseUrl;
    /** 状态下拉 GET
     *
     */
    public static String channelStates = baseUrl + "/channelStates";
    /** 获取积分选择下拉 GET
     *
     */
    public static String points = baseUrl + "/points";
    /** 分页查询渠道 GET
     *
     */
    public static String selectChannels = baseUrl + "/selectChannels";
    /** 禁用 积分渠道 PUT
     *
     */
    public static String updateToOffline  = baseUrl + "/updateToOffline/";
    /** 启用 积分渠道 PUT
     *
     */
    public static String updateToOnline = baseUrl + "/updateToOnline/";

}
