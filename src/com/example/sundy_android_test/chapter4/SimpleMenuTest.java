package com.example.sundy_android_test.chapter4;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.example.sundy_android_test.R;
import com.example.sundy_android_test.widgets.EmptyLayout;

/**
 * @author xiads
 * @date 14-7-4
 */
public class SimpleMenuTest extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EmptyLayout _emptyLayout = new EmptyLayout(this);
        final Button _btnHideActionBar = new Button(this);
        _emptyLayout.addView(_btnHideActionBar);
        _btnHideActionBar.setText("Hide Action Bar");
        setContentView(_emptyLayout);

        final ActionBar _actionBar = getActionBar();
        _btnHideActionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_actionBar.isShowing()) {
                    _actionBar.hide();
                    _btnHideActionBar.setText("Show Action Bar");
                }else {
                    _actionBar.show();
                    _btnHideActionBar.setText("Hide Action Bar");
                }
            }
        });

        SpinnerAdapter _adapter = ArrayAdapter.createFromResource(
                this,
                R.array.actionBarData,
                android.R.layout.simple_spinner_dropdown_item);
        //_actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        _actionBar.setListNavigationCallbacks(_adapter, mOnNavigationListener);

        _actionBar.setDisplayHomeAsUpEnabled(true);
    }
    /**
     * 在这里配合Fragment，实现不同的页面导航
     */
    ActionBar.OnNavigationListener mOnNavigationListener = new ActionBar.OnNavigationListener() {

        @Override
        public boolean onNavigationItemSelected(int position, long itemId) {
            Toast.makeText(SimpleMenuTest.this,
                    "position[" + position + "],itemId[" + itemId + "]",
                    Toast.LENGTH_SHORT).show();
            return true;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.simple_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        Toast.makeText(SimpleMenuTest.this,
                "you click:" + item.getItemId(), Toast.LENGTH_SHORT).show();
        return super.onMenuItemSelected(featureId, item);
    }
}
