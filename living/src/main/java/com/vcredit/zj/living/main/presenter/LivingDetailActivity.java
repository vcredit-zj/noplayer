package com.vcredit.zj.living.main.presenter;

import com.vcredit.zj.base.presenter.ActivityPresenter;
import com.vcredit.zj.living.main.delegate.LivingDetailDelegate;

/**
 * Created by shibenli on 2016/11/10.
 */

public class LivingDetailActivity extends ActivityPresenter<LivingDetailDelegate>{
    @Override
    protected Class<LivingDetailDelegate> getDelegateClass() {
        return LivingDetailDelegate.class;
    }
}
