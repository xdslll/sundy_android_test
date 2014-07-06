package com.example.sundy_android_test.chapter4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.example.sundy_android_test.R;

/**
 * @author xiads
 * @date 14-6-23
 */
public class DrawableView extends View {

    BitmapDrawable mBitmapDrawable;

    public DrawableView(Context context) {
        super(context);
        mBitmapDrawable = (BitmapDrawable)
                getResources().getDrawable(R.drawable.add_button);
        mBitmapDrawable.setBounds(10, 10, 138, 138);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mBitmapDrawable.draw(canvas);
    }
}
