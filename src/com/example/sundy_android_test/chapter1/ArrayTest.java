package com.example.sundy_android_test.chapter1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.sundy_android_test.R;

/**
 * @author Sam
 * @since 14-6-111
 * array.xml文件的动态加载
 */
public class ArrayTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layoutRoot = new LinearLayout(this);
        layoutRoot.setOrientation(LinearLayout.VERTICAL);
        layoutRoot.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        setContentView(layoutRoot);
        String[] aColors = this.getResources().getStringArray(R.array.colorsArray);
        for(int i = 0; i < aColors.length; i++) {
            TextView textView = new TextView(this);
            textView.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            textView.setText("Test Color");
            textView.setBackgroundColor(Color.parseColor(aColors[i]));
            layoutRoot.addView(textView);
        }
    }
}
