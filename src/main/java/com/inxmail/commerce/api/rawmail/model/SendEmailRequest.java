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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * <p>
 * Represents a request to send a single email that is defined using {@link Message} and related classes.
 * </p>
 */
public class SendEmailRequest implements Serializable, Cloneable {

    private String source;

    private Destination destination;

    private Message message;

    private List<String> replyToAddresses;

    /**
     * Default constructor for SendEmailRequest object. Callers should use the setter or fluent setter (with...) methods
     * to initialize the object after creating it.
     */
    public SendEmailRequest() {
    }

    /**
     * Constructs a new SendEmailRequest object. Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     *
     * @param source      The email address that is sending the email.
     *                    <p>
     *                    In all cases, the email address must be 7-bit ASCII. If the text must contain any other characters, then
     *                    you must use MIME encoded-word syntax (RFC 2047) instead of a literal string. MIME encoded-word syntax
     *                    uses the following form: <code>=?charset?encoding?encoded-text?=</code>. For more information, see <a
     *                    href="http://tools.ietf.org/html/rfc2047">RFC 2047</a>.
     * @param destination The destination for this email, composed of To:, CC:, and BCC: fields.
     * @param message     The message to be sent.
     */
    public SendEmailRequest( String source, Destination destination, Message message ) {
        setSource( source );
        setDestination( destination );
        setMessage( message );
    }

    /**
     * <p>
     * The email address that is sending the email.
     * </p>
     * <p>
     * In all cases, the email address must be 7-bit ASCII. If the text must contain any other characters, then you must
     * use MIME encoded-word syntax (RFC 2047) instead of a literal string. MIME encoded-word syntax uses the following
     * form: <code>=?charset?encoding?encoded-text?=</code>. For more information, see <a
     * href="http://tools.ietf.org/html/rfc2047">RFC 2047</a>.
     * </p>
     *
     * @param source The email address that is sending the email.
     *               <p>
     *               <p>
     *               In all cases, the email address must be 7-bit ASCII. If the text must contain any other characters, then
     *               you must use MIME encoded-word syntax (RFC 2047) instead of a literal string. MIME encoded-word syntax
     *               uses the following form: <code>=?charset?encoding?encoded-text?=</code>. For more information, see <a
     *               href="http://tools.ietf.org/html/rfc2047">RFC 2047</a>.
     */

    public void setSource( String source ) {
        this.source = source;
    }

    /**
     * <p>
     * The email address that is sending the email.
     * </p>
     * <p>
     * In all cases, the email address must be 7-bit ASCII. If the text must contain any other characters, then
     * you must use MIME encoded-word syntax (RFC 2047) instead of a literal string. MIME encoded-word syntax
     * uses the following form: <code>=?charset?encoding?encoded-text?=</code>. For more information, see <a
     * href="http://tools.ietf.org/html/rfc2047">RFC 2047</a>.
     */

    public String getSource() {
        return this.source;
    }

    /**
     * <p>
     * The email address that is sending the email.
     * </p>
     * <p>
     * In all cases, the email address must be 7-bit ASCII. If the text must contain any other characters, then you must
     * use MIME encoded-word syntax (RFC 2047) instead of a literal string. MIME encoded-word syntax uses the following
     * form: <code>=?charset?encoding?encoded-text?=</code>. For more information, see <a
     * href="http://tools.ietf.org/html/rfc2047">RFC 2047</a>.
     * </p>
     *
     * @param source The email address that is sending the email.
     *               <p>
     *               In all cases, the email address must be 7-bit ASCII. If the text must contain any other characters, then
     *               you must use MIME encoded-word syntax (RFC 2047) instead of a literal string. MIME encoded-word syntax
     *               uses the following form: <code>=?charset?encoding?encoded-text?=</code>. For more information, see <a
     *               href="http://tools.ietf.org/html/rfc2047">RFC 2047</a>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public SendEmailRequest withSource( String source ) {
        setSource( source );
        return this;
    }

    /**
     * <p>
     * The destination for this email, composed of To:, CC:, and BCC: fields.
     * </p>
     *
     * @param destination The destination for this email, composed of To:, CC:, and BCC: fields.
     */

    public void setDestination( Destination destination ) {
        this.destination = destination;
    }

    /**
     * <p>
     * The destination for this email, composed of To:, CC:, and BCC: fields.
     * </p>
     *
     * @return The destination for this email, composed of To:, CC:, and BCC: fields.
     */

    public Destination getDestination() {
        return this.destination;
    }

    /**
     * <p>
     * The destination for this email, composed of To:, CC:, and BCC: fields.
     * </p>
     *
     * @param destination The destination for this email, composed of To:, CC:, and BCC: fields.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public SendEmailRequest withDestination( Destination destination ) {
        setDestination( destination );
        return this;
    }

    /**
     * <p>
     * The message to be sent.
     * </p>
     *
     * @param message The message to be sent.
     */

