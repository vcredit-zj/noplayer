package com.vcredit.zj.living.main.presenter;

import android.os.Bundle;

import com.vcredit.zj.base.presenter.ActivityPresenter;
import com.vcredit.zj.living.R;
import com.vcredit.zj.living.main.delegate.LivingDelegate;

public class LivingActivity extends ActivityPresenter<LivingDelegate> {

    @Override
    protected Class getDelegateClass() {
        return LivingDelegate.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
