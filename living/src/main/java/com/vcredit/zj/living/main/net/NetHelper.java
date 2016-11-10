package com.vcredit.zj.living.main.net;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.vcredit.zj.living.global.NoPlayerApp;
import com.vcredit.zj.utils.CommonUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by shibenli on 2016/11/10.
 */

public class NetHelper {

    private static OkHttpClient mOkHttpClient;

    private static final String API_BASE_URL = "http://bilibili-service.daoapp.io/";

    private static final String MAIN_BASE_URL = "http://www.bilibili.com/";

    private static final String APP_BASE_URL = "http://app.bilibili.com/";

    private static final String LIVE_BASE_URL = "http://live.bilibili.com/";

    private static final String HOST_API_BASE_URL = "http://api.bilibili.cn/";

    private static final String BANGUMI_BASE_URL = "http://bangumi.bilibili.com/";

    private static final String SEARCH_BASE_URL = "http://s.search.bilibili.com/";

    private static final String ACCOUNT_BASE_URL = "https://account.bilibili.com/";

    private static final String USER_DETAILS_BASE_URL = "http://space.bilibili.com/";

    private static final String VIP_BASE_URL = "http://vip.bilibili.com/";

    private static final String IM9_BASE_URL = "http://www.im9.com/";

    private static final String COMMON_UA_STR = "OhMyBiliBili Android Client/2.1 (100332338@qq.com)";

    static
    {
        initOkHttpClient();
    }

    /**
     * 初始化OKHttpClient,设置缓存,设置超时时间,设置打印日志,设置UA拦截器
     */
    private static void initOkHttpClient()
    {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (mOkHttpClient == null)
        {
            synchronized (NetHelper.class)
            {
                if (mOkHttpClient == null)
                {
                    //设置Http缓存
                    Cache cache = new Cache(new File(NoPlayerApp.getInstance()
                            .getCacheDir(), "HttpCache"), 1024 * 1024 * 10);

                    mOkHttpClient = new OkHttpClient.Builder()
                            .cache(cache)
                            .addInterceptor(interceptor)
                            .addNetworkInterceptor(new CacheInterceptor())
                            .addNetworkInterceptor(new StethoInterceptor())
                            .retryOnConnectionFailure(true)
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(20, TimeUnit.SECONDS)
                            .readTimeout(20, TimeUnit.SECONDS)
                            .addInterceptor(new UserAgentInterceptor())
                            .build();
                }
            }
        }
    }

    /**
     * 添加UA拦截器，B站请求API需要加上UA才能正常使用
     */
    private static class UserAgentInterceptor implements Interceptor
    {

        @Override
        public Response intercept(Chain chain) throws IOException
        {

            Request originalRequest = chain.request();
            Request requestWithUserAgent = originalRequest.newBuilder()
                    .removeHeader("User-Agent")
                    .addHeader("User-Agent", COMMON_UA_STR)
                    .build();
            return chain.proceed(requestWithUserAgent);
        }
    }


    /**
     * 为okhttp添加缓存，这里是考虑到服务器不支持缓存时，从而让okhttp支持缓存
     */
    private static class CacheInterceptor implements Interceptor
    {

        @Override
        public Response intercept(Chain chain) throws IOException
        {

            // 有网络时 设置缓存超时时间1个小时
            int maxAge = 60 * 60;
            // 无网络时，设置超时为1天
            int maxStale = 60 * 60 * 24;
            Request request = chain.request();
            if (CommonUtils.isNetworkAvailable(NoPlayerApp.getInstance()))
            {
                //有网络时只从网络获取
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_NETWORK)
                        .build();
            } else
            {
                //无网络时只从缓存中读取
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response response = chain.proceed(request);
            if (CommonUtils.isNetworkAvailable(NoPlayerApp.getInstance()))
            {
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else
            {
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
            return response;
        }
    }
}
