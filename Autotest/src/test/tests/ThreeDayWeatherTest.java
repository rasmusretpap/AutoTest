import getdata.CurrentWeatherForecast;

import getdata.ThreeDayWeatherForecast;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import processinfo.ThreeDayWeatherForecastProcessor;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class ThreeDayWeatherTest {

    private JSONObject dataFromApi;
    private ArrayList<Double> minMaxTempList;
    private ThreeDayWeatherForecastProcessor threeDayWeatherForecastProcessor;

    @Before
    public void setup() {
        CurrentWeatherForecast currentWeatherForecast = new ThreeDayWeatherForecast("Tallinn", "EE", "metric", "forecast");
        threeDayWeatherForecastProcessor = new ThreeDayWeatherForecastProcessor();
        try {
            dataFromApi = currentWeatherForecast.getDataFromApi();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        minMaxTempList = threeDayWeatherForecastProcessor.getMinMaxTemperatureList(dataFromApi);
    }
    @Test
    public void testCheckIfDayOneTemperatureValuesAreAbnormal() {
        if (minMaxTempList.get(0) < -50 || minMaxTempList.get(1) > 50) {
            fail();
        }
    }

    @Test
    public void testCheckIfDayTwoTemperatureValuesAreAbnormal() {
        if (minMaxTempList.get(2) < -50 || minMaxTempList.get(3) > 50) {
            fail();
        }
    }

    @Test
    public void testCheckIfDayThreeTemperatureValuesAreAbnormal() {
        if (minMaxTempList.get(4) < - 50 || minMaxTempList.get(5) > 50) {
            fail();
        }
    }

    @Test
    public void testCheckIfDayOneMaxTempIsHigherThanDayOneMinTemp() {
        Assert.assertTrue(minMaxTempList.get(0) < minMaxTempList.get(1));
    }

    @Test
    public void testCheckIfDayTwoMaxTempIsHigherThanDayOneMinTemp() {
        Assert.assertTrue(minMaxTempList.get(2) < minMaxTempList.get(3));
    }

    @Test
    public void testCheckIfDayThreeMaxTempIsHigherThanDayOneMinTemp() {
        Assert.assertTrue(minMaxTempList.get(4) < minMaxTempList.get(5));
    }

    @Test
    public void testCheckIfLongitudeHasNormalValue() {
        double longitude = threeDayWeatherForecastProcessor.getLocationLongitude(dataFromApi);
        if(longitude < -180 || longitude > 180) {
            fail();
        }
    }

    @Test
    public void testCheckIfLatitudeHasNormalValue() {
        double latitude = threeDayWeatherForecastProcessor.getLocationLatitude(dataFromApi);
        if(latitude < -90 || latitude > 90) {
            fail();
        }
    }

    @Test
    public void testCheckIfApiGivesSufficientAmountsOfData() {
        int amountOfData = threeDayWeatherForecastProcessor.getJSONArrayLength(dataFromApi);
        if (amountOfData < 25) {
            fail();
        }
    }

    @Test
    public void testIfMinMaxListHasCorrectValues() {
        ArrayList<Double> minMaxTempList = threeDayWeatherForecastProcessor.getMinMaxTemperatureList(dataFromApi);
        if (minMaxTempList.get(0) > minMaxTempList.get(1) || minMaxTempList.get(2) > minMaxTempList.get(3)
                || minMaxTempList.get(4) > minMaxTempList.get(5)) {
            fail();
        }
    }
}
