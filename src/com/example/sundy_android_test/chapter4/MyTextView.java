package com.example.sundy_android_test.chapter4;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import com.example.sundy_android_test.R;

/**
 * @author xiads
 * @date 14-7-5
 */
public class MyTextView extends TextView {

    private boolean mBool;
    private String mString;
    private int mInt;

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.my_attrs);
        mBool = typedArray.getBoolean(R.styleable.my_attrs_test_bool_attr, false);
        mString = typedArray.getString(R.styleable.my_attrs_test_string_attr);
        mInt = typedArray.getInt(R.styleable.my_attrs_test_integer_attr, -1);
        typedArray.recycle();
    }


    public boolean getMyBool() {
        return mBool;
    }

    public String getMyString() {
        return mString;
    }

    public int getMyInt() {
        return mInt;
    }

}
