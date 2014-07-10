package com.example.sundy_android_test.chapter5.appwidget_list;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

import java.util.ArrayList;

/**
 * @author xiads
 * @date 14-7-8
 */
class DataPoint {
    String title;
    String data;

    DataPoint(String title, String data) {
        this.title = title;
        this.data = data;
    }
}

public class AppWidgetListDataProvider extends ContentProvider {

    public static final Uri CONTENT_URI =
            Uri.parse("content://sam.app.widget.provider");
    public static String EXTRA_DAY_ID = "com.example.android.weatherlistwidget.day";

    public static class Columns {
        public static final String ID = "_id";
        public static final String TITLE = "title";
        public static final String DATA = "data";
    }
    private final static ArrayList<DataPoint> sData = new ArrayList<>();

    @Override
    public boolean onCreate() {
        sData.add(new DataPoint("Sam", "a good guy"));
        sData.add(new DataPoint("Jim", "a good guy"));
        sData.add(new DataPoint("May", "a good guy"));
        sData.add(new DataPoint("Mary", "a good girl"));
        sData.add(new DataPoint("Lily", "a good girl"));
        sData.add(new DataPoint("Lucy", "a good girl"));
        sData.add(new DataPoint("Maggie", "a good girl"));
        sData.add(new DataPoint("Man", "a good guy"));
        sData.add(new DataPoint("Worry", "a good guy"));
        sData.add(new DataPoint("Link", "a good guy"));
        return true;
    }

    @Override
    public synchronized Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        assert(uri.getPathSegments().isEmpty());

        final MatrixCursor c = new MatrixCursor(
                new String[]{ Columns.ID, Columns.TITLE, Columns.DATA });
        for (int i = 0; i < sData.size(); ++i) {
            final DataPoint data = sData.get(i);
            c.addRow(new Object[]{ new Integer(i), data.title, new Integer(data.data) });
        }
        return c;
    }

    @Override
    public String getType(Uri uri) {
        return "vnd.android.cursor.dir/vnd.widgetlist.data";
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
