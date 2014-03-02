package core.net;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.scribe.model.Token;

/**
 *
 * @author Admin
 */
public class DropboxRequest {

    private final String ROOT_META = "https://api.dropbox.com/1/metadata/dropbox";
    private final String ROOT_GET = "https://api-content.dropbox.com/1/files/dropbox";
    private final String ROOT_PUT = "https://api-content.dropbox.com/1/files_put/dropbox/";

    private final String FILE_LIMIT = "file_limit";
    private final String FILE_LIMIT_VALUE = "25000";

    // access token
    private final Token token;

    public DropboxRequest(Token token) {
        this.token = token;
    }

    /**
     * Retrieves file and folder metadata
     * @param path The relative path to the file or folder
     * @return JSON String
     * @throws URISyntaxException Invalid URI
     * @throws IOException Bad request
     */
    public String list(String path) throws URISyntaxException, IOException {
        URI uri = Param.create()
                .setUrl(combine(ROOT_META, path))
                .setToken(token)
                .setParam(FILE_LIMIT, FILE_LIMIT_VALUE)
                .buildURI();
        return Request.Get(uri)
                .execute()
                .returnContent().asString();
    }
    /**
     * Downloads a file
     * @param path The relative path to the file you want to retrieve
     * @param out Output stream to write downloaded file
     * @throws URISyntaxException
     * @throws IOException 
     */
    public void download(String path, OutputStream out) throws URISyntaxException, IOException {

        URI uri = Param.create()
                .setUrl(combine(ROOT_GET, path))
                .setToken(token)
                .buildURI();
        byte[] data = Request.Get(uri)
                .execute().returnContent().asBytes();
        out.write(data);
    }
    
    /**
     * Uploads a file
     * @param path The full path to the file you want to write to
     * @param file The upload file
     * @return JSON String
     * @throws URISyntaxException
     * @throws IOException 
     */
    public String upload(String path, File file) throws URISyntaxException, IOException {
        URI uri = Param.create()
                .setUrl(combine(ROOT_PUT, path))
                .setToken(token)
                .buildURI();
        return Request.Put(uri)
                .bodyFile(file, ContentType.APPLICATION_OCTET_STREAM)
                .execute()
                .returnContent().asString();
    }

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
