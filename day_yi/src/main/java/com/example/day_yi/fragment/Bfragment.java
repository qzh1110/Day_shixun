package com.example.day_yi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.day_yi.Main4Activity;
import com.example.day_yi.R;
import com.example.day_yi.adpter.Student_adpter;
import com.example.day_yi.bean.Student;
import com.example.day_yi.dao.Db_util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 钱 on 2019/7/24.
 */

public class Bfragment extends Fragment {
    private View view;
    private RecyclerView mRecy;
    private ArrayList<Student> students;
    private Student_adpter adpter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragmet_b, null);
        initView(inflate);
        return inflate;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            init();
        } else if (students != null && students.size() > 0) {
            students.clear();
        }
    }

    private void init() {
        List<Student> select = Db_util.getDb_util().select();
        students.addAll(select);
        adpter.notifyDataSetChanged();

    }

    private void initView(View inflate) {
        mRecy = (RecyclerView) inflate.findViewById(R.id.recy);
        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        students = new ArrayList<>();
        adpter = new Student_adpter(getActivity(), students);
        mRecy.setAdapter(adpter);

        adpter.setOnLongClickListener(new Student_adpter.OnLongClickListener() {
            @Override
            public void onlong(int postion) {
                Student student = students.get(postion);
                Db_util.getDb_util().delete(student);
                students.remove(student);
                Toast.makeText(getActivity(), "删除成功", Toast.LENGTH_SHORT).show();
                adpter.notifyDataSetChanged();

            }
        });

        adpter.setOnClickListener(new Student_adpter.OnClickListener() {
            @Override
            public void getonlick(int postion) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), Main4Activity.class);
                Bundle bundle = new Bundle();
                Student student = students.get(postion);
                String name = student.getName();
                String image = student.getImage();
                String title = student.getTitle();
                bundle.putString("name", name);
                bundle.putString("image", image);
                bundle.putString("title", title);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
