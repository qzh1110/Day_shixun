package com.example.day_yi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



import com.example.day_yi.adpter.Fragment_adpter;
import com.example.day_yi.fragment.Afragment;
import com.example.day_yi.fragment.Bfragment;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ArrayList<Fragment> fragmentArrayList;
    private Fragment_adpter adpter;
    private ViewPager mViewpag;
    private TextView mTt;
    private TabLayout mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {


        mViewpag = (ViewPager) findViewById(R.id.viewpag);
        mTab = (TabLayout) findViewById(R.id.tab);
        fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new Afragment());
        fragmentArrayList.add(new Bfragment());


        adpter = new Fragment_adpter(getSupportFragmentManager(), fragmentArrayList);

        mViewpag.setAdapter(adpter);
        mTab.setupWithViewPager(mViewpag);
        mTab.getTabAt(0).setText("页面").setIcon(R.drawable.select);
        mTab.getTabAt(1).setText("收藏").setIcon(R.drawable.select);

        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewpag.setCurrentItem(tab.getPosition());

                if (tab.isSelected() == true&&tab.getPosition()==1) {
                    startActivity(new Intent(Main2Activity.this, Main3Activity.class));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mViewpag.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));

    }
}
