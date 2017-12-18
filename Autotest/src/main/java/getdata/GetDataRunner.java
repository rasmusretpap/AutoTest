package getdata;

import org.json.JSONObject;
import processinfo.CurrentWeatherForecastProcessor;
import processinfo.ThreeDayWeatherForecastProcessor;
import processinfo.WriteToFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class GetDataRunner {
    private GetUserInput getUserInput;
    private ThreeDayWeatherForecastProcessor threeDayWeatherForecastProcessor = new ThreeDayWeatherForecastProcessor();
    private WriteToFile writeToFile = new WriteToFile();

    public GetDataRunner (GetUserInput getUserInput) {
        this.getUserInput = getUserInput;
    }

    public void getAllData() throws IOException {
        getUserInput.getUserInput();

        ReadFromFile readFromFile = new ReadFromFile();
        String cityNamesAndCountryCodes[] = readFromFile.readFromFile("input.txt").split(";");

        for (String cityNamesAndCountryCode : cityNamesAndCountryCodes) {
            if (cityNamesAndCountryCode.contains(",")) {
                String cityNameAndCountryCode[] = cityNamesAndCountryCode.split(",");
                ThreeDayWeatherForecast threeDayForecastDataFromApi =
                        new ThreeDayWeatherForecast(cityNameAndCountryCode[0], cityNameAndCountryCode[1],
                                "metric", "forecast");

                JSONObject forecastDataFomApi = threeDayForecastDataFromApi.getDataFromApi();

                ArrayList<Double> minMaxTempList = threeDayWeatherForecastProcessor.getMinMaxTemperatureList(forecastDataFomApi);
                double longitude = threeDayWeatherForecastProcessor.getLocationLongitude(forecastDataFomApi);
                double latitude = threeDayWeatherForecastProcessor.getLocationLatitude(forecastDataFomApi);

                writeToOutput(writeToFile, cityNameAndCountryCode, minMaxTempList, longitude, latitude);
            }
        }
    }

    private void writeToOutput(WriteToFile writeToFile, String[] cityNameAndCountryCode, ArrayList<Double> minMaxTempList, double longitude, double latitude) {
        String lineToBeWritten = "City: " + cityNameAndCountryCode[0] + ".\n"
                + "Country: " + cityNameAndCountryCode[1] + ".\n\n"
                + "Day one minimum temperature: " + minMaxTempList.get(0) + ".\n"
                + "Day one maximum temperature: " + minMaxTempList.get(1) + ".\n\n"
                + "Day two minimum temperature: " + minMaxTempList.get(2) + ".\n"
                + "Day two maximum temperature: " + minMaxTempList.get(3) + ".\n\n"
                + "Day three minimum temperature: " + minMaxTempList.get(4) + ".\n"
                + "Day three maximum temperature: " + minMaxTempList.get(5) + ".\n\n"
                + "Coordinates: " + latitude + ":" + longitude + ".";

        String folderPath = "C:\\Users\\rasmu\\IdeaProjects\\JavaStuff\\Autotest\\src\\main\\cityoutputs\\";
        writeToFile.writeToFile(lineToBeWritten, folderPath + cityNameAndCountryCode[0] + ".txt", false);
    }
}
