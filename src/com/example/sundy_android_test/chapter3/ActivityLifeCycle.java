package com.example.sundy_android_test.chapter3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
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
public class ActivityLifeCycle extends Activity implements Constant {

    EditText mEdt;
    Button mBtn, mBtn2, mBtn3, mBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EmptyLayout _el = new EmptyLayout(this);
        setContentView(_el);
        mEdt = new EditText(this);
        mBtn = new Button(this);
        mBtn2 = new Button(this);
        mBtn3 = new Button(this);
        mBtn4 = new Button(this);
        _el.addView(mEdt);
        _el.addView(mBtn);
        _el.addView(mBtn2);
        _el.addView(mBtn3);
        _el.addView(mBtn4);
        mEdt.setText("http://www.sina.com.cn");
        mBtn.setText("Go to another Activity!");
        mBtn2.setText("Display a dialog!");
        mBtn3.setText("Dial Telephone Number");
        mBtn4.setText("Open Browser");
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent _intent = new Intent();
                _intent.setClass(ActivityLifeCycle.this, ActivityLifeCycle2.class);
                startActivity(_intent);
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder _builder =
                        new AlertDialog.Builder(ActivityLifeCycle.this);
                _builder.setTitle("Title")
                        .setMessage("Message")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create()
                        .show();
            }
        });
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent _intent = new Intent();
                _intent.setAction(Intent.ACTION_DIAL);
                _intent.setData(Uri.parse("tel:13400061001"));
                startActivity(_intent);
            }
        });
        mBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent _intent = new Intent();
                _intent.setAction(Intent.ACTION_VIEW);
                _intent.setData(Uri.parse(mEdt.getText().toString()));
                startActivity(_intent);
            }
        });
        Log.v(DEBUG_TAG, "Activity created.");
        if(savedInstanceState != null) {
            String _info = savedInstanceState.getString("info");
            mEdt.setText(_info);
        }

        Log.v(DEBUG_TAG, getClass().getSimpleName() +
                " task id:[" + this.getTaskId() + "]");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.v(DEBUG_TAG, "Activity onConfigurationChanged.");
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.v(DEBUG_TAG, "Activity onConfigurationChanged ORIENTATION_LANDSCAPE.");
        }else {
            Log.v(DEBUG_TAG, "Activity onConfigurationChanged ORIENTATION_PORTRAIT.");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(DEBUG_TAG, "Activity started.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(DEBUG_TAG, "Activity resumed.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(DEBUG_TAG, "Activity paused.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(DEBUG_TAG, "Activity restarted.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(DEBUG_TAG, "Activity stopped.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(DEBUG_TAG, "Activity destroyed.");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String _info = mEdt.getText().toString();
        outState.putString("info", _info);
        Log.v(DEBUG_TAG, "Activity onSaveInstanceState.");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //String _info = savedInstanceState.getString("info");
        //mEdt.setText(_info);
        Log.v(DEBUG_TAG, "Activity onRestoreInstanceState.");
    }
}