package com.vcredit.zj.living.main.delegate;

import android.view.View;
import android.widget.TextView;

import com.vcredit.zj.base.view.AppDelegate;
import com.vcredit.zj.living.R;

/**
 * Created by shibenli on 2016/11/4.
 */

public class LivingDelegate extends AppDelegate{
    @Override
    public int getRootLayoutId() {
        return R.layout.activity_living;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        TextView text = $(R.id.text11111);
        text.setText("hello");
    }
}
