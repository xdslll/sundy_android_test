package com.example.sundy_android_test.chapter3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.sundy_android_test.R;
import com.example.sundy_android_test.widgets.EmptyLayout;

/**
 * @author xiads
 * @date 14-6-17
 */
public class LoadView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //方法1:调用Activity的setContentView,其本质就是调用Window的setContentView
        //this.setContentView(R.layout.chapter1_1);
        //方法2:调用Window的setContentView
        //this.getWindow().setContentView(R.layout.chapter1_1);
        //方法3:调用Window的inflate
        EmptyLayout emptyLayout = new EmptyLayout(this);
        final Button _button = new Button(this);
        _button.setText("第三种加载方法");
        emptyLayout.addView(_button);
        View view = this.getLayoutInflater().
                inflate(R.layout.chapter1_1, emptyLayout);
        this.getWindow().setContentView(view);

        Button _button2 = (Button) findViewById(R.id.chapter1_1_btn);
        final LinearLayout parent = (LinearLayout) _button2.getParent();
        _button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button _button3 = new Button(LoadView.this);
                _button3.setText("Hello!");
                _button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(LoadView.this, "Hello!", Toast.LENGTH_SHORT).show();
                    }
                });
                parent.addView(_button3);
            }
        });
    }
}
