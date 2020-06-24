package com.sheng.hrt;

import com.alibaba.fastjson.JSONObject;
import com.sheng.hrt.until.ExtentUtils;
import com.sheng.hrt.until.SendHttp;
import com.sheng.hrt.urlConfig.ApplicationConfig;
import com.sheng.hrt.urlConfig.ChannelUrlConfig;
import com.sheng.hrt.urlConfig.PointUrlConfig;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;
@ExtendWith(ExtentUtils.class)
@DisplayName("积分表")
public class PointManage {
    protected static Map<String,String> headers = new HashMap<>();
    protected static Map<String,String> params = new HashMap<>();
    protected static SendHttp sendHttp = new SendHttp();

    @DisplayName("查询积分")
    @CsvSource({"1,true"})
    @ParameterizedTest
    public void getChannel(String pointId,boolean juge){
        pointId = pointId!=null?pointId:"";
        params.clear();
        params.put("pointId",pointId);
        JSONObject jsonObject = sendHttp.getHttp(PointUrlConfig.getPoint,headers,params);
        Assert.assertEquals(jsonObject.getBoolean("success"),juge);
    }
    @DisplayName("新增积分")
    @CsvFileSource(resources = "/resources/积分表数据.csv",numLinesToSkip = 1)
    @ParameterizedTest
    public void addPoint(String pointCode,String pointExchangeRate,String pointId,String pointName,String judge){
        pointCode = pointCode != null?pointCode:"";
        pointExchangeRate = pointExchangeRate != null?pointExchangeRate:"";
        pointId = pointId != null?pointId:"";
        pointName = pointName != null?pointName:"";
        String parm = "{\n" +
                "\t\"pointCode\": \""+pointCode+"\",\n" +
                "\t\"pointExchangeRate\": "+pointExchangeRate+",\n" +
                "\t\"pointId\": "+pointId+",\n" +
                "\t\"pointName\": \""+pointName+"\"\n" +
                "}";
        JSONObject jsonObject = sendHttp.postHttp(PointUrlConfig.addPoint,headers,parm);
        Assert.assertEquals(jsonObject.getString("success"),judge);
    }
    @DisplayName("修改积分")
    @CsvFileSource(resources = "/resources/积分表数据.csv",numLinesToSkip = 1)
    @ParameterizedTest
    public void updatePoint(String pointCode,String pointExchangeRate,String pointId,String pointName,String judge){
        pointCode = pointCode != null?pointCode:"";
        pointExchangeRate = pointExchangeRate != null?pointExchangeRate:"";
        pointId = pointId != null?pointId:"";
        pointName = pointName != null?pointName:"";
        String parm = "{\n" +
                "\t\"pointCode\": \""+pointCode+"\",\n" +
                "\t\"pointExchangeRate\": "+pointExchangeRate+",\n" +
                "\t\"pointId\": "+pointId+",\n" +
                "\t\"pointName\": \""+pointName+"\"\n" +
                "}";
        JSONObject jsonObject = sendHttp.putHttp(PointUrlConfig.updataPoint,headers,parm);
        Assert.assertEquals(jsonObject.getString("success"),judge);
    }

    @ParameterizedTest
    @CsvSource({
            "1,8",
            "1,10",
            "2,10",
            "0,0"
    })
    @DisplayName("分页积分列表")
    public void getlist(String pageIndex,String pageSize){
        params.clear();
        //是否计算总数
        params.put("count","true");
        //第几页
        params.put("pageIndex",pageIndex);
        //每页大小
        params.put("pageSize",pageSize);
        JSONObject jsonObject = sendHttp.getHttp(PointUrlConfig.points,headers,params);
        Assert.assertEquals(jsonObject.get("code"),200);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

}
