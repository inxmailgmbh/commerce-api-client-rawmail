package samples;

import com.inxmail.commerce.api.rawmail.HttpConfiguration;
import com.inxmail.commerce.api.rawmail.SendRawmailClient;
import com.inxmail.commerce.api.rawmail.SendRawmailClientFactory;
import com.inxmail.commerce.api.rawmail.model.Body;
import com.inxmail.commerce.api.rawmail.model.Content;
import com.inxmail.commerce.api.rawmail.model.Destination;
import com.inxmail.commerce.api.rawmail.model.Message;
import com.inxmail.commerce.api.rawmail.model.SendEmailRequest;
import com.inxmail.commerce.api.rawmail.model.SendEmailResult;

import java.io.IOException;
import java.util.Properties;


public class SendMessageViaProxy {
    public static void main( String[] args ) {
        try {
            Properties properties = new Properties();
            properties.load( SendSimpleMessage.class.getResourceAsStream( "/settings.properties" ) );

            Message message = new Message()
                    .withSubject( new Content( "Test SendSimpleMail" ) )
                    .withBody( new Body()
                            .withText( new Content( "SendSimpleMessage plain text." ) )
                            .withHtml( new Content( "<html><body><p>SendSimpleMessage</p></body></html>" ) )
                    );

            SendEmailRequest request = new SendEmailRequest()
                    .withSource( properties.getProperty( "message.from" ) )
                    .withDestination( new Destination().withToAddresses( properties.getProperty( "message.to" ) ) )
                    .withMessage( message );

            HttpConfiguration config = new HttpConfiguration()
                    .setProxy( properties.getProperty( "proxy.url" ) )
                    .setTimeouts( 10000, 5000 );


            SendRawmailClient client = SendRawmailClientFactory.instance( config ).createClient( properties.getProperty( "api.space" ), properties.getProperty( "api.key" ), properties.getProperty( "api.secret" ) );

            SendEmailResult result = client.sendEmail( request );

            System.out.println( result );
        }
        catch( IOException e ) {
            e.printStackTrace();
        }
    }
}
