package com.bwie.duhongwang.model;

import com.bwie.duhongwang.bean.ShopBean;
import com.bwie.duhongwang.okhttp.AbstractUiCallBack;
import com.bwie.duhongwang.okhttp.OkhttpUtils;

//model层
public class MainModel {
    //获取购物车数据请求接口
    public void getData(final MainModelCallBack callBack){
        OkhttpUtils.getInstance().asy(null, "https://www.zhaoapi.cn/product/getCarts?uid=71", new AbstractUiCallBack<ShopBean>() {
            @Override
            public void success(ShopBean bean) {
                callBack.success(bean);
            }
            @Override
            public void failure(Exception e) {
                callBack.failure(e);
            }
        });
    }
}
