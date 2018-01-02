package jt.ttaa.aboutPage

import android.app.Application
import android.graphics.Bitmap
import android.util.Log
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.nostra13.universalimageloader.core.assist.ImageScaleType
import jt.ttaa.R
import jt.ttaa.utils.SharedPreferenceUtils

/**
 * Created by SKL on 2017/12/25.
 */
class ayiApplication : Application() {
    companion object{
        var  instance: ayiApplication? = null
        fun  getInstance1(): ayiApplication {
            return instance!!
        }
    }
    override fun onCreate() {
        super.onCreate()
        instance=this
        SharedPreferenceUtils.init(this)
        Log.i("AyiApplication", "创建APP")
        init_image()
    }
    fun init_image(){
        val defaultOptions = DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .imageScaleType(ImageScaleType.NONE)//设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build()
        val config = ImageLoaderConfiguration.Builder(applicationContext)
                .defaultDisplayImageOptions(defaultOptions)
                .discCacheSize(50 * 1024 * 1024)
                .discCacheFileCount(100)
                .writeDebugLogs()
                .build()
        ImageLoader.getInstance().init(config)
    }
}