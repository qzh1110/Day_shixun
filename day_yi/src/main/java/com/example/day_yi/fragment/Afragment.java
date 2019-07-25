package com.example.day_yi.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.day_yi.R;
import com.example.day_yi.adpter.Recy_adpter;
import com.example.day_yi.bean.Home_bean;
import com.example.personi.Personi;
import com.example.view.Iview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 钱 on 2019/7/24.
 */

public class Afragment extends Fragment implements Iview{
    private View view;
    private RecyclerView mRecy;
    Personi personi;
    private ArrayList<Home_bean.RecentBean> recentBeans;
    private Recy_adpter adpter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragmet_a, null);
        initView(inflate);
        init();
        return inflate;
    }

    private void init() {
        personi = new Personi(this);
        personi.getMode();

    }

    int postion1;

    private void initView(View inflate) {
        mRecy = (RecyclerView) inflate.findViewById(R.id.recy);
        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecy.addItemDecoration(new DividerItemDecoration(getActivity(), 1));
        recentBeans = new ArrayList<>();
        adpter = new Recy_adpter(getActivity(), recentBeans);
        mRecy.setAdapter(adpter);





    }

    @Override
    public void getOk(List<Home_bean.RecentBean> list) {
        recentBeans.addAll(list);
        adpter.notifyDataSetChanged();
    }

    @Override
    public void getNo(String result) {
        Log.d(TAG, "getNo: " + result);
    }

    private static final String TAG = "AFragment";
}
