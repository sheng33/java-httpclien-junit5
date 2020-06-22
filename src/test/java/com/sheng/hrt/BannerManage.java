package com.sheng.hrt;

import com.alibaba.fastjson.JSONObject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import com.sheng.hrt.until.ExtentUtils;
import com.sheng.hrt.until.SendHttp;
import com.sheng.hrt.urlConfig.BannerConfig;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

@DisplayName("Banner管理接口")
@ExtendWith(ExtentUtils.class)
public class BannerManage {
    protected SendHttp sendHttp = new SendHttp();
    protected Map<String,String> headers = BaseManage.headers;
    protected Map<String,String> params = BaseManage.params;
    @Test
    public void test(){
        Assert.assertEquals(1,1);
    }


    @DisplayName("查找Banner")
    @ParameterizedTest
    @CsvSource({
            "1,8","1,10","2,10"
    })
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
        JSONObject jsonObject1 = JSONObject.parseObject(param);
        JSONObject jsonObject = sendHttp.postHttp(BannerConfig.save,headers,param);
        Assert.assertEquals(jsonObject.get("success"),Boolean.parseBoolean(judge.toLowerCase()));
    }

}
