import getdata.GetDataFromApi;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.fail;
import processinfo.CurrentWeatherForecast;

import java.net.MalformedURLException;

public class CurrentWeatherTest {

    private JSONObject jsonObject;

    @Before
    public void setup() {
        GetDataFromApi getDataFromApi = new GetDataFromApi("Tallinn", "EE", "metric", "weather");
        try {
            jsonObject = getDataFromApi.getDataFromApi();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCheckIfTemperatureIsNotAbnormal() {
        double currentTemp = CurrentWeatherForecast.getCurrentTemperature(jsonObject);
        if (currentTemp < -50 || currentTemp > 50) {
            fail();
        }
    }

    @Test
    public void testCheckIfHumidityIsNotAbnormal() {
        double currentHumidity = CurrentWeatherForecast.getCurrentHumidity(jsonObject);
        if (currentHumidity < 0 || currentHumidity > 100) {
            fail();
        }
    }

    @Test
    public void testCheckIfPressureIsNotAbnormal() {
        double currentPressure = CurrentWeatherForecast.getCurrentPressure(jsonObject);
        if (currentPressure < 870 || currentPressure > 1083) {
            fail();
        }
    }

    @Test
    public void testCheckIfWindSpeedIsNotAbnormal() {
        double currentWindSpeed = CurrentWeatherForecast.getCurrentWindSpeed(jsonObject);
        if (currentWindSpeed < 0 || currentWindSpeed > 105) {
            fail();
        }
    }

    @Test
    public void testCheckIfDirectionIsNotAbnormal() {
        double currentWindDirection = CurrentWeatherForecast.getCurrentWindDirection(jsonObject);
        if (currentWindDirection < 0 || currentWindDirection > 360) {
            fail();
        }
    }

    @Test
    public void testCheckIfCountryCodeMatches() {
        String currentCountyCode = CurrentWeatherForecast.getCurrentCountryCode(jsonObject);
        Assert.assertTrue(currentCountyCode.equals("EE"));
    }

    @Test
    public void testCheckIfCityMatches() {
        String currentCity = CurrentWeatherForecast.getCurrentCity(jsonObject);
        Assert.assertTrue(currentCity.equals("Tallinn"));
    }

    @Test
    public void testCheckIfVisibilityIsAbnormal() {
        double currentVisibility = CurrentWeatherForecast.getCurrentVisibility(jsonObject);
        if (currentVisibility < 0 || currentVisibility > 12000) {
            fail();
        }
    }


}
