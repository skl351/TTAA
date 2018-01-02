package jt.ttaa.view.activity

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.DisplayMetrics
import android.view.View
import com.zhy.autolayout.AutoLayoutActivity
import jt.ttaa.R
import jt.ttaa.customview.Bottom_view
import jt.ttaa.model.bean.tabLayout
import jt.ttaa.utils.Sp
import jt.ttaa.view.fragment.fragment1
import jt.ttaa.view.fragment.fragment2
import jt.ttaa.view.fragment.fragment3
import jt.ttaa.view.fragment.fragment4
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : Bottom_view.OnTabSelectedListener, AutoLayoutActivity() {
    override fun onTabSelected(position: Int) {
        if (fragments != null) {
//            if (position > 0 && position < 4) {
//                if (Sp.getUsername().equals("") || Sp.getPassword().equals("")) {
//                    val intent = Intent(this, LoginAvtivity::class.java)
//                    startActivity(intent)
//                    return
//                }
//            }
            if (postion_sign != position) {
                if (position < fragments!!.size) {
                    val fm = supportFragmentManager
                    val ft = fm.beginTransaction()
                    val fragment = fragments!![position]
                    ft.hide(fragments!![postion_sign])
                    if (!fragment.isAdded) {
                        ft.add(R.id.layFrame, fragment)
                    } else {
                        ft.show(fragment)
                    }
                    postion_sign = position
                    ft.commitAllowingStateLoss()
                }
            }

        }
    }

    override fun onTabUnselected(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTabReselected(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun init_width(){
        val outMetrics = DisplayMetrics()
        window.windowManager.defaultDisplay.getMetrics(outMetrics)
        Sp.setsrcw(outMetrics.widthPixels)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init_width()
        setContentView(R.layout.activity_main)
        Sp.statue = 1//正常-这个操作用来判断被后台杀死后重启的效果
        Sp.statue_mainactivity = 1
        init_bootm()
    }

    private var fragments: ArrayList<Fragment>? = null
    var list_info = ArrayList<View>()//
    fun init_bootm() {
        bottom_view_id.addItem(tabLayout(R.mipmap.ic_launcher, getString(R.string.test1)))
                .addItem(tabLayout(R.mipmap.ic_launcher, getString(R.string.test2)))
                .addItem(tabLayout(R.mipmap.ic_launcher, getString(R.string.test3)))
                .addItem(tabLayout(R.mipmap.ic_launcher, getString(R.string.test4)))
                .initialise()

        list_info = bottom_view_id.getList_xiao() as ArrayList<View>
        fragments = getFragments()
        bottom_view_id.setTabSelectedListener(this)
    }

    private fun getFragments(): ArrayList<Fragment> {
        val fragments = ArrayList<Fragment>()
        fragments.add(fragment1.newInstance())
        fragments.add(fragment2.newInstance())
        fragments.add(fragment3.newInstance())
        fragments.add(fragment4.newInstance())
        return fragments
    }

    override fun onStart() {
        super.onStart()
        if (Sp.statue_mainactivity == 1) {
            Sp.statue_mainactivity = 0
            layFrame.removeAllViews()
            setDefaultFragment()
        }
    }

    var postion_sign = 0
    private fun setDefaultFragment() {
        postion_sign = 0
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.layFrame, fragments!![postion_sign])
        transaction.commit()
    }

}
