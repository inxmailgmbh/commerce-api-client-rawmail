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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * <p>
 * Result from a send email request.
 * </p>
 */
public class SendEmailResult implements Serializable, Cloneable {

    private String relaySendingId;

    private Date acceptedDate;

    private List<RecipientWithSendingId> recipientsWithSendingId;


    static class RecipientWithSendingId {
        private String recipient;
        private String relaySendingId;
        private String type;
        private String error;

        public RecipientWithSendingId( String recipient, String relaySendingId, String type, String error ) {
            this.recipient = recipient;
            this.relaySendingId = relaySendingId;
            this.type = type;
            this.error = error;
        }

        public String getRecipient() {
            return recipient;
        }

        public String getRelaySendingId() {
            return relaySendingId;
        }

        public String getType() {
            return type;
        }

        public String getError() {
            return error;
        }
    }


    @JsonCreator( mode = JsonCreator.Mode.PROPERTIES )
    public SendEmailResult( @JsonProperty( "relaySendingId" ) String relaySendingId, @JsonProperty( "acceptedDate" ) Date acceptedDate, @JsonProperty( "recipientsWithSendingId" ) List<RecipientWithSendingId> recipientsWithSendingId ) {
        this.relaySendingId = relaySendingId;
        this.acceptedDate = acceptedDate;
        this.recipientsWithSendingId = recipientsWithSendingId;
    }

    /**
     * <p>
     * The relay sending ID as returned by the Inxmail Commerce API.
     * </p>
     *
     * @return The relay sending ID as returned by the Inxmail Commerce API.
     */
    public String getRelaySendingId() {
        return relaySendingId;
    }

    /**
     * The time when the send email rewuest has been accepted by the Inxmail Commerce API.
     *
     * @return
     */
    public Date getAcceptedDate() {
        return acceptedDate;
    }

    /**
     * <p>
     * The list of recipients with the corresponding relay sending ID returned by the Inxmail Commerce API.
     * </p>
     *
     * @return
     */
    public List<RecipientWithSendingId> getRecipientsWithSendingId() {
        return recipientsWithSendingId;
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
        if( getRelaySendingId() != null )
            sb.append( "RelaySendingId: " + getRelaySendingId() + "," );
        if( getAcceptedDate() != null )
            sb.append( "AcceptedDate: " + getAcceptedDate() + "," );
        if( getRecipientsWithSendingId() != null )
            sb.append( "RecipientsWithSendingId:" + Arrays.toString( getRecipientsWithSendingId().toArray() ) );
        sb.append( "}" );
        return sb.toString();
    }

    @Override
    public boolean equals( Object o ) {
        if( this == o )
            return true;
        if( o == null || getClass() != o.getClass() )
            return false;
        SendEmailResult that = (SendEmailResult)o;
        return Objects.equals( relaySendingId, that.relaySendingId ) && Objects.equals( acceptedDate, that.acceptedDate ) && Objects.equals( recipientsWithSendingId, that.recipientsWithSendingId );
    }

    @Override
    public int hashCode() {
        return Objects.hash( relaySendingId, acceptedDate, recipientsWithSendingId );
    }

    @Override
    public SendEmailResult clone() {
        try {
            return (SendEmailResult)super.clone();
        }
        catch( CloneNotSupportedException e ) {
            throw new IllegalStateException( "Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e );
        }
    }
}
