Client SDK for the SendRawMail endpoint in the Inxmail Commerce API
===================================================================

This library provides convenient tools to use the "send raw email" feature of the Inxmail Commerce API.
For details see the JavaDoc API reference.

Getting the SDK
---------------
The SDK is available as a Maven dependency from Inxmail GmbH's Maven repository:

```xml
<repository>
  <id>inxmail-artefacts</id>
  <name>inxmail artefacts</name>
  <url>https://inxmail-artefacts.inxshare.de/repo</url>
</repository>
```

Coordinates (see above for latest version):

```xml
<dependency>
  <groupId>com.inxmail.commerce.api</groupId>
  <artifactId>commerce-api-client-rawmail</artifactId>
  <version>1.0.0</version>
</dependency>
```

Sources, including samples, are available on [Github](https://github.com/inxmailgmbh/commerce-api-client-rawmail).

Basic example
-------------

```
String spaceId = "...";
String apiKey = "...";
String apiSecret = "...";
String sourceAddress = "...";
String recipientAddress = "...";

Message message = new Message()
        .withSubject( new Content().withData( "Send Rawmail API Test" ).withCharset( "UTF-8" ) )
        .withBody( new Body()
                .withText( new Content().withData( "Test Email Body." ).withCharset( "UTF-8" ) )
                .withHtml( new Content().withData( "<html><body>Test Email Body.</body></html>" ) ) );

SendEmailRequest request = new SendEmailRequest()
        .withSource( sourceAddress )
        .withDestination( new Destination().withToAddresses( recipientAddress ) )
        .withMessage( message );

SendRawmailClient client = SendRawmailClientFactory.instance().createClient( spaceId, apiKey, apiSecret );
SendEmailResult sendEmailResult = client.sendEmail( request );
```

Building a request with the message model
----------------------------------------
The SDK provides a `Message` model that is largely identical to the model of the AWS SES SDK.
This model provides the ability to construct simple emails with text and HTML content.

Example:

```
String sourceAddress = "Jane Doe <jdoe@source.invalid>";
String recipientAddress = "John Doe <john.doe@recipient.invalid>";

Message message = new Message()
        .withSubject( new Content().withData( "Send Rawmail API Test" ).withCharset( "UTF-8" ) )
        .withBody( new Body()
                .withText( new Content().withData( "Test Email Body." ).withCharset( "UTF-8" ) )
                .withHtml( new Content().withData( "<html><body>Test Email Body.</body></html>" ) ) );

SendEmailRequest request = new SendEmailRequest()
        .withSource( sourceAddress )
        .withDestination( new Destination().withToAddresses( recipientAddress ) )
        .withMessage( message );

```


Building a request with an existing email message
-------------------------------------------------
Alternatively, the full email message in RFC 822 format can be provided.
With this approach, any email content can be sent, including attachments. 
Sender and recipient will be determined from message headers.

The supplied email must contain the following headers:

* `From:` or `Sender:`
* `To:` or `Cc:` or `Bcc:`

All other headers and the message body are technically optional, although providing a subject and body is highly recommended.

The message can be provided as

* a `byte[]` array
* a `java.io.InputStream` (e.g. pointing to a file)
* a `javax.mail.internet.MimeMessage` as defined by the JavaMail library

Example:

```
RawMessage rawMessage = new RawMessage().withInputStream( new FileInputStream( "email.txt" ) );
SendRawEmailRequest request = new SendRawEmailRequest( rawMessage );
```

Creating a client connection to the Inxmail Commerce API
--------------------------------------------------------
All operations on the Inxmail Commerce API target a single space, identified by a Space ID.
Connecting to the Inxmail Commerce API requires an API key that can be obtained from the space management page.

Proxies and timeouts can be configured by setting up an instance of `HttpConfiguration`.

Example with default settings:

```
SendRawmailClient client = SendRawmailClientFactory.instance().createClient( spaceId, apiKey, apiSecret );
SendEmailResult sendEmailResult = client.sendEmail( request );
```

Example with proxy and custom timeouts:

```
HttpConfiguration config = new HttpConfiguration()
    .setProxy( "http://proxy.domain.invalid:8080", "proxyuser", "proxypass" )
    .setTimeouts( 10000, 5000 );
SendRawmailClient client = SendRawmailClientFactory.instance( config ).createClient( spaceId, apiKey, apiSecret );
```
