package com.sheng.hrt;


import com.sheng.hrt.urlConfig.BannerConfig;
import com.sheng.hrt.urlConfig.BaseUrlConfig;
import org.junit.jupiter.api.Test;

public class ThirdChannelTest {

    private String baseUrl;
    @Test
    public void test(){
        System.out.println(BaseUrlConfig.baseUrl);
        System.out.println(BannerConfig.baseUrl);
    }

}
