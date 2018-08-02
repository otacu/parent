package com.egoist.parent.common.utils.http;

import com.alibaba.fastjson.JSONObject;
import com.egoist.parent.common.constants.EgoistExceptionStatusConstant;
import com.egoist.parent.common.utils.json.EgoistJsonUtil;
import com.egoist.parent.pojo.exception.EgoistException;
import okhttp3.*;
import okio.ByteString;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * html工具类
 */
public final class EgoistOkHttp3Util {
    private EgoistOkHttp3Util() {
    }

    /**
     * OkHttpClient
     */
    private static OkHttpClient client;

    /**
     * 超时时间
     */
    public static final int TIMEOUT = 90;


    /**
     * 超时时间
     */
    public static final int TIMEOUT2 = 30;


    /**
     * application/x-www-form-urlencoded
     */
    public static final MediaType MEDIA_TYPE = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");

    /**
     * application/octet-stream
     */
    public static final MediaType MEDIA_OCTET_STREAM = MediaType.parse("application/octet-stream");

    static {
        client = new OkHttpClient().newBuilder().connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT2, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT2, TimeUnit.SECONDS)
                .build();
    }

    /**
     * 同步发送post请求 map为body
     *
     * @param url 请求url
     * @param map 请求map参数
     * @return 返回回来的JSONObject
     * @throws EgoistException 异常
     */
    public static JSONObject post(String url, Map<String, Object> map) throws EgoistException {
        StringBuilder context = new StringBuilder();
        // 遍历map
        if (map != null) {
            Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = iterator.next();
                context.append(entry.getKey()).append("=").append(entry.getValue());
                if (iterator.hasNext()) {
                    context.append("&");
                }
            }
        }

        RequestBody body = RequestBody.create(MEDIA_TYPE, context.toString());
        Request request = new Request.Builder().url(url).post(body).build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String data = response.body().string();
                return EgoistJsonUtil.jsonToPojo(data, JSONObject.class);
            }
            throw new EgoistException("服务器解析错误...", EgoistExceptionStatusConstant.STATUS_400);
        } catch (Exception e) {
            throw new EgoistException(e);
        }

    }

    /**
     * 同步发送post请求 map为body
     * 返回字符串
     *
     * @param url 请求url
     * @param map 请求map参数
     * @return 返回回来的JSONObject
     * @throws EgoistException 异常
     */
    public static String postMap(String url, Map<String, Object> map) throws EgoistException {
        StringBuilder context = new StringBuilder();
        // 遍历map
        if (map != null) {
            Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = iterator.next();
                context.append(entry.getKey()).append("=").append(entry.getValue());
                if (iterator.hasNext()) {
                    context.append("&");
                }
            }
        }

        RequestBody body = RequestBody.create(EgoistOkHttp3Util.MEDIA_TYPE, context.toString());
        Request request = new Request.Builder().url(url).post(body).build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String data = response.body().string();
                return data;
            }
            throw new EgoistException("服务器解析错误...", EgoistExceptionStatusConstant.STATUS_400);
        } catch (Exception e) {
            throw new EgoistException(e);
        }

    }

    /**
     * 同步发送post请求 map为body
     *
     * @param url 请求url
     * @param map 请求map参数
     * @return 返回回来的JSONObject
     * @throws EgoistException 异常
     */
    public static String postXml(String url, Map<String, Object> map) throws EgoistException {
        StringBuilder context = new StringBuilder();
        // 遍历map
        if (map != null) {
            Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = iterator.next();
                context.append(entry.getKey()).append("=").append(entry.getValue());
                if (iterator.hasNext()) {
                    context.append("&");
                }
            }
        }

        RequestBody body = RequestBody.create(MEDIA_TYPE, context.toString());
        Request request = new Request.Builder().url(url).post(body).build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String data = response.body().string();
                return data;
            }
            throw new EgoistException("服务器解析错误...", EgoistExceptionStatusConstant.STATUS_400);
        } catch (Exception e) {
            throw new EgoistException(e);
        }

    }

    /**
     * 同步发送post请求 map为body
     *
     * @param url     请求url
     * @param context 请求参数
     * @return 返回回来的JSONObject
     * @throws EgoistException 异常
     */
    public static String postString(String url, String context) throws EgoistException {

        RequestBody body = RequestBody.create(MEDIA_TYPE, context);
        Request request = new Request.Builder().url(url).post(body).build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String data = response.body().string();
                return data;
            }
            throw new EgoistException("服务器解析错误...", EgoistExceptionStatusConstant.STATUS_400);
        } catch (Exception e) {
            throw new EgoistException(e);
        }

    }


    /**
     * 同步发送post请求 map为body
     *
     * @param url 请求url
     * @param map 请求map参数
     * @return 返回回来的JSONObject
     * @throws EgoistException 异常
     */
    public static JSONObject postFormBody(String url, Map<String, Object> map) throws EgoistException {
        FormBody.Builder builder = new FormBody.Builder();
        // 遍历map
        if (map != null) {
            Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = iterator.next();
                builder.add(entry.getKey(), entry.getValue().toString());
            }
        }
        RequestBody formBody = builder.build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String data = response.body().string();
                return EgoistJsonUtil.jsonToPojo(data, JSONObject.class);
            }
            throw new EgoistException("服务器解析错误...", EgoistExceptionStatusConstant.STATUS_400);
        } catch (Exception e) {
            throw new EgoistException(e);
        }

    }


    /**
     * 同步发送post请求 文件byte[]
     *
     * @param url   请求url
     * @param map   请求map参数放入header中 (header中不能传中文，value 如果是字符串需要转码 URLEncoder.encode)
     * @param bytes 文件byte[]
     * @return 返回回来的JSONObject
     * @throws EgoistException 异常
     */
    public static JSONObject postByteArr(String url, Map map, byte[] bytes) throws EgoistException {
        if (map == null) {
            map = new HashMap();
        }
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .post(RequestBody.create(MEDIA_OCTET_STREAM, ByteString.of(bytes)))
                    .headers(Headers.of(map))
                    .build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String data = response.body().string();
                return EgoistJsonUtil.jsonToPojo(data, JSONObject.class);
            }
            throw new EgoistException("服务器解析错误...", EgoistExceptionStatusConstant.STATUS_400);
        } catch (Exception e) {
            throw new EgoistException(e);
        }

    }

    /**
     * 同步发送post请求 文件
     *
     * @param url   请求url
     * @param map   请求map参数
     * @param files 文件集合
     * @return 返回回来的JSONObject
     * @throws EgoistException 异常
     */
    public static JSONObject postFiles(String url, Map map, File... files) throws EgoistException {
        if (map == null) {
            map = new HashMap();
        }
        if (files.length == 0) {
            // if (null == file || !file.exists() || !file.canRead() || !file.isFile()) {
            throw new EgoistException("上传文件非法", EgoistExceptionStatusConstant.STATUS_400);
            // }
        }

        try {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);

            // 遍历map
            Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = iterator.next();
                builder.addFormDataPart(entry.getKey(), entry.getValue() == null ? "" : entry.getValue().toString());
            }

            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                builder.addFormDataPart("file" + i, file.getName(), RequestBody.create(MEDIA_OCTET_STREAM, file));
            }

            RequestBody requestBody = builder.build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String data = response.body().string();
                return EgoistJsonUtil.jsonToPojo(data, JSONObject.class);
            }
            throw new EgoistException("服务器解析错误...", EgoistExceptionStatusConstant.STATUS_400);
        } catch (Exception e) {
            throw new EgoistException(e);
        }

    }
}
