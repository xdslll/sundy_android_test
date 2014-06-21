package com.example.sundy_android_test.chapter3;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.Log;
import com.example.sundy_android_test.util.Constant;

/**
 * @author xiads
 * @date 14-6-17
 */
public class ApplicationTest extends Application implements Constant {

    public ApplicationTest() {
        super();
        Log.i(DEBUG_TAG, "APP Inited!");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(DEBUG_TAG, "APP Created!");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.i(DEBUG_TAG, "APP Terminated!");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(DEBUG_TAG, "APP Configuration changed!");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.i(DEBUG_TAG, "APP Low Memory!");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.i(DEBUG_TAG, "APP Trim Memory!");
    }

    @Override
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        super.registerComponentCallbacks(callback);
        Log.i(DEBUG_TAG, "APP registerComponentCallbacks!");
    }

    @Override
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        super.unregisterComponentCallbacks(callback);
        Log.i(DEBUG_TAG, "APP unregisterComponentCallbacks!");
    }

    @Override
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.registerActivityLifecycleCallbacks(callback);
        Log.i(DEBUG_TAG, "APP registerActivityLifecycleCallbacks!");
    }

    @Override
    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.unregisterActivityLifecycleCallbacks(callback);
        Log.i(DEBUG_TAG, "APP unregisterActivityLifecycleCallbacks!");
    }

    @Override
    public void registerOnProvideAssistDataListener(OnProvideAssistDataListener callback) {
        super.registerOnProvideAssistDataListener(callback);
        Log.i(DEBUG_TAG, "APP registerOnProvideAssistDataListener!");
    }

    @Override
    public void unregisterOnProvideAssistDataListener(OnProvideAssistDataListener callback) {
        super.unregisterOnProvideAssistDataListener(callback);
        Log.i(DEBUG_TAG, "APP registerOnProvideAssistDataListener!");
    }
}
