package com.vcredit.zj.living.main.net.api;

import com.vcredit.zj.living.entities.HomePageInfo;
import com.vcredit.zj.living.entities.Live;
import com.vcredit.zj.living.entities.ResponseInfo;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by shibenli on 2016/11/16.
 */

public interface LivingService {
    final String build = "429001";

    @GET("AppNewIndex/common?_device=android&platform=android")
    Observable<ResponseInfo<HomePageInfo>> getAppNewIndexCommon(@Query("scale") String scale);

    @GET("mobile/rooms?_device=android&platform=android&_hwid=12f957357901e986&appkey=1d8b6e7d45233436&mobi_app=android&build=" + build)
    Observable<ResponseInfo<Live>> getMobileRooms(@Query("area_id") String area_id, @Query("page") int page, @Query("tag") String tag, @Query("sort") String sort);
}
