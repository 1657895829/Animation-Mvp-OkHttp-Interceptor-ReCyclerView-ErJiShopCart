package com.bwie.duhongwang;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.duhongwang.bean.ShopBean;
import com.bwie.duhongwang.presenter.MainPresenter;
import com.bwie.duhongwang.view.MainViewListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//购物车列表页面，全选、反选、单选、多选等等功能
public class ThirdActivity extends AppCompatActivity implements MainViewListener {
    @Bind(R.id.third_recyclerview)
    RecyclerView thirdRecyclerview;
    @Bind(R.id.third_allselect)
    CheckBox checkBoxAll;
    @Bind(R.id.third_totalprice)
    TextView thirdTotalprice;
    private MainPresenter presenter;
    private ShopAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);

        //关联p层
        presenter = new MainPresenter(this);
        presenter.getData();

        //设置布局管理器以及适配器
        adapter = new ShopAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        thirdRecyclerview.setLayoutManager(manager);
        thirdRecyclerview.setAdapter(adapter);

        adapter.setListener(new ShopAdapter.UpdateUiListener() {
            @Override
            public void setTotal(String total, String num, boolean allCheck) {
                checkBoxAll.setChecked(allCheck);
                thirdTotalprice.setText("总价：￥" + total);
            }
        });
    }

    @Override
    public void success(ShopBean bean) {
        adapter.add(bean);
    }

    @Override
    public void failure(Exception e) {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }

    //避免内存泄漏
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }


    @OnClick({R.id.thirdBackImage, R.id.third_allselect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.thirdBackImage:       //点击左上角返回按钮跳转至购物车详情页面
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.third_allselect:     //全选/反选按钮
                adapter.selectAll(checkBoxAll.isChecked());
                break;
        }
    }
}
