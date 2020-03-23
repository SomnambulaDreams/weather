package constants.current;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public enum Query {

    EMPTY                       ("",                        "empty value",                  false),
    SPACE                       (" ",                       "space",                        false),
    UNKNOWN_VALUE               ("aaaaaa",                  "unknown value",                false),
    UPPER_CASE_VALUE            ("NEW YORK",                "New York, United States of America, USA upper case value",true), // check for value conversion
    CORRECT_VALUE_WITH_SPACES   ("  Moscow  ",              "Russia, value spaces",                 true),
    CITY_CORRECT_VALUE          ("Mykolayiv",               "Ukraine, correct value",       true),
    IP_CORRECT_VALUE            ("5.205.255.255",           "Madrid Spain ip address",      true),
    ZIP_CODE_CORRECT_VALUE      ("30301",                   "Atlanta United States of America, USA zip code",true),
    LAT_LON_CORRECT_VALUE       ("-37.72 144.98",           "Reservoir Australia lat/lon",  true),
    ;
    public String value;
    public String description;
    public boolean isCorrect;


    Query(String value, String description, boolean isCorrect) {
        this.value = value;
        this.description = description;
        this.isCorrect = isCorrect;
    }


    public static Object[] getAllValues() {
        List<Query> result = new LinkedList<>();
        Collections.addAll(result, Query.values());
        return result.toArray();
    }


    public static Object[] getCorrectValues() {
        List<Query> result = new LinkedList<>();
        for(Query item : Query.values()) {
            if(item.isCorrect)
                result.add(item);
        }
        return result.toArray();
    }


    public static Object[] getIncorrectValues() {
        List<Query> result = new LinkedList<>();
        for(Query item : Query.values()) {
            if(!item.isCorrect)
                result.add(item);
        }
        return result.toArray();
    }
}