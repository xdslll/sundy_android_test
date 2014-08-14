package com.example.sundy_android_test.chapter_my;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.sundy_android_test.R;

/**
 * @author xiads
 * @date 14-8-13
 */
public class GestureDetectorTest extends Activity
        implements GestureDetector.OnGestureListener {

    GestureDetector mDetector;
    ImageView mImageView;
    Bitmap mBitmap;
    int width, height;
    float currentScale = 1;
    Matrix matrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gesture_test);
        mDetector = new GestureDetector(this, this);

        mImageView = (ImageView) findViewById(R.id.gesture_img);
        matrix = new Matrix();
        mBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.sunny);
        width = mBitmap.getWidth();
        height = mBitmap.getHeight();
        mImageView.setImageBitmap(mBitmap);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        //Toast.makeText(this, "Gesture onDown", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        //Toast.makeText(this, "Gesture onShowPress", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        //Toast.makeText(this, "Gesture onSingleTapUp", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        //Toast.makeText(this, "Gesture onScroll", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        //Toast.makeText(this, "Gesture onLongPress", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Toast.makeText(this, "Gesture onFling,{\"velocityX\":" + velocityX +
                ",\"velocityY\":" + velocityY + "}", Toast.LENGTH_SHORT).show();
        velocityX = velocityX > 4000 ? 4000 : velocityX;
        velocityX = velocityX < -4000 ? -4000 : velocityX;
        currentScale += currentScale * velocityX / 4000.0f;
        currentScale = currentScale > 0.01 ? currentScale : 0.01f;
        matrix.reset();
        matrix.setScale(currentScale, currentScale, 160, 200);
        BitmapDrawable tmp = (BitmapDrawable) mImageView.getDrawable();
        if(!tmp.getBitmap().isRecycled()) {
            tmp.getBitmap().recycle();
        }
        Bitmap bitmap2 = Bitmap.createBitmap(mBitmap, 0, 0, width, height, matrix, true);
        mImageView.setImageBitmap(bitmap2);

        return true;
    }
}
