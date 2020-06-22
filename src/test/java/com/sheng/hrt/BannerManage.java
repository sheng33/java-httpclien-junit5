package com.sheng.hrt;

import com.alibaba.fastjson.JSONObject;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sheng.hrt.until.ExtentUtils;
import com.sheng.hrt.until.SendHttp;
import com.sheng.hrt.urlConfig.BannerConfig;
import lombok.val;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.Description;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("Banner管理接口")
public class BannerManage {
    static String reportPath = "reports/demo/index.html";
    private static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
    protected SendHttp sendHttp = new SendHttp();
    protected Map<String,String> headers = BaseManage.headers;
    protected Map<String,String> params = BaseManage.params;

    private static ExtentReports extent = new ExtentReports();
    ExtentTest test = extent.createTest("Banner管理1");
    @BeforeAll
    public static void beforeAll(){
        // 设置静态
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setDocumentTitle("api自动化测试报告");
        htmlReporter.config().setReportName("api自动化测试报告");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setCSS(".node.level-1  ul{ display:none;} .node.level-1.active ul{display:block;}");
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
    }

    @AfterAll
    public static void afterAll(){
        extent.flush();
    }
    @Test
    public void test(){

        Assert.assertEquals(1,1);
    }

//
    @ExtendWith(ExtentUtils.class)
    @DisplayName("查找Banner")
    @ParameterizedTest
    @CsvSource({
            "1,8"
    })
    public void getlist(String Index,String pageSize){
        Assert.assertEquals(1,2);
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
//
//    @DisplayName("创建Banner")
//    @ParameterizedTest
//    @CsvFileSource(resources = "/resources/Banner接口数据.csv",numLinesToSkip = 1)
//    public void addBanner(String type,String goalId,String bannerName,String bannerPic,String createTime,String id,String sort,String judge){
//        type = type!=null?type:"";
//        goalId = goalId!=null?goalId:"";
//        bannerName = bannerName!=null?bannerName:"";
//        bannerPic = bannerPic!=null?bannerPic:"";
//        createTime = createTime!=null?createTime:"";
//        id = id!=null?id:"";
//        sort = sort!=null?sort:"";
//        String param = "{\"attribute\":\"{\\\"targetId\\\":"+goalId+"}\""+
//                ",\"bannerName\":\""+bannerName+"\"" +
//                ",\"bannerPic\":\""+bannerPic+"\"" +
//                ",\"createTime\":\""+createTime+"\"" +
//                ",\"id\": \""+id+"\"" +
//                ",\"sort\":\""+sort+"\",\"type\":\""+type+"\"}";
//        JSONObject jsonObject1 = JSONObject.parseObject(param);
//        JSONObject jsonObject = sendHttp.postHttp(BannerConfig.save,headers,param);
//        Assert.assertEquals(jsonObject.get("success"),Boolean.parseBoolean(judge.toLowerCase()));
//    }


    public TestWatcher watchman = new TestWatcher() {


        @Override
        public void testDisabled(ExtensionContext extensionContext, Optional<String> optional) {
            System.out.println(5);
        }

        @Override
        public void testSuccessful(ExtensionContext extensionContext) {
            System.out.println(3);
            ExtentTest test  = extent.createTest(extensionContext.getDisplayName(),"-");
            // step log
            test.log(Status.FAIL, "-");
            extent.flush();
        }
        @Override
        public void testAborted(ExtensionContext extensionContext, Throwable throwable) {
            System.out.println(2);
        }
        @Override
        public void testFailed(ExtensionContext extensionContext, Throwable throwable) {
            System.out.println(1);
            ExtentTest test  = extent.createTest(extensionContext.getDisplayName(),"Test failed");
            // step log
            test.log(Status.FAIL, throwable);
           extent.flush();
        }
    };
}
