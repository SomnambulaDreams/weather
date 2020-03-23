package entity.current;

import com.google.gson.annotations.SerializedName;


public class Location {

    @SerializedName("type")
    private String type;

    @SerializedName("name")
    private String name;

    @SerializedName("country")
    private String country;

    @SerializedName("region")
    private String region;

    @SerializedName("lat")
    private double lat;

    @SerializedName("lon")
    private double lon;

    @SerializedName("timezone_id")
    private String timezone_id;

    @SerializedName("localtime")
    private String localtime;

    @SerializedName("localtime_epoch")
    private int localtime_epoch;

    @SerializedName("utc_offset")
    private String utc_offset;


    public Location() {
    }

    public Location(String type, String name, String country, String region, double lat, double lon, String timezone_id, String localtime, int localtime_epoch, String utc_offset) {
        this.type = type;
        this.name = name;
        this.country = country;
        this.region = region;
        this.lat = lat;
        this.lon = lon;
        this.timezone_id = timezone_id;
        this.localtime = localtime;
        this.localtime_epoch = localtime_epoch;
        this.utc_offset = utc_offset;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getTimezone_id() {
        return timezone_id;
    }

    public void setTimezone_id(String timezone_id) {
        this.timezone_id = timezone_id;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public int getLocaltime_epoch() {
        return localtime_epoch;
    }

    public void setLocaltime_epoch(int localtime_epoch) {
        this.localtime_epoch = localtime_epoch;
    }

    public String getUtc_offset() {
        return utc_offset;
    }

    public void setUtc_offset(String utc_offset) {
        this.utc_offset = utc_offset;
    }
}
