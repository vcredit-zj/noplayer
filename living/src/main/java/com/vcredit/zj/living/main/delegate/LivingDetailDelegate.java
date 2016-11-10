package com.vcredit.zj.living.main.delegate;

import com.vcredit.zj.base.view.AppDelegate;
import com.vcredit.zj.living.R;

/**
 * Created by shibenli on 2016/11/10.
 */

public class LivingDetailDelegate extends AppDelegate {
    @Override
    public int getRootLayoutId() {
        return R.layout.activity_living_detail;
    }

    @Override
    public boolean isAttach() {
        return true;
    }
}
