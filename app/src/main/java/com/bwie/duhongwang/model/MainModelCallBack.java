package com.bwie.duhongwang.model;

import com.bwie.duhongwang.bean.ShopBean;

public interface MainModelCallBack {
    public void success(ShopBean bean);
    public void failure(Exception e);

}
