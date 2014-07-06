package com.example.sundy_android_test.chapter4.sqlite_test;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.example.sundy_android_test.R;
import com.example.sundy_android_test.util.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiads
 * @date 14-7-6
 */
public class UserActivity extends ListActivity
        implements Constant, DBConts{

    List<Map<String, String>> mData;
    DBHelper mDBHelper;
    SQLiteDatabase mDB;
    public static final int SHOW_ADD_DIALOG = 0x1234;
    public static final int SHOW_EDIT_DIALOG = 0x1235;
    public static final int SHOW_DEL_DIALOG = 0x1236;
    SimpleAdapter mAdapter;

    {
        mData = new ArrayList<Map<String, String>>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new SimpleAdapter(
                this, mData, android.R.layout.simple_list_item_2,
                new String[]{"name","summary"},
                new int[]{android.R.id.text1, android.R.id.text2}
        );
        setListAdapter(mAdapter);
        registerForContextMenu(getListView());
        //Create Database
        mDBHelper = new DBHelper(this, DB_NAME, null, DB_VERSION);
        mDB = mDBHelper.getWritableDatabase();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater _menuInflater = getMenuInflater();
        _menuInflater.inflate(R.menu.user_op_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater _menuInflater = getMenuInflater();
        _menuInflater.inflate(R.menu.user_edit_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add_user:
                //Toast.makeText(UserActivity.this, "add!", Toast.LENGTH_SHORT).show();
                showDialog(SHOW_ADD_DIALOG);
                break;
            case R.id.menu_del_user:
                Toast.makeText(UserActivity.this, "del!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_edit_user:
                Toast.makeText(UserActivity.this, "edit!", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder _dialog = new AlertDialog.Builder(UserActivity.this);
        switch (id) {
            case SHOW_ADD_DIALOG:
                LayoutInflater _inflater = getLayoutInflater();
                final View _dialogView = _inflater.inflate(R.layout.chapter4_7, null);
                _dialog.setView(_dialogView)
                        .setTitle("Add User")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Insert new user
                                ContentValues _userValues = new ContentValues();
                                ContentValues _billValues = new ContentValues();
                                EditText _edtUserId = (EditText) _dialogView.findViewById(R.id.c47_user_id);
                                EditText _edtUserName = (EditText) _dialogView.findViewById(R.id.c47_user_name);
                                EditText _edtUserSum = (EditText) _dialogView.findViewById(R.id.c47_user_summary);
                                EditText _edtBillAmo = (EditText) _dialogView.findViewById(R.id.c47_user_bill);
                                int _userId = Integer.valueOf(_edtUserId.getText().toString().trim());
                                String _userName = _edtUserName.getText().toString().trim();
                                String _userSum = _edtUserSum.getText().toString().trim();
                                float _billAmo = Float.valueOf(_edtBillAmo.getText().toString().trim());
                                _userValues.put(COLUMN_USER_ID, _userId);
                                _userValues.put(COLUMN_USER_NAME, _userName);
                                _userValues.put(COLUMN_USER_SUMMARY, _userSum);
                                _billValues.put(COLUMN_BILL_USER_ID, _userId);
                                _billValues.put(COLUMN_BILL_AMOUNT, _billAmo);
                                mDB.insert(TABLE_USER, null, _userValues);
                                mDB.insert(TABLE_BILL, null, _billValues);
                                Map<String, String> _map = new HashMap<String, String>();
                                _map.put("name", _userName);
                                _map.put("summary", "bill amount:" + _billAmo);
                                mData.add(_map);
                                mAdapter.notifyDataSetChanged();

                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                break;
        }
        return _dialog.create();
        //return super.onCreateDialog(id);
    }
}
