package com.example.sundy_android_test.chapter5;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.sundy_android_test.widgets.EmptyLayout;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author xiads
 * @date 14-7-10
 */
public class AsyncTaskTest extends Activity {

    public static final int UPDATE_CONTENT = 0x001;
    public static final int SHOW_PROGRESS_DIALOG = 0x002;
    public static final int CLOSE_PROGRESS_DIALOG = 0x003;
    public static final int UPDATE_PROGRESS_DIALOG = 0x004;

    MyTask myTask;
    TextView mTxtResult;
    ProgressDialog pd;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case UPDATE_CONTENT:
                    String content = msg.getData().getString("data");
                    mTxtResult.setText(content);
                    break;
                case SHOW_PROGRESS_DIALOG:
                    pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    pd.show();
                    break;
                case CLOSE_PROGRESS_DIALOG:
                    pd.dismiss();
                    break;
                case UPDATE_PROGRESS_DIALOG:
                    int progress = msg.getData().getInt("progress");
                    pd.setProgress(progress);
                    break;
                default:
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Thread(new Runnable() {
            @Override
            public void run() {
                myTask = new MyTask();
                myTask.execute("http://www.baidu.com");
            }
        }).start();

        pd = new ProgressDialog(this);
        EmptyLayout emptyLayout = new EmptyLayout(this);
        setContentView(emptyLayout);

        Button btnStartTask = new Button(this);
        Button btnCancelTask = new Button(this);
        mTxtResult = new TextView(this);

        btnStartTask.setText("Start Task");
        btnCancelTask.setText("Cancel Task");
        mTxtResult.setText("No Data");
        emptyLayout.addView(btnStartTask);
        emptyLayout.addView(btnCancelTask);
        emptyLayout.addView(mTxtResult);

        btnStartTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTask.execute("http://libwww.njau.edu.cn/");
            }
        });

        btnCancelTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTask.cancel(true);
            }
        });
    }

    class MyTask extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            Log.v("TAG", "async task doInBackground");
            String result = "";
            //实例化HttpClient
            HttpClient httpClient = new DefaultHttpClient();
            //实例化GET请求
            HttpGet httpGet = new HttpGet(params[0]);
            try {
                //显示进度条对话框
                mHandler.sendEmptyMessage(SHOW_PROGRESS_DIALOG);
                //发送GET请求
                HttpResponse response = httpClient.execute(httpGet);
                //接收返回值
                HttpEntity entity = response.getEntity();
                //获取返回值的长度
                long length = entity.getContentLength();
                //传输返回值
                InputStream in = entity.getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;
                while((line = br.readLine()) != null) {
                    result += line;
                    //计算当前读取的字符数量的占比
                    float proportion = result.length() / (float) length;
                    //提示进度条更新
                    publishProgress((int) (proportion * 100));
                    Log.v("TAG", "result.length()=" + result.length());
                    Log.v("TAG", "length=" + length);
                    Log.v("TAG", "result.length() / (float) length=" + result.length() / (float) length);
                    Log.v("TAG", "(int) (proportion * 100)=" + (int) (proportion * 100));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            Log.v("TAG", "async task onPostExecute");
            //关闭进度对话框
            mHandler.sendEmptyMessage(CLOSE_PROGRESS_DIALOG);
            //使用Handler发送消息，更新UI
            /*Message msg = new Message();
            msg.what = UPDATE_CONTENT;
            Bundle bundle = new Bundle();
            bundle.putString("data", result);
            msg.setData(bundle);
            mHandler.sendMessage(msg);*/
            mTxtResult.setText(result);
        }

        @Override
        protected void onPreExecute() {
            Log.v("TAG", "async task onPreExecute");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.v("TAG", "async task onProgressUpdate");
            Message msg = new Message();
            msg.what = UPDATE_PROGRESS_DIALOG;
            Bundle bundle = new Bundle();
            bundle.putInt("progress", values[0]);
            msg.setData(bundle);
            mHandler.sendMessage(msg);
        }

        @Override
        protected void onCancelled(String result) {
            Log.v("TAG", "async task onCancelled");
        }

        @Override
        protected void onCancelled() {
            Log.v("TAG", "async task onCancelled");
        }
    }

}
