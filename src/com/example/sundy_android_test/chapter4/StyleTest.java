package com.example.sundy_android_test.chapter4;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import com.example.sundy_android_test.R;
import com.example.sundy_android_test.util.Constant;

/**
 * @author xiads
 * @date 14-7-4
 */
public class StyleTest extends Activity implements Constant {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = this.getLayoutInflater();
        View contentView = inflater.inflate(R.layout.chapter4_6, null);
        setContentView(contentView);

        MyTextView myTextView = (MyTextView) findViewById(R.id.my_textview);
        Log.v(DEBUG_TAG, "myTextView.getMyBool()=" + myTextView.getMyBool());
        Log.v(DEBUG_TAG, "myTextView.getMyString()=" + myTextView.getMyString());
        Log.v(DEBUG_TAG, "myTextView.getMyInt()=" + myTextView.getMyInt());

        MyButton myButton = (MyButton) findViewById(R.id.my_button);
        myButton.setOnMyButtonKeyDown(new MyButton.OnMyButtonKeyDown() {
            @Override
            public void onKeyDown(String msg) {
                Toast.makeText(StyleTest.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        SharedPreferences preferences =
                this.getSharedPreferences("test1", MODE_PRIVATE);
        Toast.makeText(this, preferences.getString("hello", "abc"),
                Toast.LENGTH_SHORT).show();
    }
}
