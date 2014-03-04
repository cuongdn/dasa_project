/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
/**
 *
 * @author Royal
 */
@JsonIgnoreProperties({"etag", "error"})
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//"kind",
//"etag",
//"selfLink",
//"nextPageToken",
//"nextLink",
//"items"
//})
public class DriveDir {
@JsonProperty("kind")
private String kind;
//@JsonProperty("etag")
//private String etag;
@JsonProperty("selfLink")
private String selfLink;
@JsonProperty("nextPageToken")
private String nextPageToken;
@JsonProperty("nextLink")
private String nextLink;
@JsonProperty("items")
public List<DriveItem> items = new ArrayList<DriveItem>();
//private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("kind")
public String getKind() {
return kind;
}

@JsonProperty("kind")
public void setKind(String kind) {
this.kind = kind;
}

//@JsonProperty("etag")
//public String getEtag() {
//return etag;
//}
//
//@JsonProperty("etag")
//public void setEtag(String etag) {
//this.etag = etag;
//}

@JsonProperty("selfLink")
public String getSelfLink() {
return selfLink;
}

@JsonProperty("selfLink")
public void setSelfLink(String selfLink) {
this.selfLink = selfLink;
}

@JsonProperty("nextPageToken")
public String getNextPageToken() {
return nextPageToken;
}

@JsonProperty("nextPageToken")
public void setNextPageToken(String nextPageToken) {
this.nextPageToken = nextPageToken;
}

@JsonProperty("nextLink")
public String getNextLink() {
return nextLink;
}

@JsonProperty("nextLink")
public void setNextLink(String nextLink) {
this.nextLink = nextLink;
}

@JsonProperty("items")
public List<DriveItem> getItems() {
return items;
}

@JsonProperty("items")
public void setItems(List<DriveItem> DriveItems) {
this.items = DriveItems;
}

//@JsonAnyGetter
//public Map<String, Object> getAdditionalProperties() {
//return this.additionalProperties;
//}
//
//@JsonAnySetter
//public void setAdditionalProperties(String name, Object value) {
//this.additionalProperties.put(name, value);
//}

}
