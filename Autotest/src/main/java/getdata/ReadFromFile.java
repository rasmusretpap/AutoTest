package getdata;


import java.io.*;
import java.util.ArrayList;

public class ReadFromFile {

    public ArrayList<String> readFromFile(String filePath) throws FileNotFoundException {

        ArrayList<String> fileData = new ArrayList<String>();

        InputStream inputStream = new FileInputStream(filePath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                fileData.add(line);
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileData;
    }
}
