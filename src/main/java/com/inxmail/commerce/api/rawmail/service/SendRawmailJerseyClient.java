package com.inxmail.commerce.api.rawmail.service;

import com.inxmail.commerce.api.rawmail.SendRawmailClient;
import com.inxmail.commerce.api.rawmail.model.InvalidMessageDataException;
import com.inxmail.commerce.api.rawmail.model.SendEmailRequest;
import com.inxmail.commerce.api.rawmail.model.SendEmailResult;
import com.inxmail.commerce.api.rawmail.model.SendRawEmailRequest;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


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
        RawmailwebserviceRequest req;
        try {
            req = buildWebserviceRequestService.buildRequest( message );
        }
        catch( IOException | MessagingException e ) {
            throw new InvalidMessageDataException( e.getMessage(), e );
        }

        return endpoint.request( MediaType.APPLICATION_JSON_TYPE ).post( Entity.entity( req, MediaType.APPLICATION_JSON_TYPE ), SendEmailResult.class );
    }

    @Override
    public SendEmailResult sendEmail( SendRawEmailRequest request ) {
        try {
            RawmailwebserviceRequest req;
            if( request.getRawMessage().getInputStream() != null ) {
                req = buildWebserviceRequestService.buildRequest( request.getRawMessage().getInputStream() );
            }
            else {
                req = buildWebserviceRequestService.buildRequest( request.getRawMessage().getData() );
            }
            return endpoint.request( MediaType.APPLICATION_JSON_TYPE ).post( Entity.entity( req, MediaType.APPLICATION_JSON_TYPE ), SendEmailResult.class );
        }
        catch( IOException e ) {
            throw new InvalidMessageDataException( e.getMessage(), e );
        }
    }
}
