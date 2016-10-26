package com.inxmail.commerce.api.rawmail.service;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


class BuildWebserviceRequestService {
    public RawmailwebserviceRequest buildRequest( byte[] email ) {
        String message = Base64.getEncoder().encodeToString( email );
        RawmailwebserviceRequest request = new RawmailwebserviceRequest();
        request.setMessage( message );
        return request;
    }

    public RawmailwebserviceRequest buildRequest( MimeMessage email ) throws IOException, MessagingException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        email.writeTo( baos );
        return buildRequest( baos.toByteArray() );
    }

    public RawmailwebserviceRequest buildRequest( InputStream is ) throws IOException {
        return buildRequest( IOUtils.toByteArray( is ) );
    }
}
