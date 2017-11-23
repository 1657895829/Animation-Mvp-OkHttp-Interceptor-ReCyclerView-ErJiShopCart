package com.bwie.duhongwang.view;

import com.bwie.duhongwang.bean.ShopBean;
//view层
public interface MainViewListener {
    public void success(ShopBean bean);
    public void failure(Exception e);

}
