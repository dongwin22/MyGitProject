package com.example.dllo.mygitproject.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by dllo on 16/7/11.
 */
public abstract class AbsBaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
       // overridePendingTransition();
        setContentView(setLayout());
        initViews();
        initDatas();
    }

    // 绑定布局
    protected abstract int setLayout();
    // 初始化组件
    protected abstract void initViews();
    // 初始化数据
    protected abstract void initDatas();
    // 绑定id
    protected <T extends View>T ByView(int resId){
        T t = (T) findViewById(resId);
        return t;
    }
    // 简化intent跳转
    protected void goTo(Context from,Class<? extends AbsBaseActivity> to){
        Intent intent = new Intent(from,to);
        startActivity(intent);
    }

    // 代值跳转
    protected void goTo(Context from,Class<? extends AbsBaseActivity> to,Bundle values){
        Intent intent = new Intent(from,to);
        intent.putExtras(values);
        startActivity(intent);
    }
}
