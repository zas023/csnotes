package com.copasso.health.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected Activity mContext;

    protected static String TAG;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        // 隐藏 ActionBar
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置 TAG
        TAG = this.getClass().getSimpleName();
        //
        super.onCreate(savedInstanceState);
        setContentView(getLayoutInflater().inflate(getLayout(), null, true));
        mContext = this;
        initView();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected abstract int getLayout();
    protected abstract void initView();
}
