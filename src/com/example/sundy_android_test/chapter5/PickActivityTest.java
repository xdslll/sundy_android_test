package com.example.sundy_android_test.chapter5;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import com.example.sundy_android_test.widgets.EmptyLayout;

/**
 * @author xiads
 * @date 14-7-7
 */
public class PickActivityTest extends Activity {

    public static final int REQUEST_CODE = 0x001;
    private int OP_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EmptyLayout _el = new EmptyLayout(this);
        setContentView(_el);

        ArrayAdapter _adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                new String[]{"ADD SHORTCUT", "DELETE SHORTCUT"});
        _adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        Spinner _spnSelectMode = new Spinner(this);
        _spnSelectMode.setAdapter(_adapter);
        _el.addView(_spnSelectMode);
        Button _btnShowPickActivity = new Button(this);
        _btnShowPickActivity.setText("Show PickActivity");
        _el.addView(_btnShowPickActivity);

        _btnShowPickActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //指向PICK_ACTIVITY
                Intent pickIntent = new Intent(Intent.ACTION_PICK_ACTIVITY);
                //为PICK_ACTIVITY指定过滤条件，过滤出用于CREATE_SHORTCUT的Activity
                Intent mainIntent = new Intent(Intent.ACTION_CREATE_SHORTCUT);
                //设定CREATE_SHORTCUT
                pickIntent.putExtra(Intent.EXTRA_INTENT, mainIntent);
                //为PICK_ACTIVITY指定标题
                pickIntent.putExtra(Intent.EXTRA_TITLE, "Sam Title");
                //启动PICK_ACTIVITY并接收返回值
                startActivityForResult(pickIntent, REQUEST_CODE);
            }
        });

        _spnSelectMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                OP_CODE = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE:
                if(resultCode == RESULT_OK) {
                    ComponentName cmp = data.getComponent();
                    //Toast.makeText(this, cmp.getShortClassName(), Toast.LENGTH_LONG).show();
                    try {
                        Class sc = Class.forName(cmp.getClassName());
                        Intent intent = new Intent(PickActivityTest.this, sc);
                        intent.putExtra("Extra_Code", OP_CODE);
                        //intent.putExtra("Extra_Code", 1);
                        startActivity(intent);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
