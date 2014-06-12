package com.example.sundy_android_test.chapter1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Sam
 * @since 14-6-11
 * 查看匿名内部类的信息
 */
public class AnonymousInnerClassTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layoutRoot = new LinearLayout(this);
        setContentView(layoutRoot);

        layoutRoot.setOrientation(LinearLayout.VERTICAL);
        Button button = new Button(this);
        final TextView textView = new TextView(this);
        layoutRoot.addView(button);
        layoutRoot.addView(textView);
        button.setText("查看");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append(this.getClass().getName() + "\n\n");
                textView.append(this.getClass().getInterfaces()[0].getName() + "\n\n");
                textView.append(this.getClass().getEnclosingClass().getName() + "\n\n");
                textView.append(this.getClass().isAnonymousClass() + "\n\n");

                textView.append(AnonymousInnerClassTest.this.getClass().getName() + "\n\n");
                textView.append(AnonymousInnerClassTest.this.getClass().getSuperclass().getName() + "\n\n");
                textView.append(AnonymousInnerClassTest.this.getClass().isAnonymousClass() + "\n\n");
            }
        });
    }
}
