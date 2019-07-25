package com.example.day_yi.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day_yi.R;
import com.example.day_yi.bean.Home_bean;
import com.example.day_yi.bean.Student;
import com.example.day_yi.dao.Db_util;


import java.util.ArrayList;

/**
 * Created by 钱 on 2019/6/25.
 */

public class Recy_adpter extends RecyclerView.Adapter<Recy_adpter.ViewHolder> {
    private Context contextl;
    private ArrayList<Home_bean.RecentBean> recentBeans;

    public Recy_adpter(Context contextl, ArrayList<Home_bean.RecentBean> recentBeans) {
        this.contextl = contextl;
        this.recentBeans = recentBeans;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(contextl).inflate(R.layout.item, null);

        return new ViewHolder(inflate);
    }

    OnClickListener onClickListener;

    public interface OnClickListener {
        void onclick(int postiion);
    }




    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Home_bean.RecentBean bean = recentBeans.get(position);
        holder.name.setText(bean.getTitle());
        holder.title.setText(bean.getUrl());
        RequestOptions options = new RequestOptions();
        options.circleCrop();

        Glide.with(contextl).load(bean.getThumbnail()).apply(options).into(holder.imag);
       holder.rd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Home_bean.RecentBean bean = recentBeans.get(position);
               String thumbnail = bean.getThumbnail();
               String title = bean.getTitle();
               String url = bean.getUrl();
               Student student = new Student(null, title, url, thumbnail);
               Db_util.getDb_util().insert(student);
               Toast.makeText(contextl, "插入成功", Toast.LENGTH_SHORT).show();
           }
       });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onclick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return recentBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, title;
        private ImageView imag;
        private CheckBox rd;

        public ViewHolder(View itemView) {
            super(itemView);
            rd = itemView.findViewById(R.id.cx);
            name = itemView.findViewById(R.id.name);
            title = itemView.findViewById(R.id.title);
            imag = itemView.findViewById(R.id.imag);

        }
    }
}
