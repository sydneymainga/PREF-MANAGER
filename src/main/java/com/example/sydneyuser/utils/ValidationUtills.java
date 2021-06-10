package com.example.sydneyuser.utils;

import android.util.Patterns;
import android.widget.EditText;

/**
 * Created by toni on 4/3/18.
 * day : Tuesday
 * time : 1:51 PM
 */
public class ValidationUtills {
    /* validate fields if empty*/
    public static boolean validate(EditText[] fields) {

        for (EditText currentField : fields) {
            if (currentField.getText().toString().length() <= 0) {
                currentField.setError(currentField.getHint() + " is required");
                return false;
            }
        }
        return true;
    }

    /* validate email */
    public static boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /* validate phone number */
    public static boolean isValidMobile(String phone) {
        return Patterns.PHONE.matcher(phone).matches();
    }

}
