package com.ayi.copy_app.network


import jt.ttaa.network.retrofit.HttpLoggingInterceptor
import jt.ttaa.network.retrofit.ResponseConverterFactory
import jt.ttaa.utils.Sp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.RxJavaCallAdapterFactory


/**
 * Created by Administrator on 2017/1/12.
 */

class RetrofitManager() {
    var retrofit: Retrofit? = null
    val interceptor = HttpLoggingInterceptor()

    init {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        retrofit = Retrofit.Builder().baseUrl(
                HOST)
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(ResponseConverterFactory.create())
                //增加返回值为Oservable<T>的支持
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()
    }

    fun <T> create(service: Class<T>): T {
        return retrofit!!.create(service)
    }

    companion object {
        val HOST = Sp.URL
        private var retrofitManager: RetrofitManager? = null
        //一个单例模式的写法
        val instance: ApiService
            get() {
                if (retrofitManager == null) {
                    synchronized(RetrofitManager::class.java) {
                        if (retrofitManager == null) {
                            retrofitManager = RetrofitManager()
                        }
                    }
                }
                return retrofitManager!!.create(ApiService::class.java)
            }


    }

}
