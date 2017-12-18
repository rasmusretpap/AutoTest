package processinfo;

import org.json.JSONObject;


public class CurrentWeatherForecastProcessor {

    public double getCurrentTemperature(JSONObject dataFromApi) {
        return dataFromApi.getJSONObject("main").getDouble("temp");
    }

    public double getCurrentPressure(JSONObject dataFromApi) {
        return dataFromApi.getJSONObject("main").getDouble("pressure");
    }

    public double getCurrentHumidity(JSONObject dataFromApi) {
        return dataFromApi.getJSONObject("main").getDouble("humidity");
    }

    public double getCurrentWindSpeed(JSONObject dataFromApi) {
        return dataFromApi.getJSONObject("wind").getDouble("speed");
    }

    public double getCurrentWindDirection(JSONObject dataFromApi) {
        return dataFromApi.getJSONObject("wind").getDouble("deg");
    }

    public String getCurrentCountryCode(JSONObject dataFromApi) {
        return dataFromApi.getJSONObject("sys").getString("country");
    }

    public String getCurrentCity(JSONObject dataFromApi) {
        return dataFromApi.getString("name");
    }

    public double getCurrentVisibility(JSONObject dataFromApi) {
        return dataFromApi.getDouble("visibility");
    }

    public double getLocationLongitude(JSONObject dataFromApi) {
        return dataFromApi.getJSONObject("coord").getDouble("lon");
    }

    public double getLocationLatitude(JSONObject dataFromApi) {
        return dataFromApi.getJSONObject("coord").getDouble("lat");
    }
}
