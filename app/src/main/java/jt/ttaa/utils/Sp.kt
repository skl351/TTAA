package jt.ttaa.utils

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.util.Log

/**
 * Created by SKL on 2017/12/25.
 */
object Sp {

    var DEFAULT_BANNER_SIZE: Int = 0//可以设动态,主页上的轮播图相关
    var now_BANNER_SIZE: Int = 0//可以设动态,主页上的轮播图相关
    var statue = 0//被杀死
    var statue_mainactivity = 0//清空fragment
    var URL_m = ""
    var URL = "http://ta.sangeayi.com/sangeayi/public/sangeayi/"
    var first_flag = 0//0第一次，否则第二次
    var latitude: Double = 0.0
    var longitude: Double = 0.0
    var area_id: String = ""
    var place: String = ""
    fun setNull() {
        setUsername("")
        setPassword("")
        setUserid("")
        setToken("")
    }

    fun getsrcw(): Int? {
        return SharedPreferenceUtils.getInt("srcw", 1080)
    }

    fun setsrcw(srcw: Int) {
        SharedPreferenceUtils.save("srcw", srcw)
    }

    fun getversion_sam(): String {
        return SharedPreferenceUtils.getString("version_sam", "3.9")
    }

    fun setversion_sam(version_sam: String) {
        SharedPreferenceUtils.save("version_sam", version_sam)
    }

    fun setUsername(username: String) {
        SharedPreferenceUtils.save("username", username)
    }

    fun getUsername(): String {
        return SharedPreferenceUtils.getString("username", "")
    }

    fun setPassword(password: String) {
        SharedPreferenceUtils.save("password", password)
    }

    fun getPassword(): String {
        return SharedPreferenceUtils.getString("password", "")
    }

    fun getUserid(): String {
        return SharedPreferenceUtils.getString("userid", "")
    }

    fun setUserid(userid: String) {
        SharedPreferenceUtils.save("userid", userid)
    }

    fun setToken(token: String) {
        SharedPreferenceUtils.save("token", token)
    }

    fun getToken(): String {
        return SharedPreferenceUtils.getString("token", "")
    }


    val Tag = "test_log:"
    fun Klog(objects: Fragment, s: String) {
        Log.e(Tag + objects, s)
    }

    fun Klog(objects: Activity, s: String) {
        Log.e(Tag + objects, s)
    }

    /*
  得到版本号
   */
    fun getAppVersionName(context: Context): Float {
        var versionName = 0f
        try {
            val pm = context.packageManager
            val pi = pm.getPackageInfo(context.packageName, 0)
            versionName = pi.versionName.toFloat()
        } catch (e: Exception) {

        }

        return versionName
    }
}