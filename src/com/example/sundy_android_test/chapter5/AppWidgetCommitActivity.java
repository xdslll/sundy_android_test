package com.example.sundy_android_test.chapter5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

/**
 * @author xiads
 * @date 14-7-7
 */
public class AppWidgetCommitActivity extends Activity {

    private static final int BUTTON_ID = 0x001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout _rl = new RelativeLayout(this);
        setContentView(_rl);

        RelativeLayout.LayoutParams _btnLp = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        _btnLp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        Button _btnCommit = new Button(this);
        _btnCommit.setText("Commit");
        _btnCommit.setLayoutParams(_btnLp);
        _btnCommit.setId(BUTTON_ID);
        _rl.addView(_btnCommit);

        RelativeLayout.LayoutParams _edtLp = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        _edtLp.addRule(RelativeLayout.LEFT_OF, _btnCommit.getId());
        final EditText _edtContent = new EditText(this);
        _edtContent.setLayoutParams(_edtLp);
        _edtContent.setHint("Write something...");
        _rl.addView(_edtContent);

        Intent _data = getIntent();
        String _strData = "";
        if(_data.getExtras() != null &&
                _data.getExtras().getString("data") != null) {
            _strData = _data.getExtras().getString("data");
        }
        if(_strData != null) {
            _edtContent.setText(_strData);
        }

        _btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _showInfo = _edtContent.getText().toString();
                Toast.makeText(AppWidgetCommitActivity.this,
                        _showInfo, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.v("TAG", "onBackPressed...");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
