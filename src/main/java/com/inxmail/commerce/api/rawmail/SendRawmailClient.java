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
