package com.example.sundy_android_test.chapter3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.sundy_android_test.widgets.EmptyLayout;

/**
 * @author xiads
 * @date 14-6-22
 */
public class StartedServiceTest extends Activity {

    Intent mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EmptyLayout _el = new EmptyLayout(this);
        setContentView(_el);
        Button _btn1 = new Button(this);
        Button _btn2 = new Button(this);
        _el.addView(_btn1);
        _el.addView(_btn2);
        _btn1.setText("Start Service");
        _btn2.setText("Stop Service");
        _btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(
                        StartedServiceTest.this, StartedService.class);
                startService(mIntent);
            }
        });
        _btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(mIntent);
            }
        });
    }
}
