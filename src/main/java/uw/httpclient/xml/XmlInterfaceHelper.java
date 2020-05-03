package uw.httpclient.xml;

import uw.httpclient.http.*;
/**
 * Xml接口助手
 * @author liliang
 * @since 2017/9/20
 */
public class XmlInterfaceHelper extends AbstractHttpInterface {

    private HttpHelper httpHelper;

    public static final ObjectMapper XML_CONVERTER = new XMLObjectMapperImpl();

    private HttpMessageCallBack callBack;

    /**
     * 生成一个默认实例
     * @return
     */
    public static HttpInterface getInstance(){
        return new XmlInterfaceHelper();
    }


    public XmlInterfaceHelper(){
        this.httpHelper = new HttpHelper();
        this.callBack = null;
    }

    public XmlInterfaceHelper(final HttpMessageCallBack callBack){
        this.httpHelper = new HttpHelper();
        this.callBack = callBack;
    }

    public XmlInterfaceHelper(final HttpConfig httpConfig){
        this.httpHelper = new HttpHelper(httpConfig);
        this.callBack = null;
    }

    public XmlInterfaceHelper(final HttpConfig httpConfig,final HttpMessageCallBack callBack){
        this.httpHelper = new HttpHelper(httpConfig);
        this.callBack = callBack;
    }


    /**
     * 值映射接口
     * @return
     */
    @Override
    public ObjectMapper objectMapper() {
        return XML_CONVERTER;
    }

    /**
     * 请求对象
     * @return
     */
    @Override
    public HttpHelper httpHelper(){
        return httpHelper;
    }

    /**
     * callBack,主要在ObjectMapper反序列化之前把content做一些处理
     * @return
     */
    public HttpMessageCallBack callBack(){
        return callBack;
    }

    /**
     * 请求对象
     * @param httpConfig
     * @return
     */
    @Override
    public HttpHelper httpHelper(HttpConfig httpConfig) {
        httpHelper = new HttpHelper(httpConfig);
        return httpHelper;
    }
}
