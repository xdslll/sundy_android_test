package com.example.sundy_android_test.chapter5;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import com.example.sundy_android_test.widgets.EmptyLayout;

/**
 * @author xiads
 * @date 14-7-10
 */
public class TestHandlerAndAsyncTask extends Activity {

    Handler mHandler = new Handler();
    AsyncTask<Void, Void, Void> mTask = new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... params) {
            r.run();
            return null;
        }
    };

    Runnable r = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EmptyLayout emptyLayout = new EmptyLayout(this);
        setContentView(emptyLayout);

        Button btnStartHandler = new Button(this);
        Button btnStartAsyncTask = new Button(this);
        btnStartHandler.setText("StartHandler");
        btnStartAsyncTask.setText("StartAsyncTask");
        emptyLayout.addView(btnStartHandler);
        emptyLayout.addView(btnStartAsyncTask);

        btnStartHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.postDelayed(r, 100);
            }
        });

        btnStartAsyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTask.execute();
            }
        });
    }
}
