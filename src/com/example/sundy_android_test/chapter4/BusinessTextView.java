package com.example.sundy_android_test.chapter4;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.example.sundy_android_test.R;

/**
 * @author xiads
 * @date 14-6-23
 */
public class BusinessTextView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter4_2);
        getTextView();
    }

    private void getTextView() {
        TextView textView = (TextView) findViewById(R.id.btv_title);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append("#Sam");
        ImageSpan imageSpan = new ImageSpan(BusinessTextView.this, R.drawable.widget_logo);
        spannableStringBuilder.setSpan(imageSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableStringBuilder);
    }
}
