package core;

import core.api.DropBoxApi20;
import core.net.DropboxRequest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

/**
 * Hello world!
 *
 */
public class DropboxApi20Example {

    private static final String NETWORK_NAME = "Dropbox";
    private static final String PROTECTED_RESOURCE_URL = "https://api.dropbox.com/1/metadata/dropbox/";
    private static final Token EMPTY_TOKEN = null;

    public static void main(String[] args) throws IOException, URISyntaxException {
//
        OAuthService service = new ServiceBuilder()
                .provider(DropBoxApi20.class)
                .apiKey("9231a0npejt32sk")
                .apiSecret("i2v1wh2kv0o0wb8")
                .callback("http://localhost")
                .build();

        Token accessToken = getToken(service);

        DropboxRequest request = new DropboxRequest(accessToken);
        String content = request.list("duan");
       
        //getFiles(service, accessToken);
    }

    private static Token getToken(OAuthService service) {

        Scanner in = new Scanner(System.in);
        System.out.println("=== " + NETWORK_NAME + "'s OAuth Workflow ===");
        System.out.println();

        // Obtain the Request Token
        System.out.println("Fetching the Request Token...");
        String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
        System.out.println("Got the Authorization URL!");
        System.out.println(authorizationUrl);
        System.out.println("And paste the verifier here");
        System.out.print(">>");
        Verifier verifier = new Verifier(in.nextLine());
//        Verifier verifier = new Verifier(requestToken.getToken());

        System.out.println();

        // Trade the Request Token and Verfier for the Access Token
        System.out.println("Trading the Request Token for an Access Token...");
        Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
        System.out.println("Got the Access Token!");
        System.out.println("(if your curious it looks like this: " + accessToken + " )");
        System.out.println();
        return accessToken;
    }

    private static void getFiles(OAuthService service, Token accessToken) {
        // Now let's go and ask for a protected resource!
        System.out.println("Now we're going to access a protected resource...");
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
//        request.addQuerystringParameter("method", "flickr.test.login");
        service.signRequest(accessToken, request);
        Response response = request.send();
        System.out.println("Got it! Lets see what we found...");
        System.out.println();
        System.out.println(response.getBody());

        System.out.println();
        System.out.println("Thats it man! Go and build something awesome with Scribe! :)");
    }

}
