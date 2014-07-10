package com.example.sundy_android_test.chapter5;

import android.app.PendingIntent;
import android.appwidget.*;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.example.sundy_android_test.R;
import com.example.sundy_android_test.launch.LaunchActivity;
import com.example.sundy_android_test.util.Constant;

/**
 * @author xiads
 * @date 14-7-7
 */
public class AppWidgetTest extends AppWidgetProvider implements Constant {

    public static final String DEBUG_NAME = "AppWidgetTest";
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        debug("onReceive");
        //Toast.makeText(context, "oh, receive message.",
        //        Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        debug("onUpdate");
        for(int i = 0; i < appWidgetIds.length; i++) {
            /*RemoteViews views = new RemoteViews(
                    context.getPackageName(), R.layout.app_widget_layout);
            views.setTextViewText(R.id.btn_app_widget_commit, "Go to commit activity.");
            //设置PendingIntent
            Intent pIntent = new Intent("sam.appwidget.receiver");
            pIntent.putExtra("data", "Sam is a good guy^_^");
            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    context, 0, pIntent, 0);
            //设置监听
            views.setOnClickPendingIntent(
                    R.id.btn_app_widget_commit, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetIds[i], views);
            debug("appWidgetIds[" + i + "]=" + appWidgetIds[i]);*/
        }
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
        debug("onAppWidgetOptionsChanged");
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        debug("onDeleted");
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        debug("onEnabled");
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        debug("onDisabled");
    }

    private void debug(String message) {
        Log.v(DEBUG_TAG, "[" + DEBUG_NAME + "]:" + message);
    }
}
