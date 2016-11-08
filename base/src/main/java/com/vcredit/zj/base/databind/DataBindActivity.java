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
package com.vcredit.zj.base.databind;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.vcredit.zj.base.presenter.ActivityPresenter;
import com.vcredit.zj.base.view.IDelegate;

/**
 * 集成数据-视图绑定的Activity基类(Presenter层)
 *
 * @param <T> View层代理类
 * @param <D> DataBinding
 * @author kymjs (http://www.kymjs.com/) on 10/23/15.
 */
public abstract class DataBindActivity<T extends IDelegate, D extends ViewDataBinding> extends
        ActivityPresenter<T> {
    protected D binding;

    @Override
    protected D createBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = super.createBinding(inflater, container, savedInstanceState);
        return binding;
    }
}
