package httputility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtility {

    public static HttpURLConnection MakeHttpGetRequest(String url) throws IOException {

        HttpURLConnection connection;
        URL connectToUrl = new URL(url);
        connection = (HttpURLConnection) connectToUrl.openConnection();
        connection.setRequestMethod("POST");

        return connection;
    }
}
