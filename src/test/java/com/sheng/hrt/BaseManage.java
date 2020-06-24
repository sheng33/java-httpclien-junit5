package com.sheng.hrt;

import com.alibaba.fastjson.JSONObject;
import com.sheng.hrt.until.ExtentUtils;
import com.sheng.hrt.until.SendHttp;
import com.sheng.hrt.urlConfig.BaseUrlConfig;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
@ExtendWith(ExtentUtils.class)
@DisplayName("部分基本接口")
public class BaseManage {
    protected static Map<String,String> headers = new HashMap<>();
    protected static Map<String,String> params = new HashMap<>();
    protected static SendHttp sendHttp = new SendHttp();;
    @BeforeAll
    public static void init(){
        headers.put("authorization","");
    }

    @DisplayName("文件上传")
    @CsvSource({"1","2"})
    @ParameterizedTest
    public void uploadFile(String imgPath){
        File file = new File(imgPath);
        JSONObject jsonObject = sendHttp.postHttp(BaseUrlConfig.upload,headers,file);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }




}
