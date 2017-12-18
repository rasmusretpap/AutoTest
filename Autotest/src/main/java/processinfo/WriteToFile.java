package processinfo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    public void writeToFile(String writeLine, String fileName, boolean appendLine) {

        File file = new File(fileName);
        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(file, appendLine));
            writer.write(writeLine);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
