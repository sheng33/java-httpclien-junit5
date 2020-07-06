package test;

import com.alibaba.fastjson.JSONObject;
import com.sheng.hrt.until.ExtentUtils;
import com.sheng.hrt.until.SendHttp;
import com.sheng.hrt.urlConfig.BaseUrlConfig;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
    @DisplayName("权限授权")
    @Tag("登录")
    public static void init(){
        headers.put("authorization","");
    }

    @DisplayName("文件上传")
    @CsvSource({"正常大小文件,1","超过限制文件,2"})
    @ParameterizedTest(name = "{0}")
    public void uploadFile(String name,String imgPath){
        File file = new File(imgPath);
        JSONObject jsonObject = sendHttp.postHttp(BaseUrlConfig.upload,headers,file);
        Assert.assertTrue(jsonObject.getBoolean("success"));
    }




}
