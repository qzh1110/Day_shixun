package com.example.mode;


import android.util.Log;


import com.example.day_yi.bean.Apisy;
import com.example.day_yi.bean.Home_bean;
import com.example.view.CallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 钱 on 2019/6/25.
 */

public class Modei implements Imode {
    private static final String TAG = "Modei";

    @Override
    public void getOk(final CallBack callBack) {

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Apisy.url)
                .build();

        retrofit.create(Apisy.class)
                .getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Home_bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Home_bean value) {
                        callBack.getData(value.getRecent());
                        Log.d(TAG, "onNext: " + value);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getNo(String result) {

    }
}
