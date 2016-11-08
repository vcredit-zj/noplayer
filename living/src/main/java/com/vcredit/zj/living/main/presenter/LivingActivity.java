package com.vcredit.zj.living.main.presenter;

import com.vcredit.zj.base.presenter.ActivityPresenter;
import com.vcredit.zj.living.main.delegate.LivingDelegate;

public class LivingActivity extends ActivityPresenter<LivingDelegate> {

    @Override
    protected Class getDelegateClass() {
        return LivingDelegate.class;
    }
}
