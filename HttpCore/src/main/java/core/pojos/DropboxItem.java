package core.pojos;

import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties({"size", "root", "icon", "thumb_exists", "revision", "rev"})
public class DropboxItem {

    public long bytes;
    public Date modified;
    public Date client_mtime;
    public String path;
    public boolean is_dir;
    public String mime_type;
}
