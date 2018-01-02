package jt.ttaa.model.bussinessImpl

import com.ayi.copy_app.network.RetrofitManager
import jt.ttaa.model.bean.Result
import jt.ttaa.model.bean.errorException.ErrorResponse
import jt.ttaa.model.bean.item_banner
import jt.ttaa.model.modeInterface.fragment1ModeInterface
import jt.ttaa.presenter.fragment1Presenter
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by SKL on 2017/12/28.
 */
class fragment1ModeinterfaceImpl : fragment1ModeInterface {
    override fun Get_bananimage(areaid: String, callBack: fragment1Presenter.CallBack_banan) {
        RetrofitManager.instance.Get_bananimage("3302", "170821").
        observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io()).
                subscribe(object : Subscriber<Result<List<item_banner>>>() {
                    override fun onCompleted() {

                    }

                    override fun onError(e: Throwable) {
                        System.out.println("error"+e.toString())
                        val zz = e as ErrorResponse
                        callBack.onFail(zz.Msg)//能都得到解析错误后的信息
                    }

                    override fun onNext(message: Result<List<item_banner>>) {
                        System.out.println("messae" + message)
                        if (message.ret == 200) {
                            callBack.onSuccess(message.data)
                        } else {
                            if (!message.msg.equals(""))
                                callBack.onFail(message.msg)
                        }

                    }
                })
    }
}