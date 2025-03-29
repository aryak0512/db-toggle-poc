package com.aryak.db.utils;

import java.util.Map;

public class CommonUtils {

    public static String prepareUrl(String url, Map<String, String> pathVariables) {
        for ( Map.Entry<String, String> e : pathVariables.entrySet() ) {
            url = url.replace(e.getKey(), e.getValue());
        }
        return url;
    }

    /**
     * dumps data to DB.
     *
     * @return true if success, false if failure
     */
    public static boolean dumpToDatabase(String data) {

        System.out.println("Inside dump to database");
        // repo or dao dependency layer code here

        return false;
    }


    public static boolean process(String data) {
        System.out.printf("Printing");
        boolean v = CommonUtils.dumpToDatabase(data);
        System.out.printf("v :" + v);
        return v;
    }
}
