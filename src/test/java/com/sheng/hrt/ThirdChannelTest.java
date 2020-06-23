package com.sheng.hrt;


import com.alibaba.fastjson.JSONObject;
import com.sheng.hrt.until.ExtentUtils;
import com.sheng.hrt.until.SendHttp;
import com.sheng.hrt.urlConfig.BannerConfig;
import com.sheng.hrt.urlConfig.ThirdChannelConfig;
import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

@ExtendWith(ExtentUtils.class)
@DisplayName("三方渠道表")
public class ThirdChannelTest {
    protected SendHttp sendHttp = new SendHttp();
    protected Map<String,String> headers = BaseManage.headers;
    protected Map<String,String> params = BaseManage.params;

    @DisplayName("获取单个三方渠道信息")
    @CsvSource({"1","2"})
    @ParameterizedTest
    public void getThirdChannel(String channerId){
        params.clear();
        params.put("channelId",channerId);
        JSONObject jsonObject = sendHttp.getHttp(ThirdChannelConfig.GetThirdChannel,headers,params);
        System.out.println(jsonObject);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }
    @DisplayName("新增 三分渠道")
    @CsvFileSource(resources = "/resources/三方渠道数据.csv",numLinesToSkip = 1)
    @Disabled
    public void addThirdChannel(String channelDailyThreshold,String channelDailyUserThreshold
            ,String channelName,String chargeRatio,String pointExchangeRate,String pointName,String judge){
        channelDailyThreshold = channelDailyThreshold!=null?channelDailyThreshold:"";
        channelDailyUserThreshold = channelDailyUserThreshold!=null?channelDailyUserThreshold:"";
        channelName = channelName!=null?channelName:"";
        chargeRatio = chargeRatio!=null?chargeRatio:"";
        pointExchangeRate = pointExchangeRate!=null?pointExchangeRate:"";
        pointName = pointName!=null?pointName:"";

        String param = "{\n" +
                "\"channelDailyThreshold\": \""+channelDailyThreshold+"\"," +
                "\"channelDailyUserThreshold\": \""+channelDailyUserThreshold+"\"," +
                "\"channelName\": \"\""+channelName+"\"\"," +
                "\"chargeRatio\":\""+chargeRatio+"\"," +
                "\"pointExchangeRate\": \""+pointExchangeRate+"\"," +
                "\"pointName\": \""+pointName+"\"" +
                "}";
        JSONObject jsonObject = sendHttp.postHttp(ThirdChannelConfig.GetThirdChannel,headers,param);
        Assert.assertEquals(jsonObject.getString("success"),judge);
    }

    @DisplayName("修改 三分渠道")
    @CsvFileSource(resources = "/resources/三方渠道数据.csv",numLinesToSkip = 1)
    @Disabled
    public void updateThirdChannel(String channelDailyThreshold,String channelDailyUserThreshold
            ,String channelName,String chargeRatio,String pointExchangeRate,String pointName,String judge){
        channelDailyThreshold = channelDailyThreshold!=null?channelDailyThreshold:"";
        channelDailyUserThreshold = channelDailyUserThreshold!=null?channelDailyUserThreshold:"";
        channelName = channelName!=null?channelName:"";
        chargeRatio = chargeRatio!=null?channelDailyUserThreshold:"";
        pointExchangeRate = pointExchangeRate!=null?channelDailyUserThreshold:"";
        pointName = pointName!=null?channelDailyUserThreshold:"";
        String param = "{" +
                "\"channelDailyThreshold\": \""+channelDailyThreshold+"\"," +
                "\"channelDailyUserThreshold\": \""+channelDailyUserThreshold+"\"," +
                "\"channelName\": \"\""+channelName+"\"\"," +
                "\"chargeRatio\":\""+chargeRatio+"\"," +
                "\"pointExchangeRate\": \""+pointExchangeRate+"\"," +
                "\"pointName\": \""+pointName+"\"" +
                "}";
        JSONObject jsonObject = sendHttp.postHttp(ThirdChannelConfig.GetThirdChannel,headers,param);
        Assert.assertEquals(jsonObject.getString("success"),judge);
    }

    @DisplayName("状态下拉")
    @Test
    public void channelStates(){
        JSONObject jsonObject = sendHttp.getHttp(ThirdChannelConfig.channelStates,headers);
        System.out.println(jsonObject);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @ParameterizedTest
    @CsvSource({
            "1,8",
            "1,10",
            "2,10",
            "0,0"
    })
    @DisplayName("分页 查询三方渠道")
    public void getlist(String Index,String pageSize){
        params.clear();
        //是否计算总数
        params.put("count","true");
        //第几页
        params.put("pageIndex",Index);
        //每页大小
        params.put("pageSize",pageSize);
        JSONObject jsonObject = sendHttp.getHttp(ThirdChannelConfig.selectChannels,headers,params);
        Assert.assertEquals(jsonObject.get("code"),200);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @DisplayName("禁用 三方渠道")
    @CsvSource({"469856733393719296,remark"})
    @ParameterizedTest
    public void updateToOffine(String id,String remark){
        params.clear();
        params.put("channelId",id);
//        params.put("remark",remark);
        JSONObject jsonObject = sendHttp.putHttplj(ThirdChannelConfig.updateToOffline,headers,params);
        System.out.println(jsonObject);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @DisplayName("启用 三方渠道")
    @CsvSource({"469856733393719296,remark2"})
    @ParameterizedTest
    public void updateToOnline(String id,String remark){
        params.clear();
        params.put("channelId",id);
//        params.put("remark",remark);
        JSONObject jsonObject = sendHttp.putHttplj(ThirdChannelConfig.updateToOnline,headers,params);
        System.out.println(jsonObject);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

}
