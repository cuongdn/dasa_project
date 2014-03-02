package core.api;

/**
 *
 * @author Admin
 */
public class SkyDriveApi extends Api20Base {

    @Override
    public String getAccessTokenEndpoint() {
        return "https://login.live.com/oauth20_token.srf";
    }

    @Override
    protected String getAuthorizeUrlFormat() {
        return "https://login.live.com/oauth20_authorize.srf?client_id=%s&redirect_uri=%s&response_type=token";
    }

}
