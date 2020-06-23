package com.sheng.hrt.until;

import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * http请求类封装
 */
public class SendHttp {
    public JSONObject getHttp(String url, Map<String,String> headers){
        HttpRequest httpRequest = HttpRequest
                .get(url)
                .headers(headers)
                .contentType(HttpRequest.CONTENT_TYPE_JSON)
                .acceptJson();

        return getJsonObject(httpRequest);
    };

    public JSONObject getHttp(String url, Map<String,String> headers,Map<String,String> params){
        String baseUrl = HttpRequest.append(url,params);
        HttpRequest httpRequest = HttpRequest
                .get(baseUrl)
                .headers(headers)
                .contentType(HttpRequest.CONTENT_TYPE_JSON)
                .acceptJson();
        return getJsonObject(httpRequest);
    };
    public JSONObject putHttp(String url, Map<String,String> headers){
        HttpRequest httpRequest = HttpRequest
                .put(url)
                .headers(headers)
                .contentType(HttpRequest.CONTENT_TYPE_JSON)
                .acceptJson();

        return getJsonObject(httpRequest);
    };

    public JSONObject putHttp(String url, Map<String,String> headers,JSONObject body){
        HttpRequest httpRequest = HttpRequest
                .put(url)
                .headers(headers)
                .contentType(HttpRequest.CONTENT_TYPE_JSON)
                .acceptJson();
        httpRequest.send(body.toString());
        return getJsonObject(httpRequest);
    };

    public JSONObject putHttp(String url, Map<String,String> headers,Map<String,String> params){
        String baseUrl = HttpRequest.append(url,params);
        System.out.println(baseUrl);
        HttpRequest httpRequest = HttpRequest
                .put(baseUrl)
                .headers(headers)
                .contentType(HttpRequest.CONTENT_TYPE_JSON)
                .acceptJson();
        return getJsonObject(httpRequest);
    };
    public JSONObject putHttplj(String url, Map<String,String> headers,Map<String,String> params){
        StringBuilder baseUrl = new StringBuilder(url);
        for(String value : params.values()){
            baseUrl.append(value);
        }
        HttpRequest httpRequest = HttpRequest
                .put(baseUrl.toString())
                .headers(headers)
                .contentType(HttpRequest.CONTENT_TYPE_JSON)
                .acceptJson();
        return getJsonObject(httpRequest);
    };
    public JSONObject postHttp(String url, Map<String,String> headers,JSONObject body){
        HttpRequest httpRequest = HttpRequest
                .post(url)
                .headers(headers)
                .contentType(HttpRequest.CONTENT_TYPE_JSON)
                .acceptJson();
        httpRequest.send(body.toString());
        return getJsonObject(httpRequest);
    };

    public JSONObject postHttp(String url, Map<String,String> headers,Map<String,String> params){
        String baseUrl = HttpRequest.append(url,params);
        HttpRequest httpRequest = HttpRequest
                .post(url)
                .headers(headers)
                .contentType(HttpRequest.CONTENT_TYPE_JSON)
                .acceptJson();

        return getJsonObject(httpRequest);
    };
    public JSONObject postHttp(String url, Map<String,String> headers,String params){
        HttpRequest httpRequest = HttpRequest
                .post(url)
                .headers(headers)
                .contentType(HttpRequest.CONTENT_TYPE_JSON)
                .acceptJson();
        httpRequest.send(params);
        return getJsonObject(httpRequest);
    };

    /**
     * 接受request返回值，并转换为JSON对象
     * @param httpRequest
     * @return
     */
    public static JSONObject getJsonObject(HttpRequest httpRequest){
        String str = "";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = null;
        try {
            ps = new PrintStream(baos, true, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        httpRequest.receive(ps);
        str = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        return JSONObject.parseObject(str);
    }

    /** 控制台格式化输出
     *
     * @param region
     * @return
     */
    public static String formatToJson(String region) {
        int level = 0;
        StringBuffer preBuffer = new StringBuffer();
        for (int i = 0; i < region.length(); i++) {
            char c = region.charAt(i);
            if (level > 0 && '\n' == preBuffer.charAt(preBuffer.length() - 1)) {
                preBuffer.append(getLevelStr(level));
            }
            switch (c) {
                case '{':
                case '[':
                    preBuffer.append(c + "\n");
                    level++;
                    break;
                case ',':
                    preBuffer.append(c + "\n");
                    break;
                case '}':
                case ']':
                    preBuffer.append("\n");
                    level--;
                    preBuffer.append(getLevelStr(level));
                    preBuffer.append(c);
                    break;
                default:
                    preBuffer.append(c);
                    break;
            }
        }

        return String.valueOf(preBuffer);

    }

    private static String getLevelStr(int level) {
        StringBuffer lb = new StringBuffer();
        for (int levelTmp = 0; levelTmp < level; levelTmp++) {
            lb.append("\t");
        }
        return String.valueOf(lb);
    }
}

