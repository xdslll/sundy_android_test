package com.example.sundy_android_test.chapter5;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.sundy_android_test.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author xiads
 * @date 14-7-8
 */
public class SimpleThreadTest extends Activity {

    TextView mTextView;
    Button mButton;
    ImageView mImageView;
    Drawable mDrawable;
    public static final String IMAGE_URL =
            "http://su.bdimg.com/static/superplus/img/logo_white.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_simple_test);
        mTextView = (TextView) findViewById(R.id.txt_thread_simple_test);
        mButton = (Button) findViewById(R.id.btn_thread_simple_test);
        mImageView = (ImageView) findViewById(R.id.imv_thread_simple_test);

        //this.runOnUiThread(r1);
        //this.runOnUiThread(r2);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //方法1：阻塞UI线程（不推荐，容易造成ANR），该方法在4.0以后的版本已不可使用，会造成android.os.NetworkOnMainThreadException
                /*Drawable drawable = downloadImage();
                mImageView.setImageDrawable(drawable);*/
                //方法2：在子线程中执行操作，该方法会报错，因为在非UI线程操作UI，报错为：android.view.ViewRootImpl$CalledFromWrongThreadException: Only the original thread that created a view hierarchy can touch its views.
                /*new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Drawable drawable = downloadImage();
                        mImageView.setImageDrawable(drawable);
                    }
                }).start();*/
                //解决方案1：在子线程中下载，并通过UI的post方法交互
                /*new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final Drawable drawable = downloadImage();
                        mImageView.post(new Runnable() {
                            @Override
                            public void run() {
                                mImageView.setImageDrawable(drawable);
                            }
                        });
                    }
                }).start();*/
                //解决方案2：AsyncTask处理
                new DownloadTask().execute(IMAGE_URL);
            }
        });

    }

    class DownloadTask extends AsyncTask<String, Void, Drawable> {

        @Override
        protected Drawable doInBackground(String... params) {
            return downloadImage();
        }

        @Override
        protected void onPostExecute(Drawable drawable) {
            if(drawable != null)
                mImageView.setImageDrawable(drawable);
        }
    }

    Runnable r1 = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mTextView.setText("Hello Sam...");
        }
    };

    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            mDrawable = downloadImage();
        }
    };

    private Drawable downloadImage() {
        try {
            URL url = new URL(IMAGE_URL);
            Drawable drawable = Drawable.createFromStream(
                    url.openStream(), "logo.png");
            return drawable;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
