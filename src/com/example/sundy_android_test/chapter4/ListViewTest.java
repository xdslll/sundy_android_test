package com.example.sundy_android_test.chapter4;

import android.app.ListActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import com.example.sundy_android_test.R;
import com.example.sundy_android_test.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiads
 * @date 14-6-25
 */
public class ListViewTest extends ListActivity implements Constant {

    private List<String> mData = new ArrayList<String>();
    private ArrayAdapter mAdapter;
    private EditText mEditText;
    {
        mData.add("AAA");
        mData.add("BBB");
        mData.add("CCC");
        mData.add("DDD");
        mData.add("EEE");
        mData.add("FFF");
        mData.add("GGG");
        mData.add("HHH");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter4_4);

        mAdapter = new ArrayAdapter(
                this, android.R.layout.simple_list_item_1, mData);
        setListAdapter(mAdapter);
        mEditText = (EditText) findViewById(R.id.listtest_edt);
        setEditTextListener();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mData.remove(position);
        mAdapter.notifyDataSetChanged();
    }

    private void setEditTextListener() {
        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                //mData.add(mEditText.getText().toString());
                //mAdapter.notifyDataSetChanged();
                mAdapter.add(mEditText.getText().toString());
                mEditText.setText(null);
                ListViewTest.this.setSelection(mAdapter.getCount() - 1);
                return false;
            }
        });
    }
}
