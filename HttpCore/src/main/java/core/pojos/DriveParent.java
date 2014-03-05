
package core.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.annotation.Generated;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author Royal
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
//@JsonPropertyOrder({
//"kind",
//"id",
//"selfLink",
//"parentLink",
//"isRoot"
//})
public class DriveParent {

    @JsonProperty("kind")
    private String kind;
    @JsonProperty("id")
    private String id;
    @JsonProperty("selfLink")
    private String selfLink;
    @JsonProperty("parentLink")
    private String parentLink;
    @JsonProperty("isRoot")
    private Boolean isRoot;

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("selfLink")
    public String getSelfLink() {
        return selfLink;
    }

    @JsonProperty("selfLink")
    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    @JsonProperty("parentLink")
    public String getParentLink() {
        return parentLink;
    }

    @JsonProperty("parentLink")
    public void setParentLink(String parentLink) {
        this.parentLink = parentLink;
    }

    @JsonProperty("isRoot")
    public Boolean getIsRoot() {
        return isRoot;
    }

    @JsonProperty("isRoot")
    public void setIsRoot(Boolean isRoot) {
        this.isRoot = isRoot;
    }

}
