package uw.httpclient.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import okhttp3.*;
import uw.task.exception.TaskPartnerException;

import java.io.IOException;
import java.util.Map;

/**
 * Http请求方法抽象实现
 *
 * @author liliang
 * @since 2017/9/20
 */
public abstract class AbstractHttpInterface implements HttpInterface {

	/**
	 * 自定义请求
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> T requestForResponse(Request request) throws Exception {
		return (T) handleResponse(null, request, ResponseExtractor.RESPONSE_CALLBACK);
	}

	/**
	 * 自定义请求
	 *
	 * @param request
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> T requestForResponse(HttpConfig httpConfig, Request request) throws Exception {
		return (T) handleResponse(httpConfig, request, ResponseExtractor.RESPONSE_CALLBACK);
	}

	/**
	 * 自定义请求
	 *
	 * @param request
	 * @param responseType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> requestForEntity(Request request, Class<T> responseType) throws Exception {
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * 自定义请求
	 *
	 * @param request
	 * @param typeRef
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> requestForEntity(Request request, TypeReference<T> typeRef) throws Exception {
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * 自定义请求
	 * @param request
	 * @param javaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> requestForEntity(Request request, JavaType javaType) throws Exception {
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}
	/**
	 * 自定义请求
	 *
	 * @param request
	 * @param responseType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T requestForObject(Request request, Class<T> responseType) throws Exception {
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * 自定义请求
	 *
	 * @param request
	 * @param typeRef
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T requestForObject(Request request, TypeReference<T> typeRef) throws Exception {
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * 自定义请求
	 *
	 * @param request
	 * @param javaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T requestForObject(Request request, JavaType javaType) throws Exception {
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * 自定义请求
	 *
	 * @param request
	 * @param responseType
	 * @param httpConfig
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> requestEntity(Request request, Class<T> responseType, HttpConfig httpConfig)
			throws Exception {
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * 自定义请求
	 *
	 * @param request
	 * @param typeRef
	 * @param httpConfig
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> requestEntity(Request request, TypeReference<T> typeRef, HttpConfig httpConfig)
			throws Exception {
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), typeRef);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * 自定义请求
	 *
	 * @param request
	 * @param javaType
	 * @param httpConfig
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> requestEntity(Request request, JavaType javaType, HttpConfig httpConfig)
			throws Exception {
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), javaType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * 自定义请求
	 *
	 * @param request
	 * @param responseType
	 * @param httpConfig
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T requestForObject(Request request, Class<T> responseType, HttpConfig httpConfig)
			throws Exception {
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), responseType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * 自定义请求
	 *
	 * @param request
	 * @param typeRef
	 * @param httpConfig
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T requestForObject(Request request, TypeReference<T> typeRef, HttpConfig httpConfig) throws Exception {
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), typeRef);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * 自定义请求
	 *
	 * @param request
	 * @param javaType
	 * @param httpConfig
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T requestForObject(Request request, JavaType javaType, HttpConfig httpConfig) throws Exception {
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), javaType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param responseType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T getForObject(String url, Class<T> responseType) throws Exception {
		Request request = new Request.Builder().url(url).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}


	/**
	 * GET
	 *
	 * @param url
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T getForObject(String url, TypeReference<T> typeRef) throws Exception {
		Request request = new Request.Builder().url(url).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T getForObject(String url, JavaType javaType) throws Exception {
		Request request = new Request.Builder().url(url).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param responseType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> getForEntity(String url, Class<T> responseType) throws Exception {
		Request request = new Request.Builder().url(url).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param typeRef
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> getForEntity(String url, TypeReference<T> typeRef) throws Exception {
		Request request = new Request.Builder().url(url).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param javaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> getForEntity(String url, JavaType javaType) throws Exception {
		Request request = new Request.Builder().url(url).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param responseType
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> getForEntity(String url, Class<T> responseType, Map<String, String> uriVariables)
			throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param typeRef
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> getForEntity(String url, TypeReference<T> typeRef, Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param javaType
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> getForEntity(String url, JavaType javaType, Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param responseType
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T getForObject(String url, Class<T> responseType, Map<String, String> uriVariables)
			throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param typeRef
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T getForObject(String url, TypeReference<T> typeRef, Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param javaType
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T getForObject(String url, JavaType javaType, Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}


	/**
	 * GET
	 *
	 * @param url
	 * @param responseType
	 * @param httpConfig
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> getForEntity(String url, Class<T> responseType, HttpConfig httpConfig,
											   Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param typeRef
	 * @param httpConfig
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> getForEntity(String url, TypeReference<T> typeRef, HttpConfig httpConfig,
											   Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), typeRef);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param javaType
	 * @param httpConfig
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> getForEntity(String url, JavaType javaType, HttpConfig httpConfig,
											   Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), javaType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param responseType
	 * @param httpConfig
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T getForObject(String url, Class<T> responseType, HttpConfig httpConfig, Map<String, String> uriVariables)
			throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), responseType);
		return handleResponse(httpConfig, request, extractor);
	}


	/**
	 * GET
	 *
	 * @param url
	 * @param typeRef
	 * @param httpConfig
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T getForObject(String url, TypeReference<T> typeRef, HttpConfig httpConfig, Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), typeRef);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param javaType
	 * @param httpConfig
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T getForObject(String url, JavaType javaType, HttpConfig httpConfig, Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), javaType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param responseType
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> getForEntity(String url, Map<String, String> headers, Class<T> responseType,
											   Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param typeRef
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> getForEntity(String url, Map<String, String> headers, TypeReference<T> typeRef,
											   Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param javaType
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> getForEntity(String url, Map<String, String> headers, JavaType javaType,
											   Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}


	/**
	 * GET
	 *
	 * @param url
	 * @param responseType
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T getForObject(String url, Map<String, String> headers, Class<T> responseType,
							  Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param typeRef
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T getForObject(String url, Map<String, String> headers, TypeReference<T> typeRef,
							  Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param javaType
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T getForObject(String url, Map<String, String> headers, JavaType javaType,
							  Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param responseType
	 * @param httpConfig
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> getForEntity(String url, Map<String, String> headers, Class<T> responseType,
											   HttpConfig httpConfig, Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param typeRef
	 * @param httpConfig
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> getForEntity(String url, Map<String, String> headers, TypeReference<T> typeRef, HttpConfig httpConfig,
											   Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), typeRef);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param javaType
	 * @param httpConfig
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> getForEntity(String url, Map<String, String> headers, JavaType javaType, HttpConfig httpConfig,
											   Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), javaType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param responseType
	 * @param httpConfig
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T getForObject(String url, Map<String, String> headers, Class<T> responseType, HttpConfig httpConfig,
							  Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), responseType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param typeRef
	 * @param httpConfig
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T getForObject(String url, Map<String, String> headers, TypeReference<T> typeRef, HttpConfig httpConfig,
							  Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), typeRef);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * GET
	 *
	 * @param url
	 * @param javaType
	 * @param httpConfig
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T getForObject(String url, Map<String, String> headers, JavaType javaType, HttpConfig httpConfig,
							  Map<String, String> uriVariables) throws Exception {
		Request request = new Request.Builder().url(buildUrl(url, uriVariables))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), javaType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param responseType
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Class<T> responseType, RequestBody requestBody)
			throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param typeRef
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, TypeReference<T> typeRef, RequestBody requestBody)
			throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param javaType
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, JavaType javaType, RequestBody requestBody)
			throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}


	/**
	 * POST
	 *
	 * @param url
	 * @param responseType
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Class<T> responseType, RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}


	/**
	 * POST
	 *
	 * @param url
	 * @param responseType
	 * @param formParam
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Class<T> responseType, Map<String, String> formParam) throws Exception {
		FormBody.Builder formBodyBuilder = new FormBody.Builder();
		for (Map.Entry<String, String> param : formParam.entrySet()) {
			formBodyBuilder.add(param.getKey(), param.getValue());
		}
		Request request = new Request.Builder().url(url).post(formBodyBuilder.build()).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param responseType
	 * @param formParam
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Class<T> responseType, Map<String, String> formParam) throws Exception {
		FormBody.Builder formBodyBuilder = new FormBody.Builder();
		for (Map.Entry<String, String> param : formParam.entrySet()) {
			formBodyBuilder.add(param.getKey(), param.getValue());
		}
		Request request = new Request.Builder().url(url).post(formBodyBuilder.build()).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param typeRef
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, TypeReference<T> typeRef, RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param typeRef
	 * @param formParam
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, TypeReference<T> typeRef, Map<String, String> formParam) throws Exception {
		FormBody.Builder formBodyBuilder = new FormBody.Builder();
		for (Map.Entry<String, String> param : formParam.entrySet()) {
			formBodyBuilder.add(param.getKey(), param.getValue());
		}
		Request request = new Request.Builder().url(url).post(formBodyBuilder.build()).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param typeRef
	 * @param formParam
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, TypeReference<T> typeRef, Map<String, String> formParam) throws Exception {
		FormBody.Builder formBodyBuilder = new FormBody.Builder();
		for (Map.Entry<String, String> param : formParam.entrySet()) {
			formBodyBuilder.add(param.getKey(), param.getValue());
		}
		Request request = new Request.Builder().url(url).post(formBodyBuilder.build()).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param javaType
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, JavaType javaType, RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param javaType
	 * @param formParam
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, JavaType javaType, Map<String, String> formParam) throws Exception {
		FormBody.Builder formBodyBuilder = new FormBody.Builder();
		for (Map.Entry<String, String> param : formParam.entrySet()) {
			formBodyBuilder.add(param.getKey(), param.getValue());
		}
		Request request = new Request.Builder().url(url).post(formBodyBuilder.build()).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param javaType
	 * @param formParam
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, JavaType javaType, Map<String, String> formParam) throws Exception {
		FormBody.Builder formBodyBuilder = new FormBody.Builder();
		for (Map.Entry<String, String> param : formParam.entrySet()) {
			formBodyBuilder.add(param.getKey(), param.getValue());
		}
		Request request = new Request.Builder().url(url).post(formBodyBuilder.build()).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param responseType
	 * @param httpConfig
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Class<T> responseType, HttpConfig httpConfig,
												RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param typeRef
	 * @param httpConfig
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, TypeReference<T> typeRef, HttpConfig httpConfig,
												RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), typeRef);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param javaType
	 * @param httpConfig
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, JavaType javaType, HttpConfig httpConfig,
												RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), javaType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param responseType
	 * @param httpConfig
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Class<T> responseType, HttpConfig httpConfig, RequestBody requestBody)
			throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), responseType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param typeRef
	 * @param httpConfig
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, TypeReference<T> typeRef, HttpConfig httpConfig, RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), typeRef);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param javaType
	 * @param httpConfig
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, JavaType javaType, HttpConfig httpConfig, RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), javaType);
		return handleResponse(httpConfig, request, extractor);
	}


	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param responseType
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, Class<T> responseType,
												RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param typeRef
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, TypeReference<T> typeRef,
												RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}
	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param javaType
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, JavaType javaType,
												RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}


	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param responseType
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType, RequestBody requestBody)
			throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param typeRef
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, TypeReference<T> typeRef,
							   RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param javaType
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, JavaType javaType,
							   RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}


	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param responseType
	 * @param httpConfig
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, Class<T> responseType,
												HttpConfig httpConfig, RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param typeRef
	 * @param httpConfig
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, TypeReference<T> typeRef, HttpConfig httpConfig,
												RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), typeRef);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param javaType
	 * @param httpConfig
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, JavaType javaType, HttpConfig httpConfig,
												RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), javaType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param responseType
	 * @param httpConfig
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType, HttpConfig httpConfig,
							   RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), responseType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param typeRef
	 * @param httpConfig
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, TypeReference<T> typeRef, HttpConfig httpConfig,
							   RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), typeRef);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param javaType
	 * @param httpConfig
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, JavaType javaType, HttpConfig httpConfig,
							   RequestBody requestBody) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), javaType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param responseType
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Class<T> responseType, String content, MediaType mediaType)
			throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param typeRef
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, TypeReference<T> typeRef,
												String content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param javaType
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, JavaType javaType,
												String content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param responseType
	 * @param content
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Class<T> responseType, String content, MediaType mediaType)
			throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param typeRef
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, TypeReference<T> typeRef,
							   String content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param javaType
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, JavaType javaType,
							   String content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param responseType
	 * @param content
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Class<T> responseType,
												Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(
				RequestBody.create(mediaType, objectMapper().toString(content))).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param typeRef
	 * @param content
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, TypeReference<T> typeRef,
												Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(
				RequestBody.create(mediaType, objectMapper().toString(content))).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param javaType
	 * @param content
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, JavaType javaType,
												Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(
				RequestBody.create(mediaType, objectMapper().toString(content))).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param responseType
	 * @param content
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Class<T> responseType,
							   Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(
				RequestBody.create(mediaType, objectMapper().toString(content))).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param typeRef
	 * @param content
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, TypeReference<T> typeRef,
							   Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(
				RequestBody.create(mediaType, objectMapper().toString(content))).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param javaType
	 * @param content
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, JavaType javaType,
							   Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(
				RequestBody.create(mediaType, objectMapper().toString(content))).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}


	/**
	 * POST
	 *
	 * @param url
	 * @param responseType
	 * @param httpConfig
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Class<T> responseType, HttpConfig httpConfig,
												String content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param typeRef
	 * @param httpConfig
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, TypeReference<T> typeRef, HttpConfig httpConfig,
												String content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), typeRef);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param javaType
	 * @param httpConfig
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, JavaType javaType, HttpConfig httpConfig,
												String content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), javaType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param responseType
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType, String content,
							   MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param typeRef
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, TypeReference<T> typeRef,
							   String content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param javaType
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, JavaType javaType,
							   String content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param responseType
	 * @param httpConfig
	 * @param content
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Class<T> responseType, HttpConfig httpConfig,
												Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(
				RequestBody.create(mediaType, objectMapper().toString(content))).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param typeRef
	 * @param httpConfig
	 * @param content
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, TypeReference<T> typeRef, HttpConfig httpConfig,
												Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(
				RequestBody.create(mediaType, objectMapper().toString(content))).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), typeRef);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param javaType
	 * @param httpConfig
	 * @param content
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, JavaType javaType, HttpConfig httpConfig,
												Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(
				RequestBody.create(mediaType, objectMapper().toString(content))).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), javaType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param responseType
	 * @param content
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType,
							   Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, objectMapper().toString(content)))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param responseType
	 * @param content
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, Class<T> responseType,
												Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, objectMapper().toString(content)))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param typeRef
	 * @param content
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, TypeReference<T> typeRef,
							   Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, objectMapper().toString(content)))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), typeRef);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param javaType
	 * @param content
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, JavaType javaType,
							   Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, objectMapper().toString(content)))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), javaType);
		return handleResponse(null, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param responseType
	 * @param httpConfig
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, Class<T> responseType,
												HttpConfig httpConfig, String content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param typeRef
	 * @param httpConfig
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, TypeReference<T> typeRef, HttpConfig httpConfig,
												String content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), typeRef);
		return handleResponse(httpConfig, request, extractor);
	}


	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param javaType
	 * @param httpConfig
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, JavaType javaType, HttpConfig httpConfig,
												String content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), javaType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param responseType
	 * @param httpConfig
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType, HttpConfig httpConfig,
							   String content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), responseType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param typeRef
	 * @param httpConfig
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, TypeReference<T> typeRef, HttpConfig httpConfig,
							   String content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), typeRef);
		return handleResponse(httpConfig, request, extractor);
	}


	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param javaType
	 * @param httpConfig
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, JavaType javaType, HttpConfig httpConfig,
							   String content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), javaType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param responseType
	 * @param httpConfig
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, Class<T> responseType, HttpConfig httpConfig,
												Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, objectMapper().toString(content)))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), responseType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param typeRef
	 * @param httpConfig
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, TypeReference<T> typeRef, HttpConfig httpConfig,
												Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, objectMapper().toString(content)))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), typeRef);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param javaType
	 * @param httpConfig
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> ResponseWrapper<T> postForEntity(String url, Map<String, String> headers, JavaType javaType, HttpConfig httpConfig,
												Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, objectMapper().toString(content)))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<ResponseWrapper<T>> extractor = responseEntityExtractor(objectMapper(), javaType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param responseType
	 * @param httpConfig
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType, HttpConfig httpConfig,
							   Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(
				RequestBody.create(mediaType, objectMapper().toString(content)))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), responseType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param typeRef
	 * @param httpConfig
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, TypeReference<T> typeRef, HttpConfig httpConfig,
							   Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(
				RequestBody.create(mediaType, objectMapper().toString(content)))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), typeRef);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * POST
	 *
	 * @param url
	 * @param headers
	 * @param javaType
	 * @param httpConfig
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, JavaType javaType, HttpConfig httpConfig,
							   Object content, MediaType mediaType) throws Exception {
		Request request = new Request.Builder().url(url).post(
				RequestBody.create(mediaType, objectMapper().toString(content)))
				.headers(Headers.of(headers)).build();
		ResponseExtractor<T> extractor = new ObjectExtractor<>(objectMapper(), javaType);
		return handleResponse(httpConfig, request, extractor);
	}

	/**
	 * responseEntityExtractor
	 *
	 * @param objectMapper
	 * @param responseType
	 * @param <T>
	 * @return
	 */
	private <T> ResponseExtractor<ResponseWrapper<T>> responseEntityExtractor(ObjectMapper objectMapper,
																			  Class<T> responseType) {
		return new EntityExtractor<>(objectMapper, responseType);
	}

