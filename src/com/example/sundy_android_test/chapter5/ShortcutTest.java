package com.example.sundy_android_test.chapter5;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.example.sundy_android_test.R;
import com.example.sundy_android_test.launch.LaunchActivity;

/**
 * @author xiads
 * @date 14-7-7
 */
public class ShortcutTest extends Activity {

    private static final String CREATE_SHORTCUT_ACTION =
            "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final String DROP_SHORTCUT_ACTION =
            "com.android.launcher.action.UNINSTALL_SHORTCUT";
    private static final String SHORTCUT_NAME = "Sam Shortcut";
    private static final String TARGET_INTENT_ACTION =
            "com.android.action.test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int code = (Integer) intent.getExtras().get("Extra_Code");
        //Toast.makeText(this, code + "", Toast.LENGTH_SHORT).show();
        switch (code) {
            case 0:
                setUpShortCut();
                break;
            case 1:
                tearDownShortCut();
                break;
            default:
        }
        finish();
    }

    /**
     * 创建桌面快捷方式
     */
    private void setUpShortCut() {
        //指定Intent的Action为：CREATE_SHORTCUT_ACTION
        Intent intent = new Intent(CREATE_SHORTCUT_ACTION);
        // 设置快捷方式图片
        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                Intent.ShortcutIconResource.fromContext(this, R.drawable.menu01));
        // 设置快捷方式名称
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, SHORTCUT_NAME);
        // 设置是否允许重复创建快捷方式 false表示不允许
        intent.putExtra("duplicate", false);
        // 设置快捷方式要打开的intent
        // 第一种方法创建快捷方式要打开的目标intent
        Intent targetIntent = new Intent(ShortcutTest.this, LaunchActivity.class);
        targetIntent.setAction(TARGET_INTENT_ACTION);
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, targetIntent);
        // 发送广播
        sendBroadcast(intent);
    }

    /**
     * 删除桌面快捷方式
     */
    private void tearDownShortCut() {
        Toast.makeText(ShortcutTest.this,
                "start uninstall shortcut...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(DROP_SHORTCUT_ACTION);
        // 指定要删除的shortcut名称
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, SHORTCUT_NAME);
        // 设置快捷方式要打开的intent
        // 第一种方法创建快捷方式要打开的目标intent
        Intent targetIntent = new Intent(ShortcutTest.this, LaunchActivity.class);
        targetIntent.setAction(TARGET_INTENT_ACTION);
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, targetIntent);
        sendBroadcast(intent);
    }
}
