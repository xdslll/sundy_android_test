package com.example.sundy_android_test.chapter4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.Button;

/**
 * @author xiads
 * @date 14-7-5
 */
public class MyButton extends Button {

    private OnMyButtonKeyDown mKeyDown;

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public interface OnMyButtonKeyDown {
        void onKeyDown(String msg);
    }

    public void setOnMyButtonKeyDown(OnMyButtonKeyDown onMyButtonKeyDown) {
        this.mKeyDown = onMyButtonKeyDown;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(mKeyDown != null) {
            mKeyDown.onKeyDown("hello sam!");
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        canvas.drawRect(20, 20, 60, 60, paint);
        paint.setTextSize(25);
        paint.setStrokeWidth(2);
        int text_width = this.getWidth() / 2;
        int text_height = this.getHeight() / 2;
        canvas.drawText("Sam", text_width, text_height, paint);
    }
}
