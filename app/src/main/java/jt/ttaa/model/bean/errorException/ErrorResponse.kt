package jt.ttaa.model.bean.errorException

import jt.ttaa.model.bean.baseBean
import java.io.IOException

/**
 * Created by SKL on 2017/12/25.
 */
data class ErrorResponse(var Msg:String,var Ret:Int) : IOException(){

}