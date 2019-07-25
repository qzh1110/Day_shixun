package com.example.day_yi;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main3Activity extends AppCompatActivity {

    private ProgressBar mPa;
    private TextView mTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        initData();
    }

    private static final String TAG = "Main3Activity";

    private void initData() {
        String s = Environment.getExternalStorageDirectory() + File.separator + "or.apk";
        final File file = new File(s);


        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://cdn.banmi.com/banmiapp/apk/banmi_330.apk")
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {


                InputStream inputStream = response.body().byteStream();
                final long contentLength = response.body().contentLength();
                int n = 0;
                int count = 0;
                byte[] by = new byte[1024 * 20];

                FileOutputStream fileOutputStream = new FileOutputStream(file);
                while ((n = inputStream.read(by)) != -1) {
                    fileOutputStream.write(by, 0, n);

                    count += n;

                    mPa.setMax((int) contentLength);
                    mPa.setProgress((int) count);
                    final int finalCount = count;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTime.setText((finalCount * 100 / contentLength) + "%");
                            if (finalCount * 100 / contentLength == 100) {
                                mPa.setVisibility(View.GONE);
                                mTime.setVisibility(View.GONE);

                                finish();

                            }
                        }
                    });
                }



            }
        });

    }

    private void initView() {
        mPa = (ProgressBar) findViewById(R.id.pa);
        mTime = (TextView) findViewById(R.id.time);
    }
}
