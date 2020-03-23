package constants;


public enum Type {

    CITY        ("city"),
    LAT_LON     ("LatLon"),
    IP          ("IP"),
    ZIP_CODE    ("Zipcode"),
    ;
    public String value;


    Type(String value) {
        this.value = value;
    }
}