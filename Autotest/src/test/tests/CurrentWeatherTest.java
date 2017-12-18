import getdata.CurrentWeatherForecast;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.fail;
import processinfo.CurrentWeatherForecastProcessor;

import java.net.MalformedURLException;

public class CurrentWeatherTest {

    private JSONObject dataFromApi;
    private CurrentWeatherForecastProcessor currentWeatherForecastProcessor;

    @Before
    public void beforeEveryTest() {
        CurrentWeatherForecast currentWeatherForecast = new CurrentWeatherForecast();
        currentWeatherForecastProcessor = new CurrentWeatherForecastProcessor();
        try {
            dataFromApi = currentWeatherForecast.getDataFromApi();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCheckIfTemperatureIsNotAbnormal() {
        double currentTemp = currentWeatherForecastProcessor.getCurrentTemperature(dataFromApi);
        if (currentTemp < -50 || currentTemp > 50) {
            fail();
        }
    }

    @Test
    public void testCheckIfHumidityIsNotAbnormal() {
        double currentHumidity = currentWeatherForecastProcessor.getCurrentHumidity(dataFromApi);
        if (currentHumidity < 0 || currentHumidity > 100) {
            fail();
        }
    }

    @Test
    public void testCheckIfPressureIsNotAbnormal() {
        double currentPressure = currentWeatherForecastProcessor.getCurrentPressure(dataFromApi);
        if (currentPressure < 870 || currentPressure > 1083) {
            fail();
        }
    }

    @Test
    public void testCheckIfWindSpeedIsNotAbnormal() {
        double currentWindSpeed = currentWeatherForecastProcessor.getCurrentWindSpeed(dataFromApi);
        if (currentWindSpeed < 0 || currentWindSpeed > 105) {
            fail();
        }
    }

    @Test
    public void testCheckIfDirectionIsNotAbnormal() {
        double currentWindDirection = currentWeatherForecastProcessor.getCurrentWindDirection(dataFromApi);
        if (currentWindDirection < 0 || currentWindDirection > 360) {
            fail();
        }
    }

    @Test
    public void testCheckIfCountryCodeMatches() {
        String currentCountyCode = currentWeatherForecastProcessor.getCurrentCountryCode(dataFromApi);
        Assert.assertTrue(currentCountyCode.equals("EE"));
    }

    @Test
    public void testCheckIfCityMatches() {
        String currentCity = currentWeatherForecastProcessor.getCurrentCity(dataFromApi);
        Assert.assertTrue(currentCity.equals("Tallinn"));
    }

    @Test
    public void testCheckIfVisibilityIsAbnormal() {
        double currentVisibility = currentWeatherForecastProcessor.getCurrentVisibility(dataFromApi);
        if (currentVisibility < 0 || currentVisibility > 12000) {
            fail();
        }
    }

    @Test
    public void testCheckIfLongitudeHasNormalValue() {
        double longitude = currentWeatherForecastProcessor.getLocationLongitude(dataFromApi);
        if(longitude < -180 || longitude > 180) {
            fail();
        }
    }

    @Test
    public void testCheckIfLatitudeHasNormalValue() {
        double latitude = currentWeatherForecastProcessor.getLocationLatitude(dataFromApi);
        if(latitude < -90 || latitude > 90) {
            fail();
        }
    }

}
