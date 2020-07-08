package test;


import com.alibaba.fastjson.JSONObject;
import com.sheng.hrt.until.ExtentUtils;
import com.sheng.hrt.until.SendHttp;
import com.sheng.hrt.urlConfig.ThirdChannelConfig;
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
@DisplayName("三方渠道表")
public class ThirdChannelTest {
    protected SendHttp sendHttp = new SendHttp();
    protected Map<String,String> headers = BaseManage.headers;
    protected Map<String,String> params = BaseManage.params;

    @DisplayName("获取单个三方渠道信息")
    @CsvSource({"name,1","name,2"})
    @ParameterizedTest(name = "{0}")
    @Tag("获取元素")
    public void getThirdChannel(String name,String channerId){
        params.clear();
        params.put("channelId",channerId);
        JSONObject jsonObject = sendHttp.getHttp(ThirdChannelConfig.GetThirdChannel,headers,params);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }
    @DisplayName("新增 三分渠道")
    @CsvFileSource(resources = "/resources/三方渠道数据.csv",numLinesToSkip = 1)
    @ParameterizedTest(name = "{0}")
    @Tag("新增")
    public void addThirdChannel(String name,String channelDailyThreshold,String channelDailyUserThreshold
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
        Assert.assertEquals(jsonObject.getString("success"),judge.toLowerCase());
    }

    @DisplayName("修改 三分渠道")
    @CsvFileSource(resources = "/resources/三方渠道数据.csv",numLinesToSkip = 1)
    @ParameterizedTest(name = "{0}")
    @Tag("修改")
    public void updateThirdChannel(String name,String channelDailyThreshold,String channelDailyUserThreshold
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
        Assert.assertEquals(jsonObject.getString("success"),judge.toLowerCase());
    }

    @DisplayName("状态下拉")
    @Test
    @Tag("下拉列表")
    public void channelStates(){
        JSONObject jsonObject = sendHttp.getHttp(ThirdChannelConfig.channelStates,headers);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @ParameterizedTest(name = "{0}")
    @CsvSource({
            "name,1,8",
            "name,1,10",
            "name,2,10",
            "name,0,0"
    })
    @DisplayName("分页 查询三方渠道")
    @Tag("分页接口")
    public void getlist(String name,String Index,String pageSize){
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
    @CsvSource({"存在,469856733393719296,true","不存在,123,false"})
    @ParameterizedTest(name = "{0}")
    @Tag("禁用启用")
    public void updateToOffine(String name,String id,boolean remark){
        params.clear();
        params.put("channelId",id);
//        params.put("remark",remark);
        JSONObject jsonObject = sendHttp.putHttplj(ThirdChannelConfig.updateToOffline,headers,params);
        Assert.assertEquals(jsonObject.getBoolean("success"),remark);
    }

    @DisplayName("启用 三方渠道")
    @CsvSource({"存在,469856733393719296,true","不存在,123,false"})
    @ParameterizedTest(name = "{0}")
    @Tag("禁用启用")
    public void updateToOnline(String name,String id,boolean remark){
        params.clear();
        params.put("channelId",id);
//        params.put("remark",remark);
        JSONObject jsonObject = sendHttp.putHttplj(ThirdChannelConfig.updateToOnline,headers,params);
        Assert.assertEquals(jsonObject.getBoolean("success"),remark);
    }

}
