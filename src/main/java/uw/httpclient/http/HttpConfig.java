package uw.httpclient.http;

import okhttp3.Authenticator;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/**
 * HttpConfig
 * @author liliang
 * @since 2017/9/21
 */
public class HttpConfig {

    /**
     * 连接超时时间 - 毫秒
     */
    private final long connectTimeout;

    /**
     * 读超时时间 - 毫秒
     */
    private final long readTimeout;

    /**
     * 写超时时间 - 毫秒
     */
    private final long writeTimeout;

    /**
     * 全局验证器
     */
    private final Authenticator authenticator;

    /**
     * application interceptor
     */
    private final Interceptor applicationInterceptor;

    /**
     * network interceptor
     */
    private final Interceptor networkInterceptor;

    /**
     *
     * Configure this client to retry or not when a connectivity problem is encountered. By default,
     * this client silently recovers from the following problems:
     *
     * <ul>
     *   <li><strong>Unreachable IP addresses.</strong> If the URL's host has multiple IP addresses,
     *       failure to reach any individual IP address doesn't fail the overall request. This can
     *       increase availability of multi-homed services.
     *   <li><strong>Stale pooled connections.</strong> The {@link okhttp3.ConnectionPool} reuses sockets
     *       to decrease request latency, but these connections will occasionally time out.
     *   <li><strong>Unreachable proxy servers.</strong> A {@link java.net.ProxySelector} can be used to
     *       attempt multiple proxy servers in sequence, eventually falling back to a direct
     *       connection.
     * </ul>
     *
     * Set this to false to avoid retrying requests when doing so is destructive. In this case the
     * calling application should do its own recovery of connectivity failures.
     *
     * 简译
     *
     *   当一个连接发生问题时,配置此值可以进行重试。默认地,OkHttp自动从以下错误恢复
     * <ul>
     *   <li><strong>无法到达的IP地址</strong> </li> 如果url解析的主机对应多个IP地址,其中任务一个失败并不会导致整个
     *   请求失败,这样可以提升多宿主服务的可用性。
     *   <li><strong>OkHttp连接池过期</strong> <li/> OkHttp连接池复用了连接降低了网络延时,但是这些连接偶尔也会有超
     *   时发生。
     *   <li><strong>无法到达的的代理服务</strong> </li> 当目的主机对应一个中间层(比如 HA Proxy,LVS等等),连接失败
     *   时会直接向代理主机进行连接。
     * </ul>
     *    当你的业务是有严格幂等要求的,重试可能会出现严重问题(比如重复调用下单),应将此值配为false!在这种业务场景下,应用应该
     * 自行处理错!
     */
    private final boolean retryOnConnectionFailure;

    /**
     * 连接池
     */
    private final ConnectionPool connectionPool;

    /**
     * sslSocketFactory
     */
    private final SSLSocketFactory sslSocketFactory;

    /**
     * trustManager
     */
    private final X509TrustManager trustManager;

    /**
     * hostnameVerifier
     */
    private final HostnameVerifier hostnameVerifier;

    public HttpConfig(Builder builder) {
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
        this.authenticator = builder.authenticator;
        this.applicationInterceptor = builder.applicationInterceptor;
        this.networkInterceptor = builder.networkInterceptor;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.connectionPool = builder.connectionPool;
        this.sslSocketFactory = builder.sslSocketFactory;
        this.trustManager = builder.trustManager;
        this.hostnameVerifier = builder.hostnameVerifier;
    }

    public long connectTimeout() {
        return connectTimeout;
    }

    public long readTimeout() {
        return readTimeout;
    }

    public long writeTimeout() {
        return writeTimeout;
    }

    public Authenticator authenticator() {
        return authenticator;
    }

    public Interceptor applicationInterceptor() {
        return applicationInterceptor;
    }

    public Interceptor networkInterceptor() {
        return networkInterceptor;
    }

    public boolean onRetryOnConnectionFailure() {
        return retryOnConnectionFailure;
    }

    public ConnectionPool connectionPool() {
        return connectionPool;
    }

    public SSLSocketFactory sslSocketFactory() {
        return sslSocketFactory;
    }

    public X509TrustManager trustManager() {
        return trustManager;
    }

    public HostnameVerifier hostnameVerifier() {
        return hostnameVerifier;
    }

    public static class Builder {
        /**
         * 连接超时时间 - 毫秒
         */
        private long connectTimeout;

        /**
         * 读超时时间 - 毫秒
         */
        private long readTimeout;

        /**
         * 写超时时间 - 毫秒
         */
        private long writeTimeout;

        /**
         * 全局验证器
         */
        private Authenticator authenticator;

        /**
         * application interceptor
         */
        private Interceptor applicationInterceptor;

        /**
         * network interceptor
         */
        private Interceptor networkInterceptor;

        /**
         * RetryOnConnectionFailure
         */
        private boolean retryOnConnectionFailure = false;

        /**
         * 连接池
         */
        private ConnectionPool connectionPool;

        /**
         * sslSocketFactory
         */
        private SSLSocketFactory sslSocketFactory;

        /**
         * trustManager
         */
        private X509TrustManager trustManager;

        /**
         * hostnameVerifier
         */
        private HostnameVerifier hostnameVerifier;

        public Builder() {
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
        }

        public Builder connectTimeout(long connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public Builder readTimeout(long readTimeout) {
            this.readTimeout = connectTimeout;
            return this;
        }

        public Builder writeTimeout(long writeTimeout) {
            this.writeTimeout = writeTimeout;
            return this;
        }

        public Builder authenticator(Authenticator authenticator) {
            this.authenticator = authenticator;
            return this;
        }

        public Builder applicationInterceptor(Interceptor applicationInterceptor) {
            this.applicationInterceptor = applicationInterceptor;
            return this;
        }

        public Builder networkInterceptor(Interceptor networkInterceptor) {
            this.networkInterceptor = networkInterceptor;
            return this;
        }

        public Builder retryOnConnectionFailure(boolean retryOnConnectionFailure){
            this.retryOnConnectionFailure = retryOnConnectionFailure;
            return this;
        }

        public Builder connectionPool(ConnectionPool connectionPool){
            this.connectionPool = connectionPool;
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager){
            this.sslSocketFactory = sslSocketFactory;
            this.trustManager = trustManager;
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public HttpConfig build() {
            return new HttpConfig(this);
        }
    }
}
