package com.example.view;



import com.example.day_yi.bean.Home_bean;

import java.util.List;

/**
 * Created by 钱 on 2019/6/25.
 */

public interface Iview {

    void getOk(List<Home_bean.RecentBean> list);

    void getNo(String result);


}
