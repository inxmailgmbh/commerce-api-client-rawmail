/*
 * Copyright 2011-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * Package renamed and adapted by Inxmail GmbH 2016.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.inxmail.commerce.api.rawmail.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


/**
 * <p>
 * Represents the raw data of the message. Data can be represented either as byte array or as InputStream. The representations are alternative, no conversion is done.
 * In any case, the data must define a complete message according to RFC 822. At least, the following headers must be present:
 * </p>
 * <ul>
 * <li>From: or Sender:</li>
 * <li>To: or CC: or BCC:</li>
 * </ul>
 */
public class RawMessage implements Serializable, Cloneable {

    private byte[] data;

    private InputStream is;

    /**
     * Default constructor for RawMessage object. Callers should use the fluent setter (with...) methods to
     * initialize the object after creating it.
     */
    public RawMessage() {
    }

    /**
     * <p>
     * The raw data of the message. The client must ensure that the message format complies with Internet email
     * standards regarding email header fields, MIME types, MIME encoding, and base64 encoding.
     * </p>
     *
     * @return The raw data of the message. The client must ensure that the message format complies with Internet email
     * standards regarding email header fields, MIME types, MIME encoding, and base64 encoding.
     */

    public byte[] getData() {
        return this.data;
    }

    /**
     * <p>
     * The raw data of the message as an input stream, if initialized as input stream. The client must ensure that the message format complies with Internet email
     * standards regarding email header fields, MIME types, MIME encoding, and base64 encoding.
     * </p>
     *
     * @return The raw data of the message. The client must ensure that the message format complies with Internet email
     * standards regarding email header fields, MIME types, MIME encoding, and base64 encoding.
     */
    public InputStream getInputStream() {
        return is;
    }

    /**
     * <p>
     * The raw data of the message. The client must ensure that the message format complies with Internet email
     * standards regarding email header fields, MIME types, MIME encoding, and base64 encoding.
     * </p>
     * <p>The RawMail client api encodes the entire content as Base64 for the webservice request. The supplied data must not already be
     * Base64 encoded in its entirety.
     * </p>
     *
     * @param data The raw data of the message. The client must ensure that the message format complies with Internet email
     *             standards regarding email header fields, MIME types, MIME encoding, and base64 encoding.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public RawMessage withData( byte[] data ) {
        this.is = null;
        this.data = data;
        return this;
    }

    /**
     * <p>
     * Set the raw data of the message as <code>InputStream</code>. The client must ensure that the message format complies with Internet email
     * standards regarding email header fields, MIME types, MIME encoding, and base64 encoding.
     * </p>
     * <p>The RawMail client api encodes the entire content as Base64 for the webservice request. The supplied data must not already be
     * Base64 encoded in its entirety.
     * </p>
     *
     * @param is The raw data of the message. The client must ensure that the message format complies with Internet email
     *           standards regarding email header fields, MIME types, MIME encoding, and base64 encoding.
     * @return Returns a reference to this object so that method calls can be chained together.
     */
    public RawMessage withInputStream( InputStream is ) {
        this.data = null;
        this.is = is;
        return this;
    }

    /**
     * <p>Set the raw data of the message as a JavaMail <code>MimeMessage</code>. The message is serialized to a byte array, and Exceptions thrown
     * in this process are passed on.</p>
     *
     * @param message The mail message to send.
     * @return Returns a reference to this object so that method calls can be chained together.
     * @throws IOException        as thrown by <code>MimeMessage#writeTo(OutputStream)</code>. A <code>ByteArrayOutputStream</code> is used as a target.
     * @throws MessagingException as thrown by <code>MimeMessage#writeTo(OutputStream)</code>
     */
    public RawMessage withMimeMessage( MimeMessage message ) throws IOException, MessagingException {
        this.is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        message.writeTo( baos );
        this.data = baos.toByteArray();
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and debugging.
     *
     * @return A string representation of this object.
     * @see Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append( "{" );
        if( getData() != null )
            sb.append( "Data: " + getData() );
        sb.append( "}" );
        return sb.toString();
    }

    @Override
    public boolean equals( Object obj ) {
        if( this == obj )
            return true;
        if( obj == null )
            return false;

        if( obj instanceof RawMessage == false )
            return false;
        RawMessage other = (RawMessage)obj;
        if( other.getData() == null ^ this.getData() == null )
            return false;
        if( other.getData() != null && other.getData().equals( this.getData() ) == false )
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getData() == null) ? 0 : getData().hashCode());
        return hashCode;
    }

    @Override
    public RawMessage clone() {
        try {
            return (RawMessage)super.clone();
        }
        catch( CloneNotSupportedException e ) {
            throw new IllegalStateException( "Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e );
        }
    }
}
