package com.example.sundy_android_test.chapter1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.sundy_android_test.R;
import com.example.sundy_android_test.util.CommonUtil;
import com.example.sundy_android_test.util.Constant;

/**
 * @author Sam
 * @since v1.0
 * @date 2014-6-11
 * 遍历View时，根据View的类型绑定相应的事件
 */
public class InstanceofTest extends Activity implements View.OnClickListener, Constant {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter1_1);
        LinearLayout ll = (LinearLayout) findViewById(R.id.chapter1_1_ll);
        int childCount = ll.getChildCount();
        Log.v(DEBUG_TAG, "child count=" + childCount);
        if(childCount > 0) {
            for (int index = 0; index < childCount; index++) {
                View childView = ll.getChildAt(index);
                childView.setOnClickListener(this);
            }
        }
    }

    /**
     * @param v
     */
    @Override
    public void onClick(View v) {
        if(v instanceof CheckBox) {
            CommonUtil.ShowToastMessage(this, "this is checkbox");
        }else if(v instanceof Button) {
            CommonUtil.ShowToastMessage(this, "this is button_9");
        }else if(v instanceof TextView) {
            CommonUtil.ShowToastMessage(this, "this is textview");
        }
    }

}
