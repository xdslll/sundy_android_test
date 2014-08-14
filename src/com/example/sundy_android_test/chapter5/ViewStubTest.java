package com.example.sundy_android_test.chapter5;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import com.example.sundy_android_test.R;

/**
 * @author xiads
 * @date 14-7-22
 */
public class ViewStubTest extends Activity {

    ViewHolder mHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_stub_test);
        Button btnShow = (Button) findViewById(R.id.view_stub_show);
        mHolder = new ViewHolder();
        mHolder.viewStubPort = (ViewStub) findViewById(R.id.view_stub_stub_port);
        mHolder.viewStubLand = (ViewStub) findViewById(R.id.view_stub_stub_land);
        mHolder.viewStubPort.inflate();
        mHolder.viewStubLand.inflate();
        int screenOrientation = getResources().getConfiguration().orientation;
        if(screenOrientation == Configuration.ORIENTATION_PORTRAIT) {
            mHolder.viewStubPort.setVisibility(View.VISIBLE);
            mHolder.viewStubLand.setVisibility(View.GONE);
        }else {
            mHolder.viewStubLand.setVisibility(View.VISIBLE);
            mHolder.viewStubPort.setVisibility(View.GONE);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.v("TAG", "ORIENTATION_PORTRAIT");
            mHolder.viewStubPort.setVisibility(View.VISIBLE);
            mHolder.viewStubLand.setVisibility(View.GONE);
        }else if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.v("TAG", "ORIENTATION_LANDSCAPE");
            mHolder.viewStubLand.setVisibility(View.VISIBLE);
            mHolder.viewStubPort.setVisibility(View.GONE);
        }
    }

    static class ViewHolder {
        ViewStub viewStubPort;
        ViewStub viewStubLand;
    }
}
