package com.example.sundy_android_test.chapter_my;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import com.example.sundy_android_test.R;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author xiads
 * @date 14-8-12
 */
public class TitleProgress extends Activity {

    ScheduledExecutorService mService = Executors.newScheduledThreadPool(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        setProgressBarVisibility(true);
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);

        mService.scheduleAtFixedRate(r, 0, 1, TimeUnit.SECONDS);
        // 通过线程来改变ProgressBar的值
        /*new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                        Message m = new Message();
                        m.what = (i + 1) * 20;
                        TitleProgress.this.myMessageHandler.sendMessage(m);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();*/
        setContentView(R.layout.chapter1_1);
    }

    int mCount = 0;
    Runnable r = new Runnable() {
        public void run() {
            Message m = new Message();
            m.what = (mCount + 1) * 20;
            TitleProgress.this.myMessageHandler.sendMessage(m);
            mCount++;
        }
    };

    Handler myMessageHandler = new Handler() {
        // @Override
        public void handleMessage(Message msg) {
            // 设置标题栏中前景的一个进度条进度值
            setProgress(100 * msg.what);
            // 设置标题栏中后面的一个进度条进度值
            setSecondaryProgress(100 * msg.what + 10);
            super.handleMessage(msg);
        }
    };
}
