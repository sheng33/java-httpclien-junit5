package com.sheng.test.junitTest;

import com.alibaba.fastjson.JSONObject;
import com.sheng.test.until.ExtentUtils;
import com.sheng.test.until.SendHttp;
import com.sheng.test.urlConfig.PointUrlConfig;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
    @CsvSource({"name,1,true"})
    @ParameterizedTest(name = "{0}")
    @Tag("查询")
    public void getChannel(String name,String pointId,boolean juge){
        pointId = pointId!=null?pointId:"";
        params.clear();
        params.put("pointId",pointId);
        JSONObject jsonObject = sendHttp.getHttp(PointUrlConfig.getPoint,headers,params);
        Assert.assertEquals(jsonObject.getBoolean("success"),juge);
    }
    @DisplayName("新增积分")
    @CsvFileSource(resources = "/resources/积分表数据.csv",numLinesToSkip = 1)
    @ParameterizedTest(name = "{0}")
    @Tag("新增")
    public void addPoint(String name,String pointCode,String pointExchangeRate,String pointId,String pointName,String judge){
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
        Assert.assertEquals(jsonObject.getString("success"),judge.toLowerCase());
    }
    @DisplayName("修改积分")
    @CsvFileSource(resources = "/resources/积分表数据.csv",numLinesToSkip = 1)
    @ParameterizedTest(name = "{0}")
    @Tag("修改")
    public void updatePoint(String name,String pointCode,String pointExchangeRate,String pointId,String pointName,String judge){
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
        Assert.assertEquals(jsonObject.getString("success"),judge.toLowerCase());
    }

    @ParameterizedTest(name = "{0}")
    @CsvSource({
            "name,1,8",
            "name,1,10",
            "name,2,10",
            "name,0,0"
    })
    @DisplayName("分页积分列表")
    @Tag("分页接口")
    public void getlist(String name,String pageIndex,String pageSize){
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
