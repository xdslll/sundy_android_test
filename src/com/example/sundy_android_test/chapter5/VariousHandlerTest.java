package com.example.sundy_android_test.chapter5;

import android.app.Activity;
import android.content.Context;
import android.os.*;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.sundy_android_test.widgets.EmptyLayout;

/**
 * @author xiads
 * @date 14-7-9
 */
public class VariousHandlerTest extends Activity {

    Handler mHandler;

    MyHandlerThread mHandlerThread = new MyHandlerThread("MyHandlerThread") {
        @Override
        protected void onLooperPrepared() {
            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    String content = msg.getData().getString("data");
                    Log.v("TAG", "[mHandler]content:" + content);
                }
            };
        }
    };
    Looper mLooper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EmptyLayout emptyLayout = new EmptyLayout(this);
        setContentView(emptyLayout);

        final Handler handler1 = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String content = msg.getData().getString("data");
                Log.v("TAG", "[handler1]content:" + content);
            }
        };
        final Handler handler2 = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String content = msg.getData().getString("data");
                Log.v("TAG", "[handler2]content:" + content);
            }
        };

        final TextView txtInfo = new TextView(this);
        txtInfo.setText("Title");
        txtInfo.setTextSize(25.0f);
        txtInfo.setGravity(Gravity.CENTER);
        emptyLayout.addView(txtInfo);

        Button btnStartHandlerInMain = new Button(this);
        btnStartHandlerInMain.setText("Start Handler In Main Thread");
        emptyLayout.addView(btnStartHandlerInMain);
        btnStartHandlerInMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.sendMessage(getMessage("Sam is a good worker T_T"));
                mHandler.sendMessage(getMessage("Sam is a good worker T_T"));
                //handler1.sendMessage(getMessage("Sam is a good guy ^_^"));
                //handler2.sendMessage(getMessage("Sam is a good boy -_-"));
            }
        });

        Button btnStartHandlerInThread = new Button(this);
        btnStartHandlerInThread.setText("Start Handler In Thread");
        emptyLayout.addView(btnStartHandlerInThread);
        btnStartHandlerInThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(!mHandlerThread.isAlive()) {
                    mHandlerThread.start();
                }*/
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Looper.prepare();
                        mLooper = Looper.myLooper();
                        mHandler = new Handler(mLooper) {
                            @Override
                            public void handleMessage(Message msg) {
                                super.handleMessage(msg);
                                try {
                                    Thread.sleep(5000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                String content = msg.getData().getString("data");
                                Log.v("TAG", "[mHandler]content:" + content);
                            }
                        };
                        Looper.loop();
                    }
                }).start();
            }
        });

        Button btnRemoveHandlerMessage = new Button(this);
        btnRemoveHandlerMessage.setText("Remove Handler Message");
        emptyLayout.addView(btnRemoveHandlerMessage);
        btnRemoveHandlerMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.removeMessages(0x001);
                //handler1.removeMessages(0x001);
                //handler2.removeMessages(0x001);
            }
        });


    }

    private Message getMessage(String msgContent) {
        Message msg = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("data", msgContent);
        msg.setData(bundle);
        msg.what = 0x001;
        return msg;
    }

    class MyHandlerThread extends HandlerThread {

        public MyHandlerThread(String name) {
            super(name);
        }

    }
}
