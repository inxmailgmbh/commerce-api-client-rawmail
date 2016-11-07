/*
 * Copyright 2016 Inxmail GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * or in the License file accompanying this file.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.inxmail.commerce.api.rawmail.service;

import com.inxmail.commerce.api.rawmail.model.Body;
import com.inxmail.commerce.api.rawmail.model.Destination;
import com.inxmail.commerce.api.rawmail.model.InvalidMessageDataException;
import com.inxmail.commerce.api.rawmail.model.SendEmailRequest;

import java.util.List;
import java.util.stream.Collectors;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


class BuildMimeMessageService {
    public MimeMessage buildMimeMessage( SendEmailRequest request ) {
        try {
            MimeMessage message = new MimeMessage( (Session)null );
            if( request.getSource() != null ) {
                message.setFrom( request.getSource() );
            }
            else {
                throw new InvalidMessageDataException( "Request does not contain any sender" );
            }
            Destination destination = request.getDestination();
            if( destination.isEmpty() ) {
                throw new InvalidMessageDataException( "Request does not contain any recipients" );
            }
            if( !destination.getToAddresses().isEmpty() ) {
                message.setRecipients( Message.RecipientType.TO, convertAddresses( destination.getToAddresses() ) );
            }
            if( !destination.getCcAddresses().isEmpty() ) {
                message.setRecipients( Message.RecipientType.CC, convertAddresses( destination.getCcAddresses() ) );
            }
            if( !destination.getBccAddresses().isEmpty() ) {
                message.setRecipients( Message.RecipientType.BCC, convertAddresses( destination.getBccAddresses() ) );
            }
            if( request.getMessage().getSubject() != null ) {
                message.setSubject( request.getMessage().getSubject().getData(), request.getMessage().getSubject().getCharset() );
            }
            else {
                throw new InvalidMessageDataException( "Request does not contain a subject" );
            }
            Body body = request.getMessage().getBody();
            if( body != null && (body.getText() != null || body.getHtml() != null) ) {
                if( body.getHtml() == null ) {
                    message.setText( body.getText().getData(), body.getText().getCharset() );
                }
                else if( body.getText() == null ) {
                    message.setText( body.getHtml().getData(), body.getHtml().getCharset(), "html" );
                }
                else {
                    MimeBodyPart text = new MimeBodyPart();
                    text.setText( body.getText().getData(), body.getText().getCharset() );
                    MimeBodyPart html = new MimeBodyPart();
                    html.setText( body.getHtml().getData(), body.getHtml().getCharset(), "html" );
                    message.setContent( new MimeMultipart( "alternative", text, html ) );
                }
            }
            else {
                throw new InvalidMessageDataException( "Request does not contain any content" );
            }
            return message;
        }
        catch( MessagingException e ) {
            throw new InvalidMessageDataException( e.getMessage(), e );
        }
    }

    private Address[] convertAddresses( List<String> addresses ) {
        return addresses.stream().map( address -> {
            try {
                return new InternetAddress( address );
            }
            catch( AddressException e ) {
                throw new InvalidMessageDataException( String.format( "Invalid recipient address %s: %s", address, e.getMessage() ) );
            }
        } ).collect( Collectors.toList() ).toArray( new Address[addresses.size()] );
    }
}
