package constants;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public enum Unit {

    // link to API documentation: https://weatherstack.com/documentation#units_parameter

    METRIC              ("m",       "temp - cesius, wind speed - km/h, pressure - millibar, precip - millimeters, total snow - centimeters",  true),
    SCIENTIFIC          ("s",       "temp - kelvin, wind speed - km/h, pressure - millibar, precip - millimeters, total snow - centimeters",  true),
    FAHRENHEIT          ("f",       "temp - fahrenheit, wind speed - miles/h, pressure - millibar, precip - inches, total snow - inches",     true),
    EMPTY               ("",        "empty value",          true),
    SPACE               (" ",       "space value",          false),
    UNKNOWN_VALUE       ("a",       "unknown value",        false),
    UPPERCASE_VALUE     ("M",       "uppercase value",      true),
    VALUE_WITH_SPACES   ("  m  ",   "value with spaces",    false),
    ;
    public String value;
    public String description;
    public boolean isCorrect;


    Unit(String value, String description, boolean isCorrect) {
        this.value = value;
        this.description = description;
        this.isCorrect = isCorrect;
    }


    public static Object[] getAllValues() {
        List<Unit> result = new LinkedList<>();
        Collections.addAll(result, Unit.values());
        return result.toArray();
    }


    public static Object[] getCorrectValues() {
        List<Unit> result = new LinkedList<>();
        for(Unit item : Unit.values()) {
            if(item.isCorrect)
                result.add(item);
        }
        return result.toArray();
    }


    public static Object[] getIncorrectValues() {
        List<Unit> result = new LinkedList<>();
        for(Unit item : Unit.values()) {
            if(!item.isCorrect)
                result.add(item);
        }
        return result.toArray();
    }
}