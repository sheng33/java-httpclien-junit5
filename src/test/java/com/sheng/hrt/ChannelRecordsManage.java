package com.sheng.hrt;

import com.alibaba.fastjson.JSONObject;
import com.sheng.hrt.until.ExtentUtils;
import com.sheng.hrt.until.SendHttp;
import com.sheng.hrt.urlConfig.ChannelRecordsConfig;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;
@ExtendWith(ExtentUtils.class)
@DisplayName("记录管理")
public class ChannelRecordsManage {
    protected SendHttp sendHttp = new SendHttp();
    protected Map<String,String> headers = BaseManage.headers;
    protected Map<String,String> params = BaseManage.params;

    @DisplayName("获取发放渠道记录")
    @CsvSource({",,,,,,,"})
    @ParameterizedTest(name = "{0}")
    @Tag("下拉列表")
    public void getChannelRecords(String name,String billType,String channelName,String count
            ,String pageIndex,String pageSize,String queryEndTimeStamp,String queryStartTimeStamp){
        billType = billType!=null?billType:"";
        channelName = channelName!=null?channelName:"";
        count = count!=null?count:"";
        pageIndex = pageIndex!=null?pageIndex:"";
        pageSize = pageSize!=null?pageSize:"";
        queryEndTimeStamp = queryEndTimeStamp!=null?queryEndTimeStamp:"";
        queryStartTimeStamp = queryStartTimeStamp!=null?queryStartTimeStamp:"";
        params.clear();
        params.put("billType",billType);
        params.put("channelName",channelName);
        params.put("count",count);
        params.put("pageIndex",pageIndex);
        params.put("pageSize",pageSize);
        params.put("queryEndTimeStamp",queryEndTimeStamp);
        params.put("queryStartTimeStamp",queryStartTimeStamp);
        JSONObject jsonObject = sendHttp.getHttp(ChannelRecordsConfig.channelRecords,headers,params);
        System.out.println(jsonObject);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @DisplayName("获取抽佣记录")
    @CsvSource({",,,,,,"})
    @ParameterizedTest(name = "{0}")
    @Tag("获取元素")
    public void getCommissionRecords(String name,String appName,String count
            ,String pageIndex,String pageSize,String queryEndTimeStamp,String queryStartTimeStamp){
        appName = appName!=null?appName:"";
        count = count!=null?count:"";
        pageIndex = pageIndex!=null?pageIndex:"";
        pageSize = pageSize!=null?pageSize:"";
        queryEndTimeStamp = queryEndTimeStamp!=null?queryEndTimeStamp:"";
        queryStartTimeStamp = queryStartTimeStamp!=null?queryStartTimeStamp:"";
        params.clear();
        params.put("appName",appName);
        params.put("count",count);
        params.put("pageIndex",pageIndex);
        params.put("pageSize",pageSize);
        params.put("queryEndTimeStamp",queryEndTimeStamp);
        params.put("queryStartTimeStamp",queryStartTimeStamp);
        JSONObject jsonObject = sendHttp.getHttp(ChannelRecordsConfig.commissionRecords,headers,params);
        System.out.println(jsonObject);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }
    @DisplayName("获取积分记录")
    @CsvSource({",,,,,,,,,"})
    @ParameterizedTest(name = "{0}")
    @Tag("获取元素")
    public void getPointRecords(String name,String billType,String count,String firstChargeMark
            ,String pageIndex,String pageSize,String pointCode,String queryEndTimeStamp
            ,String queryStartTimeStamp,String userId){
        billType = billType!=null?billType:"";
        firstChargeMark = firstChargeMark!=null?firstChargeMark:"";
        count = count!=null?count:"";
        pageIndex = pageIndex!=null?pageIndex:"";
        pageSize = pageSize!=null?pageSize:"";
        pointCode = pointCode!=null?pointCode:"";
        queryEndTimeStamp = queryEndTimeStamp!=null?queryEndTimeStamp:"";
        queryStartTimeStamp = queryStartTimeStamp!=null?queryStartTimeStamp:"";
        userId = userId!=null?userId:"";
        params.clear();
        params.put("billType",billType);
        params.put("count",count);
        params.put("firstChargeMark",firstChargeMark);
        params.put("pageIndex",pageIndex);
        params.put("pageSize",pageSize);
        params.put("pointCode",pointCode);
        params.put("queryEndTimeStamp",queryEndTimeStamp);
        params.put("queryStartTimeStamp",queryStartTimeStamp);
        params.put("userId",userId);
        JSONObject jsonObject = sendHttp.getHttp(ChannelRecordsConfig.pointRecords,headers,params);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }
    @DisplayName("获取回兑记录")
    @CsvSource({",,,,,,,"})
    @ParameterizedTest(name = "{0}")
    @Tag("获取元素")
    public void getReExchangeRecords(String name,String count
            ,String pageIndex,String pageSize,String queryEndTimeStamp
            ,String queryStartTimeStamp,String targetPointName,String userId){
        count = count!=null?count:"";
        pageIndex = pageIndex!=null?pageIndex:"";
        pageSize = pageSize!=null?pageSize:"";
        queryEndTimeStamp = queryEndTimeStamp!=null?queryEndTimeStamp:"";
        queryStartTimeStamp = queryStartTimeStamp!=null?queryStartTimeStamp:"";
        userId = userId!=null?userId:"";
        targetPointName = targetPointName!=null?targetPointName:"";
        params.clear();
        params.put("count",count);
        params.put("pageIndex",pageIndex);
        params.put("pageSize",pageSize);
        params.put("queryEndTimeStamp",queryEndTimeStamp);
        params.put("queryStartTimeStamp",queryStartTimeStamp);
        params.put("targetPointName",targetPointName);
        params.put("userId",userId);
        JSONObject jsonObject = sendHttp.getHttp(ChannelRecordsConfig.reExchangeRecords,headers,params);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }
}
