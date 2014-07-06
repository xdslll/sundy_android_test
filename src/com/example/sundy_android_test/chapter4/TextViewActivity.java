package com.example.sundy_android_test.chapter4;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.sundy_android_test.R;
import com.example.sundy_android_test.util.Constant;
import org.xml.sax.XMLReader;

/**
 * @author xiads
 * @date 14-6-23
 */
public class TextViewActivity extends Activity implements Constant {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter4_1);
        getTextView();
    }

    private void getTextView() {
        TextView textView = (TextView) findViewById(R.id.chapter4_textview01);
        /*String imgSource = "<img src=\"http://su.bdimg.com/static/superplus" +
                "/img/logo_white.png\"/>";
        String textSource = "<sam>Sam:</sam>" + imgSource + "<b>Hello Baidu!</b>";
        Html.ImageGetter imageGetter = new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                if(source != null) {
                    BitmapDrawable drawable = (BitmapDrawable) TextViewActivity.this
                            .getResources().getDrawable(R.drawable.up);
                    drawable.setBounds(0, 0,
                            drawable.getIntrinsicWidth(),
                            drawable.getIntrinsicHeight());
                    return drawable;
                }else
                    return null;
            }
        };
        Html.TagHandler tagHandler = new Html.TagHandler() {
            @Override
            public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
                Log.v(DEBUG_TAG, "tag:" + tag);
                Log.v(DEBUG_TAG, "output:" + output);
            }
        };
        Spanned htmlText = Html.fromHtml(textSource, imageGetter, tagHandler);
        textView.setText(htmlText);
*/

        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append("Sam:<img>今年世界杯有三多：黑马多，绝杀多，进球多。");

        ImageSpan imageSpan = new ImageSpan(TextViewActivity.this, R.drawable.up);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(TextViewActivity.this,
                        "Hello!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(
                        TextViewActivity.this, NinePatchTest.class));
            }
        };

        builder.setSpan(imageSpan, 4, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(clickableSpan, 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(builder);
    }
}
