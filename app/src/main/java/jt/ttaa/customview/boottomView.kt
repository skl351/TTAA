package jt.ttaa.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import jt.ttaa.R
import jt.ttaa.model.bean.tabLayout
import jt.ttaa.utils.Sp
import java.util.ArrayList

/**
 * Created by SKL on 2017/12/25.
 */

class Bottom_view(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    var mSelectedPosition = 0//当前 poi
    var my_tab: View? = null
    internal var size: Int = 0//总共尺寸
    var list_xiao = ArrayList<View>();

    init {
        my_tab = View.inflate(context, R.layout.tablbig_view, this) as LinearLayout//将view控制在指定view上
    }

    fun getList_xiao(): List<View> {
        return list_xiao
    }

    internal var mTablayoutiemItems = ArrayList<tabLayout>()
    internal var list_view = ArrayList<View>()
    fun addItem(item: tabLayout): Bottom_view {
        mTablayoutiemItems.add(item)
        return this
    }


    fun initialise() {
        if (!mTablayoutiemItems.isEmpty()) {
            size = mTablayoutiemItems.size
            val width = Sp.getsrcw()?.div(size)//一个的高度
            val lin = my_tab?.findViewById<View>(R.id.tablbig_view_id) as LinearLayout
            for (i in mTablayoutiemItems.indices) {
                val view = LayoutInflater.from(context).inflate(R.layout.tab_item, null)
//                var bootom_red_view = view.findViewById(R.id.bootom_red_view);
                val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                layoutParams.width = width!!
                view.layoutParams = layoutParams
                val imageView = view.findViewById<View>(R.id.icon_img) as ImageView
                imageView.setBackgroundResource(mTablayoutiemItems[i].icon)
                val vv = view.findViewById<View>(R.id.icon_text) as TextView
                vv.text = mTablayoutiemItems[i].title

//                if (i == 2) {
//                    list_xiao.clear()
//                    list_xiao.add(bootom_red_view)
//                }

                if (i == 0) {
                    imageView.isSelected = true
                    vv.setTextColor(resources.getColor(R.color.black))
                } else {
                    vv.setTextColor(resources.getColor(R.color.gray))
                    imageView.isSelected = false
                }
                list_view.add(view)
                lin.addView(view)
            }
            for (i in mTablayoutiemItems.indices) {
                list_view[i].setOnClickListener({
                    v ->
                    if (i == mSelectedPosition) {

                    } else {
                        for (i in 0..size - 1) {
                            list_view[i].findViewById<View>(R.id.icon_img).isSelected = false
                            val vv = list_view[i].findViewById<View>(R.id.icon_text) as TextView
                            vv.setTextColor(resources.getColor(R.color.gray))
                        }
                        (v.findViewById<View>(R.id.icon_text) as TextView).setTextColor(resources.getColor(R.color.black))
                        v.findViewById<View>(R.id.icon_img).setSelected(true)
                        mTabSelectedListener?.onTabSelected(i)
                        mSelectedPosition = i
                    }
                })
            }

        }
    }

    fun setCurrentTab(i: Int) {
        for (i in 0..size - 1) {
            list_view[i].findViewById<View>(R.id.icon_img).isSelected = false
            val vv = list_view[i].findViewById<View>(R.id.icon_text) as TextView
            vv.setTextColor(resources.getColor(R.color.gray))
        }
        (list_view[i].findViewById<View>(R.id.icon_text) as TextView).setTextColor(resources.getColor(R.color.black))
        list_view[i].findViewById<View>(R.id.icon_img).setSelected(true)
        mTabSelectedListener?.onTabSelected(i)
        mSelectedPosition = i
    }

    interface OnTabSelectedListener {
        fun onTabSelected(position: Int)
        fun onTabUnselected(position: Int)
        fun onTabReselected(position: Int)
    }

    var mTabSelectedListener: Bottom_view.OnTabSelectedListener? = null
    fun setTabSelectedListener(tabSelectedListener: Bottom_view.OnTabSelectedListener): Bottom_view {
        this.mTabSelectedListener = tabSelectedListener
        return this
    }
}