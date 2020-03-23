package entity.current;


import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("type")
    private String type;

    @SerializedName("query")
    private String query;

    @SerializedName("language")
    private String language;

    @SerializedName("unit")
    private String unit;


    public Request() {

    }


    public Request(String type, String query, String language, String unit) {
        this.type = type;
        this.query = query;
        this.language = language;
        this.unit = unit;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}