package com.example.sundy_android_test.chapter5;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import com.example.sundy_android_test.R;

/**
 * @author xiads
 * @date 14-7-10
 */
public class OrientationTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orientation_portrait_layout);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.v("TAG", "ORIENTATION_PORTRAIT");
            setContentView(R.layout.orientation_portrait_layout);
        }else if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.v("TAG", "ORIENTATION_LANDSCAPE");
            setContentView(R.layout.orientation_landscape_layout);
        }
    }
}
