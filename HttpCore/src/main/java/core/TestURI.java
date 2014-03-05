/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.net.DriveRequest;
import core.net.Param;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.scribe.model.Token;

/**
 *
 * @author Royal
 */
public class TestURI {

    private static final String ROOT_META = "https://www.googleapis.com/drive/v2/files";
    private static final String MAX_RESULTS = "maxResults";
    private static final String RESULTS_LIMIT_VALUE = "1000";

    public static void main(String[] args) throws URISyntaxException, IOException {
        Token token = new Token("ya29.1.AADtN_W77eq-NEdZMRufxcCMpDP-4f0HGQs53ZvuCF0fOLc8z3qJD661bNVaTvtTVimJzoEP", "kMvlc0XRJQvtj0N6WUDLh0s7");

        String ID = "4354dfhgdhfg";
        URI uri;
        uri = Param.create()
                .setUrl(ROOT_META)
                .setParam(MAX_RESULTS, RESULTS_LIMIT_VALUE)
                .buildURI();
        String str = uri.toString();
        str = setquery(str, ID);
        str = settoken(str, token.getToken().toString());
        System.out.println(str);
    }

    //q='me'+in+owners+and+'root'+in+parents
    private static String setquery(String root, String ID) {
        ID = "&q='me'+in+owners+and+'" + ID + "'+in+parents";
        return root + ID;
    }

    private static String settoken(String root, String token) {
        token = "&access_token=" + token;
        return root + token;
    }
}
