package constants.current;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public enum Callback {

    NULL                        (null,                      "null",                     true),
    EMPTY                       ("",                        "empty value",              false),
    SPACE                       (" ",                       "space",                    false),
    CORRECT_VALUE               ("FUNCTION_NAME",           "correct value",            true),
    CORRECT_VALUE_WITH_SPACES   ("  FUNCTION_NAME  ",       "spaces before and after",  false), // check for trim function
    INCORRECT_VALUE_WITH_SPACES ("  FUNCTION NAME  ",       "spaces inside value",      false),
    ;
    public String value;
    public String description;
    public boolean isCorrect;


    Callback(String value, String description, boolean isCorrect) {
        this.value = value;
        this.description = description;
        this.isCorrect = isCorrect;
    }


    public static Object[] getAllValues() {
        List<Callback> result = new LinkedList<>();
        Collections.addAll(result, Callback.values());
        return result.toArray();
    }


    public static Object[] getCorrectValues() {
        List<Callback> result = new LinkedList<>();
        for(Callback item : Callback.values()) {
            if(item.isCorrect)
                result.add(item);
        }
        return result.toArray();
    }


    public static Object[] getIncorrectValues() {
        List<Callback> result = new LinkedList<>();
        for(Callback item : Callback.values()) {
            if(!item.isCorrect)
                result.add(item);
        }
        return result.toArray();
    }
}
