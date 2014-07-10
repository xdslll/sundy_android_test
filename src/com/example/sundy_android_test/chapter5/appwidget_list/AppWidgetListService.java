package com.example.sundy_android_test.chapter5.appwidget_list;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import com.example.sundy_android_test.R;
import com.example.sundy_android_test.util.CommonUtil;

import java.util.ArrayList;

/**
 * @author xiads
 * @date 14-7-8
 */
public class AppWidgetListService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new MyStackViewFactory(this.getApplicationContext(), intent);
    }
}

class MyStackViewFactory implements RemoteViewsService.RemoteViewsFactory {

    private Context mContext;
    private int mAppWidgetId;
    private static ArrayList<String> sData = new ArrayList<>();

    MyStackViewFactory(Context mContext, Intent intent) {
        this.mContext = mContext;
        mAppWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);
        sData.add("A");
        sData.add("B");
        sData.add("C");
        sData.add("D");
        sData.add("E");
        sData.add("F");
        sData.add("G");
    }

    @Override
    public void onCreate() {
        CommonUtil.Debug("[MyStackViewFactory]:onCreate");
    }

    @Override
    public void onDataSetChanged() {
        CommonUtil.Debug("[MyStackViewFactory]:onDataSetChanged");
    }

    @Override
    public void onDestroy() {
        CommonUtil.Debug("[MyStackViewFactory]:onDestroy");
    }

    @Override
    public int getCount() {
        return sData.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews rv = new RemoteViews(mContext.getPackageName(), R.layout.app_widget_list_item);
        rv.setTextViewText(R.id.widget_item, sData.get(position));
        Intent fillInIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(AppWidgetListProvider.EXTRA_ITEM, position);
        fillInIntent.putExtras(bundle);
        rv.setOnClickFillInIntent(R.id.widget_item, fillInIntent);
        return rv;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
