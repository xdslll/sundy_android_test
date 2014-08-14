package com.example.sundy_android_test.chapter5.anim;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.*;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.sundy_android_test.R;

/**
 * @author xiads
 * @date 14-7-22
 */
public class TweenAnimationTest extends Activity implements View.OnClickListener {

    ImageView mImageAlpha, mImageRotate, mImageScale, mImageTrans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tween_anim_test);

        mImageAlpha = (ImageView) findViewById(R.id.anim_test_alpha);
        mImageAlpha.setId(0x001);
        mImageAlpha.setOnClickListener(this);

        mImageRotate = (ImageView) findViewById(R.id.anim_test_rotate);
        mImageRotate.setId(0x002);
        mImageRotate.setOnClickListener(this);

        mImageScale = (ImageView) findViewById(R.id.anim_test_scale);
        mImageScale.setId(0x003);
        mImageScale.setOnClickListener(this);

        mImageTrans = (ImageView) findViewById(R.id.anim_test_translate);
        mImageTrans.setId(0x004);
        mImageTrans.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case 0x001:
                AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0.1f);
                alphaAnimation.setDuration(2000);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setRepeatCount(5);
                alphaAnimation.setRepeatMode(Animation.REVERSE);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.v("TAG", "onAnimationStart");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Log.v("TAG", "onAnimationEnd");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Log.v("TAG", "onAnimationRepeat");
                    }
                });
                mImageAlpha.startAnimation(alphaAnimation);
                break;
            case 0x002:
                RotateAnimation rotateAnimation = new RotateAnimation(
                        0, 360,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f
                );
                rotateAnimation.setDuration(3000);
                mImageRotate.startAnimation(rotateAnimation);
                break;
            case 0x003:
                ScaleAnimation scaleAnimation = new ScaleAnimation(
                        1, 1.5f, 1, 1.5f,
                        ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
                        ScaleAnimation.RELATIVE_TO_SELF, 0.5f
                );
                scaleAnimation.setDuration(3000);
                scaleAnimation.setZAdjustment(ScaleAnimation.ZORDER_TOP);
                mImageScale.startAnimation(scaleAnimation);
                break;
            case 0x004:
                AnimationSet set = new AnimationSet(false);
                RotateAnimation rotateAnimation1 = new RotateAnimation(
                        0, 30,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f
                );
                RotateAnimation rotateAnimation2 = new RotateAnimation(
                        30, 0,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f
                );
                rotateAnimation1.setDuration(1000);
                rotateAnimation2.setDuration(1000);

                set.addAnimation(rotateAnimation1);
                //set.addAnimation(rotateAnimation2);
                //set.addAnimation(rotateAnimation3);

                mImageTrans.startAnimation(set);
                break;
            default:
        }
    }
}
