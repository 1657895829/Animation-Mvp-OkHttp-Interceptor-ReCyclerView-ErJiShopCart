package com.bwie.duhongwang.model;

import com.bwie.duhongwang.bean.SecondBean;
import com.bwie.duhongwang.okhttp.AbstractUiCallBack;
import com.bwie.duhongwang.okhttp.OkhttpUtils;
import com.bwie.duhongwang.view.SecondViewListener;

//购物车详情页面model层
public class SecondModel {
    public void getDataModel(final SecondViewListener.ModelSecondInterface modelSecondInterface){
        OkhttpUtils.getInstance().asy(null, "https://www.zhaoapi.cn/product/getProductDetail?pid=1", new AbstractUiCallBack<SecondBean>() {
            @Override
            public void success(SecondBean bean) {
                modelSecondInterface.success(bean);
            }

            @Override
            public void failure(Exception e) {
                modelSecondInterface.failed(e);
            }
        });
    }
}
