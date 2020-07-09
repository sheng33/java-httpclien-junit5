##  接口测试 帮助文档
此次接口测试采用httpclient+junit5+fastjson+extentreports

通过读取resources-接口测试数据包中csv文件参数化数据

``` java
@CsvFileSource 读取csv文件
例:@CsvFileSource(resources = "/接口测试数据/Banner接口数据.csv",numLinesToSkip = 1)
```

用例大概说明
```java
@ExtendWith(ExtentUtils.class) /** 使用自定义扩展类，用于生成extentreports测试用例报告*/
@DisplayName("应用管理")  
public class ApplicationManage {
    protected SendHttp sendHttp = new SendHttp(); /**SendHttp是我基于kevinsawicki再次封装的http请求类*/
    protected Map<String,String> headers = BaseManage.headers;
    protected Map<String,String> params = BaseManage.params;
    @DisplayName("获取单个应用信息")
    @CsvSource({"存在,473213539499249664","不存在,21"})
    @ParameterizedTest(name = "{0}")
    @Tag("获取元素")
    public void getApp(String name,String appId){
        params.clear();
        params.put("appId",appId);
        JSONObject jsonObject = sendHttp.getHttp(ApplicationConfig.getApp,headers,params); // ApplicationConfig.getApp 即是 url接口地址
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }
}
```

效果图：

![图片名称](https://github.com/sheng33/java-httpclien-junit5-/blob/home/%E6%8A%A5%E5%91%8A%E5%9B%BE%E7%89%87/1.png) 
![图片名称](https://github.com/sheng33/java-httpclien-junit5-/blob/home/%E6%8A%A5%E5%91%8A%E5%9B%BE%E7%89%87/2.png) 
![图片名称](https://github.com/sheng33/java-httpclien-junit5-/blob/home/%E6%8A%A5%E5%91%8A%E5%9B%BE%E7%89%87/3.png) 
