package getdata;

public class ThreeDayWeatherForecast extends CurrentWeatherForecast{

    public ThreeDayWeatherForecast(String cityName, String countryCode, String units, String type) {
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.units = units;
        this.type = type;
    }
}
