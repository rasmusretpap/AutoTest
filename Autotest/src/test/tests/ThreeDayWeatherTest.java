import getdata.GetDataFromApi;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import processinfo.ThreeDayWeatherForecast;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class ThreeDayWeatherTest {

    private JSONObject jsonObject;
    private ArrayList<Double> minMaxTempList;

    @Before
    public void setup() {
        GetDataFromApi getDataFromApi = new GetDataFromApi("Tallinn", "EE", "metric", "forecast");
        try {
            jsonObject = getDataFromApi.getDataFromApi();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        minMaxTempList = ThreeDayWeatherForecast.getMinMaxTemperatureList(jsonObject);
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
}
