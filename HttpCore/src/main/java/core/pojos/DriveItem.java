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
@JsonIgnoreProperties({


  "etag",

  "webContentLink",
  "webViewLink",
  "alternateLink",
  "embedLink",
  "openWithLinks",
  "defaultOpenWithLink",
  "iconLink",
  "thumbnailLink",
  "thumbnail",

  "mimeType",
  "description",
  "labels",
  "createdDate",
  "modifiedDate",
  "modifiedByMeDate",
  "lastViewedByMeDate",
  "sharedWithMeDate",

  "downloadUrl",
  "exportLinks",
  "indexableText",
  "userPermission",

  "fileExtension",
  "md5Checksum",
  "fileSize",
  "quotaBytesUsed",
  "ownerNames",
  "owners",
  "lastModifyingUserName",
  "lastModifyingUser",
    "isAuthenticatedUser",
    "permissionId",
  "editable",
  "copyable",
  "writersCanShare",
  "shared",
  "explicitlyTrashed",
  "appDataContents",
  "headRevisionId",
  "properties",
  "imageMediaMetadata",
    "date",
    "cameraMake",
    "cameraModel",
    "exposureTime",
    "aperture",
    "flashUsed",
    "focalLength",
    "isoSpeed",
    "meteringMode",
    "sensor",
    "exposureMode",
    "colorSpace",
    "whiteBalance",
    "exposureBias",
    "maxApertureValue",
    "subjectDistance",
    "lens"
})
@JsonInclude(JsonInclude.Include.NON_NULL)

