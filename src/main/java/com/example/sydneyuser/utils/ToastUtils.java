package com.example.sydneyuser.utils;

import android.content.Context;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class ToastUtils {


    public static void showErrorToast(Context ctx, String msg) {
        Toasty.error(ctx, msg, Toast.LENGTH_SHORT, true).show();
        

    }

    public static void showSuccessToast(Context ctx, String msg) {
        Toasty.success(ctx, msg, Toast.LENGTH_SHORT, true).show();
    }

    public static void showInfoToast(Context ctx, String msg) {
        Toasty.info(ctx, msg, Toast.LENGTH_SHORT, true).show();
    }

    public static void showWarnignToast(Context ctx, String msg) {
        Toasty.warning(ctx, msg, Toast.LENGTH_SHORT, true).show();
    }



}
