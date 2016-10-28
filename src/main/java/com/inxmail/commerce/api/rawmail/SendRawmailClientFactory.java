package com.inxmail.commerce.api.rawmail;

import com.inxmail.commerce.api.rawmail.service.SendRawmailJerseyClient;
import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;


/**
 * Main entry point to the SendRawMail API client library.
 * Creates clients to the SendRawMail endpoint of the Inxmail Commerce API of a given Inxmail Commerce space.
 */
public class SendRawmailClientFactory {
    private static final String PUBLIC_API_URL = "https://%s.api.inxmail-commerce.com/api-service/";
    private ClientBuilder builder;

    /**
     * Obtain a client factory with a default configuration
     *
     * @return client factory
     */
    public static SendRawmailClientFactory instance() {
        return instance( new HttpConfiguration() );
    }

    /**
     * Obtain a client factory with the supplied configuration
     *
     * @param config configuration for the underlying JAX-RS client
     * @return client factory
     */
    public static SendRawmailClientFactory instance( HttpConfiguration config ) {
        return new SendRawmailClientFactory( ClientBuilder.newBuilder(), config );
    }

    private SendRawmailClientFactory( ClientBuilder builder, HttpConfiguration config ) {
        ((ClientConfig)config.getConfiguration()).connectorProvider( new ApacheConnectorProvider() ).register( JacksonFeature.class );
        builder.withConfig( config.getConfiguration() );
        this.builder = builder;
    }

    /**
     * Create a client for the public API for the given Inxmail Commerce space. Key and Secret to access the API can be retrieved from your
     * Inxmail Commerce login.
     *
     * @param spaceId   the ID of the Inxmail Commerce space
     * @param apiKey    the API key
     * @param apiSecret the API secret
     * @return a client instance configured to access the requested space
     */
    public SendRawmailClient createClient( String spaceId, String apiKey, String apiSecret ) {
        WebTarget endpoint = createWebTarget( spaceId, apiKey, apiSecret, PUBLIC_API_URL );
        return new SendRawmailJerseyClient( endpoint );
    }

    /**
     * Creates a client for a custom API instance. Exists for debugging purposes of Inxmail GmbH. Custom API instances are generally not
     * available to customers.
     *
     * @param spaceId             the ID of the Inxmail Commerce space
     * @param apiKey              the API key
     * @param apiSecret           the API secret
     * @param endpointUrlTemplate URL template to a custom instance of the Inxmail Commerce API service. The template msu contain <code>%s</code> in
     *                            place of the spaceId
     * @return a client instance configured to access the requested space
     */
    public SendRawmailClient createCustomEndpointClient( String spaceId, String apiKey, String apiSecret, String endpointUrlTemplate ) {
        WebTarget endpoint = createWebTarget( spaceId, apiKey, apiSecret, endpointUrlTemplate );
        return new SendRawmailJerseyClient( endpoint );
    }

    private WebTarget createWebTarget( String spaceId, String apiKey, String apiSecret, String urlTemplate ) {
        HttpAuthenticationFeature basic = HttpAuthenticationFeature.basic( apiKey, apiSecret );
        return builder.build().register( basic ).target( String.format( urlTemplate, spaceId ) ).path( "v1/sendrawmail" );
    }
}
