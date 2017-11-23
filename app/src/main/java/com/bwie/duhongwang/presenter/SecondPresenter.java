package com.bwie.duhongwang.presenter;

import com.bwie.duhongwang.bean.SecondBean;
import com.bwie.duhongwang.model.SecondModel;
import com.bwie.duhongwang.view.SecondViewListener;

//购物车详情页面presenter层
public class SecondPresenter {
    SecondViewListener.PresenterSecondInterface  presenterSecondInterface;
    SecondModel secondModel;

    public SecondPresenter(SecondViewListener.PresenterSecondInterface  presenterSecondInterface) {
        this.presenterSecondInterface = presenterSecondInterface;
        this.secondModel = new SecondModel();
    }

    public void getData(){
        secondModel.getDataModel(new SecondViewListener.ModelSecondInterface() {
            @Override
            public void success(SecondBean bean) {
                presenterSecondInterface.success(bean);
            }

            @Override
            public void failed(Exception e) {
                presenterSecondInterface.failed(e);
            }
        });
    }

    //防止内存泄露
    public void detach(){
        presenterSecondInterface = null;
    }
}

