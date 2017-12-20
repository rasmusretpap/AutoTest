import getdata.CurrentWeatherForecast;

import org.json.JSONArray;
import org.json.JSONObject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.net.MalformedURLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApiMockTest {

    @Mock
    private CurrentWeatherForecast currentWeatherForecast;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void beforeAllTests() throws MalformedURLException {
        currentWeatherForecast = mock(CurrentWeatherForecast.class);

        JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();
        JSONObject item = new JSONObject();
        item.put("min_temp", 2.1);
        item.put("temp", 3.1);
        item.put("max_temp", 4.6);
        array.put(item);

        json.put("main", array);
        when(currentWeatherForecast.getDataFromApi()).thenReturn(json);

    }

    @Test
    public void testCurrentWeather() throws MalformedURLException {
        JSONObject dataFromApi = currentWeatherForecast.getDataFromApi();
        Assert.assertTrue(dataFromApi.getJSONArray("main").getJSONObject(0).getDouble("temp") == 3.1);
    }
}
