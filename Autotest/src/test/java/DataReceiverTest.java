import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class DataReceiverTest {

    @Test
    public void testCheckIfMaxTempIsAboveMinTemp() {
        boolean deltaTemperature = WeatherApiInformation.checkIfMaxTempIsAboveMinTemp("30", "30");
        assertEquals(true, deltaTemperature);
    }

    @Test
    public void testCheckIfMaxTempIsBelowHighestRecorded() {
        double highestRecordedTemperature = 30.3;
        double maximumTemperatureInSelectedLocation = WeatherApiInformation.getMaximumTemperature();
        if (highestRecordedTemperature < maximumTemperatureInSelectedLocation) {
            fail();
        }
    }

    @Test
    public void testCheckIfMinTempIsBelowLowestRecorded() {
        double lowestRecordedTemperature = -30;
        double minimumTemperatureInSelectedLocation = WeatherApiInformation.getMinimumTemperature();
        if (lowestRecordedTemperature < minimumTemperatureInSelectedLocation) {
            fail();
        }
    }

    @Test
    public void testCheckIfWindSpeedIsPositive() {
        assertTrue(WeatherApiInformation.checkWindSpeedReality());
    }

    @Test
    public void testCheckIfWindSpeedIsAboveHighestRecorded() {
        double highestRecordedWindSpeed = 30;
        double currentWindSpeedInSelectedLocation = WeatherApiInformation.getWindSpeed();
        if (highestRecordedWindSpeed < currentWindSpeedInSelectedLocation) {
            fail();
        }
    }

    @Test
    public void testCheckIfWindDirectionIsPositive() {
        if (WeatherApiInformation.getWindDirection() < 0) {
            fail();
        }
    }

    @Test
    public void testCheckIfWindDirectionIsAboveThreeSixtyDegrees() {
        if (WeatherApiInformation.getWindDirection() > 360) {
            fail();
        }
    }

    @Test
    public void testCheckIfCountryFormatIsCorrect() {
        assertTrue("ET".equals(WeatherApiInformation.getSelectedLocationCountry()));
    }

    @Test
    public void testCheckIfLocationEqualsUserSelectedLocation() {
         assertEquals("Tallinn", WeatherApiInformation.getSelectedLocation());
    }

    @Test
    public void testCheckIfWeatherApiSentCorrectAmountOfLinesOfData() {
        assertEquals(3, WeatherApiInformation.getWeatherApiAmountOfLinesSent());
    }

    @Test
    public void testCheckIfHumidityIsPositive() {
        if (WeatherApiInformation.getHumidity() < 0) {
            fail();
        }
    }

    @Test
    public void testCheckIfHumidityIsAboveHighestRecorded() {
        double highestHumidityRecorded = 30;
        if (WeatherApiInformation.getHumidity() > highestHumidityRecorded) {
            fail();
        }
    }

    @Test
    public void testCheckIfPressureIsPositive() {
        if (WeatherApiInformation.getPressure() < 0) {
            fail();
        }
    }

    @Test
    public void testCheckIfPressureIsAboveHighestRecorded() {
        double highestRecordedPressure = 30;
        if (highestRecordedPressure < WeatherApiInformation.getPressure()) {
            fail();
        }
    }

    @Test
    public void testCheckIfReceivedLongitudeMatchesWithAskedLongitude() {
        double longitudeOfSelectedPosition = 03.30;
        if (longitudeOfSelectedPosition != WeatherApiInformation.getLongitude()) {
            fail();
        }
    }

    @Test
    public void testCheckIfReceivedLatitudeMatchesWithAskedLatitude() {
        double latitudeOfSelectedPosition = 30.30;
        if (latitudeOfSelectedPosition != WeatherApiInformation.getLatitude()) {
            fail();
        }
    }

    @Test
    public void testCheckIfVisibilityIsPositive() {
        if (WeatherApiInformation.getVisibility() < 0) {
            fail();
        }
    }

    @Test
    public void testCheckIfWeatherNameIsCorrect() {
        assertTrue(WeatherApiInformation.checkIfWeatherNameIsCorrect());
    }

    @Test
    public void testCheckIfWeatherDescriptionHasCorrectFormat() {
        assertTrue(WeatherApiInformation.checkIfWeatherDescriptionHasCorrectFormat());
    }

    @Test
    public void testCheckIfCloudDescriptionHasCorrectFormat() {
        assertTrue(WeatherApiInformation.checkIfCloudDescriptionHasCorrectFormat());
    }

    @Test
    public void testCheckIfReceivedCityIdMatchesWithAskedCityId() {
        int selectedCityID = 97;
        assertEquals(selectedCityID, WeatherApiInformation.getSelectedCityID());
    }

}
