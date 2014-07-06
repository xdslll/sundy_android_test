package com.example.sundy_android_test.chapter4;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.sundy_android_test.widgets.EmptyLayout;

/**
 * @author xiads
 * @date 14-7-5
 */
public class SharedPreferenceTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EmptyLayout emptyLayout = new EmptyLayout(this);
        setContentView(emptyLayout);

        final SharedPreferences preferences =
                this.getSharedPreferences("test1", MODE_PRIVATE);

        Button btn_getSp = new Button(this);
        emptyLayout.addView(btn_getSp);
        btn_getSp.setText("Get SharedPreference");
        btn_getSp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = preferences.getString("hello", "sam");
                Toast.makeText(SharedPreferenceTest.this,
                        "hello " + value, Toast.LENGTH_SHORT).show();
            }
        });

        final EditText edt_newValue = new EditText(this);
        Button btn_commit = new Button(this);
        emptyLayout.addView(edt_newValue);
        emptyLayout.addView(btn_commit);
        btn_commit.setText("Commit");
        btn_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newValue = edt_newValue.getText().toString().trim();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("hello", newValue);
                editor.commit();
                Toast.makeText(SharedPreferenceTest.this,
                        "Edit successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
