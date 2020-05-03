package uw.httpclient.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import okhttp3.Request;
import okhttp3.Response;
import uw.httpclient.util.NoReturnClass;
import uw.task.exception.MapperException;

import java.io.IOException;

/**
 * 实体请求结果抓取器
 * @author liliang，kaizen
 * @since 2017/9/25
 */
public class ObjectExtractor<T> implements ResponseExtractor<T> {

    private ObjectMapper objectMapper;

    private Class<T> responseType;

    private TypeReference<T> typeRef;

    private JavaType javaType;

    public ObjectExtractor(ObjectMapper objectMapper, Class<T> responseType) {
        this.objectMapper = objectMapper;
        this.responseType = responseType;
    }

    public ObjectExtractor(ObjectMapper objectMapper, TypeReference<T> typeRef) {
        this.objectMapper = objectMapper;
        this.typeRef = typeRef;
    }

    public ObjectExtractor(ObjectMapper objectMapper, JavaType javaType) {
        this.objectMapper = objectMapper;
        this.javaType = javaType;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T extractData(Request request,Response response,HttpMessageCallBack callBack) throws IOException, MapperException {
        String resp = response.body().string();
        if(callBack != null){
            resp = callBack.doConvert(resp);
            if (responseType == NoReturnClass.class && typeRef == null)
                return null;
        }
        if(responseType == String.class)
            return (T)resp;
        if (responseType != null)
            return (T)objectMapper.parse(resp,responseType);
        if(typeRef != null)
            return (T)objectMapper.parse(resp, typeRef);
        if(javaType != null)
            return (T)objectMapper.parse(resp, javaType);
        throw new IllegalArgumentException("responseType or typeRef or javaType must not null!");
    }

}
