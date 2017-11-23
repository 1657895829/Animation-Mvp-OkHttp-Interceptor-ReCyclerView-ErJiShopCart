package com.bwie.duhongwang.view;
import com.bwie.duhongwang.bean.SecondBean;

//购物车详情页面View层
public interface SecondViewListener {
    public interface ModelSecondInterface{
        public void success(SecondBean bean);
        public void failed(Exception e);
    }
    public interface PresenterSecondInterface{
        public void success(SecondBean bean);
        public void failed(Exception e);
    }
}
