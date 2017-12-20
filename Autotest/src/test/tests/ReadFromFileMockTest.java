import processinfo.ProcessAllData;
import getdata.ReadFromFile;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import processinfo.ThreeDayWeatherForecastProcessor;
import processinfo.WriteToFile;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ReadFromFileMockTest {

    @Mock
    private ReadFromFile readFromFile;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private ProcessAllData processAllData;


    @Before
    public void beforeAllTests() throws MalformedURLException {
        readFromFile = mock(ReadFromFile.class);
        ThreeDayWeatherForecastProcessor threeDayWeatherForecastProcessor = new ThreeDayWeatherForecastProcessor();
        WriteToFile writeToFile = new WriteToFile();
        processAllData = new ProcessAllData(threeDayWeatherForecastProcessor, writeToFile, readFromFile);
    }

    @Test
    public void testIfReadFromFileIsUsedAndIfReadsCorrectFile() throws IOException {
        processAllData.getAllData("input.txt");
        verify(readFromFile).readFromFile("input.txt");
    }
}

