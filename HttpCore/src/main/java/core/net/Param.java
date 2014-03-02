package core.net;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.scribe.model.OAuthConstants;
import org.scribe.model.Token;
import org.scribe.utils.Preconditions;

/**
 *
 * @author Admin
 */
public class Param {

    public static Param create() {
        return new Param();
    }

    private Map<String, String> map = new HashMap<String, String>();
    private String url = null;

    private Param() {
    }

    public Param setUrl(String url) {
        Preconditions.checkNotNull(url, "The url cannot be null");
        this.url = url;
        return this;
    }

    public Param setParam(String key, String value) {
        map.put(key, value);
        return this;
    }

    public Param setToken(Token token) {
        map.put(OAuthConstants.ACCESS_TOKEN, token.getToken());
        return this;
    }

    public List<NameValuePair> buildParams() {
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        for (String key : map.keySet()) {
            list.add(new BasicNameValuePair(key, map.get(key)));
        }
        return list;
    }

    public URI buildURI() throws URISyntaxException {
        return new URIBuilder(url)
                .setParameters(buildParams())
                .build();
    }
}
