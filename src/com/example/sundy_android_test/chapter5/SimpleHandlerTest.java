package com.example.sundy_android_test.chapter5;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.sundy_android_test.R;

/**
 * @author xiads
 * @date 14-7-9
 */
public class SimpleHandlerTest extends Activity {

    public static final int REQUEST_STOP = 0x001;
    public static final int REQUEST_START = 0x002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mHandler.sendEmptyMessage(REQUEST_START);
        setContentView(R.layout.thread_simple_test);
        Button _btnStop = (Button) findViewById(R.id.btn_thread_simple_test);
        Button _btnStartHandler = (Button) findViewById(R.id.btn_thread_simple_test2);
        Button _btnStartEndlessLoop = (Button) findViewById(R.id.btn_thread_simple_test3);
        Button _btnStopEndlessLoop = (Button) findViewById(R.id.btn_thread_simple_test4);

        _btnStop.setText("STOP HANDLER");
        _btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.sendEmptyMessage(REQUEST_STOP);
            }
        });
        _btnStartHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.sendEmptyMessage(REQUEST_START);
            }
        });

        _btnStartEndlessLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sCmd = true;
                Log.v("TAG", "thread.isAlive()=" + thread.isAlive());
                if(!thread.isAlive())
                    thread.start();
            }
        });

        _btnStopEndlessLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sCmd = false;
            }
        });
    }

    Handler.Callback mHandlerCallback = new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Log.v("TAG", "handler handleMessage callback...");
            return false;
        }
    };

    Handler mHandler = new Handler(mHandlerCallback) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.v("TAG", "handler handleMessage...");
            switch (msg.what) {
                case REQUEST_START:
                    doSomething(true);
                    break;
                case REQUEST_STOP:
                    doSomething(false);
                    break;
                default:
            }
        }
    };

    private void doSomething(boolean command) {
        Log.v("TAG", "you are " + command);
    }

    static boolean sCmd;

    private Runnable mRunStart = new Runnable() {
        @Override
        public void run() {
            endlessLoop();
        }
    };

    private Thread thread = new Thread(mRunStart);

    private void endlessLoop() {
        int i = 0;
        while(true) {
            while (sCmd) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.v("TAG", "number" + i);
                i++;
            }
        }
    }
}
