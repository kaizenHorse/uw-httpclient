package uw.httpclient.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.Map;

/**
 * Http请求接口
 * @author liliang
 * @since 2017/9/20
 */
public interface HttpInterface {

    /**
     * 值映射接口
     * @return
     */
    ObjectMapper objectMapper();

    /**
     * 请求对象
     * @return
     */
    HttpHelper httpHelper();

    /**
     * HTTP callBack
     * @return
     */
    HttpMessageCallBack callBack();

    /**
     * 请求对象
     * @param httpConfig
     * @return
     */
    HttpHelper httpHelper(HttpConfig httpConfig);

    /**
     * 自定义请求
     * @param request
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T requestForResponse(Request request) throws Exception;

    /**
     * 自定义请求
     * @param request
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T requestForResponse(HttpConfig httpConfig, Request request) throws Exception;

    /**
     * 自定义请求
     * @param request
     * @param responseType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> requestForEntity(Request request, Class<T> responseType) throws Exception;

    /**
     * 自定义请求
     * @param request
     * @param typeRef
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> requestForEntity(Request request, TypeReference<T> typeRef) throws Exception;


    /**
     * 自定义请求
     * @param request
     * @param javaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> requestForEntity(Request request, JavaType javaType) throws Exception;

    /**
     * 自定义请求
     * @param request
     * @param responseType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T requestForObject(Request request, Class<T> responseType) throws Exception;

    /**
     * 自定义请求
     * @param request
     * @param typeRef
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T requestForObject(Request request, TypeReference<T> typeRef) throws Exception;


    /**
     * 自定义请求
     * @param request
     * @param javaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T requestForObject(Request request, JavaType javaType) throws Exception;

    /**
     * 自定义请求
     * @param request
     * @param responseType
     * @param httpConfig
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> requestEntity(Request request, Class<T> responseType, HttpConfig httpConfig) throws Exception;

    /**
     * 自定义请求
     * @param request
     * @param typeRef
     * @param httpConfig
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> requestEntity(Request request, TypeReference<T> typeRef, HttpConfig httpConfig) throws Exception;

    /**
     * 自定义请求
     * @param request
     * @param javaType
     * @param httpConfig
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> requestEntity(Request request, JavaType javaType, HttpConfig httpConfig) throws Exception;

    /**
     * 自定义请求
     * @param request
     * @param responseType
     * @param httpConfig
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T requestForObject(Request request, Class<T> responseType, HttpConfig httpConfig) throws Exception;

    /**
     * 自定义请求
     * @param request
     * @param typeRef
     * @param httpConfig
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T requestForObject(Request request, TypeReference<T> typeRef, HttpConfig httpConfig) throws Exception;

    /**
     * 自定义请求
     * @param request
     * @param javaType
     * @param httpConfig
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T requestForObject(Request request, JavaType javaType, HttpConfig httpConfig) throws Exception;

    /**
     * GET
     * @param url
     * @param responseType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T getForObject(String url, Class<T> responseType) throws Exception;

    /**
     * GET
     * @param url
     * @param responseType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> getForEntity(String url, Class<T> responseType) throws Exception;

    /**
     * GET
     * @param url
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T getForObject(String url, TypeReference<T> typeRef) throws Exception;

    /**
     * GET
     * @param url
     * @param typeRef
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> getForEntity(String url, TypeReference<T> typeRef) throws Exception;

    /**
     * GET
     * @param url
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T getForObject(String url, JavaType type) throws Exception;

    /**
     * GET
     * @param url
     * @param type
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> getForEntity(String url, JavaType type) throws Exception;

    /**
     * GET
     * @param url
     * @param responseType
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> getForEntity(String url, Class<T> responseType, Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param typeRef
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> getForEntity(String url, TypeReference<T> typeRef, Map<String, String> uriVariables) throws Exception;


    /**
     * GET
     * @param url
     * @param javaType
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> getForEntity(String url, JavaType javaType, Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param responseType
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T getForObject(String url, Class<T> responseType, Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param typeRef
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T getForObject(String url, TypeReference<T> typeRef, Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param javaType
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T getForObject(String url, JavaType javaType, Map<String, String> uriVariables) throws Exception;


    /**
     * GET
     * @param url
     * @param responseType
     * @param httpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> getForEntity(String url, Class<T> responseType, HttpConfig httpConfig, Map<String, String> uriVariables) throws Exception;


    /**
     * GET
     * @param url
     * @param typeRef
     * @param httpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> getForEntity(String url, TypeReference<T> typeRef, HttpConfig httpConfig, Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param javaType
     * @param httpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> getForEntity(String url, JavaType javaType, HttpConfig httpConfig, Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param responseType
     * @param httpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T getForObject(String url, Class<T> responseType, HttpConfig httpConfig, Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param typeRef
     * @param httpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T getForObject(String url, TypeReference<T> typeRef, HttpConfig httpConfig, Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param javaType
     * @param httpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T getForObject(String url, JavaType javaType, HttpConfig httpConfig, Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param responseType
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> getForEntity(String url, Map<String, String> headers, Class<T> responseType,
                                        Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param typeRef
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> getForEntity(String url, Map<String, String> headers, TypeReference<T> typeRef,
                                        Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param javaType
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> getForEntity(String url, Map<String, String> headers, JavaType javaType,
                                        Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param responseType
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T getForObject(String url, Map<String, String> headers, Class<T> responseType,
                       Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param typeRef
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T getForObject(String url, Map<String, String> headers, TypeReference<T> typeRef,
                       Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param javaType
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T getForObject(String url, Map<String, String> headers, JavaType javaType,
                       Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param responseType
     * @param httpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> getForEntity(String url, Map<String, String> headers, Class<T> responseType, HttpConfig httpConfig,
                                        Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param typeRef
     * @param httpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> getForEntity(String url, Map<String, String> headers, TypeReference<T> typeRef, HttpConfig httpConfig,
                                        Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param javaType
     * @param httpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> getForEntity(String url, Map<String, String> headers, JavaType javaType, HttpConfig httpConfig,
                                        Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param responseType
     * @param httpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T getForObject(String url, Map<String, String> headers, Class<T> responseType, HttpConfig httpConfig,
                       Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param typeRef
     * @param httpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T getForObject(String url, Map<String, String> headers, TypeReference<T> typeRef, HttpConfig httpConfig,
                       Map<String, String> uriVariables) throws Exception;

    /**
     * GET
     * @param url
     * @param javaType
     * @param httpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T getForObject(String url, Map<String, String> headers, JavaType javaType, HttpConfig httpConfig,
                       Map<String, String> uriVariables) throws Exception;
    /**
     * POST
     * @param url
     * @param responseType
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Class<T> responseType, RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param responseType
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Class<T> responseType, RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param responseType
     * @param formParam
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Class<T> responseType, Map<String, String> formParam) throws Exception;

    /**
     * POST
     * @param url
     * @param responseType
     * @param formParam
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Class<T> responseType, Map<String, String> formParam) throws Exception;

    /**
     * POST
     * @param url
     * @param typeRef
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, TypeReference<T> typeRef, RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param typeRef
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, TypeReference<T> typeRef, RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param typeRef
     * @param formParam
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, TypeReference<T> typeRef, Map<String, String> formParam) throws Exception;

    /**
     * POST
     * @param url
     * @param typeRef
     * @param formParam
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, TypeReference<T> typeRef, Map<String, String> formParam) throws Exception;

    /**
     * POST
     * @param url
     * @param javaType
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, JavaType javaType, RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param javaType
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, JavaType javaType, RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param javaType
     * @param formParam
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, JavaType javaType, Map<String, String> formParam) throws Exception;

    /**
     * POST
     * @param url
     * @param javaType
     * @param formParam
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, JavaType javaType, Map<String, String> formParam) throws Exception;

    /**
     * POST
     * @param url
     * @param responseType
     * @param httpConfig
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Class<T> responseType, HttpConfig httpConfig, RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param typeRef
     * @param httpConfig
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, TypeReference<T> typeRef, HttpConfig httpConfig, RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param javaType
     * @param httpConfig
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, JavaType javaType, HttpConfig httpConfig, RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param responseType
     * @param httpConfig
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Class<T> responseType, HttpConfig httpConfig, RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param typeRef
     * @param httpConfig
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, TypeReference<T> typeRef, HttpConfig httpConfig, RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param javaType
     * @param httpConfig
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, JavaType javaType, HttpConfig httpConfig, RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param responseType
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, Class<T> responseType,
                                         RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param typeRef
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, TypeReference<T> typeRef,
                                         RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param javaType
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, JavaType javaType,
                                         RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param responseType
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType,
                        RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param typeRef
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Map<String, String> headers, TypeReference<T> typeRef,
                        RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param javaType
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Map<String, String> headers, JavaType javaType,
                        RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param responseType
     * @param httpConfig
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, Class<T> responseType, HttpConfig httpConfig,
                                         RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param typeRef
     * @param httpConfig
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, TypeReference<T> typeRef, HttpConfig httpConfig,
                                         RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param javaType
     * @param httpConfig
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, JavaType javaType, HttpConfig httpConfig,
                                         RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param responseType
     * @param httpConfig
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType, HttpConfig httpConfig,
                        RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param typeRef
     * @param httpConfig
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Map<String, String> headers, TypeReference<T> typeRef, HttpConfig httpConfig,
                        RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param javaType
     * @param httpConfig
     * @param requestBody
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Map<String, String> headers, JavaType javaType, HttpConfig httpConfig,
                        RequestBody requestBody) throws Exception;

    /**
     * POST
     * @param url
     * @param responseType
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Class<T> responseType,
                                         String content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param typeRef
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, TypeReference<T> typeRef,
                                         String content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param javaType
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, JavaType javaType,
                                         String content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param responseType
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Class<T> responseType,
                        String content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param typeRef
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, TypeReference<T> typeRef,
                        String content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param javaType
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, JavaType javaType,
                        String content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param responseType
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Class<T> responseType,
                                         Object content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param typeRef
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, TypeReference<T> typeRef,
                                         Object content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param javaType
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, JavaType javaType,
                                         Object content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param responseType
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Class<T> responseType,
                        Object content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param typeRef
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, TypeReference<T> typeRef,
                        Object content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param javaType
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, JavaType javaType,
                        Object content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param responseType
     * @param httpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Class<T> responseType, HttpConfig httpConfig,
                                         String content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param typeRef
     * @param httpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, TypeReference<T> typeRef, HttpConfig httpConfig,
                                         String content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param javaType
     * @param httpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, JavaType javaType, HttpConfig httpConfig,
                                         String content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param responseType
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType,
                        String content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param typeRef
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Map<String, String> headers, TypeReference<T> typeRef,
                        String content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param javaType
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Map<String, String> headers, JavaType javaType,
                        String content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param responseType
     * @param httpConfig
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Class<T> responseType, HttpConfig httpConfig,
                                         Object content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param typeRef
     * @param httpConfig
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, TypeReference<T> typeRef, HttpConfig httpConfig,
                                         Object content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param javaType
     * @param httpConfig
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, JavaType javaType, HttpConfig httpConfig,
                                         Object content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param responseType
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType,
                        Object content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param responseType
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, Class<T> responseType,
                                         Object content, MediaType mediaType) throws Exception;


    /**
     * POST
     * @param url
     * @param headers
     * @param typeRef
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Map<String, String> headers, TypeReference<T> typeRef,
                        Object content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param javaType
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Map<String, String> headers, JavaType javaType,
                        Object content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param responseType
     * @param httpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, Class<T> responseType, HttpConfig httpConfig,
                                         String content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param typeRef
     * @param httpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, TypeReference<T> typeRef, HttpConfig httpConfig,
                                         String content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param javaType
     * @param httpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, JavaType javaType, HttpConfig httpConfig,
                                         String content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param responseType
     * @param httpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType, HttpConfig httpConfig,
                        String content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param typeRef
     * @param httpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Map<String, String> headers, TypeReference<T> typeRef, HttpConfig httpConfig,
                        String content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param javaType
     * @param httpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Map<String, String> headers, JavaType javaType, HttpConfig httpConfig,
                        String content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param responseType
     * @param httpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, Class<T> responseType, HttpConfig httpConfig,
                                         Object content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param typeRef
     * @param httpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, TypeReference<T> typeRef, HttpConfig httpConfig,
                                         Object content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param javaType
     * @param httpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, JavaType javaType, HttpConfig httpConfig,
                                         Object content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param responseType
     * @param httpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType, HttpConfig httpConfig,
                        Object content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param typeRef
     * @param httpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Map<String, String> headers, TypeReference<T> typeRef, HttpConfig httpConfig,
                        Object content, MediaType mediaType) throws Exception;

    /**
     * POST
     * @param url
     * @param headers
     * @param javaType
     * @param httpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T postForObject(String url, Map<String, String> headers, JavaType javaType, HttpConfig httpConfig,
                        Object content, MediaType mediaType) throws Exception;
}
