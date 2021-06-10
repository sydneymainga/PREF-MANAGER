package com.example.sydneyuser.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;

import com.example.sydneyuser.R;
import com.tapadoo.alerter.Alerter;




/**
 * Created by toni on 4/11/18.
 * day : Wednesday
 * time : 10:28 AM
 * <p>
 * Uses Alerter lib
 * ref =  https://github.com/Tapadoo/Alerter.git
 * <p>
 * color and icons customized to likes of Toasty
 */

public class TopAlertUtils {


//    TopAlertUtils.DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF");
//    TopAlertUtils.ERROR_COLOR = Color.parseColor("#D50000");
//    TopAlertUtils.INFO_COLOR = Color.parseColor("#3F51B5");
//    TopAlertUtils.SUCCESS_COLOR = Color.parseColor("#388E3C");
//    TopAlertUtils.WARNING_COLOR = Color.parseColor("#FFA900");

    /* warning */
    public static void warning(Context context, String message) {
        Alerter.create((Activity) context)
                .setText(message)
                .setIcon(R.drawable.ic_warning_black_24dp)
                .setBackgroundColorInt(Color.parseColor("#FFA900"))
                .setIconColorFilter(0) // Optional - Removes white tint
                .show();
    }


    /* display error */
    public static void error(Context context, String message) {
        Alerter.create((Activity) context)
                .setText(message)
                .setIcon(R.drawable.ic_clear_black_24dp)
                .setBackgroundColorInt(Color.parseColor("#D50000"))
                .setIconColorFilter(0) // Optional - Removes white tint
                .show();
    }

    /* display success */
    public static void success(Context context, String message) {
        Alerter.create((Activity) context)
                .setText(message)
                .setIcon(R.drawable.ic_check_black_24dp)
                .setBackgroundColorInt(Color.parseColor("#388E3C"))
                .setIconColorFilter(0) // Optional - Removes white tint
                .show();
    }

    /* display information */
    public static void info(Context context, String message) {
        Alerter.create((Activity) context)
                .setText(message)
                .setIcon(R.drawable.ic_info_outline_black_24dp)
                .setBackgroundColorInt(Color.parseColor("#3F51B5"))
                .setIconColorFilter(0) // Optional - Removes white tint
                .show();
    }

}
