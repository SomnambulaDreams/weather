package entity.current;

import com.google.gson.annotations.SerializedName;
import entity.WeatherRequestObject;


public class CurrentRequest extends WeatherRequestObject {

    @SerializedName("query")
    private String query;

    @SerializedName("units")
    private String units;

    @SerializedName("language")
    private String language;

    @SerializedName("callback")
    private String callback;


    public CurrentRequest() {}


    public CurrentRequest(String query, String units, String language, String callback) {
        this.query = query;
        this.units = units;
        this.language = language;
        this.callback = callback;
    }


    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    @Override
    public String toString() {
        return  "query    = " + this.getQuery() + "\n" +
                "units    = " + this.getUnits() + "\n" +
                "language = " + this.getLanguage() + "\n" +
                "callback = " + this.getCallback();
    }
}