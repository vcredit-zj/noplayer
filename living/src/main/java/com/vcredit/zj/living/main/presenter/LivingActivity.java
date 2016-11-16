package com.vcredit.zj.living.main.presenter;

import android.view.View;

import com.vcredit.zj.base.presenter.ActivityPresenter;
import com.vcredit.zj.living.R;
import com.vcredit.zj.living.entities.HomePageInfo;
import com.vcredit.zj.living.entities.ResponseInfo;
import com.vcredit.zj.living.main.delegate.LivingDelegate;
import com.vcredit.zj.living.main.net.NetHelper;
import com.vcredit.zj.utils.CommonUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LivingActivity extends ActivityPresenter<LivingDelegate> implements View.OnClickListener{

    @Override
    protected Class getDelegateClass() {
        return LivingDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        viewDelegate.setOnClickListener(this, R.id.jump, R.id.get);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jump:{
                jumpTo(this, LivingDetailActivity.class);
            }
            break;
            case R.id.get: {
                NetHelper.getLivingService().getAppNewIndexCommon("xxhdpi")
                        .compose(this.bindToLifecycle())
                        .map(ResponseInfo::getData)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext(dataBean -> {
                            CommonUtils.LOG_D(getDelegateClass(), dataBean.toString());
                        })
                        .map(HomePageInfo::getPartitions)
                        .subscribe(dataBean -> {
                            CommonUtils.LOG_D(getDelegateClass(), dataBean.toString());
                        }, Throwable::printStackTrace);
            }
            break;
        }
    }
}
