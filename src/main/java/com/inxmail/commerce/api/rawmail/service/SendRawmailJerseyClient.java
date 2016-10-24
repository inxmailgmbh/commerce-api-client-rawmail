package com.inxmail.commerce.api.rawmail.service;

import com.inxmail.commerce.api.rawmail.SendRawmailClient;
import com.inxmail.commerce.api.rawmail.model.SendEmailRequest;
import com.inxmail.commerce.api.rawmail.model.SendEmailResult;
import com.inxmail.commerce.api.rawmail.model.SendRawEmailRequest;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class SendRawmailJerseyClient implements SendRawmailClient {
    private BuildMimeMessageService buildMimeMessageService;
    private BuildWebserviceRequestService buildWebserviceRequestService;
    private WebTarget endpoint;

    public SendRawmailJerseyClient( WebTarget endpoint ) {
        this.endpoint = endpoint;
        buildMimeMessageService = new BuildMimeMessageService();
        buildWebserviceRequestService = new BuildWebserviceRequestService();
    }

    public SendEmailResult sendEmail( SendEmailRequest request ) {
        MimeMessage message = buildMimeMessageService.buildMimeMessage( request );
        RawmailwebserviceRequest req = null;
        try {
            req = buildWebserviceRequestService.buildRequest( message );
        }
        catch( IOException e ) {
            e.printStackTrace();
        }
        catch( MessagingException e ) {
            e.printStackTrace();
        }

        return endpoint.request( MediaType.APPLICATION_JSON_TYPE ).post( Entity.entity( req, MediaType.APPLICATION_JSON_TYPE ), SendEmailResult.class );
    }

    @Override
    public SendEmailResult sendEmail( SendRawEmailRequest request ) {
        return null;
    }
}
