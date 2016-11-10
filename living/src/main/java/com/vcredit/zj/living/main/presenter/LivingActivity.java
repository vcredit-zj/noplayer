package com.vcredit.zj.living.main.presenter;

import android.os.Bundle;
import android.view.View;

import com.vcredit.zj.base.presenter.ActivityPresenter;
import com.vcredit.zj.living.R;
import com.vcredit.zj.living.main.delegate.LivingDelegate;

public class LivingActivity extends ActivityPresenter<LivingDelegate> implements View.OnClickListener{

    @Override
    protected Class getDelegateClass() {
        return LivingDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        viewDelegate.setOnClickListener(this, R.id.jump);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jump:{
                jumpTo(this, LivingDetailActivity.class);
            }
        }
    }
}
