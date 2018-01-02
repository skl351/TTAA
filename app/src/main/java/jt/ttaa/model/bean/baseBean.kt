package jt.ttaa.model.bean

import com.google.gson.Gson

/**
 * Created by SKL on 2017/12/25.
 */
open class baseBean {
    override fun toString(): String {
        return Gson().toJson(this)//可以直接打印json
    }
}