package com.example.sundy_android_test.chapter4;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.widget.Toast;
import com.example.sundy_android_test.R;

/**
 * @author xiads
 * @date 14-7-5
 */
public class PreActivityTest extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
        Preference pre_wifi = findPreference("pre_wifi");
        pre_wifi.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Toast.makeText(PreActivityTest.this,
                        preference.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        this.openOrCreateDatabase("a", SQLiteDatabase.OPEN_READONLY, null);

    }
}
