package core.pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author Royal
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DriveItem {

    @JsonProperty("kind")
    public String kind;
    @JsonProperty("id")
    public String id;

    @JsonProperty("selfLink")
    public String selfLink;

    @JsonProperty("title")
    public String title;

    @JsonProperty("mimeType")
    public String mimeType;

    @JsonProperty("userPermission")
    public DriveUserPermission userPermission;

    @JsonProperty("originalFilename")
    public String originalFilename;
    @JsonProperty("fileExtension")
    public String fileExtension;

}
