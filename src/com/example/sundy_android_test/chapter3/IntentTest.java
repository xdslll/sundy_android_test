package com.example.sundy_android_test.chapter3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.example.sundy_android_test.util.CommonUtil;
import com.example.sundy_android_test.util.Constant;
import com.example.sundy_android_test.widgets.EmptyLayout;

/**
 * @author xiads
 * @date 14-6-17
 */
public class IntentTest extends Activity implements Constant {

    private EmptyLayout mEmptyLayout;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEmptyLayout = new EmptyLayout(this);
        setContentView(mEmptyLayout);

        mButton = new Button(this);
        mButton.setText("跳转");
        mEmptyLayout.addView(mButton);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent _intent = new Intent(IntentTest.this, IntentTest2.class);
                Intent _intent = new Intent();
                _intent.setAction("com.test.chapter3.DOTEST");
                _intent.putExtra("name", "Sam");
                _intent.setData(Uri.parse("http://www.baidu.com"));
                startActivityForResult(_intent, REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_CODE :
                String _message = data.getStringExtra("hello");
                CommonUtil.ShowToastMessage(this, _message);
                break;
        }
    }
}
