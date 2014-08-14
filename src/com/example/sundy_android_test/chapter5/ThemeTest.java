package com.example.sundy_android_test.chapter5;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.sundy_android_test.R;

/**
 * @author xiads
 * @date 14-7-10
 */
public class ThemeTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        //设置自定义标题
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.custom_title_controller);
        //设置自定义标题的样式
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);

        final TextView txtTitle = (TextView) findViewById(R.id.txt_custom_title);
        final EditText edtTitleName = (EditText) findViewById(R.id.edt_custom_title);
        Button btnChangeTitle = (Button) findViewById(R.id.btn_set_custom_title);
        btnChangeTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtTitleName.getText().toString();
                txtTitle.setText(title);
            }
        });
        */

        //设置Dialog Activity
        setContentView(R.layout.custom_dialog_title);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND,
                WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        /*ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.filled_box));
        setContentView(imageView);*/

    }
}
