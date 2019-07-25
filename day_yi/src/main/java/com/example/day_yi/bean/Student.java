package com.example.day_yi.bean;

import android.util.Log;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 钱 on 2019/6/25.
 */

@Entity
public class Student {
    @Id
    Long id;
    private String name;
    private String title;
    private String image;
    @Generated(hash = 650577952)
    public Student(Long id, String name, String title, String image) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.image = image;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImage() {
        return this.image;
    }
    public void setImage(String image) {
        this.image = image;
    }


}
