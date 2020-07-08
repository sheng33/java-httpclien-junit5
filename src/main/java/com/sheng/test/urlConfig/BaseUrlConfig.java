package com.sheng.hrt.urlConfig;

/** 三方认证Url配置表
 *
 */
public class BaseUrlConfig {
    /** 根地址
     *
     */
    public static String baseUrl = "http://192.168.0.19:8084/";

    /** 三方认证
     *
     */
    public static String auth = baseUrl + "/api/third/auth";

    /** 文件上传
     *
     */
    public static String upload = baseUrl + "/manage/file/upload";
}
