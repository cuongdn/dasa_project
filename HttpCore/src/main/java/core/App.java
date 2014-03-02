package core;

import core.net.DropboxRequest;
import core.net.Json;
import core.oauth.ServiceFactory;
import core.pojos.DropboxItem;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
public class App {

    public static void main(String[] args) throws IOException, URISyntaxException {
        OAuthService service = ServiceFactory.create(ServiceFactory.DROPBOX);

        Scanner in = new Scanner(System.in);
        System.out.println("=== Dropbox's OAuth Workflow ===");
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

        DropboxRequest request = new DropboxRequest(token);
        System.out.println("");
        System.out.println("Listing directory DuAn...");
        String json = request.list("duan");

        // deserialize json string to list DropBoxItem
        ArrayList<DropboxItem> list = Json.ToDropboxList(json);
        for (DropboxItem item : list) {
            System.out.println(item.path + "\t" + item.bytes);
        }

        System.out.println("");
        System.out.println("Uploading... file a.txt");
        File file = new File("src/main/resources/a.txt");
        String rs = request.upload("duan/a.txt", file);
        System.out.println(rs);

        System.out.println("");
        System.out.println("Downloading... file a.txt");
        File target = new File("src/main/resources/a.txt");
        OutputStream out = new FileOutputStream(target);
        try {
            request.download("duan/a.txt", out);
        } catch (Exception e) {
            out.close();
        }
        System.out.println("Done!!!");
    }

}
