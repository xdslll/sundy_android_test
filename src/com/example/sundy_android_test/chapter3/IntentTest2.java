package com.example.sundy_android_test.chapter3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.sundy_android_test.util.CommonUtil;
import com.example.sundy_android_test.util.Constant;
import com.example.sundy_android_test.widgets.EmptyLayout;

/**
 * @author xiads
 * @date 14-6-17
 */
public class IntentTest2 extends Activity implements Constant {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EmptyLayout _el = new EmptyLayout(this);
        setContentView(_el);

        final Intent _intent = this.getIntent();
        String _name = _intent.getStringExtra("name");
        CommonUtil.ShowToastMessage(this, _intent.getDataString());

        TextView _textView = new TextView(this);
        Button _button = new Button(this);
        Button _button2 = new Button(this);
        _el.addView(_textView);
        _el.addView(_button);
        _el.addView(_button2);
        _textView.setText("成功跳转到intent2!");
        _button.setText("返回");
        _button2.setText("打电话");
        _button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _intent.putExtra("hello", "Hello Android!");
                setResult(RESULT_CODE, _intent);
                finish();
            }
        });
        _button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent _intent2 = new Intent();
                _intent2.setAction(Intent.ACTION_DIAL);
                _intent2.setData(Uri.parse("tel:13400061001"));
                startActivity(_intent2);
            }
        });
    }
}
