package com.example.sundy_android_test.launch;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.example.sundy_android_test.chapter1.InstanceofTest;

/**
 * Æô¶¯Activity
 */
public class LaunchActivity extends ListActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        this, android.R.layout.simple_list_item_1, activityNames);
        this.setListAdapter(adapter);
        this.getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(LaunchActivity.this, activityClasses[position]);
        startActivity(intent);
    }

    String[] activityNames = {
            "InstanceofTest"
    };
    Class[] activityClasses = new Class[]{
            InstanceofTest.class
    };
}
