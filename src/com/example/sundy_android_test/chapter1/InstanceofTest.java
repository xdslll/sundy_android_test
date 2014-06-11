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
 * @since 14-6-11
 * 点击任一个界面元素，自动判断用户点击的是什么控件
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
     * 这里注意：一定要将CheckBox的判断放在前面，因为CheckBox是Button和TextView的子类
     * 同理，Button是TextView的子类，所以应该放在TextView前面判断
     * @param v
     */
    @Override
    public void onClick(View v) {
        if(v instanceof CheckBox) {
            CommonUtil.ShowToastMessage(this, "您点击了checkbox");
        }else if(v instanceof Button) {
            CommonUtil.ShowToastMessage(this, "您点击了button");
        }else if(v instanceof TextView) {
            CommonUtil.ShowToastMessage(this, "您点击了textview");
        }
    }

}
