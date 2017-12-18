package getdata;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CurrentWeatherForecast {
    String cityName;
    String countryCode;
    String units;
    String type;

    public CurrentWeatherForecast() {
        this.cityName = "Tallinn";
        this.countryCode = "EE";
        this.units = "metric";
        this.type = "weather";
    }

    public JSONObject getDataFromApi() throws MalformedURLException {

        String dataFromApi = "";
        String url = "https://api.openweathermap.org/data/2.5/" + type + "?q=" + this.cityName + ","
                + this.countryCode + "&units=" + this.units + "&APPID=d02d0a3c1e7b1840370a11699a3682c9";
        URL apiUrl = new URL(url);
        URLConnection connection = null;

        try {
            connection = apiUrl.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream is = null;
        try {
            is = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line;
        try {
            while ((line = br.readLine()) != null) {
                dataFromApi += line;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new JSONObject(dataFromApi);
    }
}
