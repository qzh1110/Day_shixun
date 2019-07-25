package com.example.day_yi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Main4Activity extends AppCompatActivity {

    private ImageView mImm;
    private TextView mName1;
    private TextView mTitle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initView();
    }

    private void initView() {
        mImm = (ImageView) findViewById(R.id.imm);
        mName1 = (TextView) findViewById(R.id.name1);
        mTitle2 = (TextView) findViewById(R.id.title2);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String name = bundle.getString("name");
        String image = bundle.getString("image");
        String title = bundle.getString("title");


        mName1.setText(name);
        mTitle2.setText(title);
        Glide.with(this).load(image).into(mImm);
    }
}
