package com.vcredit.zj.base.global;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.multidex.MultiDexApplication;

import com.vcredit.zj.base.BuildConfig;
import com.vcredit.zj.utils.CommonUtils;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by shibenli on 2016/10/28.
 */

public abstract class App extends MultiDexApplication {
    public static String APPLICATION_ID = BuildConfig.APPLICATION_ID;

    /**
     * 获得Application对象
     */
    protected static App appInstance;

    public static App getInstance() {
        return appInstance;
    }

    protected Configuration config;

    protected String channel = "unknown";

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;

        initApp();
        String processName = CommonUtils.getProcessName(this, android.os.Process.myPid());
        if (processName != null) {
            Context applicationContext = getApplicationContext();
            boolean defaultProcess = processName.equals(BuildConfig.APPLICATION_ID);
            if (defaultProcess) {
                initAppForMainProcess(applicationContext);
            }
        }
    }

    protected void initApp() {
        //禁用系统默认的字体缩放
        config = new Configuration();
        config.setToDefaults();
    }

    protected void initAppForMainProcess(Context applicationContext) {
        //初始化EventBus
        EventBus.builder().throwSubscriberException(BuildConfig.DEBUG).logNoSubscriberMessages(BuildConfig.DEBUG).installDefaultEventBus();
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }
}
