package com.sheng.test.junitTest;

import com.alibaba.fastjson.JSONObject;
import com.sheng.test.until.ExtentUtils;
import com.sheng.test.until.SendHttp;
import com.sheng.test.urlConfig.BannerConfig;
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
@DisplayName("Banner管理接口")
public class BannerManage {
    protected SendHttp sendHttp = new SendHttp();
    protected Map<String,String> headers = BaseManage.headers;
    protected Map<String,String> params = BaseManage.params;

    @ParameterizedTest(name = "{0}")
    @CsvSource({
            "可查(1-8),1,8",
            "可查(1-10),1,10",
            "无数据(2-10),2,10",
            "无数据(0-0),0,0"
    })
    @DisplayName("查找Banner")
    @Tag("分页接口")
    public void getlist(String name,String Index,String pageSize){
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
//        bannerId = jsonObject.getString("id"); //用于测试-删除Banner

    }

    @DisplayName("创建Banner")
    @ParameterizedTest(name = "{0}")
    @CsvFileSource(resources = "/resources/Banner接口数据.csv",numLinesToSkip = 1)
    @Tag("新增")
    public void addBanner(String name,String type,String goalId,String bannerName,String bannerPic,String createTime,String id,String sort,String judge){
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
    @Tag("下拉列表")
    public void getBannerlist(){
        JSONObject jsonObject = sendHttp.getHttp(BannerConfig.types,headers);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @DisplayName("下架Banner")
    @CsvSource({"下架Banner(存在),472497518299713536","下架Banner(不存在),472490190833848320"})
    @ParameterizedTest(name = "{0}")
    @Tag("上架下架")
    public void updateToOffine(String name,String id){
        params.clear();
        params.put("bannerId",id);
        JSONObject jsonObject = sendHttp.putHttplj(BannerConfig.updateToOffline,headers,params);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @DisplayName("上架Banner")
    @CsvSource({"上架Banner(存在),472497518299713536","上架Banner(不存在),472490190833848320"})
    @ParameterizedTest(name = "{0}")
    @Tag("上架下架")
    public void updateToOnline(String name,String id){
        params.clear();
        params.put("bannerId",id);
        JSONObject jsonObject = sendHttp.putHttplj(BannerConfig.updateToOnline,headers,params);
        System.out.println(jsonObject);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }

    @DisplayName("删除Banner")
    @CsvSource({"删除Banner-存在,1","删除Banner-不存在,2"})
    @Tag("删除")
    public void delBanner(String name,String bannerId){
        params.clear();
        params.put("bannerId",bannerId);
        JSONObject jsonObject = sendHttp.getHttp(BannerConfig.delete,headers,params);
    }

}
