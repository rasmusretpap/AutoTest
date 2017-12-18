package getdata;


import java.io.*;

public class ReadFromFile {

    public String readFromFile(String filePath) throws FileNotFoundException {
        String fileData = "";
        InputStream inputStream = new FileInputStream(filePath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                fileData += ";" + line;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileData;
    }
}
