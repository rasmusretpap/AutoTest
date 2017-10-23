package processinfo;

import org.json.JSONObject;
import java.util.ArrayList;

public class CurrentWeatherForecast {

    public static double getCurrentTemperature(JSONObject dataFromApi) {
        return dataFromApi.getJSONObject("main").getDouble("temp");
    }

    public static double getCurrentPressure(JSONObject dataFromApi) {
        return dataFromApi.getJSONObject("main").getDouble("pressure");
    }

    public static double getCurrentHumidity(JSONObject dataFromApi) {
        return dataFromApi.getJSONObject("main").getDouble("humidity");
    }

    public static double getCurrentWindSpeed(JSONObject dataFromApi) {
        return dataFromApi.getJSONObject("wind").getDouble("speed");
    }

    public static double getCurrentWindDirection(JSONObject dataFromApi) {
        return dataFromApi.getJSONObject("wind").getDouble("deg");
    }

    public static String getCurrentCountryCode(JSONObject dataFromApi) {
        return dataFromApi.getJSONObject("sys").getString("country");
    }

    public static String getCurrentCity(JSONObject dataFromApi) {
        return dataFromApi.getString("name");
    }

    public static double getCurrentVisibility(JSONObject dataFromApi) {
        return dataFromApi.getDouble("visibility");
    }
}
