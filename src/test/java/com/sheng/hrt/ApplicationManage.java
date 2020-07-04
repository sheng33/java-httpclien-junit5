package com.sheng.hrt;

import com.alibaba.fastjson.JSONObject;
import com.sheng.hrt.until.ExtentUtils;
import com.sheng.hrt.until.SendHttp;
import com.sheng.hrt.urlConfig.ApplicationConfig;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;
@ExtendWith(ExtentUtils.class)
@DisplayName("应用管理")
public class ApplicationManage {
    protected SendHttp sendHttp = new SendHttp();
    protected Map<String,String> headers = BaseManage.headers;
    protected Map<String,String> params = BaseManage.params;

    @DisplayName("获取单个应用信息")
    @CsvSource({"存在,1","不存在,2"})
    @ParameterizedTest(name = "{0}")
    @Tag("获取元素")
    public void getApp(String name,String appId){
        params.clear();
        params.put("appId",appId);
        JSONObject jsonObject = sendHttp.getHttp(ApplicationConfig.getApp,headers,params);
        System.out.println(jsonObject);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }
    @DisplayName("新增 应用")
    @CsvFileSource(resources = "/resources/应用数据.csv",numLinesToSkip = 1)
    @ParameterizedTest(name = "{0}")
    @Tag("新增")
    public void addApplication(String name,String appCode,String appImg,String appName
            ,String appSubtitle,String appUrl,String sort,String judge){
        //excel表为空时，赋值空格 而不是null
        appCode = appCode!=null?appCode:"";
        appImg = appImg!=null?appImg:"";
        appName = appName!=null?appName:"";
        appSubtitle = appSubtitle!=null?appSubtitle:"";
        appUrl = appUrl!=null?appUrl:"";
        sort = sort!=null?sort:"";
        String param = "{\n" +
                "\"appCode\": \""+appCode+"\"," +
                "\"appImg\": \""+appImg+"\"," +
                "\"appName\": \"\""+appName+"\"\"," +
                "\"appSubtitle\":\""+appSubtitle+"\"," +
                "\"appUrl\": \""+appUrl+"\"," +
                "\"sort\": \""+sort+"\"" +
                "}";
        JSONObject jsonObject = sendHttp.postHttp(ApplicationConfig.addApp,headers,param);
        Assert.assertEquals(jsonObject.getString("success"),judge);
    }

    @DisplayName("修改 应用")
    @CsvFileSource(resources = "/resources/应用数据.csv",numLinesToSkip = 1)
    @ParameterizedTest(name = "{0}")
    @Tag("修改")
    public void updateApplication(String name,String appCode,String appImg,String appName
            ,String appSubtitle,String appUrl,String sort,String judge){
        //excel表为空时，赋值空格 而不是null
        appCode = appCode!=null?appCode:"";
        appImg = appImg!=null?appImg:"";
        appName = appName!=null?appName:"";
        appSubtitle = appSubtitle!=null?appSubtitle:"";
        appUrl = appUrl!=null?appUrl:"";
        sort = sort!=null?sort:"";
        String param = "{\n" +
                "\"appCode\": \""+appCode+"\"," +
                "\"appImg\": \""+appImg+"\"," +
                "\"appName\": \"\""+appName+"\"\"," +
                "\"appSubtitle\":\""+appSubtitle+"\"," +
                "\"appUrl\": \""+appUrl+"\"," +
                "\"sort\": \""+sort+"\"" +
                "}";
        JSONObject jsonObject = sendHttp.postHttp(ApplicationConfig.updateApp,headers,param);
        Assert.assertEquals(jsonObject.getString("success"),judge);
    }

    @DisplayName("状态下拉")
    @Test
    @Tag("下拉列表")
    public void getPointsStates(){
        JSONObject jsonObject = sendHttp.getHttp(ApplicationConfig.points,headers);
        //常量配对
        /**
         *
         *
         *
         *
         */

        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @ParameterizedTest(name = "{0}")
    @CsvSource({
            "可查1-8,1,8",
            "可查1-10,1,10",
            "无数据10-20,2,10",
            "无数据0-0,0,0"
    })
    @DisplayName("分页 查询应用")
    @Tag("分页接口")
    public void getlist(String name,String Index,String pageSize){
        params.clear();
        //是否计算总数
        params.put("count","true");
        //第几页
        params.put("pageIndex",Index);
        //每页大小
        params.put("pageSize",pageSize);
        JSONObject jsonObject = sendHttp.getHttp(ApplicationConfig.selectApps,headers,params);
        Assert.assertEquals(jsonObject.get("code"),200);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @DisplayName("禁用 应用")
    @CsvSource({"禁用应用（存在）,469856733393719296,remark"
            ,"禁用应用（不存在),123456,faild"})
    @ParameterizedTest(name = "{0}")
    @Tag("禁用启用-应用")
    public void updateToOffine(String name,String id,String remark){
        params.clear();
        params.put("appId",id);
//        params.put("remark",remark);
        JSONObject jsonObject = sendHttp.putHttplj(ApplicationConfig.updateToOffine,headers,params);
        System.out.println(jsonObject);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @DisplayName("启用 应用")
    @CsvSource({"启用应用(存在),469856733393719296,remark2"
            ,"启用应用(不存在),123,remark2"})
    @ParameterizedTest(name = "{0}")
    @Tag("禁用启用")
    public void updateToOnline(String name,String id,String remark){
        params.clear();
        params.put("appId",id);
//        params.put("remark",remark);
        JSONObject jsonObject = sendHttp.putHttplj(ApplicationConfig.updateToOnline,headers,params);
        System.out.println(jsonObject);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @DisplayName("删除应用")
    @CsvSource({"删除应用(存在),469856733393719296,remark2"
            ,"删除应用(不存在),123,remark2"})
    @ParameterizedTest(name = "{0}")
    @Tag("删除")
    public void delApps(String name,String id,String remark){
        params.clear();
        params.put("appId",id);
        JSONObject jsonObject = sendHttp.deleteHttp(ApplicationConfig.delApp,headers,params);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

}