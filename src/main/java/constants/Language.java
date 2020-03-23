package constants;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public enum Language {

    // https://weatherstack.com/documentation#language_parameter

    NULL                        (null,      "null value",          true, true),
    ARABIC	                    ("ar",      "Arabic",	            true, false),
    BENGALI	                    ("bn",      "Bengali",	            true, false),
    BULGARIAN	                ("bg",      "Bulgarian",	        true, false),
    CHINESE_SIMPLIFIED	        ("zh",      "Chinese Simplified",	true, false),
    CHINESE_TRADITIONAL	        ("zh_tw",   "Chinese Traditional",	true, false),
    CZECH	                    ("cs",      "Czech",	            true, false),
    DANISH	                    ("da",      "Danish",	            true, false),
    DUTCH	                    ("nl",      "Dutch",	            true, false),
    FINNISH	                    ("fi",      "Finnish",	            true, false),
    FRENCH	                    ("fr",      "French",	            true, false),
    GERMAN	                    ("de",      "German",	            true, false),
    GREEK	                    ("el",      "Greek",	            true, false),
    HINDI	                    ("hi",      "Hindi",	            true, false),
    HUNGARIAN	                ("hu",      "Hungarian",	        true, false),
    ITALIAN	                    ("it",      "Italian",	            true, false),
    JAPANESE	                ("ja",      "Japanese",	        true, false),
    JAVANESE	                ("jv",      "Javanese",	        true, false),
    KOREAN	                    ("ko",      "Korean",	            true, false),
    MANDARIN	                ("zh_cmn",  "Mandarin",	        true, false),
    MARATHI	                    ("mr",      "Marathi",	            true, false),
    POLISH	                    ("pl",      "Polish",	            true, false),
    PORTUGUESE	                ("pt",      "Portuguese",	        true, false),
    PUNJABI	                    ("pa",      "Punjabi",	            true, false),
    ROMANIAN	                ("ro",      "Romanian",	        true, false),
    RUSSIAN	                    ("ru",      "Russian",	            true, false),
    SERBIAN	                    ("sr",      "Serbian",	            true, false),
    SINHALESE	                ("si",      "Sinhalese",	        true, false),
    SLOVAK	                    ("sk",      "Slovak",	            true, false),
    SPANISH	                    ("es",      "Spanish",	            true, false),
    SWEDISH	                    ("sv",      "Swedish",	            true, false),
    TAMIL	                    ("ta",      "Tamil",	            true, false),
    TELUGU	                    ("te",      "Telugu",	            true, false),
    TURKISH	                    ("tr",      "Turkish",	            true, false),
    UKRAINIAN	                ("uk",      "Ukrainian",	        true, false),
    URDU	                    ("ur",      "Urdu",	            true, false),
    VIETNAMESE	                ("vi",      "Vietnamese",	        true, false),
    WU	                        ("zh_wuu",  "Wu (Shanghainese)",	true, false),
    XIANG	                    ("zh_hsn",  "Xiang",	            true, false),
    YUE 	                    ("zh_yue",  "Yue (Cantonese)",	    true, false),
    ZULU	                    ("zu",      "Zulu",	            true, false),
    EMPTY                       ("",        "empty value",         false, false),
    SPACE                       (" ",       "space",               false, false),
    UNKNOWN_VALUE               ("aaaaaa",  "unknown value",       false, false),
    UPPER_CASE_VALUE            ("AR",      "upper case value",    true, false), // check for value conversion
    CORRECT_VALUE_WITH_SPACES   ("  ar  ",  "value spaces",        true, false), // check for trim function
    ;
    public String value;
    public String description;
    public boolean isCorrect;
    public boolean isAvailable;


    Language(String value, String description, boolean isCorrect, boolean isAvailable) {
        this.value = value;
        this.description = description;
        this.isCorrect = isCorrect;
        this.isAvailable = isAvailable;
    }


    public static Object[] getAllValues() {
        List<Language> result = new LinkedList<>();
        Collections.addAll(result, Language.values());
        return result.toArray();
    }


    public static Object[] getCorrectValues() {
        List<Language> result = new LinkedList<>();
        for(Language item : Language.values()) {
            if(item.isCorrect)
                result.add(item);
        }
        return result.toArray();
    }


    public static Object[] getIncorrectValues() {
        List<Language> result = new LinkedList<>();
        for(Language item : Language.values()) {
            if(!item.isCorrect)
                result.add(item);
        }
        return result.toArray();
    }

    public static Object[] getCorrectUnavailableValues() {
        List<Language> result = new LinkedList<>();
        for(Language item : Language.values()) {
            if(item.isCorrect && !item.isAvailable)
                result.add(item);
        }
        return result.toArray();
    }
}