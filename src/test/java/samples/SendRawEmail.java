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
package samples;

import com.inxmail.commerce.api.rawmail.SendRawmailClient;
import com.inxmail.commerce.api.rawmail.SendRawmailClientFactory;
import com.inxmail.commerce.api.rawmail.model.RawMessage;
import com.inxmail.commerce.api.rawmail.model.SendEmailResult;
import com.inxmail.commerce.api.rawmail.model.SendRawEmailRequest;

import java.io.IOException;
import java.util.Properties;


public class SendRawEmail {
    public static void main( String[] args ) {
        try {
            Properties properties = new Properties();
            properties.load( SendRawEmail.class.getResourceAsStream( "/settings.properties" ) );

            RawMessage rawMessage = new RawMessage().withInputStream( SendRawEmail.class.getResourceAsStream( "/raw-email.msg" ) );
            SendRawEmailRequest request = new SendRawEmailRequest( rawMessage );
            SendRawmailClient client = SendRawmailClientFactory.instance().createClient( properties.getProperty( "api.space" ), properties.getProperty( "api.key" ), properties.getProperty( "api.secret" ) );

            SendEmailResult result = client.sendEmail( request );

            System.out.println( result );
        }
        catch( IOException e ) {
            e.printStackTrace();
        }
    }

}
