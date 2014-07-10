package com.example.sundy_android_test.chapter5;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.example.sundy_android_test.R;
import com.example.sundy_android_test.launch.LaunchActivity;

/**
 * @author xiads
 * @date 14-7-7
 */
public class AppWidgetConfigure extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_widget_configure);
        final EditText _edtName = (EditText) findViewById(R.id.edt_app_widget_conf_name);
        Button _btnDone = (Button) findViewById(R.id.btn_app_widget_done);
        _btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //定义上下文
                Context _context = AppWidgetConfigure.this;
                //获取AppWidgetId
                Intent _intent = getIntent();
                int _appWidgetId = _intent.getExtras().getInt(
                        AppWidgetManager.EXTRA_APPWIDGET_ID,
                        AppWidgetManager.INVALID_APPWIDGET_ID);
                //获取AppWidgetManager
                AppWidgetManager _appWidgetManager =
                        AppWidgetManager.getInstance(_context);
                //获取RemoteViews
                RemoteViews _views = new RemoteViews(
                        getPackageName(), R.layout.app_widget_layout);
                //获取用户输入的文本
                String _text = _edtName.getText().toString().trim();
                Intent _pIntent = new Intent("sam.appwidget.commit");
                _pIntent.putExtra("data", "Sam is a good guy^_^");
                _pIntent.addCategory(Intent.CATEGORY_DEFAULT);
                PendingIntent _pendingIntent = PendingIntent.getActivity(
                        _context, 0, _pIntent, 0);
                _views.setOnClickPendingIntent(
                        R.id.btn_app_widget_commit, _pendingIntent);
                //更新RemoteViews
                _views.setTextViewText(R.id.btn_app_widget_commit, _text);
                //更新AppWidget界面
                _appWidgetManager.updateAppWidget(_appWidgetId, _views);
                //返回设置完毕的信息
                Intent _returnIntent = new Intent();
                _returnIntent.putExtra(
                        AppWidgetManager.EXTRA_APPWIDGET_ID, _appWidgetId);
                setResult(RESULT_OK, _returnIntent);
                //关闭Activity
                Toast.makeText(_context, "设置成功!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
