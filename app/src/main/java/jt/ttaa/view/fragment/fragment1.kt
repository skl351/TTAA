package jt.ttaa.view.fragment

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import jt.ttaa.Adapter.BannerAdapter
import jt.ttaa.R
import jt.ttaa.model.bean.item_banner
import jt.ttaa.presenter.fragment1Presenter
import jt.ttaa.utils.Sp
import jt.ttaa.view.viewInterface.fragment1Interface
import java.util.*

/**
 * Created by SKL on 2017/12/26.
 */
class fragment1 : fragment1Interface, baseFragment() {
    var fragment1presenter = fragment1Presenter(this)
    var bannerAdapter: BannerAdapter? = null
    override fun onSuccess_banan(event: List<item_banner>) {
        System.out.println("轮播图" + event)
        Sp.DEFAULT_BANNER_SIZE = event.size

        bannerAdapter = BannerAdapter(activity, event, mViewPager)
        mViewPager?.setAdapter(bannerAdapter)
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

    var mViewPager: ViewPager? = null
    fun init_view(main_view: View?) {
        mViewPager = main_view?.findViewById<View>(R.id.view_pager) as ViewPager
        fragment1presenter.get_bananimage()
        init_slideshow();
    }

    var mIsUserTouched = false
    var mTimerTask: TimerTask? = null//定时器
    var mTimer: Timer? = null
    fun init_slideshow() {
        mViewPager?.setOnTouchListener({ v, event ->
            val action = event.action
            if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE) {
                mIsUserTouched = true
            } else if (action == MotionEvent.ACTION_UP) {
                mIsUserTouched = false
            }
            false
        })
        mTimerTask = object : TimerTask() {
            override fun run() {
                if (!mIsUserTouched) {
                    if (Sp.DEFAULT_BANNER_SIZE != 0) {
                        Sp.now_BANNER_SIZE = (Sp.now_BANNER_SIZE + 1) % Sp.DEFAULT_BANNER_SIZE

                        /**
                         * Android在子线程更新UI的几种方法
                         * Handler，AsyncTask,view.post,runOnUiThread
                         */
                        if (activity != null) {
                            activity.runOnUiThread {
                                mViewPager?.setCurrentItem(Sp.now_BANNER_SIZE)
                                System.out.println("mBannerPosition" + Sp.now_BANNER_SIZE)
                            }
                        }
                    }

                }
            }
        }
        mTimer = Timer()
        mTimer?.schedule(mTimerTask, 5000, 5000)
    }
}