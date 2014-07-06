package com.example.sundy_android_test.chapter4;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.*;
import com.example.sundy_android_test.R;

/**
 * @author xiads
 * @date 14-6-24
 */
public class ButtonTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter4_3);
        getToggleButton();
        getRadioButton();
    }

    private void getToggleButton() {
        ToggleButton toggleButton =
                (ToggleButton) findViewById(R.id.chapter4_3_tb);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(ButtonTest.this, "ON!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ButtonTest.this, "OFF!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isPlaying = false;
    private void getRadioButton() {
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.MusicList_RadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.MusicList_RadioGroup_playAndpuse:
                        Toast.makeText(ButtonTest.this,
                                "isPlaying:" + isPlaying, Toast.LENGTH_SHORT).show();
                        RadioButton radioButton = (RadioButton)
                                findViewById(R.id.MusicList_RadioGroup_playAndpuse);
                        if(isPlaying) {
                            setRadioDrawable(R.drawable.plus, radioButton);
                            isPlaying = false;
                        }else {
                            setRadioDrawable(R.drawable.up, radioButton);
                            isPlaying = true;
                        }
                        radioGroup.clearCheck();
                        break;
                }
            }
        });
    }

    private void setRadioDrawable(int resId, RadioButton radioButton) {
        Drawable drawable = getResources().getDrawable(resId);
        /*drawable.setBounds(0, 0,
                drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight());*/
        radioButton.setButtonDrawable(drawable);
    }
}
