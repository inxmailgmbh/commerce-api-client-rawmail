/*
 * Copyright 2011-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

import java.io.Serializable;


/**
 * <p>
 * Represents a request to send a single raw email. Sender and recipient information must be defined in the supplied message.
 * </p>
 */
public class SendRawEmailRequest implements Serializable, Cloneable {

    private RawMessage rawMessage;

    /**
     * Default constructor for SendRawEmailRequest object. Callers should use the setter or fluent setter (with...)
     * methods to initialize the object after creating it.
     */
    public SendRawEmailRequest() {
    }

    /**
     * Constructs a new SendRawEmailRequest object. Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     *
     * @param rawMessage The raw message in RFC 822 format. The client is responsible for ensuring the following:
     *                   <ul>
     *                   <li>
     *                   <p>
     *                   Message must contain a header and a body, separated by a blank line.
     *                   </p>
     *                   </li>
     *                   <li>
     *                   <p>
     *                   All required header fields must be present.
     *                   </p>
     *                   </li>
     *                   <li>
     *                   <p>
     *                   Each part of a multipart MIME message must be formatted properly.
     *                   </p>
     *                   </li>
     *                   </ul>
     */
    public SendRawEmailRequest( RawMessage rawMessage ) {
        setRawMessage( rawMessage );
    }

    /**
     * <p>
     * The raw message in RFC 822 format. The client is responsible for ensuring the following:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Message must contain a header and a body, separated by a blank line.
     * </p>
     * </li>
     * <li>
     * <p>
     * All required header fields must be present.
     * </p>
     * </li>
     * <li>
     * <p>
     * Each part of a multipart MIME message must be formatted properly.
     * </p>
     * </li>
     * </ul>
     *
     * @param rawMessage The raw text of the message.
     */

    public void setRawMessage( RawMessage rawMessage ) {
        this.rawMessage = rawMessage;
    }

    /**
     * <p>
     * The raw message in RFC 822 format.
     * </p>
     */
    public RawMessage getRawMessage() {
        return this.rawMessage;
    }

    /**
     * <p>
     * The raw message in RFC 822 format. The client is responsible for ensuring the following:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Message must contain a header and a body, separated by a blank line.
     * </p>
     * </li>
     * <li>
     * <p>
     * All required header fields must be present.
     * </p>
     * </li>
     * <li>
     * <p>
     * Each part of a multipart MIME message must be formatted properly.
     * </p>
     * </li>
     * </ul>
     *
     * @param rawMessage The raw message in RFC 822 format.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public SendRawEmailRequest withRawMessage( RawMessage rawMessage ) {
        setRawMessage( rawMessage );
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
        if( getRawMessage() != null )
            sb.append( "RawMessage: " + getRawMessage() );
        sb.append( "}" );
        return sb.toString();
    }

    @Override
    public boolean equals( Object obj ) {
        if( this == obj )
            return true;
        if( obj == null )
            return false;

        if( obj instanceof SendRawEmailRequest == false )
            return false;
        SendRawEmailRequest other = (SendRawEmailRequest)obj;
        if( other.getRawMessage() == null ^ this.getRawMessage() == null )
            return false;
        if( other.getRawMessage() != null && other.getRawMessage().equals( this.getRawMessage() ) == false )
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getRawMessage() == null) ? 0 : getRawMessage().hashCode());
        return hashCode;
    }

    @Override
    public SendRawEmailRequest clone() {
        try {
            return (SendRawEmailRequest)super.clone();
        }
        catch( CloneNotSupportedException e ) {
            throw new IllegalStateException( "Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e );
        }
    }
}
