package com.sheng.hrt.urlConfig;

/** 应用管理Url配置表
 *
 */
public class ApplicationConfig {
    /** 应用管理
     *
     */
    public static String baseUrl = BannerConfig.baseUrl+"/manage/application";
    /** 获取单个用户 GET
     *
     */
    public static String getApp = baseUrl;
    /** 新增用户 POST
     *
     */

    public static String addApp = baseUrl;
    /** 修改应用 PUT
     *
     */
    public static String updataApp = baseUrl;
    /** 删除应用 DELETE
     *
     */
    public static String delApp = baseUrl;
    /** 获取应用下拉 GET
     *
     */
    public static String points = baseUrl + "/points";
    /** 分页 查询应用 GET
     *
     */
    public static String selectApps = baseUrl + "selectApps";
    /** 下架应用 PUT
     *
     */
    public static String updataToOffine = baseUrl + "/updataToOffine";
    /** 上架应用 PUT
     *
     */
    public static String updataToOnline = baseUrl + "/updataToOnline";









}