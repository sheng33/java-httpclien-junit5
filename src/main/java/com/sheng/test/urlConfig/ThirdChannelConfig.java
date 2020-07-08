package com.sheng.test.urlConfig;

/** 三方渠道api配置
 *
 */
public class ThirdChannelConfig {
    /** 三方渠道根地址
     *
     */
    public static String baseUrl = BaseUrlConfig.baseUrl+"/manage/thirdChannel";
    /** 获取单个渠道信息 GET
     *
     */
    public static String GetThirdChannel = baseUrl;
    /** 新增 三方渠道 POST
     *
     */
    public static String AddThirdChannel = baseUrl;
    /** 修改 三方渠道 PUT
     *
     */
    public static String UpDateThirdChannel = baseUrl;
    /** 状态 下拉列表 GET
     *
     */
    public static String channelStates = baseUrl+"/channelStates";
    /** 分页 查询三方渠道 GET
     *
     */
    public static String selectChannels = baseUrl+"/selectChannels";
    /** 禁用 三方渠道 PUT
     *
     */
    public static String updateToOffline = baseUrl+"/updateToOffline/";
    /** 启用 三方渠道 PUT
     *
     */
    public static String updateToOnline = baseUrl+"/updateToOnline/";

}
