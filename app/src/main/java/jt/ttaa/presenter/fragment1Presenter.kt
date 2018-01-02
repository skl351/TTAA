package jt.ttaa.presenter

import jt.ttaa.model.bean.item_banner
import jt.ttaa.model.bussinessImpl.fragment1ModeinterfaceImpl
import jt.ttaa.model.modeInterface.fragment1ModeInterface
import jt.ttaa.utils.Sp
import jt.ttaa.view.viewInterface.fragment1Interface

/**
 * Created by SKL on 2017/12/28.
 */
class fragment1Presenter(fragment1Interface: fragment1Interface) {
    var fragment1Modeinterface: fragment1ModeInterface? = null
    var fragment1interface: fragment1Interface? = null
    init {
        this.fragment1Modeinterface = fragment1ModeinterfaceImpl()
        this.fragment1interface = fragment1Interface
    }
    fun get_bananimage() {
        fragment1Modeinterface?.Get_bananimage(Sp.area_id, object : fragment1Presenter.CallBack_banan {
            override fun onSuccess(event: List<item_banner>) {
                fragment1interface?.onSuccess_banan(event)
            }

            override fun onFail(str: String) {
                fragment1interface?.showToast(str)
            }

        })
    }
    interface CallBack_banan {
        fun onFail(str: String)
        fun onSuccess(event: List<item_banner>)
    }
}