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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * Result from a send email request.
 * </p>
 */
public class SendEmailResult implements Serializable, Cloneable {

    private String relaySendingId;

    private Date acceptedDate;


    @JsonCreator( mode = JsonCreator.Mode.PROPERTIES )
    public SendEmailResult( @JsonProperty( "relaySendingId" ) String relaySendingId, @JsonProperty( "acceptedDate" ) Date acceptedDate ) {
        this.relaySendingId = relaySendingId;
        this.acceptedDate = acceptedDate;
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
            sb.append( "AcceptedDate: " + getAcceptedDate() );
        sb.append( "}" );
        return sb.toString();
    }

    @Override
    public boolean equals( Object obj ) {
        if( this == obj )
            return true;
        if( obj == null )
            return false;

        if( obj instanceof SendEmailResult == false )
            return false;
        SendEmailResult other = (SendEmailResult)obj;
        if( other.getRelaySendingId() == null ^ this.getRelaySendingId() == null )
            return false;
        if( other.getRelaySendingId() != null && other.getRelaySendingId().equals( this.getRelaySendingId() ) == false )
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getRelaySendingId() == null) ? 0 : getRelaySendingId().hashCode());
        return hashCode;
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
