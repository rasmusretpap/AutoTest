package processinfo;

import org.json.JSONObject;
import java.util.ArrayList;

public class ThreeDayWeatherForecast {


    public static ArrayList<Double> getMinMaxTemperatureList(JSONObject dataFromApi) {

        ArrayList<Double> minMaxTempList = new ArrayList<Double>();
        minMaxTempList.add(getMinimumTemperatureForDayOne(dataFromApi));
        minMaxTempList.add(getMaximumTemperatureForDayOne(dataFromApi));

        minMaxTempList.add(getMinimumTemperatureForDayTwo(dataFromApi));
        minMaxTempList.add(getMaximumTemperatureForDayTwo(dataFromApi));

        minMaxTempList.add(getMinimumTemperatureForDayThree(dataFromApi));
        minMaxTempList.add(getMaximumTemperatureForDayThree(dataFromApi));
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

    private static ArrayList<Double> getCurrentTemperatureList(JSONObject dataFromApi) {
        ArrayList<Double> temperatureList = new ArrayList<Double>();
        for (int apiTimeStamp = 0; apiTimeStamp < 40; apiTimeStamp++) {
            temperatureList.add(dataFromApi.getJSONArray("list").
                    getJSONObject(apiTimeStamp).getJSONObject("main").getDouble("temp"));
        }
        return temperatureList;
    }

    private static double getMaximumTemperatureForDayOne(JSONObject dataFromApi) {
        ArrayList<Double> maxTemperatureList = getMaxTemperatureList(dataFromApi);
        double maximumTemperatureForDayOne = maxTemperatureList.get(0);
        for(int firstDaysWorthOfApiTimeStamps = 0; firstDaysWorthOfApiTimeStamps < 8; firstDaysWorthOfApiTimeStamps++) {
            if (maxTemperatureList.get(firstDaysWorthOfApiTimeStamps) > maximumTemperatureForDayOne) {
                maximumTemperatureForDayOne = maxTemperatureList.get(firstDaysWorthOfApiTimeStamps);
            }
        }
        return maximumTemperatureForDayOne;
    }

    private static double getMaximumTemperatureForDayThree(JSONObject dataFromApi) {
        ArrayList<Double> maxTemperatureList = getMaxTemperatureList(dataFromApi);
        double maximumTemperatureForDayThree = maxTemperatureList.get(0);
        for(int firstDaysWorthOfApiTimeStamps = 17; firstDaysWorthOfApiTimeStamps < 26; firstDaysWorthOfApiTimeStamps++) {
            if (maxTemperatureList.get(firstDaysWorthOfApiTimeStamps) > maximumTemperatureForDayThree) {
                maximumTemperatureForDayThree = maxTemperatureList.get(firstDaysWorthOfApiTimeStamps);
            }
        }
        return maximumTemperatureForDayThree;
    }

    private static double getMaximumTemperatureForDayTwo(JSONObject dataFromApi) {
        ArrayList<Double> maxTemperatureList = getMaxTemperatureList(dataFromApi);
        double maximumTemperatureForDayTwo = maxTemperatureList.get(0);
        for(int firstDaysWorthOfApiTimeStamps = 9; firstDaysWorthOfApiTimeStamps < 17; firstDaysWorthOfApiTimeStamps++) {
            if (maxTemperatureList.get(firstDaysWorthOfApiTimeStamps) > maximumTemperatureForDayTwo) {
                maximumTemperatureForDayTwo = maxTemperatureList.get(firstDaysWorthOfApiTimeStamps);
            }
        }
        return maximumTemperatureForDayTwo;
    }

    private static double getMinimumTemperatureForDayOne(JSONObject dataFromApi) {
        ArrayList<Double> minTemperatureList = getMinTemperatureList(dataFromApi);
        double minimumTemperatureForDayOne = minTemperatureList.get(0);

        for(int firstDaysWorthOfApiTimeStamps = 0; firstDaysWorthOfApiTimeStamps < 8; firstDaysWorthOfApiTimeStamps++) {
            if (minTemperatureList.get(firstDaysWorthOfApiTimeStamps) < minimumTemperatureForDayOne) {
                minimumTemperatureForDayOne = minTemperatureList.get(firstDaysWorthOfApiTimeStamps);
            }
        }
        return minimumTemperatureForDayOne;
    }

    private static double getMinimumTemperatureForDayTwo(JSONObject dataFromApi) {
        ArrayList<Double> minTemperatureList = getMinTemperatureList(dataFromApi);
        double minimumTemperatureForDayTwo = minTemperatureList.get(9);

        for(int firstDaysWorthOfApiTimeStamps = 9; firstDaysWorthOfApiTimeStamps < 17; firstDaysWorthOfApiTimeStamps++) {
            if (minTemperatureList.get(firstDaysWorthOfApiTimeStamps) < minimumTemperatureForDayTwo) {
                minimumTemperatureForDayTwo = minTemperatureList.get(firstDaysWorthOfApiTimeStamps);
            }
        }
        return minimumTemperatureForDayTwo;
    }

    private static double getMinimumTemperatureForDayThree(JSONObject dataFromApi) {
        ArrayList<Double> minTemperatureList = getMinTemperatureList(dataFromApi);
        double minimumTemperatureForDayThree = minTemperatureList.get(17);

        for(int firstDaysWorthOfApiTimeStamps = 17; firstDaysWorthOfApiTimeStamps < 26; firstDaysWorthOfApiTimeStamps++) {
            if (minTemperatureList.get(firstDaysWorthOfApiTimeStamps) < minimumTemperatureForDayThree) {
                minimumTemperatureForDayThree = minTemperatureList.get(firstDaysWorthOfApiTimeStamps);
            }
        }
        return minimumTemperatureForDayThree;
    }
}
