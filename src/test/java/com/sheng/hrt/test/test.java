package com.sheng.hrt.test;

import com.sheng.hrt.until.ExtentUtils;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;

@DisplayName("测试类名")
@ExtendWith(ExtentUtils.class)
public class test {
    @DisplayName("测试成功方法")
//    @TestTemplate
    @CsvSource({"A,2","2,2",",1"})
    @ParameterizedTest(name = "{0}")
    @Tag(value = "新增")
//    @ExtendWith(MyTestTemplateInvocationContextProvider.class)
    public void success(String fruits,String b){
        System.out.println(fruits +"  :  " + b);
        Assert.assertEquals(fruits,b);
    }

    @DisplayName("方法2")
    @CsvSource({"test"})
    @ParameterizedTest(name = "{0}")
    @Tag("修改")
    @Tag("xiug")
    public void fail(String name){
        Assert.assertEquals("1","2");
    }


}
