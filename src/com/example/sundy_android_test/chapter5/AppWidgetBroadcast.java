package com.example.sundy_android_test.chapter5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @author xiads
 * @date 14-7-8
 */
public class AppWidgetBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("TAG", "This message was printed by BroadcastReceiver...");
    }
}
