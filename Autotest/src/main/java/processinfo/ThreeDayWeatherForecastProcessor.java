package processinfo;

import org.json.JSONObject;
import java.util.ArrayList;

public class ThreeDayWeatherForecastProcessor {


    public ArrayList<Double> getMinMaxTemperatureList(JSONObject dataFromApi) {

        ArrayList<Double> minMaxTempList = new ArrayList<Double>();
        minMaxTempList.add(getMinimumTemperatureForDayOne(dataFromApi));
        minMaxTempList.add(getMaximumTemperatureForDayOne(dataFromApi));

        minMaxTempList.add(getMinimumTemperatureForDayTwo(dataFromApi));
        minMaxTempList.add(getMaximumTemperatureForDayTwo(dataFromApi));

        minMaxTempList.add(getMinimumTemperatureForDayThree(dataFromApi));
        minMaxTempList.add(getMaximumTemperatureForDayThree(dataFromApi));
        return minMaxTempList;

    }

    private ArrayList<Double> getMaxTemperatureList(JSONObject dataFromApi) {
        ArrayList<Double> maxTemperatureList = new ArrayList<Double>();
        for (int threeHourTicks = 0; threeHourTicks < getJSONArrayLength(dataFromApi); threeHourTicks++) {
            maxTemperatureList.add(dataFromApi.getJSONArray("list").
                    getJSONObject(threeHourTicks).getJSONObject("main").getDouble("temp_max"));
        }
        return maxTemperatureList;
    }

    private ArrayList<Double> getMinTemperatureList(JSONObject dataFromApi) {
        ArrayList<Double> minTemperatureList = new ArrayList<Double>();
        for (int threeHourTicks = 0; threeHourTicks < getJSONArrayLength(dataFromApi); threeHourTicks++) {
            minTemperatureList.add(dataFromApi.getJSONArray("list").
                    getJSONObject(threeHourTicks).getJSONObject("main").getDouble("temp_min"));
        }
        return minTemperatureList;
    }

    private double getMaximumTemperatureForDayOne(JSONObject dataFromApi) {
        ArrayList<Double> maxTemperatureList = getMaxTemperatureList(dataFromApi);
        double maximumTemperatureForDayOne = maxTemperatureList.get(0);
        for(int firstDaysWorthOfApiTimeStamps = 0; firstDaysWorthOfApiTimeStamps < 8; firstDaysWorthOfApiTimeStamps++) {
            if (maxTemperatureList.get(firstDaysWorthOfApiTimeStamps) > maximumTemperatureForDayOne) {
                maximumTemperatureForDayOne = maxTemperatureList.get(firstDaysWorthOfApiTimeStamps);
            }
        }
        return maximumTemperatureForDayOne;
    }

    private double getMaximumTemperatureForDayTwo(JSONObject dataFromApi) {
        ArrayList<Double> maxTemperatureList = getMaxTemperatureList(dataFromApi);
        double maximumTemperatureForDayTwo = maxTemperatureList.get(8);
        for(int firstDaysWorthOfApiTimeStamps = 8; firstDaysWorthOfApiTimeStamps < 16; firstDaysWorthOfApiTimeStamps++) {
            if (maxTemperatureList.get(firstDaysWorthOfApiTimeStamps) > maximumTemperatureForDayTwo) {
                maximumTemperatureForDayTwo = maxTemperatureList.get(firstDaysWorthOfApiTimeStamps);
            }
        }
        return maximumTemperatureForDayTwo;
    }

    private double getMaximumTemperatureForDayThree(JSONObject dataFromApi) {
        ArrayList<Double> maxTemperatureList = getMaxTemperatureList(dataFromApi);
        double maximumTemperatureForDayThree = maxTemperatureList.get(16);
        for(int firstDaysWorthOfApiTimeStamps = 16; firstDaysWorthOfApiTimeStamps < 25; firstDaysWorthOfApiTimeStamps++) {
            if (maxTemperatureList.get(firstDaysWorthOfApiTimeStamps) > maximumTemperatureForDayThree) {
                maximumTemperatureForDayThree = maxTemperatureList.get(firstDaysWorthOfApiTimeStamps);
            }
        }
        return maximumTemperatureForDayThree;
    }


    private double getMinimumTemperatureForDayOne(JSONObject dataFromApi) {
        ArrayList<Double> minTemperatureList = getMinTemperatureList(dataFromApi);
        double minimumTemperatureForDayOne = minTemperatureList.get(0);

        for(int firstDaysWorthOfApiTimeStamps = 0; firstDaysWorthOfApiTimeStamps < 8; firstDaysWorthOfApiTimeStamps++) {
            if (minTemperatureList.get(firstDaysWorthOfApiTimeStamps) < minimumTemperatureForDayOne) {
                minimumTemperatureForDayOne = minTemperatureList.get(firstDaysWorthOfApiTimeStamps);
            }
        }
        return minimumTemperatureForDayOne;
    }

    private double getMinimumTemperatureForDayTwo(JSONObject dataFromApi) {
        ArrayList<Double> minTemperatureList = getMinTemperatureList(dataFromApi);
        double minimumTemperatureForDayTwo = minTemperatureList.get(8);

        for(int firstDaysWorthOfApiTimeStamps = 8; firstDaysWorthOfApiTimeStamps < 16; firstDaysWorthOfApiTimeStamps++) {
            if (minTemperatureList.get(firstDaysWorthOfApiTimeStamps) < minimumTemperatureForDayTwo) {
                minimumTemperatureForDayTwo = minTemperatureList.get(firstDaysWorthOfApiTimeStamps);
            }
        }
        return minimumTemperatureForDayTwo;
    }

    private double getMinimumTemperatureForDayThree(JSONObject dataFromApi) {
        ArrayList<Double> minTemperatureList = getMinTemperatureList(dataFromApi);
        double minimumTemperatureForDayThree = minTemperatureList.get(16);

        for(int firstDaysWorthOfApiTimeStamps = 16; firstDaysWorthOfApiTimeStamps < 25; firstDaysWorthOfApiTimeStamps++) {
            if (minTemperatureList.get(firstDaysWorthOfApiTimeStamps) < minimumTemperatureForDayThree) {
                minimumTemperatureForDayThree = minTemperatureList.get(firstDaysWorthOfApiTimeStamps);
            }
        }
        return minimumTemperatureForDayThree;
    }

    public double getLocationLatitude(JSONObject dataFromApi) {
        return dataFromApi.getJSONObject("city").getJSONObject("coord").getDouble("lat");
    }

    public double getLocationLongitude(JSONObject dataFromApi) {
        return dataFromApi.getJSONObject("city").getJSONObject("coord").getDouble("lon");
    }

    public int getJSONArrayLength(JSONObject dataFromApi) {
        return dataFromApi.getJSONArray("list").length();
    }
}
