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
