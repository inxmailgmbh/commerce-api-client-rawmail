package com.inxmail.commerce.api.rawmail;

import com.inxmail.commerce.api.rawmail.model.SendEmailRequest;
import com.inxmail.commerce.api.rawmail.model.SendEmailResult;
import com.inxmail.commerce.api.rawmail.model.SendRawEmailRequest;


/**
 * Client to use the SendRawMail facility of the Inxmail Commerce API. An instance of this interface is scoped to one Inxmail Commerce space.
 */
public interface SendRawmailClient {
    SendEmailResult sendEmail( SendEmailRequest request );

    SendEmailResult sendEmail( SendRawEmailRequest request );
}
