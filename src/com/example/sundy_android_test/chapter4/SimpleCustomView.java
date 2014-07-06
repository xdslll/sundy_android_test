package com.example.sundy_android_test.chapter4;

import android.content.Context;
import android.graphics.*;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.example.sundy_android_test.util.Constant;

/**
 * @author xiads
 * @date 14-6-23
 */
public class SimpleCustomView extends View implements Constant {

    public SimpleCustomView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Matrix _matrix = new Matrix();
        _matrix.setRotate(15.0f);
        //canvas.setMatrix(_matrix);
        //canvas.scale(1.0f, 1.0f);
        canvas.clipRect(20, 20, 200, 200);
        Paint _paint = new Paint();
        _paint.setAntiAlias(true);
        _paint.setColor(Color.RED);
        //canvas.drawRect(10, 10, 200, 200, _paint);
        RectF _rectF = new RectF(50, 50, 200, 100);
        canvas.drawRoundRect(_rectF, 20.0f, 20.0f, _paint);
        _paint.setColor(Color.BLACK);
        canvas.drawText("Hello World", 80, 80, _paint);
        _paint.setColor(Color.BLUE);
        RectF _oval = new RectF(20, 200, 120, 300);
        canvas.drawOval(_oval, _paint);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_DPAD_UP) {
            Log.v(DEBUG_TAG, "your key down!");
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
                Log.v(DEBUG_TAG, "view : your key down!");
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.v(DEBUG_TAG, "view : your action down!");
                break;
            case MotionEvent.ACTION_UP:
                Log.v(DEBUG_TAG, "view : your action down!");
                break;
        }
        return super.onTouchEvent(event);
    }
}
