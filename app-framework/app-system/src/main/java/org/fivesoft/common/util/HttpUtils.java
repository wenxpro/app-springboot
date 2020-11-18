package org.fivesoft.common.util;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * okhttp 请求类
 * @author wenx
 **/
@Slf4j
public class HttpUtils {
    private static final String HTTP_GET_METHOD = "GET";
    private static final String HTTP_DELETE_METHOD = "DELETE";
    private static final String HTTP_POST_METHOD = "POST";
    private static final String HTTP_PUT_METHOD = "PUT";
    private static final int HTTP_TIMEOUT_SECOND = 15;

    public static Map httpGet(String url) {
        return httpGet("", "", url);
    }

    public static Map httpGet(String url, Headers headers) {
        if (StrUtil.isEmpty(url)) {
            log.warn("Http get failed, url is null: " + url);
            return Collections.emptyMap();
        }

        Request request = new Request.Builder().url(url).headers(headers).build();
        return getResponse(getHttpClient("", ""), request);
    }
    /**
     * Http get 请求
     *
     * @param proxyHost 代理的主机
     * @param proxyPort 代理的端口
     * @param url       访问的Url
     * @return JSON对象列表
     */
    public static Map httpGet(String proxyHost, String proxyPort, String url) {
        if (StrUtil.isEmpty(url)) {
            log.warn("Http get failed, url is null: " + url);
            return Collections.emptyMap();
        }

        Request request = new Request.Builder().url(url).build();
        return getResponse(getHttpClient(proxyHost, proxyPort), request);
    }

    public static Map httpPost(String url, Object body) {
        return httpPost("", "", url, body, null);
    }
    public static Map httpDelete(String url, Object body) {
        return httpDelete("", "", url, body, null);
    }

    public static Map httpPost(String url, Object body, Headers headers) {
        return httpPost("", "", url, body, headers);
    }

    /**
     * Http post 请求
     *
     * @param proxyHost 代理的主机
     * @param proxyPort 代理的端口
     * @param url       访问的Url
     * @param body      实体内容
     * @return JSON对象列表
     */
    public static Map httpPost(String proxyHost, String proxyPort, String url, Object body, Headers headers) {
        if (StrUtil.isEmpty(url) || body == null) {
            log.warn("Http post failed, url or body is null: " + url + " " + body);
            return Collections.emptyMap();
        }

        return getResponse(getHttpClient(proxyHost, proxyPort), generateRequest(url, HTTP_POST_METHOD, body, headers));
    }
    public static Map httpDelete(String proxyHost, String proxyPort, String url, Object body, Headers headers) {
        if (StrUtil.isEmpty(url) || body == null) {
            log.warn("Http delete failed, url or body is null: " + url + " " + body);
            return Collections.emptyMap();
        }

        return getResponse(getHttpClient(proxyHost, proxyPort), generateRequest(url, HTTP_DELETE_METHOD, body, headers));
    }

    public static Map httpPut(String url, Object body) {
        return httpPut("", "", url, body);
    }

    public static Map httpPut(String proxyHost, String proxyPort, String url, Object body) {
        if (StrUtil.isEmpty(url) || body == null) {
            log.warn("Http put failed, url or body is null: " + url + " " + body);
            return Collections.emptyMap();
        }

        return getResponse(getHttpClient(proxyHost, proxyPort), generateRequest(url, HTTP_PUT_METHOD, body, null));
    }

    /**
     * Http post 请求
     *
     * @param url  访问的Url
     * @param body 实体内容
     * @return JSON对象列表
     */
    private static Request generateRequest(String url, String method, Object body, Headers headers) {
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"),
                JSON.toJSONString(body));
        if (headers == null || headers.size() == 0) {
            return new Request.Builder().url(url).method(method.toUpperCase(), requestBody).build();
        } else {
            return new Request.Builder().url(url).method(method.toUpperCase(), requestBody).headers(headers).build();
        }
    }

    /**
     * 构造客户端，分为使用代理和没有代理
     *
     * @param proxyHost 代理的主机
     * @param proxyPort 代理的端口
     * @return 客户端
     */
    private static OkHttpClient getHttpClient(String proxyHost, String proxyPort) {
        OkHttpClient client;

        if (!StrUtil.isAllEmpty(proxyHost, proxyPort)) {
            log.info("User http proxy: " + proxyHost + " " + proxyPort);
            client = new OkHttpClient().newBuilder()
                    .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, Integer.parseInt(proxyPort))))
                    .readTimeout(HTTP_TIMEOUT_SECOND, TimeUnit.SECONDS)
                    .build();
        } else {
            client = new OkHttpClient().newBuilder()
                    .readTimeout(HTTP_TIMEOUT_SECOND, TimeUnit.SECONDS)
                    .build();
        }

        return client;
    }

    /**
     * 构造返回结果
     *
     * @param client  客户端
     * @param request 请求
     * @return
     */
    private static Map getResponse(OkHttpClient client, Request request) {
        Response response;

        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            log.error("Http request exception: " + request.url().toString() + "\n" + JSON.toJSONString(e));
            return Collections.emptyMap();
        }

        if (!response.isSuccessful()) {
            log.error("Http request failed: " + request.url().toString() + "\n" + JSON.toJSONString(response));
            return Collections.emptyMap();
        }

        try {
            return JSON.parseObject(response.body().string(), Map.class);
        } catch (IOException e) {
            log.error("Http request failed, Cannot get body string: " + request.url().toString() + " " + JSON.toJSONString(response));
            return Collections.emptyMap();
        }
    }
}