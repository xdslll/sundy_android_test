package com.example.sundy_android_test.chapter3;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.example.sundy_android_test.util.Constant;

/**
 * @author xiads
 * @date 14-6-21
 */
public class SamService extends Service implements Constant {

    private boolean mMark = true;

    private class HelloService implements Runnable {

        @Override
        public void run() {
            int _index = 1;
            while(mMark) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.v(DEBUG_TAG, "service[" + _index + "]");
                _index++;
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.v(DEBUG_TAG, "onBind");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //new Thread(new HelloService()).start();
        Log.v(DEBUG_TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
        /*if(intent != null) {
            Log.i(DEBUG_TAG, "intent is not null!");
        }else {
            Log.i(DEBUG_TAG, "intent is null!");
        }
        return START_STICKY;*/
    }

    @Override
    public void onDestroy() {
        Log.v(DEBUG_TAG, "onDestroy");
        super.onDestroy();
        mMark = false;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v(DEBUG_TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.v(DEBUG_TAG, "onRebind");
        super.onRebind(intent);
    }

    @Override
    public void onCreate() {
        Log.v(DEBUG_TAG, "onCreate");
        super.onCreate();
    }
}
