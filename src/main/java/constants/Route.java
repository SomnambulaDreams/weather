package constants;

public enum Route {
    CURRENT     ("current"),
    HISTORICAL  ("historical"),
    FORECAST    ("forecast"),
    ;
    public final String value;

    Route(String value) {
        this.value = value;
    }
}