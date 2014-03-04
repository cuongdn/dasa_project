/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.net;

import core.pojos.DriveItem;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.scribe.model.Token;
/**
 *
 * @author Royal
 */
public class DriveRequest {
      private final String ROOT_META = "https://drive.google.com";
//    private final String ROOT_META = "https://www.googleapis.com/drive/v2/files";
//    private final String ROOT_GET = "https://api-content.dropbox.com/1/files/dropbox";
//    private final String ROOT_PUT = "https://api-content.dropbox.com/1/files_put/dropbox/";

    private final String MAX_RESULTS = "maxResults";
    private final String RESULTS_LIMIT_VALUE = "1000";

    // access token
    private final Token token;

    public DriveRequest(Token token) {
        this.token = token;
    }

    /**
     * Retrieves file and folder metadata
     * @param path The relative path to the file or folder
     * @return JSON String
     * @throws URISyntaxException Invalid URI
     * @throws IOException Bad request
     */
//    public String list(String path) throws URISyntaxException, IOException {
//        URI uri = Param.create()
//                .setUrl(combine(ROOT_META, path))
//                .setParam(MAX_RESULTS, RESULTS_LIMIT_VALUE)
//                .setToken(token)
//                .buildURI();
//        return Request.Get(uri)
//                .execute()
//                .returnContent().asString();
//    }
    
     public static List<DriveItem> Rootlist(List<DriveItem> items){
        List<DriveItem> temp = new ArrayList<>();
        for(int i = 0; i < items.size() ; i++){
            if( (items.get(i).getDriveParents().size() != 1) || (items.get(i).getMimeType().equals("application/vnd.google-apps.folder") && items.get(i).getDriveParents().get(0).getIsRoot()) && items.get(i).getUserPermission().getRole().equals("owner")  ){
            temp.add(items.get(i));
            } 
        }
        return temp;
    }   
    
        public static List<DriveItem> Childlist(List<DriveItem> items, DriveItem item) {
        List<DriveItem> temp = new ArrayList<>();
        if (item.getMimeType().equals("application/vnd.google-apps.folder")) {
            for (int i = 0; i < items.size(); i++) {
                if ((items.get(i).getDriveParents().size() != 0) && (items.get(i).getUserPermission().getRole().equals("owner")) ) {
                    if (items.get(i).getDriveParents().get(0).getId().equals(item.getId())) {
                        temp.add(items.get(i));
                    }
                }
            }
        }
        return temp;
    }
    
    
//    /**
//     * Downloads a file
//     * @param path The relative path to the file you want to retrieve
//     * @param out Output stream to write downloaded file
//     * @throws URISyntaxException
//     * @throws IOException 
//     */
//    public void download(String path, OutputStream out) throws URISyntaxException, IOException {
//
//        URI uri = Param.create()
//                .setUrl(combine(ROOT_GET, path))
//                .setToken(token)
//                .buildURI();
//        byte[] data = Request.Get(uri)
//                .execute().returnContent().asBytes();
//        out.write(data);
//    }
//    
//    /**
//     * Uploads a file
//     * @param path The full path to the file you want to write to
//     * @param file The upload file
//     * @return JSON String
//     * @throws URISyntaxException
//     * @throws IOException 
//     */
//    public String upload(String path, File file) throws URISyntaxException, IOException {
//        URI uri = Param.create()
//                .setUrl(combine(ROOT_PUT, path))
//                .setToken(token)
//                .buildURI();
//        return Request.Put(uri)
//                .bodyFile(file, ContentType.APPLICATION_OCTET_STREAM)
//                .execute()
//                .returnContent().asString();
//    }

    /**
     * Combine root and path
     * @param root Root path of Dropbox. Using constant value in class DropboxRequest
     * @param path Path to file or folder
     * @return 
     */
    private String combine(String root, String path) {
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return root + path;
    }
}