//@JsonPropertyOrder({
//"kind",
//"id",
//"etag",
//"selfLink",
//"alternateLink",
//"embedLink",
//"openWithLinks",
//"defaultOpenWithLink",
//"iconLink",
//"thumbnailLink",
//"title",
//"mimeType",
//"labels",
//"createdDate",
//"modifiedDate",
//"modifiedByMeDate",
//"lastViewedByMeDate",
//"parents",
//"exportLinks",
//"userPermission",
//"quotaBytesUsed",
//"ownerNames",
//"owners",
//"lastModifyingUserName",
//"lastModifyingUser",
//"editable",
//"copyable",
//"writersCanShare",
//"shared",
//"appDataContents",
//"webContentLink",
//"downloadUrl",
//"originalFilename",
//"fileExtension",
//"md5Checksum",
//"fileSize",
//"headRevisionId",
//"imageMediaMetadata"
//})
public class DriveItem {
@JsonProperty("kind")
private String kind;
@JsonProperty("id")
private String id;
//@JsonProperty("etag")
//private String etag;
@JsonProperty("selfLink")
private String selfLink;
//@JsonProperty("alternateLink")
//private String alternateLink;
//@JsonProperty("embedLink")
//private String embedLink;
//@JsonProperty("openWithLinks")
//private OpenWithLinks openWithLinks;
//@JsonProperty("defaultOpenWithLink")
//private String defaultOpenWithLink;
//@JsonProperty("iconLink")
//private String iconLink;
//@JsonProperty("thumbnailLink")
//private String thumbnailLink;
@JsonProperty("title")
private String title;
//@JsonProperty("mimeType")
//private String mimeType;
//@JsonProperty("labels")
//private Labels labels;
//@JsonProperty("createdDate")
//private String createdDate;
//@JsonProperty("modifiedDate")
//private String modifiedDate;
//@JsonProperty("modifiedByMeDate")
//private String modifiedByMeDate;
//@JsonProperty("lastViewedByMeDate")
//private String lastViewedByMeDate;
@JsonProperty("parents")
private List<DriveParent> DriveParents = new ArrayList<DriveParent>();
//@JsonProperty("exportLinks")
//private ExportLinks exportLinks;
////@JsonProperty("userPermission")
//private UserPermission userPermission;
//@JsonProperty("quotaBytesUsed")
//private String quotaBytesUsed;
//@JsonProperty("ownerNames")
//private List<String> ownerNames = new ArrayList<String>();
//@JsonProperty("owners")
//private List<Owner> owners = new ArrayList<Owner>();
//@JsonProperty("lastModifyingUserName")
//private String lastModifyingUserName;
//@JsonProperty("lastModifyingUser")
//private LastModifyingUser lastModifyingUser;
//@JsonProperty("editable")
//private Boolean editable;
//@JsonProperty("copyable")
//private Boolean copyable;
//@JsonProperty("writersCanShare")
//private Boolean writersCanShare;
//@JsonProperty("shared")
//private Boolean shared;
//@JsonProperty("appDataContents")
//private Boolean appDataContents;
//@JsonProperty("webContentLink")
//private String webContentLink;
//@JsonProperty("downloadUrl")
//private String downloadUrl;
@JsonProperty("originalFilename")
private String originalFilename;
@JsonProperty("fileExtension")
private String fileExtension;
//@JsonProperty("md5Checksum")
//private String md5Checksum;
//@JsonProperty("fileSize")
//private String fileSize;
//@JsonProperty("headRevisionId")
//private String headRevisionId;
//@JsonProperty("imageMediaMetadata")
//private ImageMediaMetadata imageMediaMetadata;
//private Map<String, Object> additionalProperties = new HashMap<String, Object>();


public String getKind() {
return kind;
}


public void setKind(String kind) {
this.kind = kind;
}


public String getId() {
return id;
}


public void setId(String id) {
this.id = id;
}


//public String getEtag() {
//return etag;
//}
//
//
//public void setEtag(String etag) {
//this.etag = etag;
//}


public String getSelfLink() {
return selfLink;
}


public void setSelfLink(String selfLink) {
this.selfLink = selfLink;
}


//public String getAlternateLink() {
//return alternateLink;
//}
//
//
//public void setAlternateLink(String alternateLink) {
//this.alternateLink = alternateLink;
//}
//
//
//public String getEmbedLink() {
//return embedLink;
//}
//
//
//public void setEmbedLink(String embedLink) {
//this.embedLink = embedLink;
//}


//public OpenWithLinks getOpenWithLinks() {
//return openWithLinks;
//}
//
//
//public void setOpenWithLinks(OpenWithLinks openWithLinks) {
//this.openWithLinks = openWithLinks;
//}


//public String getDefaultOpenWithLink() {
//return defaultOpenWithLink;
//}
//
//
//public void setDefaultOpenWithLink(String defaultOpenWithLink) {
//this.defaultOpenWithLink = defaultOpenWithLink;
//}
//
//
//public String getIconLink() {
//return iconLink;
//}
//
//
//public void setIconLink(String iconLink) {
//this.iconLink = iconLink;
//}
//
//
//public String getThumbnailLink() {
//return thumbnailLink;
//}
//
//
//public void setThumbnailLink(String thumbnailLink) {
//this.thumbnailLink = thumbnailLink;
//}


public String getTitle() {
return title;
}


public void setTitle(String title) {
this.title = title;
}


//public String getMimeType() {
//return mimeType;
//}
//
//
//public void setMimeType(String mimeType) {
//this.mimeType = mimeType;
//}

//@JsonProperty("labels")
//public Labels getLabels() {
//return labels;
//}
//
//@JsonProperty("labels")
//public void setLabels(Labels labels) {
//this.labels = labels;
//}


//public String getCreatedDate() {
//return createdDate;
//}
//
//
//public void setCreatedDate(String createdDate) {
//this.createdDate = createdDate;
//}
//
//
//public String getModifiedDate() {
//return modifiedDate;
//}
//
//
//public void setModifiedDate(String modifiedDate) {
//this.modifiedDate = modifiedDate;
//}
//
//
//public String getModifiedByMeDate() {
//return modifiedByMeDate;
//}
//
//
//public void setModifiedByMeDate(String modifiedByMeDate) {
//this.modifiedByMeDate = modifiedByMeDate;
//}
//
//
//public String getLastViewedByMeDate() {
//return lastViewedByMeDate;
//}
//
//
//public void setLastViewedByMeDate(String lastViewedByMeDate) {
//this.lastViewedByMeDate = lastViewedByMeDate;
//}


public List<DriveParent> getDriveParents() {
return DriveParents;
}


public void setParents(List<DriveParent> DriveParents) {
this.DriveParents = DriveParents;
}

//@JsonProperty("exportLinks")
//public ExportLinks getExportLinks() {
//return exportLinks;
//}
//
//@JsonProperty("exportLinks")
//public void setExportLinks(ExportLinks exportLinks) {
//this.exportLinks = exportLinks;
//}
//
//@JsonProperty("userPermission")
//public UserPermission getUserPermission() {
//return userPermission;
//}
//
//@JsonProperty("userPermission")
//public void setUserPermission(UserPermission userPermission) {
//this.userPermission = userPermission;
//}
//
//@JsonProperty("quotaBytesUsed")
//public String getQuotaBytesUsed() {
//return quotaBytesUsed;
//}
//
//@JsonProperty("quotaBytesUsed")
//public void setQuotaBytesUsed(String quotaBytesUsed) {
//this.quotaBytesUsed = quotaBytesUsed;
//}
//
//@JsonProperty("ownerNames")
//public List<String> getOwnerNames() {
//return ownerNames;
//}
//
//@JsonProperty("ownerNames")
//public void setOwnerNames(List<String> ownerNames) {
//this.ownerNames = ownerNames;
//}
//
//@JsonProperty("owners")
//public List<Owner> getOwners() {
//return owners;
//}
//
//@JsonProperty("owners")
//public void setOwners(List<Owner> owners) {
//this.owners = owners;
//}
//
//@JsonProperty("lastModifyingUserName")
//public String getLastModifyingUserName() {
//return lastModifyingUserName;
//}
//
//@JsonProperty("lastModifyingUserName")
//public void setLastModifyingUserName(String lastModifyingUserName) {
//this.lastModifyingUserName = lastModifyingUserName;
//}
//
//@JsonProperty("lastModifyingUser")
//public LastModifyingUser getLastModifyingUser() {
//return lastModifyingUser;
//}
//
//@JsonProperty("lastModifyingUser")
//public void setLastModifyingUser(LastModifyingUser lastModifyingUser) {
//this.lastModifyingUser = lastModifyingUser;
//}


//public Boolean getEditable() {
//return editable;
//}
//
//
//public void setEditable(Boolean editable) {
//this.editable = editable;
//}
//
//
//public Boolean getCopyable() {
//return copyable;
//}
//
//
//public void setCopyable(Boolean copyable) {
//this.copyable = copyable;
//}
//
//
//public Boolean getWritersCanShare() {
//return writersCanShare;
//}
//
//
//public void setWritersCanShare(Boolean writersCanShare) {
//this.writersCanShare = writersCanShare;
//}
//
//
//public Boolean getShared() {
//return shared;
//}
//
//
//public void setShared(Boolean shared) {
//this.shared = shared;
//}
//
//
//public Boolean getAppDataContents() {
//return appDataContents;
//}
//
//
//public void setAppDataContents(Boolean appDataContents) {
//this.appDataContents = appDataContents;
//}
//
//
//public String getWebContentLink() {
//return webContentLink;
//}
//
//
//public void setWebContentLink(String webContentLink) {
//this.webContentLink = webContentLink;
//}
//
//
//public String getDownloadUrl() {
//return downloadUrl;
//}
//
//
//public void setDownloadUrl(String downloadUrl) {
//this.downloadUrl = downloadUrl;
//}


public String getOriginalFilename() {
return originalFilename;
}


public void setOriginalFilename(String originalFilename) {
this.originalFilename = originalFilename;
}


public String getFileExtension() {
return fileExtension;
}


public void setFileExtension(String fileExtension) {
this.fileExtension = fileExtension;
}


//public String getMd5Checksum() {
//return md5Checksum;
//}
//
//
//public void setMd5Checksum(String md5Checksum) {
//this.md5Checksum = md5Checksum;
//}
//
//
//public String getFileSize() {
//return fileSize;
//}
//
//
//public void setFileSize(String fileSize) {
//this.fileSize = fileSize;
//}
//
//
//public String getHeadRevisionId() {
//return headRevisionId;
//}
//
//
//public void setHeadRevisionId(String headRevisionId) {
//this.headRevisionId = headRevisionId;
//}

//@JsonProperty("imageMediaMetadata")
//public ImageMediaMetadata getImageMediaMetadata() {
//return imageMediaMetadata;
//}
//
//@JsonProperty("imageMediaMetadata")
//public void setImageMediaMetadata(ImageMediaMetadata imageMediaMetadata) {
//this.imageMediaMetadata = imageMediaMetadata;
//}

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
