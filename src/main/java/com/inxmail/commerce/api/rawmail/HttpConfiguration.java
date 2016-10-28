package com.inxmail.commerce.api.rawmail;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import java.util.Map;
import javax.ws.rs.core.Configurable;
import javax.ws.rs.core.Configuration;


/**
 * Configuration for the JAX-RS Client API used to access the Inxmail Commerce API.
 * <p>
 * Intended purpose is configuring proxy settings and timeouts.
 * Other JAX-RS configuration, namely registration of filters and interceptors,
 * is possible, although at the risk of interfering with the internal configuration
 * needed for the features of this library.
 */
public class HttpConfiguration implements Configurable<HttpConfiguration> {
    private final ClientConfig configuration;

    /**
     * Create a new HttpConfiguration, with default timeouts and no proxy.
     */
    public HttpConfiguration() {
        this.configuration = new ClientConfig();
        setTimeouts( 30000 );
    }

    /**
     * Set a proxy to use for the Inxmail Commerce API connection
     *
     * @param proxyUrl the URL of the proxy server
     * @return this object to fluently perform more configuration
     */
    public HttpConfiguration setProxy( String proxyUrl ) {
        return property( ClientProperties.PROXY_URI, proxyUrl );
    }

    /**
     * Set a proxy that uses authentication to use for the Inxmail Commerce API connection
     *
     * @param proxyUrl      the URL of the proxy server
     * @param proxyUsername the username for the proxy server
     * @param proxyPassword the password for the proxy server
     * @return this object to fluently perform more configuration
     */
    public HttpConfiguration setProxy( String proxyUrl, String proxyUsername, String proxyPassword ) {
        return property( ClientProperties.PROXY_URI, proxyUrl ).property( ClientProperties.PROXY_USERNAME, proxyUsername ).property( ClientProperties.PROXY_PASSWORD, proxyPassword );
    }

    /**
     * Set connection and socket read timeouts to this value.
     *
     * @param timeout in milliseconds for both connection and socket read. Default value is 30s
     * @return this object to fluently perform more configuration
     */
    public HttpConfiguration setTimeouts( int timeout ) {
        return setTimeouts( timeout, timeout );
    }

    /**
     * Set connection and socket read timeouts to the supplied values.
     *
     * @param connectTimeout connection timeout in milliseconds
     * @param socketTimeout  socket read timeout in milliseconds
     * @return this object to fluently perform more configuration
     */
    public HttpConfiguration setTimeouts( int connectTimeout, int socketTimeout ) {
        return property( ClientProperties.CONNECT_TIMEOUT, connectTimeout ).property( ClientProperties.READ_TIMEOUT, socketTimeout );
    }

    @Override
    public HttpConfiguration register( Class<?> providerClass ) {
        configuration.register( providerClass );
        return this;
    }

    @Override
    public HttpConfiguration register( Object provider ) {
        configuration.register( provider );
        return this;
    }

    @Override
    public HttpConfiguration register( Class<?> providerClass, int bindingPriority ) {
        configuration.register( providerClass, bindingPriority );
        return this;
    }

    @Override
    public HttpConfiguration register( Class<?> providerClass, Class<?>[] contracts ) {
        configuration.register( providerClass, contracts );
        return this;
    }

    @Override
    public HttpConfiguration register( Class<?> providerClass, Map<Class<?>, Integer> contracts ) {
        configuration.register( providerClass, contracts );
        return this;
    }

    @Override
    public HttpConfiguration register( Object provider, int bindingPriority ) {
        configuration.register( provider, bindingPriority );
        return this;
    }

    @Override
    public HttpConfiguration register( Object provider, Class<?>[] contracts ) {
        configuration.register( provider, contracts );
        return this;
    }

    @Override
    public HttpConfiguration register( Object provider, Map<Class<?>, Integer> contracts ) {
        configuration.register( provider, contracts );
        return this;
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public HttpConfiguration property( String name, Object value ) {
        configuration.property( name, value );
        return this;
    }


}
