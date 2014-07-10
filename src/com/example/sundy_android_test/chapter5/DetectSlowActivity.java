package com.example.sundy_android_test.chapter5;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import com.example.sundy_android_test.chapter4.sqlite_test.DBConts;
import com.example.sundy_android_test.chapter4.sqlite_test.DBHelper;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xiads
 * @date 14-7-10
 */
public class DetectSlowActivity extends Activity implements DBConts {

    boolean DEVELOPER_MODE = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (DEVELOPER_MODE) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()   // or .detectAll() for all detectable problems
                    .penaltyDialog()
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build()
            );
        }
        super.onCreate(savedInstanceState);
        new Thread(new Runnable() {
            @Override
            public void run() {
                writeFile();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                readDB();
            }
        }).start();

    }

    private void readDB() {
        //打开数据库
        DBHelper dbHelper = new DBHelper(this, DB_NAME, null, DB_VERSION);
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        //查询数据
        Cursor cursor = database.query(DBHelper.TABLE_USER, null, null, null, null, null, null);
        cursor.moveToFirst();
        while(cursor.moveToNext()) {
            Log.v("TAG", cursor.getString(1));
        }
        cursor.close();
    }

    private void writeFile() {
        FileOutputStream fos;
        try {
            fos = openFileOutput("Test", MODE_ENABLE_WRITE_AHEAD_LOGGING);
            fos.write("Hello Sam".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
