package com.example.sundy_android_test.chapter4;

import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.sundy_android_test.R;
import com.example.sundy_android_test.util.Constant;
import com.example.sundy_android_test.widgets.EmptyLayout;

/**
 * @author xiads
 * @date 14-6-23
 */
public class SimpleCustomViewActivity extends Activity implements Constant {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //SimpleCustomView _scw = new SimpleCustomView(this);
        //DrawableView _dv  = new DrawableView(this);
        /*_scw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SimpleCustomViewActivity.this,
                        "Hello!", Toast.LENGTH_SHORT).show();
            }
        });*/

        EmptyLayout _el = new EmptyLayout(this);
        ImageView _iw = new ImageView(this);
        TransitionDrawable _drawable = (TransitionDrawable)
                this.getResources().getDrawable(R.drawable.add);
        _iw.setAdjustViewBounds(true);
        _iw.setImageDrawable(_drawable);
        _iw.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        _drawable.startTransition(1000);
        TextView _textView = new TextView(this);
        _textView.setText("Hello World!");
        _el.addView(_iw);
        _el.addView(_textView);
        setContentView(_el);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_DPAD_UP) {
            Log.v(DEBUG_TAG, "activity : your key down!");
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
                Log.v(DEBUG_TAG, "activity : your key down!");
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.v(DEBUG_TAG, "activity : your action down!");
                break;
            case MotionEvent.ACTION_UP:
                long _eventTime = event.getEventTime();
                long _downTime = event.getDownTime();
                if(_eventTime - _downTime > 2000) {
                    Log.v(DEBUG_TAG, "activity : your action is long click!");
                    Log.v(DEBUG_TAG, "activity : _eventTime=" +
                            _eventTime +"ms,_downTime=" + _downTime + "ms");
                }
                Log.v(DEBUG_TAG, "activity : your action down!");
                break;
        }
        return super.onTouchEvent(event);
    }
}
