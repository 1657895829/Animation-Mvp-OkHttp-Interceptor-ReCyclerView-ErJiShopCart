package com.bwie.duhongwang.presenter;

import com.bwie.duhongwang.bean.ShopBean;
import com.bwie.duhongwang.model.MainModel;
import com.bwie.duhongwang.model.MainModelCallBack;
import com.bwie.duhongwang.view.MainViewListener;
//Presenter层
public class MainPresenter {
    private MainViewListener listener;
    private MainModel mainModel;
    public MainPresenter(MainViewListener listener){
        this.listener = listener ;
        this.mainModel = new MainModel();
    }


    public void getData(){


        mainModel.getData(new MainModelCallBack() {

            @Override
            public void success(ShopBean bean) {

                if(listener != null){
                    listener.success(bean);
                }

            }

            @Override
            public void failure(Exception e) {

                if(listener != null){
                    listener.failure(e);
                }
            }
        });
    }


    /**
     * 防止内存泄漏
     */
    public void detach(){
        listener = null;
    }

}
