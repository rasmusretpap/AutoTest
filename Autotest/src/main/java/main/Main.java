package main;

import processinfo.ProcessAllData;
import getdata.GetUserInput;
import getdata.ReadFromFile;
import processinfo.ThreeDayWeatherForecastProcessor;
import processinfo.WriteToFile;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GetUserInput getUserInput = new GetUserInput();
        getUserInput.getUserInput();


        ProcessAllData processAllData = new ProcessAllData(new ThreeDayWeatherForecastProcessor(), new WriteToFile(), new ReadFromFile());

        processAllData.getAllData("input.txt");
    }
}
