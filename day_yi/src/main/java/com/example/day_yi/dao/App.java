package com.example.day_yi.dao;

import android.app.Application;

/**
 * Created by 钱 on 2019/6/25.
 */

public class App extends Application {
    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static App getApp() {
        return app;
    }
}
