package core.oauth;

import core.api.DriveApi;
import core.api.DropBoxApi20;
import org.scribe.builder.ServiceBuilder;
import org.scribe.oauth.OAuthService;

/**
 *
 * @author Admin
 */
public class ServiceFactory {

    public static final String DROPBOX = "dropbox";
    public static final String DRIVE = "drive";

    private static final String DROPBOX_API_KEY = "9231a0npejt32sk";
    private static final String DROPBOX_API_SECRET = "i2v1wh2kv0o0wb8";
    private static final String DROPBOX_CALLBACK = "http://localhost";

    private static final String DRIVE_API_KEY = "671870858786-5046aa1ar8jmjuigq9k1us2sqksli6b1.apps.googleusercontent.com";
    private static final String DRIVE_API_SECRET = "kMvlc0XRJQvtj0N6WUDLh0s7";
    private static final String DRIVE_CALLBACK = "urn:ietf:wg:oauth:2.0:oob";
    private static final String DRIVE_SCOPE = "https://www.googleapis.com/auth/drive";

    public static OAuthService create(String type) {
        switch (type) {
            case DROPBOX:
                return createDropboxAuthService();
            case DRIVE:
                return createDriveAuthService();
            default:
                throw new UnsupportedOperationException(type);
        }
    }

    private static OAuthService createDropboxAuthService() {
        return new ServiceBuilder()
                .provider(DropBoxApi20.class)
                .apiKey(DROPBOX_API_KEY)
                .apiSecret(DROPBOX_API_SECRET)
                .callback(DROPBOX_CALLBACK)
                .build();
    }

    private static OAuthService createDriveAuthService() {
        return new ServiceBuilder()
                .provider(DriveApi.class)
                .apiKey(DRIVE_API_KEY)
                .apiSecret(DRIVE_API_SECRET)
                .callback(DRIVE_CALLBACK)
                .scope(DRIVE_SCOPE)
                .build();
    }
}
