package com.sheng.hrt;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.sheng.hrt.until.ExtentUtils;
import com.sheng.hrt.until.SendHttp;
import com.sheng.hrt.urlConfig.ApplicationConfig;
import com.sheng.hrt.urlConfig.dailyStatisticConfig;
import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;
@ExtendWith(ExtentUtils.class)
@DisplayName("数据管理")
public class dailyStatisticManage {
    protected SendHttp sendHttp = new SendHttp();
    protected Map<String,String> headers = BaseManage.headers;
    protected Map<String,String> params = BaseManage.params;

    @DisplayName("抽佣面板")
    @Test
    public void testCommissionData(){
        JSONObject jsonObject = sendHttp.getHttp(dailyStatisticConfig.commissionData,headers);
        System.out.println(jsonObject);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @DisplayName("抽佣面板(根据时间区间查询按日数据)")
    @CsvSource({",","1,2"})
    @ParameterizedTest
    public void testCommissionDataDaily(String startTime,String endTime){
        startTime = startTime!=null?startTime:"";
        endTime = endTime!=null?endTime:"";
        params.clear();
        params.put("queryStartTimeStamp",startTime);
        params.put("queryEndTimeStamp",endTime);
        JSONObject jsonObject = sendHttp.getHttp(dailyStatisticConfig.commissionDataDaily,headers,params);
        System.out.println(jsonObject);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @DisplayName("查询消耗数据面板")
    @CsvSource({
            ",,"
            ,"1,,"
            ,",1,2"
    })
    @ParameterizedTest
    public void testConsumeBoardData(String pointCode,String queryStartTime,String queryEndTime){
        pointCode = pointCode!=null?pointCode:"";
        queryStartTime = queryStartTime!=null?queryStartTime:"";
        queryEndTime = queryEndTime!=null?queryEndTime:"";
        params.clear();
        params.put("pointCode",pointCode);
        params.put("queryStartTimeStamp",queryStartTime);
        params.put("queryEndTimeStamp",queryEndTime);
        JSONObject jsonObject = sendHttp.getHttp(dailyStatisticConfig.consumeBoardData,headers,params);
        System.out.println(jsonObject);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }
    @DisplayName("查询消耗数据面板(根据时间区间查询按日数据)")
    @CsvSource({
            ",,"
            ,"1,,"
            ,",1,2"
    })
    @ParameterizedTest
    public void testConsumeBoardDataDaily(String pointCode,String queryStartTime,String queryEndTime){
        pointCode = pointCode!=null?pointCode:"";
        queryStartTime = queryStartTime!=null?queryStartTime:"";
        queryEndTime = queryEndTime!=null?queryEndTime:"";
        params.clear();
        params.put("pointCode",pointCode);
        params.put("queryStartTimeStamp",queryStartTime);
        params.put("queryEndTimeStamp",queryEndTime);
        JSONObject jsonObject = sendHttp.getHttp(dailyStatisticConfig.consumeBoardDataDaily,headers,params);
        System.out.println(jsonObject);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }
    @DisplayName("获取数据报表聚合数据")
    @CsvSource({
            ","
            ,"1,2"
            ,"2,1"
    })
    @ParameterizedTest
    public void testData(String startTime,String endTime){
        startTime = startTime!=null?startTime:"";
        endTime = endTime!=null?endTime:"";
        params.clear();
        params.put("queryStartTimeStamp",startTime);
        params.put("queryEndTimeStamp",endTime);
        JSONObject jsonObject = sendHttp.getHttp(dailyStatisticConfig.data,headers,params);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }
    @DisplayName("导出数据报表,暂未完成文件接收请求")
    @CsvSource({
            ","
            ,"1,2"
            ,"2,1"
    })
    @ParameterizedTest
    @Disabled
    public void testExport(String startTime,String endTime){
        startTime = startTime!=null?startTime:"";
        endTime = endTime!=null?endTime:"";
        params.clear();
        params.put("queryStartTimeStamp",startTime);
        params.put("queryEndTimeStamp",endTime);
        JSONObject jsonObject = sendHttp.getHttp(dailyStatisticConfig.export,headers,params);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }
    @DisplayName("服务费面板")
    @Test
    public void testFeeData(){
        JSONObject jsonObject = sendHttp.getHttp(dailyStatisticConfig.feeData,headers);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @DisplayName("服务费面板(根据时间区间查询按日数据)")
    @CsvSource({
            ","
            ,"1,2"
            ,"2,1"
    })
    @ParameterizedTest
    public void testFeeDataDaily(String startTime,String endTime){
        startTime = startTime!=null?startTime:"";
        endTime = endTime!=null?endTime:"";
        params.clear();
        params.put("queryStartTimeStamp",startTime);
        params.put("queryEndTimeStamp",endTime);
        JSONObject jsonObject = sendHttp.getHttp(dailyStatisticConfig.feeDataDaily,headers,params);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }
    @DisplayName("查询发放数据面板")
    @CsvSource({
            ",,"
            ,"1,,"
            ,",1,2"
    })
    @ParameterizedTest
    public void testIssueBoardData(String pointCode,String queryStartTime,String queryEndTime){
        pointCode = pointCode!=null?pointCode:"";
        queryStartTime = queryStartTime!=null?queryStartTime:"";
        queryEndTime = queryEndTime!=null?queryEndTime:"";
        params.clear();
        params.put("pointCode",pointCode);
        params.put("queryStartTimeStamp",queryStartTime);
        params.put("queryEndTimeStamp",queryEndTime);
        JSONObject jsonObject = sendHttp.getHttp(dailyStatisticConfig.issueBoardData,headers,params);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }
    @DisplayName("查询发放数据面板(根据时间区间查询按日数据)")
    @CsvSource({
            ",,"
            ,"1,,"
            ,",1,2"
    })
    @ParameterizedTest
    public void testIssueBoardDataDaily(String pointCode,String queryStartTime,String queryEndTime){
        pointCode = pointCode!=null?pointCode:"";
        queryStartTime = queryStartTime!=null?queryStartTime:"";
        queryEndTime = queryEndTime!=null?queryEndTime:"";
        params.clear();
        params.put("pointCode",pointCode);
        params.put("queryStartTimeStamp",queryStartTime);
        params.put("queryEndTimeStamp",queryEndTime);
        JSONObject jsonObject = sendHttp.getHttp(dailyStatisticConfig.issueBoardDataDaily,headers,params);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @ParameterizedTest
    @CsvSource({
            "false,,,,",
            ",,,,",
            "true,1,10,,",
            "true,,0,1,",
            "true,,,,",
            "true,0,0,0,0,0"
    })
    @DisplayName("分页 查询应用")
    public void getPages(String count,String Index,String pageSize,String startTime,String endTime){
        count = count!=null?count:"";
        Index = Index!=null?Index:"";
        pageSize = pageSize!=null?pageSize:"";
        startTime = startTime!=null?startTime:"";
        endTime = endTime!=null?endTime:"";
        params.clear();
        //是否计算总数
        params.put("count",count);
        //第几页
        params.put("pageIndex",Index);
        //每页大小
        params.put("pageSize",pageSize);
        params.put("queryStartTimeStamp",startTime);
        params.put("queryEndTimeStamp",endTime);
        JSONObject jsonObject = sendHttp.getHttp(dailyStatisticConfig.pages,headers,params);
        System.out.println(jsonObject);
        Assert.assertEquals(jsonObject.get("code"),200);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }
}
