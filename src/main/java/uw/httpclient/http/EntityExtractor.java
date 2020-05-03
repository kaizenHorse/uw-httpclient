package uw.httpclient.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import okhttp3.Request;
import okhttp3.Response;
import uw.httpclient.util.NoReturnClass;
import uw.task.exception.MapperException;

import java.io.IOException;

/**
 * 实体Wrapper请求结果抓取器
 *
 * @author liliang,Kaizen
 * @since 2017/9/25
 */
public class EntityExtractor<T> implements ResponseExtractor<ResponseWrapper<T>> {

    private ObjectMapper objectMapper;

    private Class<T> responseType;

    private TypeReference<T> typeRef;

    private JavaType javaType;


    public EntityExtractor(ObjectMapper objectMapper, Class<T> responseType) {
        this.objectMapper = objectMapper;
        this.responseType = responseType;
    }

    public EntityExtractor(ObjectMapper objectMapper, TypeReference<T> typeRef) {
        this.objectMapper = objectMapper;
        this.typeRef = typeRef;
    }

    public EntityExtractor(ObjectMapper objectMapper, JavaType javaType) {
        this.objectMapper = objectMapper;
        this.javaType = javaType;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ResponseWrapper<T> extractData(Request request, Response response, HttpMessageCallBack callBack) throws IOException, MapperException {
        String resp = response.body().string();
        if (callBack != null) {
            resp = callBack.doConvert(resp);
            if (responseType == NoReturnClass.class && typeRef == null)
                return null;
        }

        if(responseType == String.class)
            return new ResponseWrapper<>(request, response, (T) resp, resp);
        if (responseType != null)
            return new ResponseWrapper<>(request, response, objectMapper.parse(resp, responseType), resp);
        if(typeRef != null)
            return new ResponseWrapper<>(request, response, objectMapper.parse(resp, typeRef), resp);
        if (javaType != null)
            return new ResponseWrapper<>(request, response, objectMapper.parse(resp, javaType), resp);
        throw new IllegalArgumentException("responseType or typeRef or javaType must not null!");
    }
}
