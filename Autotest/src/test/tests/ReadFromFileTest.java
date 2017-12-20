import getdata.ReadFromFile;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.fail;


public class ReadFromFileTest {

    private ReadFromFile readFromFile;
    private ArrayList<String> fileData;


    @Before
    public void beforeEveryTest() {
        readFromFile = new ReadFromFile();
        fileData = new ArrayList<String>();
    }

    @Test
    public void testIfReaderReadsProperAmountOfLines() {
        try {
            fileData = readFromFile.readFromFile("inputtest.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int numberOfLines = fileData.size();

        if (numberOfLines != 7) {
            fail();
        }
    }

    @Test
    public void testIfReaderReadsCorrectly() {
        try {
            fileData = readFromFile.readFromFile("inputtest.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!fileData.get(2).equals("Tallinn,EE") || !fileData.get(5).equals("; ;")) {
            fail();
        }
    }

}

