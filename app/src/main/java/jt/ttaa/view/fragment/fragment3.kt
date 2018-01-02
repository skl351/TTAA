package jt.ttaa.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jt.ttaa.R

/**
 * Created by SKL on 2017/12/26.
 */
class fragment3 :baseFragment(){
    companion object {
        var main_view: View? = null
        fun newInstance(): fragment3 {
            val fragment = fragment3()
            return fragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)
        fragment3.main_view = inflater?.inflate(R.layout.fragment3, null)
        return fragment3.main_view
    }
}