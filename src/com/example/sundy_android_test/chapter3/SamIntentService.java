package com.example.sundy_android_test.chapter3;

import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.example.sundy_android_test.util.Constant;

/**
 * @author xiads
 * @date 14-6-21
 */
public class SamIntentService extends IntentService implements Constant {

    private boolean mMark = true;

    public SamIntentService() {
        this("SamIntentService");
    }

    private int mIndex = 0;

    IBinder mBinder = new SamBinder();

    public class SamBinder extends Binder {

        public int getIndex() {
            addIndex();
            return mIndex;
        }

        public int addIndex() {
            return mIndex++;
        }

        public SamIntentService getService() {
            return SamIntentService.this;
        }

        public void printIndex() {
            printIndex();
        }
    }

    public int getServiceIndex() {
        return mIndex++;
    }

    public void printIndex() {
        for(int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.v(DEBUG_TAG, "service[" + i + "]");
        }
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public SamIntentService(String name) {
        super(name);
    }

    private void helloIntentService() {
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

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.v(DEBUG_TAG, this.getClass().getSimpleName() + " onHandleIntent");
        helloIntentService();
    }

    @Override
    public void onCreate() {
        Log.v(DEBUG_TAG, this.getClass().getSimpleName() + " onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(DEBUG_TAG, this.getClass().getSimpleName() + " onStartCommand");
        return super.onStartCommand(intent, flags, startId);
        //return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.v(DEBUG_TAG, this.getClass().getSimpleName() + " onDestroy");
        super.onDestroy();
        mMark = false;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.v(DEBUG_TAG, this.getClass().getSimpleName() + " onBind");
        //return super.onBind(intent);
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v(DEBUG_TAG, this.getClass().getSimpleName() + " onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.v(DEBUG_TAG, this.getClass().getSimpleName() + " onRebind");
        super.onRebind(intent);
    }
}
