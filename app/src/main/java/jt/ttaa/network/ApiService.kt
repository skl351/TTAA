package com.ayi.copy_app.network

import jt.ttaa.model.bean.Result
import jt.ttaa.model.bean.item_banner
import retrofit2.http.POST
import retrofit2.http.Query
import rx.Observable


/**
 * Created by Administrator on 2017/7/14.
 */
interface ApiService {
    @POST("?service=Banner.getList&type=1")
    fun Get_bananimage(@Query("areaid") areaid: String,
                       @Query("secret_key") vnum: String): Observable<Result<List<item_banner>>>


}