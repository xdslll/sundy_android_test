package com.example.sundy_android_test.chapter4;

import android.app.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.example.sundy_android_test.R;

/**
 * @author xiads
 * @date 14-7-4
 */
public class ContextMenuTest extends ListActivity {

    private NotificationManager mNotificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] _data = {
                "Show AlertDialog",
                "Show Notification",
                "Person 3",
                "Person 4",
                "Person 5"
        };
        ArrayAdapter<String> _adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                _data);
        setListAdapter(_adapter);
        registerForContextMenu(getListView());
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position) {
            case 0:
                showDialog(1234);
                break;
            case 1:
                showNotification();
                break;
            default:
        }
        super.onListItemClick(l, v, position, id);
    }

    private void showNotification() {
        mNotificationManager = (NotificationManager)
                getSystemService(Activity.NOTIFICATION_SERVICE);
        Notification _notification = new Notification(
                R.drawable.menu01, "You got an email...", 3000);
        Intent _intent = new Intent(ContextMenuTest.this, SimpleMenuTest.class);
        PendingIntent _pendingIntent = PendingIntent.getActivity(
                ContextMenuTest.this, 0, _intent, 0);
        /*_notification.setLatestEventInfo(ContextMenuTest.this,
                "Title", "Content", _pendingIntent);*/
        RemoteViews _remoteView = new RemoteViews(
                getPackageName(), R.layout.chapter4_5);
        _notification.contentIntent = _pendingIntent;
        _notification.contentView = _remoteView;
        mNotificationManager.notify(0, _notification);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mNotificationManager.cancel(0);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 1234:
                AlertDialog _dialog = new AlertDialog.Builder(ContextMenuTest.this)
                        .setTitle("Info")
                        .setMessage("Simple Dialog")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .create();
                return _dialog;
            default:
        }
        return super.onCreateDialog(id);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.simple_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        Toast.makeText(ContextMenuTest.this,
                "you click:" + item.getItemId(), Toast.LENGTH_SHORT).show();
        return super.onMenuItemSelected(featureId, item);
    }
}
