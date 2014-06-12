package com.example.sundy_android_test.chapter1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.example.sundy_android_test.util.Constant;
import com.example.sundy_android_test.widgets.InfoLayout;

/**
 * Created by xiads on 14-6-11.
 */
public class GenericTest extends Activity implements Constant {

    class Eat<T> {

        public String eatFoot(T food, int count) {
            return "you eat " + food.getClass().getSimpleName() + " for " + count + " piece(s).";
        }

    }

    class Rice {}

    class Meat {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InfoLayout layoutRoot = new InfoLayout(this);
        setContentView(layoutRoot);

        final Eat<Rice> eatRice = new Eat<Rice>();
        final Eat<Meat> eatMeat = new Eat<Meat>();

        final TextView infoText = layoutRoot.getTextView();
        layoutRoot.addButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoText.append(eatRice.eatFoot(new Rice(), 5) + "\n");
                infoText.append(eatMeat.eatFoot(new Meat(), 2) + "\n");
            }
        });

    }
}