    public void setMessage( Message message ) {
        this.message = message;
    }

    /**
     * <p>
     * The message to be sent.
     * </p>
     *
     * @return The message to be sent.
     */

    public Message getMessage() {
        return this.message;
    }

    /**
     * <p>
     * The message to be sent.
     * </p>
     *
     * @param message The message to be sent.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public SendEmailRequest withMessage( Message message ) {
        setMessage( message );
        return this;
    }

    /**
     * <p>
     * The reply-to email address(es) for the message. If the recipient replies to the message, each reply-to address
     * will receive the reply.
     * </p>
     *
     * @return The reply-to email address(es) for the message. If the recipient replies to the message, each reply-to
     * address will receive the reply.
     */

    public List<String> getReplyToAddresses() {
        if( replyToAddresses == null ) {
            replyToAddresses = new ArrayList<>();
        }
        return replyToAddresses;
    }

    /**
     * <p>
     * The reply-to email address(es) for the message. If the recipient replies to the message, each reply-to address
     * will receive the reply.
     * </p>
     *
     * @param replyToAddresses The reply-to email address(es) for the message. If the recipient replies to the message, each reply-to
     *                         address will receive the reply.
     */

    public void setReplyToAddresses( java.util.Collection<String> replyToAddresses ) {
        if( replyToAddresses == null ) {
            this.replyToAddresses = null;
            return;
        }

        this.replyToAddresses = new ArrayList<>( replyToAddresses );
    }

    /**
     * <p>
     * The reply-to email address(es) for the message. If the recipient replies to the message, each reply-to address
     * will receive the reply.
     * </p>
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setReplyToAddresses(java.util.Collection)} or {@link #withReplyToAddresses(java.util.Collection)} if you
     * want to override the existing values.
     * </p>
     *
     * @param replyToAddresses The reply-to email address(es) for the message. If the recipient replies to the message, each reply-to
     *                         address will receive the reply.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public SendEmailRequest withReplyToAddresses( String... replyToAddresses ) {
        if( this.replyToAddresses == null ) {
            setReplyToAddresses( new ArrayList<>( replyToAddresses.length ) );
        }
        for( String ele : replyToAddresses ) {
            this.replyToAddresses.add( ele );
        }
        return this;
    }

    /**
     * <p>
     * The reply-to email address(es) for the message. If the recipient replies to the message, each reply-to address
     * will receive the reply.
     * </p>
     *
     * @param replyToAddresses The reply-to email address(es) for the message. If the recipient replies to the message, each reply-to
     *                         address will receive the reply.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public SendEmailRequest withReplyToAddresses( Collection<String> replyToAddresses ) {
        setReplyToAddresses( replyToAddresses );
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
        if( getSource() != null )
            sb.append( "Source: " + getSource() + "," );
        if( getDestination() != null )
            sb.append( "Destination: " + getDestination() + "," );
        if( getReplyToAddresses() != null )
            sb.append( "ReplyToAddresses: " + getReplyToAddresses() + "," );
        if( getMessage() != null )
            sb.append( "Message: " + getMessage() + "," );
        sb.append( "}" );
        return sb.toString();
    }

    @Override
    public boolean equals( Object obj ) {
        if( this == obj )
            return true;
        if( obj == null )
            return false;

        if( obj instanceof SendEmailRequest == false )
            return false;
        SendEmailRequest other = (SendEmailRequest)obj;
        if( other.getSource() == null ^ this.getSource() == null )
            return false;
        if( other.getSource() != null && other.getSource().equals( this.getSource() ) == false )
            return false;
        if( other.getDestination() == null ^ this.getDestination() == null )
            return false;
        if( other.getDestination() != null && other.getDestination().equals( this.getDestination() ) == false )
            return false;
        if( other.getMessage() == null ^ this.getMessage() == null )
            return false;
        if( other.getMessage() != null && other.getMessage().equals( this.getMessage() ) == false )
            return false;
        if( other.getReplyToAddresses() == null ^ this.getReplyToAddresses() == null )
            return false;
        if( other.getReplyToAddresses() != null && other.getReplyToAddresses().equals( this.getReplyToAddresses() ) == false )
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getSource() == null) ? 0 : getSource().hashCode());
        hashCode = prime * hashCode + ((getDestination() == null) ? 0 : getDestination().hashCode());
        hashCode = prime * hashCode + ((getMessage() == null) ? 0 : getMessage().hashCode());
        hashCode = prime * hashCode + ((getReplyToAddresses() == null) ? 0 : getReplyToAddresses().hashCode());
        return hashCode;
    }

    @Override
    public SendEmailRequest clone() {
        try {
            return (SendEmailRequest)super.clone();
        }
        catch( CloneNotSupportedException e ) {
            throw new IllegalStateException( "Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e );
        }
    }
}
