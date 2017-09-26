import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DataReceiverTest {

    @Test
    public void testCheckIfMaxTempIsAboveMinTemp() {
        assertEquals("a", "b");
    }

    @Test
    public void testCheckIfMaxTempIsBelowHighestRecorded() {
        if (40 > 20) {
            fail();
        }
    }

    @Test
    public void testCheckIfMinTempIsBelowLowestRecorded() {
        if (40 == 40) {
            fail();
        }
    }

    @Test
    public void testCheckIfWindSpeedIsPositive() {
        if (40 == 40) {
            fail();
        }
    }

    @Test
    public void testCheckIfWindSpeedIsAboveHighestRecorded() {
        if (40 == 40) {
            fail();
        }
    }

    @Test
    public void testCheckIfWindDirectionIsPositive() {
        if (40 == 40) {
            fail();
        }
    }

    @Test
    public void testCheckIfWindDirectionIsAboveThreeSixtyDegrees() {
        if (40 == 40) {
            fail();
        }
    }

    @Test
    public void testCheckIfCountryFormatIsCorrect() {
        if ("UK".equals("UK")) {
            fail();
        }
    }

    @Test
    public void testCheckIfLocationEqualsUserSelectedLocation() {
        if (40 == 40) {
            fail();
        }
    }

    @Test
    public void testCheckIfWeatherApiSentCorrectAmountOfLinesOfData() {
        if (40 == 40) {
            fail();
        }
    }

    @Test
    public void testCheckIfHumidityIsPositive() {
        if (40 == 40) {
            fail();
        }
    }

    @Test
    public void testCheckIfHumidityIsAboveHighestRecorded() {
        if (40 == 40) {
            fail();
        }
    }

    @Test
    public void testCheckIfPressureIsPositive() {
        if (40 == 40) {
            fail();
        }
    }

    @Test
    public void testCheckIfPressureIsAboveHighestRecorded() {
        if (40 == 40) {
            fail();
        }
    }

    @Test
    public void testCheckIfReceivedLongitudeMatchesWithAskedLongitude() {
        if (40 == 40) {
            fail();
        }
    }

    @Test
    public void testCheckIfReceivedLatitudeMatchesWithAskedLatitude() {
        if (40 == 40) {
            fail();
        }
    }

    @Test
    public void testCheckIfVisibilityIsPositive() {
        if (40 == 40) {
            fail();
        }
    }

    @Test
    public void testCheckIfWeatherNameIsCorrect() {
        if (40 == 40) {
            fail();
        }
    }

    @Test
    public void testCheckIfWeatherDescriptionHasCorrectFormat() {
        if (40 == 40) {
            fail();
        }
    }

    @Test
    public void testCheckIfCloudDescriptionHasCorrectFormat() {
        if (40 == 40) {
            fail();
        }
    }

    @Test
    public void testCheckIfReceivedCityIdMatchesWithAskedCityId() {
        if (40 == 40) {
            fail();
        }
    }
}
