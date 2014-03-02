package core.net;

import core.pojos.DropboxDir;
import core.pojos.DropboxItem;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Admin
 */
public class Json {

    public static ArrayList<DropboxItem> ToDropboxList(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        DropboxDir folder = mapper.readValue(json, DropboxDir.class);
        return folder.items;
    }
}
