package com.sheng.hrt;

import org.junit.jupiter.api.BeforeAll;

import java.util.HashMap;
import java.util.Map;

public class BaseManage {
    protected static Map<String,String> headers = new HashMap<>();
    protected static Map<String,String> params = new HashMap<>();
    @BeforeAll
    public void init(){
        headers.put("authorization","");
    }


}
