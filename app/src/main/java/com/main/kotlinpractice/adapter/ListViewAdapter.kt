package com.main.kotlinpractice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.main.kotlinpractice.R

/**
 * 版权：咸鱼信息科技有限公司 版权所有
 * @author lqw
 * 创建日期：2023/3/10 21:18
 * 描述：列表适配器
 */
class ListViewAdapter(private val context: Context, private val newsList:MutableList<String>, private val background:Int) :BaseAdapter() {

    override fun getCount(): Int = newsList.size

    override fun getItem(position: Int): Any =newsList[position]

    override fun getItemId(position: Int): Long =position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view  = convertView
        val holder:ViewHolder?
        if(view == null){
            holder = ViewHolder()
            view = LayoutInflater.from(context).inflate(R.layout.list_view_item,null)
            holder.tv_title = view.findViewById<View>(R.id.tv_title) as TextView
            view.tag = holder
        }else{
            holder = view.tag as ViewHolder
        }
        holder.tv_title.text = newsList[position]
        return view as View
    }

    class ViewHolder{
        lateinit var tv_title:TextView
    }

}