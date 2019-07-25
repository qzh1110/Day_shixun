package com.example.day_yi.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day_yi.R;
import com.example.day_yi.bean.Student;


import java.util.ArrayList;

/**
 * Created by 钱 on 2019/6/25.
 */

public class Student_adpter extends RecyclerView.Adapter<Student_adpter.ViewHolder> {
    private Context context;
    private ArrayList<Student> students;

    public Student_adpter(Context context, ArrayList<Student> students) {
        this.context = context;
        this.students = students;
    }

    OnClickListener onClickListener;

    public interface OnClickListener {
        void getonlick(int postion);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(context).inflate(R.layout.item1, null);
        return new ViewHolder(inflate);
    }
    OnLongClickListener onLongClickListener;

    public interface OnLongClickListener {
        void onlong(int postion);
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Student student = students.get(position);
        holder.title.setText(student.getTitle());
        holder.name.setText(student.getName());
        RequestOptions options = new RequestOptions();
        options.circleCrop();
        Glide.with(context).load(student.getImage()).apply(options).into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.getonlick(position);
                }
            }
        });



        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onLongClickListener != null) {
                    onLongClickListener.onlong(position);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, title;
        private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.imag);

        }
    }
}
