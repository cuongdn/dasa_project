package core;

import core.api.SkyDriveApi;
import java.io.IOException;
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
public class SkyDriveApiExample {

    private static final String NETWORK_NAME = "Drive";
    private static final String PROTECTED_RESOURCE_URL = "https://www.googleapis.com/drive/v2/files";
    private static final Token EMPTY_TOKEN = null;

    public static void main(String[] args) throws IOException {

        String CLIENT_ID = "0000000044112D7F";
        String CLIENT_SECRET = "ir3jr475dDjndfi6kYhkIlWEeaxiW8tA";
        String REDIRECT_URI = "https://login.live.com/oauth20_desktop.srf";

        OAuthService service = new ServiceBuilder()
                .provider(SkyDriveApi.class)
                .apiKey(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .scope("wl.skydrive")
                .callback(REDIRECT_URI)
                .build();
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

        System.out.println();
        Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
        System.out.println("Got the Access Token!");
        System.out.println("(if your curious it looks like this: " + accessToken + " )");
        System.out.println();

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
