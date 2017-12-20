import getdata.ReadFromFile;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import processinfo.ProcessAllData;
import processinfo.ThreeDayWeatherForecastProcessor;
import processinfo.WriteToFile;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WriteToFileMockTest {

    @Mock
    private WriteToFile writeToFile;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private ProcessAllData processAllData;

    @Before
    public void beforeAllTests() throws MalformedURLException {
        writeToFile = mock(WriteToFile.class);
        ReadFromFile readFromFile = new ReadFromFile();
        ThreeDayWeatherForecastProcessor threeDayWeatherForecastProcessor = new ThreeDayWeatherForecastProcessor();

        processAllData = new ProcessAllData(threeDayWeatherForecastProcessor, writeToFile, readFromFile);
    }

    @Test
    public void testIfWriteToFileIsUsed() throws IOException {
        processAllData.getAllData("inputtest2.txt");
        verify(writeToFile).writeToFile(anyString(), anyString(), anyBoolean());
    }
}
