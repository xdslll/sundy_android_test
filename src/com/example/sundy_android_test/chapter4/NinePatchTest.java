package com.example.sundy_android_test.chapter4;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.example.sundy_android_test.R;
import com.example.sundy_android_test.widgets.EmptyLayout;

/**
 * @author xiads
 * @date 14-6-23
 */
public class NinePatchTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BitmapDrawable drawable = (BitmapDrawable)
                this.getResources().getDrawable(R.drawable.button_9);
        EmptyLayout emptyLayout = new EmptyLayout(this);
        Button button = new Button(this);
        emptyLayout.addView(button);
        button.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
        button.setText("HelloHelloHelloHelloHelloHelloHello" +
                "HelloHelloHelloHelloHelloHelloHelloHelloHello" +
                "HelloHelloHelloHelloHelloHelloHelloHelloHello");
        button.setTextSize(20.0f);
        button.setBackground(drawable);

        setContentView(emptyLayout);
    }
}
