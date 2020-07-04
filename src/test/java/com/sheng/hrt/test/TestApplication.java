package com.sheng.hrt.test;

import com.sheng.hrt.until.ExtentUtils;
import com.sheng.hrt.until.SendHttp;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;
@ExtendWith(ExtentUtils.class)
@DisplayName("应用管理")
public class TestApplication {
    protected SendHttp sendHttp = new SendHttp();
//    protected Map<String,String> headers = BaseManage.headers;
//    protected Map<String,String> params = BaseManage.params;
    protected  Map<String,String> headers = new HashMap<>();
    protected  Map<String,String> params = new HashMap<>();
    @DisplayName("获取单个应用信息")
    @CsvSource({"存在,1","不存在,2"})
    @ParameterizedTest(name = "{0}")
    @Tag("获取元素")
    public void getApp(String name,String appId){
        Assert.assertEquals(1,appId);
    }
    @DisplayName("新增 应用")
    @CsvFileSource(resources = "/resources/应用数据.csv",numLinesToSkip = 1)
    @ParameterizedTest(name = "{0}")
    @Tag("新增")
    public void addApplication(String name,String appCode,String appImg,String appName
            ,String appSubtitle,String appUrl,String sort,String judge){
        //excel表为空时，赋值空格 而不是ct.getString("success"),judge);
        Assert.assertEquals(1,name);
    }

    @DisplayName("修改 应用")
    @CsvFileSource(resources = "/resources/应用数据.csv",numLinesToSkip = 1)
    @ParameterizedTest(name = "{0}")
    @Tag("修改")
    public void updateApplication(String name,String appCode,String appImg,String appName
            ,String appSubtitle,String appUrl,String sort,String judge){
        //excel表为空时，赋值空格 而不是null
        Assert.assertEquals(1,appCode);
    }

    @DisplayName("状态下拉")
    @Test
    @Tag("下拉列表")
    public void getPointsStates(){
        //常量配对
        /**
         *
         *
         *
         *
         */

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
    }

    @DisplayName("禁用 应用")
    @CsvSource({"禁用应用（存在）,469856733393719296,remark"
            ,"禁用应用（不存在),123456,faild"})
    @ParameterizedTest(name = "{0}")
    @Tag("禁用启用")
    public void updateToOffine(String name,String id,String remark){
    }

    @DisplayName("启用 应用")
    @CsvSource({"启用应用(存在),469856733393719296,remark2"
            ,"启用应用(不存在),123,remark2"})
    @ParameterizedTest(name = "{0}")
    @Tag("禁用启用")
    public void updateToOnline(String name,String id,String remark){
    }

    @DisplayName("删除应用")
    @CsvSource({"删除应用(存在),469856733393719296,remark2"
            ,"删除应用(不存在),123,remark2"})
    @ParameterizedTest(name = "{0}")
    @Tag("删除")
    public void delApps(String name,String id,String remark){
        Assert.assertEquals("123",id);
    }

}
