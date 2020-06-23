package com.sheng.hrt;

import com.alibaba.fastjson.JSONObject;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.sheng.hrt.until.ExtentUtils;
import com.sheng.hrt.until.SendHttp;
import com.sheng.hrt.urlConfig.BannerConfig;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

@ExtendWith(ExtentUtils.class)
@DisplayName("Banner管理接口")
public class BannerManage {
    protected SendHttp sendHttp = new SendHttp();
    protected Map<String,String> headers = BaseManage.headers;
    protected Map<String,String> params = BaseManage.params;
    private static String bannerId;

    @ParameterizedTest
    @CsvSource({
            "1,8",
            "1,10",
            "2,10",
            "0,0"
    })
    @DisplayName("查找Banner")
    public void getlist(String Index,String pageSize){
        params.clear();
        //是否计算总数
        params.put("count","true");
        //第几页
        params.put("pageIndex",Index);
        //每页大小
        params.put("pageSize",pageSize);
        JSONObject jsonObject = sendHttp.getHttp(BannerConfig.list,headers,params);
        Assert.assertEquals(jsonObject.get("code"),200);
        jsonObject = jsonObject.getJSONObject("data");
        jsonObject = jsonObject.getJSONArray("rows").getJSONObject(0);
        bannerId = jsonObject.getString("id");
    }

    @DisplayName("创建Banner")
    @ParameterizedTest
    @CsvFileSource(resources = "/resources/Banner接口数据.csv",numLinesToSkip = 1)
    public void addBanner(String type,String goalId,String bannerName,String bannerPic,String createTime,String id,String sort,String judge){
        type = type!=null?type:"";
        goalId = goalId!=null?goalId:"";
        bannerName = bannerName!=null?bannerName:"";
        bannerPic = bannerPic!=null?bannerPic:"";
        createTime = createTime!=null?createTime:"";
        id = id!=null?id:"";
        sort = sort!=null?sort:"";
        String param = "{\"attribute\":\"{\\\"targetId\\\":"+goalId+"}\""+
                ",\"bannerName\":\""+bannerName+"\"" +
                ",\"bannerPic\":\""+bannerPic+"\"" +
                ",\"createTime\":\""+createTime+"\"" +
                ",\"id\": \""+id+"\"" +
                ",\"sort\":\""+sort+"\",\"type\":\""+type+"\"}";
        JSONObject jsonObject = sendHttp.postHttp(BannerConfig.save,headers,param);
        Assert.assertEquals(jsonObject.get("success"),Boolean.parseBoolean(judge.toLowerCase()));
    }

    @DisplayName("获取banner列表")
    @Test
    public void getBannerlist(){
        JSONObject jsonObject = sendHttp.getHttp(BannerConfig.types,headers);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @DisplayName("下架Banner")
    @CsvSource({"472497518299713536","472490190833848320"})
    @ParameterizedTest
    public void updateToOffine(String id){
        params.clear();
        params.put("bannerId",id);
        JSONObject jsonObject = sendHttp.putHttplj(BannerConfig.updateToOffline,headers,params);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @DisplayName("上架Banner")
    @CsvSource({"472497518299713536","472490190833848320"})
    @ParameterizedTest
    public void updateToOnline(String id){
        params.clear();
        params.put("bannerId",id);
        JSONObject jsonObject = sendHttp.putHttplj(BannerConfig.updateToOnline,headers,params);
        System.out.println(jsonObject);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @DisplayName("删除Banner")
    @Test
    public void delBanner(){
        params.clear();
        params.put("bannerId",bannerId);
        JSONObject jsonObject = sendHttp.getHttp(BannerConfig.delete,headers,params);
    }

}
