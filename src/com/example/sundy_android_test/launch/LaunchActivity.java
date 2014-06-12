package com.example.sundy_android_test.launch;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.example.sundy_android_test.R;
import com.example.sundy_android_test.chapter1.AnonymousInnerClassTest;
import com.example.sundy_android_test.chapter1.ArrayTest;
import com.example.sundy_android_test.chapter1.GenericTest;
import com.example.sundy_android_test.chapter1.InstanceofTest;
import com.example.sundy_android_test.util.Constant;

/**
 * Start Activity
 */
public class LaunchActivity extends ListActivity
        implements AdapterView.OnItemClickListener, Constant {

    String[] activityNames;
    String prefix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityNames = this.getResources().getStringArray(R.array.launchActivities);
        prefix = this.getResources().getString(R.string.launchPackage);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this, android.R.layout.simple_list_item_1, activityNames);
        this.setListAdapter(adapter);
        this.getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try {
            //通过反射启动Activity
            if(!prefix.endsWith(".")) prefix += ".";
            String className = prefix + activityNames[position];
            Log.v(DEBUG_TAG, className);

            Class clazz = Class.forName(className);
            Intent intent = new Intent(LaunchActivity.this, clazz);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
