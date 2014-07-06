package com.example.sundy_android_test.chapter4.sqlite_test;

/**
 * @author xiads
 * @date 14-7-6
 */
public interface DBConts {

    public static final String DB_NAME = "test_db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_USER = "table_user";
    public static final String TABLE_BILL = "table_bill";
    public static final String COLUMN_USER_ID = "id";
    public static final String COLUMN_USER_NAME = "name";
    public static final String COLUMN_USER_SUMMARY = "summary";
    public static final String COLUMN_BILL_ID = "id";
    public static final String COLUMN_BILL_USER_ID = "user_id";
    public static final String COLUMN_BILL_AMOUNT = "amount";

    public static final String KEYWORD_AUTOINCREMENT = "AUTOINCREMENT";
    public static final String KEYWORD_PRIMARY = "PRIMARY KEY";
    public static final String KEYWORD_NOTNULL = "NOT NULL";

    public static final String CREATE_USER_SQL =
            "CREATE TABLE " + TABLE_USER +
                    "(" + COLUMN_USER_ID + " INTEGER " + KEYWORD_NOTNULL +
                    " " + KEYWORD_PRIMARY + " " + KEYWORD_AUTOINCREMENT +
                    "," + COLUMN_USER_NAME + " TEXT " + KEYWORD_NOTNULL +
                    "," + COLUMN_USER_SUMMARY + " TEXT)";
    public static final String CREATE_BILL_SQL =
            "CREATE TABLE " + TABLE_BILL +
                    "(" + COLUMN_BILL_ID + " INTEGER " + KEYWORD_NOTNULL +
                    " " + KEYWORD_PRIMARY + " " + KEYWORD_AUTOINCREMENT +
                    "," + COLUMN_BILL_USER_ID + " INTEGER" + KEYWORD_NOTNULL +
                    "," + COLUMN_BILL_AMOUNT + " REAL)";
}
