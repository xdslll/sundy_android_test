package com.example.sundy_android_test.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by xiads btn_on 14-6-11.
 */
public class CommonUtil {

    public static void ShowToastMessage(Context c, String msg) {
        Toast.makeText(c, msg, Toast.LENGTH_SHORT).show();
    }
}
