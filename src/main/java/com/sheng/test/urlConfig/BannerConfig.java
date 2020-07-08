package com.sheng.test.urlConfig;

/** banner管理Url配置表
 *
 */
public class BannerConfig {
    /** banner管理根目录
     *
     */
    public static String baseUrl = BaseUrlConfig.baseUrl+"manage/banner";
    /** 删除按钮 DELETE
     *
     */
    public static String delete = baseUrl;
    /** banner列表 GET
     *
     */
    public static String list = baseUrl+"/list";
    /** 新增｜修改更新Banner POST
     *
     */
    public static String save = baseUrl+"/save";
    /** 获取Banner类型列表 GET
     *
     */
    public static String types = baseUrl+"/types";
    /** 下架Banner PUT
     *
     */
    public static String updateToOffline = baseUrl+"/updateToOffline/";
    /** 上架Banner PUT
     *
     */
    public static String updateToOnline = baseUrl+"/updateToOnline/";
}
