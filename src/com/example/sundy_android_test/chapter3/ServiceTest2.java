package com.example.sundy_android_test.chapter3;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.sundy_android_test.util.Constant;
import com.example.sundy_android_test.widgets.EmptyLayout;

/**
 * @author xiads
 * @date 14-6-21
 */
public class ServiceTest2 extends Activity implements Constant {

    Intent mIntent;
    EditText mEdtBindServiceResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EmptyLayout _el = new EmptyLayout(this);
        setContentView(_el);

        Button _btnStartService = new Button(this);
        Button _btnStopService = new Button(this);
        Button _btnStartIntentService = new Button(this);
        Button _btnStopIntentService = new Button(this);
        Button _btnBindService = new Button(this);
        mEdtBindServiceResult =new EditText(this);
        Button _btnGetIndex = new Button(this);
        Button _btnUnbindService = new Button(this);

        _btnStartService.setText("Start Service");
        _btnStopService.setText("Stop Service");
        _btnStartIntentService.setText("Start IntentService");
        _btnStopIntentService.setText("Stop IntentService");
        _btnBindService.setText("Bind Service");
        _btnGetIndex.setText("Get Index From Service");
        _btnUnbindService.setText("Unbind Service");
        _el.addView(_btnStartService);
        _el.addView(_btnStopService);
        _el.addView(_btnStartIntentService);
        _el.addView(_btnStopIntentService);
        _el.addView(_btnBindService);
        _el.addView(mEdtBindServiceResult);
        _el.addView(_btnGetIndex);
        _el.addView(_btnUnbindService);
        _btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(ServiceTest2.this, SamService.class);
                startService(mIntent);
                //finish();
            }
        });
        _btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIntent != null) {
                    stopService(mIntent);
                }
            }
        });
        _btnStartIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(ServiceTest2.this, SamIntentService.class);
                startService(mIntent);
            }
        });
        _btnStopIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIntent != null) {
                    stopService(mIntent);
                }
            }
        });
        _btnBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(ServiceTest2.this, SamIntentService.class);
                bindService(mIntent, mConn, BIND_AUTO_CREATE);
            }
        });
        _btnGetIndex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mService != null) {
                    Toast.makeText(
                            ServiceTest2.this,
                            "index:" + mService.getServiceIndex(),
                            Toast.LENGTH_SHORT
                    ).show();
                }else {
                    Toast.makeText(
                            ServiceTest2.this,
                            "Service not connection",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
        _btnUnbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(mConn);
            }
        });
    }

    SamIntentService mService;

    private ServiceConnection mConn = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //int _index = ((SamService.SamBinder) service).getIndex();
            //mEdtBindServiceResult.setText("index:" + _index);
            //Toast.makeText(ServiceTest.this, _index + "", Toast.LENGTH_SHORT).show();
            mService = ((SamIntentService.SamBinder) service).getService();
            //mService.printIndex();
            Log.v(DEBUG_TAG, "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.v(DEBUG_TAG, "onServiceDisconnected");
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(DEBUG_TAG, "ServiceTest onDestroy");
    }
}
