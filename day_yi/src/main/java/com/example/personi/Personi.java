package com.example.personi;

;

import com.example.day_yi.bean.Home_bean;
import com.example.mode.Modei;
import com.example.view.CallBack;
import com.example.view.Iview;

import java.util.List;

/**
 * Created by 钱 on 2019/6/25.
 */

public class Personi implements Iperson {

    Iview iview;
    Modei modei;
    public Personi(Iview iview) {
        this.iview = iview;
        modei=new Modei();
    }

    @Override
    public void getMode() {
            modei.getOk(new CallBack() {
                @Override
                public void getData(List<Home_bean.RecentBean> list) {
                    iview.getOk(list);
                }
            });
    }
}
