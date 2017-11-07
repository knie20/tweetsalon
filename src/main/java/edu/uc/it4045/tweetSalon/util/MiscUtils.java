package edu.uc.it4045.tweetSalon.util;

import java.util.*;

/**
 * Helper class for miscellaneous algorithms and services
 */
public class MiscUtils {

    public static final String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Und"};

    /**
     * turn the datetime format supplied by the Twitter API into a java.util.Calendar object
     * @param s the string, usually in "day_of_week month day_of_month hour:minute:second offset_from_GMT year"
     *          example: "Sat Dec 14 04:35:55 +0000 2013"
     * @return a Calendar object
     */
    public static Calendar parseCalendarFromString(String s){
        return new GregorianCalendar(
                Integer.parseInt(s.substring(26)),
                Arrays.asList(months).indexOf(s.substring(4, 7)),
                Integer.parseInt(s.substring(8, 10)),
                Integer.parseInt(s.substring(11, 13)),
                Integer.parseInt(s.substring(14, 16)),
                Integer.parseInt(s.substring(17, 19))
        );
    }

    /**
     * concatenate an array of strings with a comma in between each string,
     * used for storing tweet entities such as hashtags and urls, which are usually too few to store in a separate table.
     * @param strings
     * @return comma-separated strings as a larger string
     */
    public static String StringsToCSV (ArrayList<String> strings){
        String returnString = "";

        for(String str : strings){
            returnString = returnString + str + ",";
        }

        if(returnString != "" && returnString.length() > 0 && returnString.charAt(returnString.length() -1) == ','){
            returnString = returnString.substring(0, returnString.length() - 1);
        }
        return returnString;
    }

    public static String buildRequestUrl(String base, Map<String, String> params){
        return "";
    }
}
