package com.inxmail.commerce.api.rawmail;

import com.inxmail.commerce.api.rawmail.model.InvalidMessageDataException;
import com.inxmail.commerce.api.rawmail.model.SendEmailRequest;
import com.inxmail.commerce.api.rawmail.model.SendEmailResult;
import com.inxmail.commerce.api.rawmail.model.SendRawEmailRequest;

import javax.ws.rs.WebApplicationException;


/**
 * Client to use the SendRawMail facility of the Inxmail Commerce API. An instance of this interface is scoped to one Inxmail Commerce space.
 */
public interface SendRawmailClient {
    /**
     * Send an email constructed with a {@link com.inxmail.commerce.api.rawmail.model.Message}
     *
     * @param request the send email request
     * @return the Inxmail Commerce API response
     * @throws WebApplicationException     if the request to the Inxmail Commerce API failed or was rejected
     * @throws InvalidMessageDataException if the request could not be transformed into a valid email message
     */
    SendEmailResult sendEmail( SendEmailRequest request ) throws WebApplicationException, InvalidMessageDataException;

    /**
     * Send an email constructed with a {@link com.inxmail.commerce.api.rawmail.model.RawMessage} from a predefined email message.
     *
     * @param request the send raw email request
     * @return the Inxmail Commerce API response
     * @throws WebApplicationException     if the request to the Inxmail Commerce API failed or was rejected
     * @throws InvalidMessageDataException if the request could not be transformed into a valid email message
     */
    SendEmailResult sendEmail( SendRawEmailRequest request ) throws WebApplicationException, InvalidMessageDataException;
}
