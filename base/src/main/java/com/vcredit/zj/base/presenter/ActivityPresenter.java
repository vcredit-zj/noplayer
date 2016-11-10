/*
 * Copyright (c) 2015, 张涛.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vcredit.zj.base.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.vcredit.zj.base.R;
import com.vcredit.zj.base.global.App;
import com.vcredit.zj.base.view.IDelegate;

import java.io.Serializable;


/**
 * Presenter base class for Activity
 * Presenter层的实现基类
 *
 * @param <T> View delegate class type
 * @author kymjs (http://www.kymjs.com/) on 10/23/15.
 */
public abstract class ActivityPresenter<T extends IDelegate> extends RxAppCompatActivity {
    protected T viewDelegate;

    private SlidrInterface attach;

    public ActivityPresenter() {
        try {
            viewDelegate = getDelegateClass().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("create IDelegate error");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("create IDelegate error");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initSlidr();
        super.onCreate(savedInstanceState);
        createBinding(getLayoutInflater(), null, savedInstanceState);
        setContentView(viewDelegate.getRootView());
        initToolbar();
        viewDelegate.initWidget();
        bindEvenListener();
    }

    protected <D extends ViewDataBinding> D createBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return viewDelegate.create(inflater, container, savedInstanceState);
    }

    protected void bindEvenListener() {
    }

    protected void initSlidr() {
        FrameLayout content = (FrameLayout)findViewById(android.R.id.content);
        content.setBackgroundColor(getResources().getColor(R.color.activityBackground));

        if (viewDelegate.isAttach()){
            attach = Slidr.attach(this);
        }
    }

    protected void initToolbar() {
        Toolbar toolbar = viewDelegate.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (viewDelegate == null) {
            try {
                viewDelegate = getDelegateClass().newInstance();
                createBinding(getLayoutInflater(), null, savedInstanceState);
            } catch (InstantiationException e) {
                throw new RuntimeException("create IDelegate error");
            } catch (IllegalAccessException e) {
                throw new RuntimeException("create IDelegate error");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (viewDelegate.getOptionsMenuId() != 0) {
            getMenuInflater().inflate(viewDelegate.getOptionsMenuId(), menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewDelegate = null;
        attach = null;
    }

    @Override
    public Resources getResources() {
        return App.getInstance().getResources();
    }

    protected abstract Class<T> getDelegateClass();

    protected static void jumpTo(Context packageContext, Class clazz){
        Intent intent = new Intent();
        intent.setClass(packageContext, clazz);
        packageContext.startActivity(intent);
    }

    protected static void jumpTo(Context packageContext, Class clazz, String key, Serializable serializable){
        Intent intent = new Intent();
        intent.setClass(packageContext, clazz);
        intent.putExtra(key, serializable);
        packageContext.startActivity(intent);
    }


}