	/**
	 * responseEntityExtractor
	 *
	 * @param objectMapper
	 * @param typeRef
	 * @param <T>
	 * @return
	 */
	private <T> ResponseExtractor<ResponseWrapper<T>> responseEntityExtractor(ObjectMapper objectMapper,
																			  TypeReference<T> typeRef) {
		return new EntityExtractor<>(objectMapper, typeRef);
	}

	/**
	 * responseEntityExtractor
	 *
	 * @param objectMapper
	 * @param javaType
	 * @param <T>
	 * @return
	 */
	private <T> ResponseExtractor<ResponseWrapper<T>> responseEntityExtractor(ObjectMapper objectMapper,
																			  JavaType javaType) {
		return new EntityExtractor<>(objectMapper, javaType);
	}

	/**
	 * handleResponse
	 *
	 * @param request
	 * @param extractor
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	private <T> T handleResponse(HttpConfig httpConfig, final Request request, final ResponseExtractor<T> extractor)
			throws Exception {
		if (httpConfig != null) {
			httpHelper(httpConfig);
		}
		Response response = null;
		try {
			response = httpHelper().execute(request);
		} catch (IOException e) {
			throw new TaskPartnerException(e.getMessage(), e);
		}
		if (response.isSuccessful()) {
			try {
				return extractor.extractData(request, response, callBack());
			} catch (IOException t) {
				throw new TaskPartnerException("返回结果失败: ", t);
			}
		}
		throw new TaskPartnerException("HTTP CODE: " + response.code() + ", RESPONSE: " + response.body().string());
	}

	/**
	 * @param url          url路径
	 * @param uriVariables 参数
	 * @return HttpUrl url
	 */
	private HttpUrl buildUrl(String url, Map<String, String> uriVariables) throws Exception {
		HttpUrl httpUrl = HttpUrl.parse(url);
		if (httpUrl == null) {
			throw new Exception("url invalid!");
		}
		HttpUrl.Builder urlBuilder = httpUrl.newBuilder();
		uriVariables.forEach(urlBuilder::addQueryParameter);
		return urlBuilder.build();
	}
}
