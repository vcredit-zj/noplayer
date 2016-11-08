package com.vcredit.zj.living.global;

import android.content.Context;

import com.tencent.bugly.crashreport.CrashReport;
import com.vcredit.zj.base.global.App;
import com.vcredit.zj.living.BuildConfig;

/**
 * Created by shibenli on 2016/10/28.
 */

public class NoPlayerApp extends App {

    public static NoPlayerApp getInstance() {
        return (NoPlayerApp) appInstance;
    }

    @Override
    public void onCreate() {
        //覆盖父类的APPLICATION_ID
        APPLICATION_ID = BuildConfig.APPLICATION_ID;
        super.onCreate();
    }

    protected void initApp() {
        super.initApp();
    }

    protected void initAppForMainProcess(Context applicationContext) {
        super.initAppForMainProcess(applicationContext);

        //初始化Bugly
        CrashReport.initCrashReport(applicationContext, "2df8640479", BuildConfig.DEBUG);
        CrashReport.setAppChannel(applicationContext, channel);
    }

}
