package com.example.sundy_android_test.chapter5.appwidget_list;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import com.example.sundy_android_test.R;
import com.example.sundy_android_test.util.Constant;

/**
 * @author xiads
 * @date 14-7-8
 */
public class AppWidgetListProvider extends AppWidgetProvider implements Constant {

    public static final String DEBUG_NAME = "AppWidgetAlarmTest";
    public static final String EXTRA_ITEM = "sam.appwidget.extra.item";

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        debug("onReceive");
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        //显示ListView
        for(int i = 0; i < appWidgetIds.length; i++) {
            RemoteViews rv = buildLayout(context, appWidgetIds[i]);
            appWidgetManager.updateAppWidget(appWidgetIds[i], rv);
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        debug("onUpdate");
    }

    private RemoteViews buildLayout(Context context, int appWidgetId) {
        Intent adapterIntent = new Intent(context, AppWidgetListService.class);
        adapterIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        adapterIntent.setData(Uri.parse(adapterIntent.toUri(Intent.URI_INTENT_SCHEME)));
        RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.app_widget_list);
        rv.setRemoteAdapter(R.id.lsv_app_widget_list, adapterIntent);
        rv.setEmptyView(R.id.lsv_app_widget_list, R.id.txt_app_widget_list_empty);
        return rv;
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
