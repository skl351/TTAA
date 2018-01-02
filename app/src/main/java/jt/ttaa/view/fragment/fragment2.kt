package jt.ttaa.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jt.ttaa.R

/**
 * Created by SKL on 2017/12/26.
 */
class fragment2 :baseFragment(){
    companion object {
        var main_view: View? = null
        fun newInstance(): fragment2 {
            val fragment = fragment2()
            return fragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)
        fragment2.main_view = inflater?.inflate(R.layout.fragment2, null)
        return fragment2.main_view
    }
}