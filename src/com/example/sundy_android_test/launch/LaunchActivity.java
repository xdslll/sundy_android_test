package com.example.sundy_android_test.launch;

import android.app.ListActivity;
import android.content.Intent;
import android.os.*;
import android.os.Process;
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
        Log.i(DEBUG_TAG, "Launch Activity onCreate.");
        super.onPause();
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
        //通过反射启动Activity
        if(!prefix.endsWith(".")) prefix += ".";
        String className = prefix + activityNames[position];
        Log.v(DEBUG_TAG, className);

        Intent intent = new Intent();
        intent.setClassName(LaunchActivity.this, className);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(DEBUG_TAG, "Launch Activity onDestroy.");
        //System.exit(0);
        //Process.killProcess(Process.myPid());
    }

    @Override
    protected void onPause() {
        Log.i(DEBUG_TAG, "Launch Activity onPause.");
        super.onPause();
    }

    @Override
    protected void onStart() {
        Log.i(DEBUG_TAG, "Launch Activity onPause.");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.i(DEBUG_TAG, "Launch Activity onStop.");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.i(DEBUG_TAG, "Launch Activity onResume.");
        super.onResume();
    }
}
