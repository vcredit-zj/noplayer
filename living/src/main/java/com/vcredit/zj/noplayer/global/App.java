package com.vcredit.zj.noplayer.global;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.multidex.MultiDexApplication;

import com.tencent.bugly.crashreport.CrashReport;
import com.vcredit.zj.noplayer.BuildConfig;
import com.vcredit.zj.utils.CommonUtils;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by shibenli on 2016/10/28.
 */

public class App extends MultiDexApplication {

    /**
     * 获得Application对象
     */
    private static App appInstance;

    public static App getInstance() {
        return appInstance;
    }

    private Configuration config;

    private String channel = "unknown";

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;

        initApp();
        String processName = CommonUtils.getProcessName(this, android.os.Process.myPid());
        if (processName != null) {
            boolean defaultProcess = processName.equals(BuildConfig.APPLICATION_ID);
            if (defaultProcess) {
                initAppForMainProcess();
            }
        }
    }

    protected void initApp() {
        //禁用系统默认的字体缩放
        config = new Configuration();
        config.setToDefaults();
    }

    private void initAppForMainProcess() {
        Context applicationContext = getApplicationContext();
        //初始化EventBus
        EventBus.builder().throwSubscriberException(BuildConfig.DEBUG).logNoSubscriberMessages(BuildConfig.DEBUG).installDefaultEventBus();

        //初始化Bugly
        CrashReport.initCrashReport(applicationContext, "2df8640479", BuildConfig.DEBUG);
        CrashReport.setAppChannel(applicationContext, channel);
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }
}
