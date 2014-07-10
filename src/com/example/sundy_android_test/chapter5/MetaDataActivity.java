package com.example.sundy_android_test.chapter5;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

/**
 * @author xiads
 * @date 14-7-7
 */
public class MetaDataActivity extends Activity {

    ActivityInfo mInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            mInfo = getPackageManager().getActivityInfo(
                    getComponentName(), PackageManager.GET_META_DATA);
            String _value = String.valueOf(mInfo.metaData.get("sam.meta.data"));
            Toast.makeText(this, "_value=" + _value, Toast.LENGTH_SHORT).show();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
