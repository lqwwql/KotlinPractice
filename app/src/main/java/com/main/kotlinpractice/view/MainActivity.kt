package com.main.kotlinpractice.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateUtils
import android.view.View
import android.widget.Button
import com.main.kotlinpractice.R
import com.main.kotlinpractice.bean.RequestData
import org.jetbrains.anko.toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initClick()
    }

    private fun initClick() {
//        btn_name.setOnClickListener {
//            tv_content.text = "点击了按钮,dataType=${testDataType()}"
//        }
        btn_name.setOnClickListener(MyClickListener())
        cb_remember.setOnCheckedChangeListener { view, isCheck ->
            tv_content.text = ("${if (isCheck) "记住" else "不保存"}密码")
        }
        rg_choose.setOnCheckedChangeListener { group, checkId ->
            tv_content.text = when (checkId) {
                R.id.rb_check1 -> "你选择了1"
                R.id.rb_check2 -> "你选择了2"
                else -> "没有选择"
            }
        }
        sw_open.setOnCheckedChangeListener { view, isSelected ->
            if (isSelected) sw_open.text = "打开" else sw_open.text = "关闭"
        }
        btn_jump.setOnClickListener { v ->
//            startActivity(Intent(this@MainActivity,SecondActivity::class.java))
            var man = RequestData("小帅", 24, 0)
            var wuman = RequestData("小美", 25, 1)
            startActivity<SecondActivity>(
                Pair("requestName", "MainActivity"),
                Pair(
                    "requestTime",
                    DateUtils.formatDateTime(this, Date().time, DateUtils.FORMAT_SHOW_TIME)
                ),
                Pair("man", man),
                Pair("wuman", wuman)
            )
        }
    }


    private fun testDataType(): Long {
        var i: Int = 123;
        var b: Long = i.toLong()

        return b
    }


    private inner class MyClickListener : View.OnClickListener {
        override fun onClick(v: View?) {
            toast("click button：${(v as Button).text}")
        }
    }


}