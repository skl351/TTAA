package jt.ttaa.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jt.ttaa.R
import jt.ttaa.customview.WebViewActivity
import jt.ttaa.customview.banner.BannerLayout
import jt.ttaa.model.bean.item_banner
import jt.ttaa.presenter.fragment1Presenter
import jt.ttaa.utils.Sp
import jt.ttaa.view.viewInterface.fragment1Interface
import kotlin.collections.ArrayList

/**
 * Created by SKL on 2017/12/26.
 */
class fragment1 : fragment1Interface, baseFragment() {
    var fragment1presenter = fragment1Presenter(this)

    override fun onSuccess_banan(event: List<item_banner>) {
        System.out.println("轮播图" + event)
        Sp.DEFAULT_BANNER_SIZE = event.size

        mViewPager?.setViewUrls(event)
        mViewPager?.setOnBannerItemClickListener({ i ->

            val intent = Intent(activity, WebViewActivity::class.java)
            intent.putExtra("url", event.get(i).link)
            intent.putExtra("title", event.get(i).title)

            activity.startActivity(intent)


        })
//        progressBar1?.visibility = View.GONE
    }


    override fun showToast(a: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    companion object {
        var main_view: View? = null
        fun newInstance(): fragment1 {
            val fragment = fragment1()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)
        if (Sp.statue_mainactivity == 1) {
            return null
        }
        main_view = inflater?.inflate(R.layout.fragment1, null)
        init_view(main_view)//初始化界面
        return main_view
    }

    var mViewPager: BannerLayout? = null
    fun init_view(main_view: View?) {
        mViewPager = main_view?.findViewById<View>(R.id.view_pager) as BannerLayout
        fragment1presenter.get_bananimage()

    }


}