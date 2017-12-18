import getdata.ReadFromFile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import processinfo.WriteToFile;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import static org.mockito.Mockito.mock;



public class MockWriteToFileTest {

    @Mock
    private WriteToFile writeToFile;
    private ReadFromFile readFromFile;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void beforeAllTests() throws MalformedURLException {
        writeToFile = mock(WriteToFile.class);
        readFromFile = new ReadFromFile();
    }

    @Test
    public void testWriteToFileUsage() throws MalformedURLException, FileNotFoundException {

        writeToFile.writeToFile("Tallinn,EE", "inputtext.txt", false);
        String testReader = readFromFile.readFromFile("inputtest.txt");
        Assert.assertEquals("Tallinn,EE", testReader);
    }

}

