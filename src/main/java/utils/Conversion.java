package utils;

import java.lang.reflect.Field;
import java.util.HashMap;


public class Conversion {


    public static HashMap<String, String> getHashMap(Object object) {

        HashMap<String, String> values = new HashMap<>();

        try {
            Field[] fieldsNames = object.getClass().getDeclaredFields();

            for (Field fieldsName : fieldsNames) {
                String fieldName = fieldsName.getName();

                fieldsName.setAccessible(true);

                String fieldValue = (String) fieldsName.get(object);
                values.put(fieldName, fieldValue);
            }
        } catch (IllegalAccessException iaex) {
            iaex.printStackTrace();
        }

        return values;
    }
}