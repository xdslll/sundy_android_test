package com.example.sundy_android_test.chapter3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.sundy_android_test.util.Constant;
import com.example.sundy_android_test.widgets.EmptyLayout;

/**
 * @author xiads
 * @date 14-6-20
 */
public class ActivityTaskB extends Activity implements Constant {

    private Button mBtn1, mBtn2;
    private static int sIndex = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EmptyLayout _el = new EmptyLayout(this);
        setContentView(_el);
        mBtn1 = new Button(this);
        mBtn2 = new Button(this);
        mBtn1.setText("Go to activity A");
        mBtn2.setText("Go to activity B");
        _el.addView(mBtn1);
        _el.addView(mBtn2);

        String title = "activity A[" + sIndex++ + "]task id:" + getTaskId();
        Log.v(DEBUG_TAG, title);
        this.getWindow().setTitle(title);

        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent _intent = new Intent(ActivityTaskB.this, ActivityTaskA.class);
                startActivity(_intent);
            }
        });

        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent _intent = new Intent(ActivityTaskB.this, ActivityTaskB.class);
                startActivity(_intent);
            }
        });
    }
}
