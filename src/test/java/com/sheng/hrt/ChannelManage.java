package com.sheng.hrt;

import com.alibaba.fastjson.JSONObject;
import com.sheng.hrt.until.ExtentUtils;
import com.sheng.hrt.until.SendHttp;
import com.sheng.hrt.urlConfig.ApplicationConfig;
import com.sheng.hrt.urlConfig.ChannelUrlConfig;
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
@DisplayName("渠道表")
public class ChannelManage {
    protected static Map<String,String> headers = new HashMap<>();
    protected static Map<String,String> params = new HashMap<>();
    protected static SendHttp sendHttp = new SendHttp();

    @DisplayName("获取单个积分渠道信息")
    @CsvSource({"name,1,true"})
    @ParameterizedTest(name = "{0}")
    @Tag("获取元素")
    public void getChannel(String name,String channelId,boolean juge){
        channelId = channelId!=null?channelId:"";
        params.clear();
        params.put("channelId",channelId);
        JSONObject jsonObject = sendHttp.getHttp(ChannelUrlConfig.getChannel,headers,params);
        Assert.assertEquals(jsonObject.getBoolean("success"),juge);
    }
    @DisplayName("新增积分渠道")
    @CsvFileSource(resources = "/resources/渠道表数据.csv",numLinesToSkip = 1)
    @ParameterizedTest(name = "{0}")
    @Tag("新增")
    public void addChannel(String name,Boolean judge){
        JSONObject jsonObject = sendHttp.getHttp(ChannelUrlConfig.addChannel,headers,params);
        Assert.assertEquals(jsonObject.getBoolean("success"),judge);
    }

    @DisplayName("修改积分渠道")
    @CsvFileSource(resources = "/resources/渠道表数据.csv",numLinesToSkip = 1)
    @ParameterizedTest(name = "{0}")
    @Tag("修改")
    public void updateChannel(String name,Boolean judge){
        JSONObject jsonObject = sendHttp.getHttp(ChannelUrlConfig.updataChannel,headers,params);
        Assert.assertEquals(jsonObject.getBoolean("success"),judge);
    }



    @DisplayName("状态 下拉")
    @Test
    @Tag("下拉列表")
    public void channelStates(){
        JSONObject jsonObject = sendHttp.getHttp(ChannelUrlConfig.channelStates,headers);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @DisplayName("获取积分选择下拉")
    @Test
    @Tag("下拉列表")
    public void pointsStates(){
        JSONObject jsonObject = sendHttp.getHttp(ChannelUrlConfig.points,headers);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }
    @ParameterizedTest
    @CsvSource({
            "name,1,8",
            "name,1,10",
            "name,2,10",
            "name,0,0"
    })
    @DisplayName("分页 查询渠道")
    @Tag("分页接口")
    public void getlist(String name,String Index,String pageSize){
        params.clear();
        //是否计算总数
        params.put("count","true");
        //第几页
        params.put("pageIndex",Index);
        //每页大小
        params.put("pageSize",pageSize);
        JSONObject jsonObject = sendHttp.getHttp(ChannelUrlConfig.selectChannels,headers,params);
        Assert.assertEquals(jsonObject.get("code"),200);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }
    @DisplayName("禁用 积分渠道")
    @CsvSource({"禁用积分渠道（存在）,469856733393719296,remark"})
    @ParameterizedTest(name = "{0}")
    @Tag("禁用启用")
    public void updateToOffine(String name,String id,String remark){
        params.clear();
        JSONObject jsonObject = sendHttp.putHttp(ChannelUrlConfig.updateToOffline,headers,id);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @DisplayName("启用 积分渠道")
    @CsvSource({"启用积分渠道,469856733393719296,remark2"})
    @ParameterizedTest(name = "{0}")
    @Tag("禁用启用")
    public void updateToOnline(String name,String id,String remark){
        params.clear();
        params.put("channelId",id);
        params.put("remark",remark);
        JSONObject jsonObject = sendHttp.putHttp(ChannelUrlConfig.updateToOnline,headers,id,params);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

}
