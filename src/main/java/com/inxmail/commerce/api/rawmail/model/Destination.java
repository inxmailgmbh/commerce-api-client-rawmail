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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * <p>
 * Represents the destination of the message, consisting of To:, CC:, and BCC: fields.
 * </p>
 * <p>
 * By default, the string must be 7-bit ASCII. If the text must contain any other characters, then you must use MIME
 * encoded-word syntax (RFC 2047) instead of a literal string. MIME encoded-word syntax uses the following form:
 * <code>=?charset?encoding?encoded-text?=</code>. For more information, see <a
 * href="http://tools.ietf.org/html/rfc2047">RFC 2047</a>.
 * </p>
 */
public class Destination implements Serializable, Cloneable {

    private List<String> toAddresses;

    private List<String> ccAddresses;

    private List<String> bccAddresses;

    /**
     * Default constructor for Destination object. Callers should use the setter or fluent setter (with...) methods to
     * initialize the object after creating it.
     */
    public Destination() {
    }

    /**
     * Constructs a new Destination object. Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     *
     * @param toAddresses The To: field(s) of the message.
     */
    public Destination( List<String> toAddresses ) {
        setToAddresses( toAddresses );
    }

    /**
     * <p>
     * The To: field(s) of the message.
     * </p>
     *
     * @return The To: field(s) of the message.
     */

    public List<String> getToAddresses() {
        if( toAddresses == null ) {
            toAddresses = new ArrayList<>();
        }
        return toAddresses;
    }

    /**
     * <p>
     * The To: field(s) of the message.
     * </p>
     *
     * @param toAddresses The To: field(s) of the message.
     */

    public void setToAddresses( Collection<String> toAddresses ) {
        if( toAddresses == null ) {
            this.toAddresses = null;
            return;
        }

        this.toAddresses = new ArrayList<>( toAddresses );
    }

    /**
     * <p>
     * The To: field(s) of the message.
     * </p>
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setToAddresses(java.util.Collection)} or {@link #withToAddresses(java.util.Collection)} if you want to
     * override the existing values.
     * </p>
     *
     * @param toAddresses The To: field(s) of the message.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Destination withToAddresses( String... toAddresses ) {
        if( this.toAddresses == null ) {
            setToAddresses( new ArrayList<>( toAddresses.length ) );
        }
        for( String ele : toAddresses ) {
            this.toAddresses.add( ele );
        }
        return this;
    }

    /**
     * <p>
     * The To: field(s) of the message.
     * </p>
     *
     * @param toAddresses The To: field(s) of the message.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Destination withToAddresses( Collection<String> toAddresses ) {
        setToAddresses( toAddresses );
        return this;
    }

    /**
     * <p>
     * The CC: field(s) of the message.
     * </p>
     *
     * @return The CC: field(s) of the message.
     */

    public List<String> getCcAddresses() {
        if( ccAddresses == null ) {
            ccAddresses = new ArrayList<>();
        }
        return ccAddresses;
    }

    /**
     * <p>
     * The CC: field(s) of the message.
     * </p>
     *
     * @param ccAddresses The CC: field(s) of the message.
     */

    public void setCcAddresses( Collection<String> ccAddresses ) {
        if( ccAddresses == null ) {
            this.ccAddresses = null;
            return;
        }

        this.ccAddresses = new ArrayList<>( ccAddresses );
    }

    /**
     * <p>
     * The CC: field(s) of the message.
     * </p>
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setCcAddresses(java.util.Collection)} or {@link #withCcAddresses(java.util.Collection)} if you want to
     * override the existing values.
     * </p>
     *
     * @param ccAddresses The CC: field(s) of the message.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Destination withCcAddresses( String... ccAddresses ) {
        if( this.ccAddresses == null ) {
            setCcAddresses( new ArrayList<>( ccAddresses.length ) );
        }
        for( String ele : ccAddresses ) {
            this.ccAddresses.add( ele );
        }
        return this;
    }

    /**
     * <p>
     * The CC: field(s) of the message.
     * </p>
     *
     * @param ccAddresses The CC: field(s) of the message.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Destination withCcAddresses( Collection<String> ccAddresses ) {
        setCcAddresses( ccAddresses );
        return this;
    }

    /**
     * <p>
     * The BCC: field(s) of the message.
     * </p>
     *
     * @return The BCC: field(s) of the message.
     */

    public java.util.List<String> getBccAddresses() {
        if( bccAddresses == null ) {
            bccAddresses = new ArrayList<>();
        }
        return bccAddresses;
    }

    /**
     * <p>
     * The BCC: field(s) of the message.
     * </p>
     *
     * @param bccAddresses The BCC: field(s) of the message.
     */

    public void setBccAddresses( Collection<String> bccAddresses ) {
        if( bccAddresses == null ) {
            this.bccAddresses = null;
            return;
        }

        this.bccAddresses = new ArrayList<>( bccAddresses );
    }

    /**
     * <p>
     * The BCC: field(s) of the message.
     * </p>
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setBccAddresses(java.util.Collection)} or {@link #withBccAddresses(java.util.Collection)} if you want to
     * override the existing values.
     * </p>
     *
     * @param bccAddresses The BCC: field(s) of the message.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Destination withBccAddresses( String... bccAddresses ) {
        if( this.bccAddresses == null ) {
            setBccAddresses( new ArrayList<>( bccAddresses.length ) );
        }
        for( String ele : bccAddresses ) {
            this.bccAddresses.add( ele );
        }
        return this;
    }

    /**
     * <p>
     * The BCC: field(s) of the message.
     * </p>
     *
     * @param bccAddresses The BCC: field(s) of the message.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Destination withBccAddresses( Collection<String> bccAddresses ) {
        setBccAddresses( bccAddresses );
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
        if( getToAddresses() != null )
            sb.append( "ToAddresses: " + getToAddresses() + "," );
        if( getCcAddresses() != null )
            sb.append( "CcAddresses: " + getCcAddresses() + "," );
        if( getBccAddresses() != null )
            sb.append( "BccAddresses: " + getBccAddresses() );
        sb.append( "}" );
        return sb.toString();
    }

    @Override
    public boolean equals( Object obj ) {
        if( this == obj )
            return true;
        if( obj == null )
            return false;

        if( obj instanceof Destination == false )
            return false;
        Destination other = (Destination)obj;
        if( other.getToAddresses() == null ^ this.getToAddresses() == null )
            return false;
        if( other.getToAddresses() != null && other.getToAddresses().equals( this.getToAddresses() ) == false )
            return false;
        if( other.getCcAddresses() == null ^ this.getCcAddresses() == null )
            return false;
        if( other.getCcAddresses() != null && other.getCcAddresses().equals( this.getCcAddresses() ) == false )
            return false;
        if( other.getBccAddresses() == null ^ this.getBccAddresses() == null )
            return false;
        if( other.getBccAddresses() != null && other.getBccAddresses().equals( this.getBccAddresses() ) == false )
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getToAddresses() == null) ? 0 : getToAddresses().hashCode());
        hashCode = prime * hashCode + ((getCcAddresses() == null) ? 0 : getCcAddresses().hashCode());
        hashCode = prime * hashCode + ((getBccAddresses() == null) ? 0 : getBccAddresses().hashCode());
        return hashCode;
    }

    @Override
    public Destination clone() {
        try {
            return (Destination)super.clone();
        }
        catch( CloneNotSupportedException e ) {
            throw new IllegalStateException( "Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e );
        }
    }

    public boolean isEmpty() {
        return getToAddresses().isEmpty() && getCcAddresses().isEmpty() && getBccAddresses().isEmpty();
    }
}
