import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class WeatherApiResponse {

    public static void main(String[] args) throws Exception {
        ArrayList<Double> temperatureList;
        ArrayList<Double> minTemperatureList;
        ArrayList<Double> maxTemperatureList;
        ArrayList<Double> minMaxTempList;

        String apiData = "";

        URL apiUrl = new URL("http://api.openweathermap.org/data/2.5/forecast?id=588409&APPID=d02d0a3c1e7b1840370a11699a3682c9");
        URLConnection connection = apiUrl.openConnection();

        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line;
        while ((line = br.readLine()) != null) {
            apiData += line;
        }
        br.close();

        JSONObject dataFromApi = new JSONObject(apiData);

        temperatureList = getTemperatureList(dataFromApi);
        minTemperatureList = getMinTemperatureList(dataFromApi);
        maxTemperatureList = getMaxTemperatureList(dataFromApi);
        minMaxTempList = getMinMaxTemperatureList(minTemperatureList, maxTemperatureList);

    }

    private static ArrayList<Double> getMinMaxTemperatureList(ArrayList<Double> minTemperatureList, ArrayList<Double> maxTemperatureList) {
        ArrayList<Double> minMaxTempList = new ArrayList<Double>();
        minMaxTempList.add(getMinimumTemperatureForDayOne(minTemperatureList));
        minMaxTempList.add(getMaximumTemperatureForDayOne(maxTemperatureList));

        minMaxTempList.add(getMinimumTemperatureForDayTwo(minTemperatureList));
        minMaxTempList.add(getMaximumTemperatureForDayTwo(maxTemperatureList));

        minMaxTempList.add(getMinimumTemperatureForDayThree(minTemperatureList));
        minMaxTempList.add(getMaximumTemperatureForDayThree(maxTemperatureList));
        System.out.println(minMaxTempList);
        return minMaxTempList;

    }

    private static ArrayList<Double> getMaxTemperatureList(JSONObject dataFromApi) {
        ArrayList<Double> maxTemperatureList = new ArrayList<Double>();
        for (int apiTimeStamp = 0; apiTimeStamp < 40; apiTimeStamp++) {
            maxTemperatureList.add(dataFromApi.getJSONArray("list").
                    getJSONObject(apiTimeStamp).getJSONObject("main").getDouble("temp_max"));
        }
        return maxTemperatureList;
    }

    private static ArrayList<Double> getMinTemperatureList(JSONObject dataFromApi) {
        ArrayList<Double> minTemperatureList = new ArrayList<Double>();
        for (int apiTimeStamp = 0; apiTimeStamp < 40; apiTimeStamp++) {
            minTemperatureList.add(dataFromApi.getJSONArray("list").
                    getJSONObject(apiTimeStamp).getJSONObject("main").getDouble("temp_min"));
        }
        return minTemperatureList;
    }

    private static ArrayList<Double> getTemperatureList(JSONObject dataFromApi) {
        ArrayList<Double> temperatureList = new ArrayList<Double>();
        for (int apiTimeStamp = 0; apiTimeStamp < 40; apiTimeStamp++) {
            temperatureList.add(dataFromApi.getJSONArray("list").
                    getJSONObject(apiTimeStamp).getJSONObject("main").getDouble("temp"));
        }
        return temperatureList;
    }

    private static double getMaximumTemperatureForDayOne(ArrayList<Double> maxTemperatureList) {
        double maximumTemperatureForDayOne = maxTemperatureList.get(0);
        for(int firstDaysWorthOfApiTimeStamps = 0; firstDaysWorthOfApiTimeStamps < 8; firstDaysWorthOfApiTimeStamps++) {
            if (maxTemperatureList.get(firstDaysWorthOfApiTimeStamps) > maximumTemperatureForDayOne) {
                maximumTemperatureForDayOne = maxTemperatureList.get(firstDaysWorthOfApiTimeStamps);
            }
        }
        return maximumTemperatureForDayOne;
    }

    private static double getMaximumTemperatureForDayThree(ArrayList<Double> maxTemperatureList) {
        double maximumTemperatureForDayThree = maxTemperatureList.get(0);
        for(int firstDaysWorthOfApiTimeStamps = 17; firstDaysWorthOfApiTimeStamps < 26; firstDaysWorthOfApiTimeStamps++) {
            if (maxTemperatureList.get(firstDaysWorthOfApiTimeStamps) > maximumTemperatureForDayThree) {
                maximumTemperatureForDayThree = maxTemperatureList.get(firstDaysWorthOfApiTimeStamps);
            }
        }
        return maximumTemperatureForDayThree;
    }

    private static double getMaximumTemperatureForDayTwo(ArrayList<Double> maxTemperatureList) {
        double maximumTemperatureForDayTwo = maxTemperatureList.get(0);
        for(int firstDaysWorthOfApiTimeStamps = 9; firstDaysWorthOfApiTimeStamps < 17; firstDaysWorthOfApiTimeStamps++) {
            if (maxTemperatureList.get(firstDaysWorthOfApiTimeStamps) > maximumTemperatureForDayTwo) {
                maximumTemperatureForDayTwo = maxTemperatureList.get(firstDaysWorthOfApiTimeStamps);
            }
        }
        return maximumTemperatureForDayTwo;
    }

    private static double getMinimumTemperatureForDayOne(ArrayList<Double> minTemperatureList) {
        double minimumTemperatureForDayOne = minTemperatureList.get(0);
        for(int firstDaysWorthOfApiTimeStamps = 0; firstDaysWorthOfApiTimeStamps < 8; firstDaysWorthOfApiTimeStamps++) {
            if (minTemperatureList.get(firstDaysWorthOfApiTimeStamps) < minimumTemperatureForDayOne) {
                minimumTemperatureForDayOne = minTemperatureList.get(firstDaysWorthOfApiTimeStamps);
            }
        }
        return minimumTemperatureForDayOne;
    }

    private static double getMinimumTemperatureForDayTwo(ArrayList<Double> minTemperatureList) {
        double minimumTemperatureForDayTwo = minTemperatureList.get(9);
        for(int firstDaysWorthOfApiTimeStamps = 9; firstDaysWorthOfApiTimeStamps < 17; firstDaysWorthOfApiTimeStamps++) {
            if (minTemperatureList.get(firstDaysWorthOfApiTimeStamps) < minimumTemperatureForDayTwo) {
                minimumTemperatureForDayTwo = minTemperatureList.get(firstDaysWorthOfApiTimeStamps);
            }
        }
        return minimumTemperatureForDayTwo;
    }

    private static double getMinimumTemperatureForDayThree(ArrayList<Double> minTemperatureList) {
        double minimumTemperatureForDayThree = minTemperatureList.get(17);
        for(int firstDaysWorthOfApiTimeStamps = 17; firstDaysWorthOfApiTimeStamps < 26; firstDaysWorthOfApiTimeStamps++) {
            if (minTemperatureList.get(firstDaysWorthOfApiTimeStamps) < minimumTemperatureForDayThree) {
                minimumTemperatureForDayThree = minTemperatureList.get(firstDaysWorthOfApiTimeStamps);
            }
        }
        return minimumTemperatureForDayThree;
    }
}
