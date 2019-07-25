package com.example.day_yi;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 欢迎来到积云教育
     */
    private TextView mTv;
    private ImageView mIm;
    /**
     * 跳过
     */
    private Button mBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mIm = (ImageView) findViewById(R.id.im);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set);

        mIm.startAnimation(animation);

        mTv.startAnimation(animation);


        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        }.start();


        mBt = (Button) findViewById(R.id.bt);
        mBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt:
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                break;
        }
    }
}
