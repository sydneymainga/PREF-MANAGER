package com.example.sydneyuser.utils;

import android.util.Log;

/**
 * Created by toni on 3/6/18.
 * day : Tuesday
 * time : 9:46 AM
 */

public class ConsoleUtills {

    /**
     * print message to console
     *
     * @param content
     */
    public static void print(String content) {

        String Tag = ConsoleUtills.class.getSimpleName();

        Log.e(Tag, "===========================================================================================================");
        Log.e(Tag, "                                                                                                            ");
        Log.e(Tag, content);
        Log.e(Tag, "                                                                                                            ");
        Log.e(Tag, "===========================================================================================================");
    }

    /**
     * print error exception
     *
     * @param e Exception
     */
    public static void printException(Exception e) {
        String Tag = e.getClass().getSimpleName();
        Log.e(Tag, "==========================================  EXCEPTION   ===================================================");
        Log.e(Tag, "                                                                                                            ");
        Log.e(Tag, "Source ---------> " + e.getClass());
        Log.e(Tag, "                                                                                                            ");
        Log.e(Tag, "Error ----------> " + e.getLocalizedMessage());
        Log.e(Tag, "                                                                                                           ");
        Log.e(Tag, "Cause ----------> " + e.getCause());
        Log.e(Tag, "                                                                                                           ");
        e.printStackTrace();
        Log.e(Tag, "===========================================================================================================");
    }

}
