package com.example.sundy_android_test.chapter3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.sundy_android_test.util.Constant;
import com.example.sundy_android_test.widgets.EmptyLayout;

/**
 * @author xiads
 * @date 14-6-18
 */
public class ActivityLifeCycle2 extends Activity implements Constant {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(DEBUG_TAG, "Activity2 created.");
        Log.v(DEBUG_TAG, getClass().getSimpleName() +
                " task id:[" + this.getTaskId() + "]");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(DEBUG_TAG, "Activity2 started.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(DEBUG_TAG, "Activity2 resumed.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(DEBUG_TAG, "Activity2 paused.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(DEBUG_TAG, "Activity2 restarted.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(DEBUG_TAG, "Activity2 stopped.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(DEBUG_TAG, "Activity2 destroyed.");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.v(DEBUG_TAG, "Activity2 onConfigurationChanged");
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.v(DEBUG_TAG, "Activity2 onConfigurationChanged ORIENTATION_LANDSCAPE.");
        }else {
            Log.v(DEBUG_TAG, "Activity2 onConfigurationChanged ORIENTATION_PORTRAIT.");
        }
    }
}