package com.main.kotlinpractice.view

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.main.kotlinpractice.R
import com.main.kotlinpractice.adapter.GridViewAdapter
import com.main.kotlinpractice.adapter.ListViewAdapter
import com.main.kotlinpractice.bean.PhotoBean
import com.main.kotlinpractice.bean.RequestData
import kotlinx.android.synthetic.main.activity_second.*
import org.jetbrains.anko.toast

class SecondActivity : AppCompatActivity() {

    private val colorArray = arrayOf("红色", "黄色", "绿色")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initClick()
        initSpinner()
        initListView()
        initGridView()
    }

    private fun initClick() {
        btn_back.setOnClickListener { v ->
            onBackPressed()
        }

        btn_test.setOnClickListener {
            val bundle = intent.extras
            val requestName = bundle?.getString("requestName")
            val requestTime = bundle?.getString("requestTime")
            var man: RequestData = bundle?.get("man") as RequestData
            var wuman: RequestData = bundle?.get("wuman") as RequestData
            tv_second_content.text = "这是第二个页面,来自${requestName},访问时间:${requestTime}"
            tv_human.text = "男人姓名：${man.name} 年龄；${man.age} \n 女人姓名：${wuman.name} 年龄：${wuman.age}"
        }
        btn_click.setOnClickListener { v ->
            testMethod()
        }
    }

    private fun initSpinner() {
        val colorAdapter = ArrayAdapter(this, R.layout.spinner_item, colorArray)
        colorAdapter.setDropDownViewResource(R.layout.spinner_item)
        sp_color.prompt = "请选择颜色"
        sp_color.adapter = colorAdapter
        sp_color.setSelection(0, true)
        sp_color.onItemSelectedListener = ItemSelectListener()
    }

    private fun initListView() {
        var newsArray: MutableList<String> = mutableListOf()
        for (i in 0..20) {
            newsArray.add("这是第${i}个新闻")
        }
        lv_news.adapter = ListViewAdapter(this, newsArray, Color.WHITE)
        lv_news.setOnItemClickListener { parent, view, position, id ->
            toast("你点击的是：${newsArray[position]}")
        }
    }

    private fun initGridView() {
        var photoList: MutableList<PhotoBean> = mutableListOf(
            PhotoBean(R.drawable.photo1, "菜单"),
            PhotoBean(R.drawable.photo2, "定位"),
            PhotoBean(R.drawable.photo3, "主页"),
            PhotoBean(R.drawable.photo4, "测量"),
            PhotoBean(R.drawable.photo5, "测方"),
            PhotoBean(R.drawable.photo6, "测距")
        )
        gv_photo.adapter = GridViewAdapter(this, photoList, Color.BLACK)
        gv_photo.setOnItemClickListener { parent, view, position, id ->
            toast("你点击的是：${photoList[position].photoName}")
        }
    }


    private fun testMethod() {
        var currentStr = "当前字符串后面有逗号，"
        var sonStr = currentStr.substring(0, currentStr.indexOf("，"))
        toast("sonStr=${sonStr}")
    }

    internal inner class ItemSelectListener : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            toast("你选中了${colorArray[position]}")
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
        }
    }


}