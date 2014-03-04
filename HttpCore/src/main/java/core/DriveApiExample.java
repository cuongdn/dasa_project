package core;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.DriveApi;
import core.net.DriveRequest;
import core.net.Json;
import core.pojos.DriveDir;
import core.pojos.DriveItem;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.MultipartPostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
/**
 * Hello world!
 *
 */
public class DriveApiExample {

    private static final String NETWORK_NAME = "Drive";
    private static final String PROTECTED_RESOURCE_URL = "https://www.googleapis.com/drive/v2/files";
    private static final Token EMPTY_TOKEN = null;

    public static void main(String[] args) throws IOException, URISyntaxException {

        String CLIENT_ID = "671870858786-5046aa1ar8jmjuigq9k1us2sqksli6b1.apps.googleusercontent.com";
        String CLIENT_SECRET = "kMvlc0XRJQvtj0N6WUDLh0s7";
        String REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";

        OAuthService service = new ServiceBuilder()
                .provider(DriveApi.class)
                .apiKey(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .callback(REDIRECT_URI)
                .scope("https://www.googleapis.com/auth/drive")
                .build();
        
        
        
        
        
        
        Token accessToken = getToken(service);

//        DriveRequest request = new DriveRequest(accessToken);
//        String content = request.list("duan");
        
        getFiles(service, accessToken);
        
        

        
        
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

        System.out.println();
        Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
        System.out.println("Got the Access Token!");
        System.out.println("(if your curious it looks like this: " + accessToken + " )");
        System.out.println();
        return accessToken;
    }
    
    private static void getFiles(OAuthService service, Token accessToken) throws FileNotFoundException, IOException {
        // Now let's go and ask for a protected resource!
        System.out.println("Now we're going to access a protected resource...");
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
//        request.addQuerystringParameter("method", "flickr.test.login");
        service.signRequest(accessToken, request);
        Response response = request.send();
        System.out.println("Got it! Lets see what we found...");
        System.out.println();
        System.out.println(response.getBody());
       

        FileOutputStream fos = new FileOutputStream("D:\\test.json");
        fos.write(response.getBody().getBytes());
        fos.flush();
        fos.close();

        Json json2list = new Json();
        List<DriveItem> ToDriveList = Json.ToDriveList(response.getBody());
        System.out.println("I am Here!!!!"+ ToDriveList.size() );
        for(int i = 0; i < ToDriveList.size(); i++){
        System.out.println("I am Here!!!!"+ ToDriveList.get(i).getOriginalFilename() +" & "+ ToDriveList.get(i).getTitle() );
        }
        System.out.println();
        System.out.println("Thats it man! Go and build something awesome with Scribe! :)");
        
        
//        HttpClient client = new HttpClient() {};
//        HttpMethod method = new GetMethod("https://www.googleapis.com/drive/v2/files?maxResults=50&key="+accessToken.getToken());
//
//        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
//                new DefaultHttpMethodRetryHandler(3, false));
//
//        try {
//            int statusCode = client.executeMethod(method);
//
//            if (statusCode != HttpStatus.SC_OK) {
//                System.err.println("Method failed: " + method.getStatusLine());
//            }
//            byte[] responeBody = method.getResponseBody();
//            FileOutputStream fos = new FileOutputStream("D:\\test.json");
//            fos.write(responeBody);
//            fos.flush();
//            fos.close();
//            String jsonstr = new String(responeBody);
//            System.out.println(jsonstr);
////            Json json2list = new Json();
////            List<DriveItem> ToDriveList = Json.ToDriveList(new String(responeBody));
//            
////            ObjectMapper mapper = new ObjectMapper();
////            DriveDir folder = mapper.readValue(new String(responeBody), DriveDir.class);
//            
//            
////            System.out.println("I am here!!!!!!!"+ folder.items.get(0).getOriginalFilename() );
//
//        } catch (HttpException e) {
//            System.err.println("Fatal protocol violation: " + e.getMessage());
//            e.printStackTrace();
//        } catch (IOException e) {
//            System.err.println("Fatal transport error: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
      }
    

}
