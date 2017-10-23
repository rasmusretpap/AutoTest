import org.junit.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class HttpUtilityTest {

    @Test
    public void testSuccessfulHttpConnectionToExampleApi() {
        try {
            String requestUrl = "http://api.openweathermap.org/data/2.5/forecast?id=588409&APPID=d02d0a3c1e7b1840370a11699a3682c9";
            HttpURLConnection con = HttpUtility.MakeHttpGetRequest(requestUrl);
            assertEquals(con.getResponseCode(), 200);
        } catch (IOException ioq) {
            fail("HTTP connection threw error:" + ioq.getLocalizedMessage());
        }
    }
}
