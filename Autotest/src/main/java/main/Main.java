package main;

import getdata.GetDataFromApi;
import org.json.JSONObject;
import processinfo.CurrentWeatherForecast;
import processinfo.ThreeDayWeatherForecast;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws MalformedURLException {
        
        GetDataFromApi getForecastDataFromApi = new GetDataFromApi("Tallinn", "EE", "metric", "forecast");
        GetDataFromApi getCurrentDataFromApi = new GetDataFromApi("Tallinn", "EE", "metric", "weather");

        JSONObject forecast = getForecastDataFromApi.getDataFromApi();
        JSONObject current = getCurrentDataFromApi.getDataFromApi();

        ArrayList<Double> minMaxTempList = ThreeDayWeatherForecast.getMinMaxTemperatureList(forecast);
        System.out.println(minMaxTempList);
        System.out.println(CurrentWeatherForecast.getCurrentTemperature(current));
    }
}
