package jt.ttaa.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import jt.ttaa.R
import jt.ttaa.utils.Sp

/**
 * Created by SKL on 2017/12/25.
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        if (Sp.statue==0){
//            System.out.println("被杀死了")
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }

        super.onCreate(savedInstanceState)
        init1()
    }

    open fun init1(){

    }
    open fun init_back() {
//        findViewById(R.id.Titlebar_left)?.setOnClickListener({
//            onBackPressed()
//        })
    }


}