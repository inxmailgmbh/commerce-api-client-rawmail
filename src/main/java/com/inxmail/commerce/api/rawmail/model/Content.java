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
 * Represents textual data, plus an optional character set specification.
 * </p>
 * <p>
 * By default, the text must be 7-bit ASCII, due to the constraints of the SMTP protocol. If the text must contain any
 * other characters, then you must also specify a character set. Examples include UTF-8, ISO-8859-1, and Shift_JIS.
 * </p>
 */
public class Content implements Serializable, Cloneable {

    /**
     * <p>
     * The textual data of the content.
     * </p>
     */
    private String data;
    /**
     * <p>
     * The character set of the content.
     * </p>
     */
    private String charset;

    /**
     * Default constructor for Content object. Callers should use the setter or fluent setter (with...) methods to
     * initialize the object after creating it.
     */
    public Content() {
    }

    /**
     * Constructs a new Content object. Callers should use the setter or fluent setter (with...) methods to initialize
     * any additional object members.
     *
     * @param data The textual data of the content.
     */
    public Content( String data ) {
        setData( data );
    }

    /**
     * <p>
     * The textual data of the content.
     * </p>
     *
     * @param data The textual data of the content.
     */

    public void setData( String data ) {
        this.data = data;
    }

    /**
     * <p>
     * The textual data of the content.
     * </p>
     *
     * @return The textual data of the content.
     */

    public String getData() {
        return this.data;
    }

    /**
     * <p>
     * The textual data of the content.
     * </p>
     *
     * @param data The textual data of the content.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Content withData( String data ) {
        setData( data );
        return this;
    }

    /**
     * <p>
     * The character set of the content.
     * </p>
     *
     * @param charset The character set of the content.
     */

    public void setCharset( String charset ) {
        this.charset = charset;
    }

    /**
     * <p>
     * The character set of the content.
     * </p>
     *
     * @return The character set of the content.
     */

    public String getCharset() {
        return this.charset;
    }

    /**
     * <p>
     * The character set of the content.
     * </p>
     *
     * @param charset The character set of the content.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Content withCharset( String charset ) {
        setCharset( charset );
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
            sb.append( "Data: " + getData() + "," );
        if( getCharset() != null )
            sb.append( "Charset: " + getCharset() );
        sb.append( "}" );
        return sb.toString();
    }

    @Override
    public boolean equals( Object obj ) {
        if( this == obj )
            return true;
        if( obj == null )
            return false;

        if( obj instanceof Content == false )
            return false;
        Content other = (Content)obj;
        if( other.getData() == null ^ this.getData() == null )
            return false;
        if( other.getData() != null && other.getData().equals( this.getData() ) == false )
            return false;
        if( other.getCharset() == null ^ this.getCharset() == null )
            return false;
        if( other.getCharset() != null && other.getCharset().equals( this.getCharset() ) == false )
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getData() == null) ? 0 : getData().hashCode());
        hashCode = prime * hashCode + ((getCharset() == null) ? 0 : getCharset().hashCode());
        return hashCode;
    }

    @Override
    public Content clone() {
        try {
            return (Content)super.clone();
        }
        catch( CloneNotSupportedException e ) {
            throw new IllegalStateException( "Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e );
        }
    }
}
