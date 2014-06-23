package com.example.sundy_android_test.chapter3;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.example.sundy_android_test.util.Constant;

/**
 * @author xiads
 * @date 14-6-22
 */
public class StartedService extends Service implements Constant {

    private int mIndex = 0;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(DEBUG_TAG, "onStartCommand " + mIndex++);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(DEBUG_TAG, "onDestroy");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(DEBUG_TAG, "onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
