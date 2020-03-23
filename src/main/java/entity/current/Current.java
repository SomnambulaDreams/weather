package entity.current;

import com.google.gson.annotations.SerializedName;


public class Current {

    @SerializedName("observation_time")
    private String observation_time;

    @SerializedName("temperature")
    private double temperature;

    @SerializedName("weather_code")
    private int weather_code;

    @SerializedName("weather_icons")
    private String[] weather_icons;

    @SerializedName("weather_descriptions")
    private String[] weather_descriptions;

    @SerializedName("wind_speed")
    private double wind_speed;

    @SerializedName("wind_degree")
    private double wind_degree;

    @SerializedName("wind_dir")
    private String wind_dir;

    @SerializedName("pressure")
    private int pressure;

    @SerializedName("precip")
    private double precip;

    @SerializedName("humidity")
    private double humidity;

    @SerializedName("cloudcover")
    private double cloudcover;

    @SerializedName("feelslike")
    private double feelslike;

    @SerializedName("uv_index")
    private int uv_index;

    @SerializedName("visibility")
    private int visibility;

    @SerializedName("is_day")
    private String is_day;


    public Current() {
    }


    public Current(String observation_time, double temperature, int weather_code, String[] weather_icons, String[] weather_descriptions, double wind_speed, double wind_degree, String wind_dir, int pressure, double precip, double humidity, double cloudcover, double feelslike, int uv_index, int visibility, String is_day) {
        this.observation_time = observation_time;
        this.temperature = temperature;
        this.weather_code = weather_code;
        this.weather_icons = weather_icons;
        this.weather_descriptions = weather_descriptions;
        this.wind_speed = wind_speed;
        this.wind_degree = wind_degree;
        this.wind_dir = wind_dir;
        this.pressure = pressure;
        this.precip = precip;
        this.humidity = humidity;
        this.cloudcover = cloudcover;
        this.feelslike = feelslike;
        this.uv_index = uv_index;
        this.visibility = visibility;
        this.is_day = is_day;
    }


    public String getObservation_time() {
        return observation_time;
    }

    public void setObservation_time(String observation_time) {
        this.observation_time = observation_time;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getWeather_code() {
        return weather_code;
    }

    public void setWeather_code(int weather_code) {
        this.weather_code = weather_code;
    }

    public String[] getWeather_icons() {
        return weather_icons;
    }

    public void setWeather_icons(String[] weather_icons) {
        this.weather_icons = weather_icons;
    }

    public String[] getWeather_descriptions() {
        return weather_descriptions;
    }

    public void setWeather_descriptions(String[] weather_descriptions) {
        this.weather_descriptions = weather_descriptions;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public double getWind_degree() {
        return wind_degree;
    }

    public void setWind_degree(double wind_degree) {
        this.wind_degree = wind_degree;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public double getPrecip() {
        return precip;
    }

    public void setPrecip(double precip) {
        this.precip = precip;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(double cloudcover) {
        this.cloudcover = cloudcover;
    }

    public double getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(double feelslike) {
        this.feelslike = feelslike;
    }

    public int getUv_index() {
        return uv_index;
    }

    public void setUv_index(int uv_index) {
        this.uv_index = uv_index;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public String getIs_day() {
        return is_day;
    }

    public void setIs_day(String is_day) {
        this.is_day = is_day;
    }
}