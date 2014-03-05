package core;

import core.net.DriveRequest;
import core.net.Json;
import core.oauth.ServiceFactory;
import core.pojos.DriveItem;

import java.io.IOException;
import java.net.URISyntaxException;

import java.util.ArrayList;

import java.util.Scanner;

import static org.scribe.model.OAuthConstants.EMPTY_TOKEN;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

/**
 * Hello world!
 *
 */
public class DriveApiExample {

    public static void main(String[] args) throws IOException, URISyntaxException {

        OAuthService service = ServiceFactory.create(ServiceFactory.DRIVE);
        Scanner in = new Scanner(System.in);
        System.out.println("=== Drive's OAuth Workflow ===");
        System.out.println();

        System.out.println("Fetching the Request Token...");
        String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
        System.out.println("Got the Authorization URL!");
        System.out.println(authorizationUrl);
        System.out.println("And paste the verifier here");
        System.out.print(">>");
        Verifier verifier = new Verifier(in.nextLine());
        System.out.println();

        System.out.println("Trading the Request Token for an Access Token...");
        Token token = service.getAccessToken(EMPTY_TOKEN, verifier);
        System.out.println("Got the Access Token!");
        System.out.println("(if your curious it looks like this: " + token + " )");
        System.out.println();

        DriveRequest request = new DriveRequest(token);
        System.out.println("");
        System.out.println("Listing root directory ...");
        String json = request.list("");

        // deserialize json string to list DropBoxItem
        ArrayList<DriveItem> list = Json.ToDriveList(json);
        for (DriveItem item : list) {
            System.out.println(item.title + " " + item.mimeType);
        }

        // test another later
        
        ///...
        
        
        System.out.println("Done!!!");

    }

}
