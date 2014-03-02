package core.pojos;

import java.util.ArrayList;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties({"size", "hash", "thumb_exists", "rev", "modified",
    "icon", "revision"})
public class DropboxDir {

    public long bytes;
    public boolean is_dir;
    public String root;
    public String path;
    public String size;

    @JsonProperty("contents")
    public ArrayList<DropboxItem> items;
}
