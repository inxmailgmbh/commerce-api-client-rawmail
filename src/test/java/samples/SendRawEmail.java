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
